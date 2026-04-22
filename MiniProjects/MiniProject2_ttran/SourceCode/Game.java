/**
 * This class simulates the game mechanics of Blackjack.
 * The game includes a player, a dealer, and a deck of cards.
 * Player start by enter a total amount of money they have for the game
 * 2 cards are dealt to player and dealers
 * Each turn, the player has a choice to either hit  or stay
 * The game continues until the player runs out of money or chooses not to play another round.
 *
 * @author Tuan Tran
 * @version 1.0
 */

import java.util.Scanner;

public class Game {
    private BlackJackPlayer player;
    private Dealer dealer;
    private Deck deck;
    private Scanner scanner; // Scanner declared here

    /**
     * Constructs a Game object, initializing a player with starting money,
     * a dealer, and a deck of cards for the game.
     *
     * @param startingMoney the initial amount of money the player has for betting.
     */
    public Game(double startingMoney) {
        player = new BlackJackPlayer(startingMoney);
        dealer = new Dealer();
        deck = new Deck();
        scanner = new Scanner(System.in); // Initialize scanner
    }

    /**
     * Starts the game loop, allowing the player to play multiple rounds.
     * Checks if the player has money to continue, handles user betting,
     * deals cards to the player and dealer, manages the player's turn,
     * and processes the dealer's turn.
     * The game will continue until the player runs out of money or decides to stop playing.
     */
    public void startGame() {

        // variable to keep track player is still playing
        boolean keepPlaying = true;

        while (keepPlaying) {
            if (player.getMoney() <= 0) {
                System.out.println("You are out of money! Game over.");
                break;
            }

            // Print player's total money
            System.out.println("\nCurrent money: $" + player.getMoney());

            // Initialize the bet variable to keep track player's bet
            double bet = getPlayerBet();

            // Ask player for their bet
            player.placeBet(bet);

            // Deal cards for player and dealer
            dealInitialCards();

            // Player is dealt 2 cards, both up, then get total value
            System.out.println("Player's hand: " + player.printHand() +
                    " Total: " + player.getTotalValue());

            // The dealer is dealt two cards, one face up and one face down
            System.out.println("Dealer's showing card: " +
                    dealer.printHand().split("\n")[0]);

            // Initialize variable to track if player has busted or not
            boolean playerBusted = PlayerTurn();

            // if player stay and not busted, it's dealer turn and check for winner
            if (!playerBusted) {
                DealerTurn();
                checkWinner();
            } else {
                player.loseBet(); // if player busted, they lose bet
            }

            // Shuffle deck after each round
            deck.shuffle();
            System.out.println("Deck has been reshuffled.\n");

            keepPlaying = askContinue();
        }

        scanner.close();
    }

    /**
     * Prompts the player for their bet and validate the number
     * Continues to prompt for valid input until a correct bet amount is provided.
     *
     * @return the amount bet by the player for the current round.
     */
    private double getPlayerBet() {
        double bet = 0;
        while (true) {
            System.out.print("Enter your bet: ");
            if (scanner.hasNextDouble()) {
                bet = scanner.nextDouble();
                if (bet > 0 && bet <= player.getMoney()) {
                    break;
                } else {
                    System.out.println("Invalid bet. Enter a value between 1 and " +
                            player.getMoney());
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // discard invalid input
            }
        }
        return bet;
    }

    /**
     * Deals two cards each to the player and the dealer to start the round.
     * First, clears any existing cards in both the player's and dealer's hands
     * to prepare for a fresh game round.
     */
    private void dealInitialCards() {
        player.clearHand();
        dealer.clearHand();
        player.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
    }

    /**
     * Manages the player's turn, prompting them to choose
     * to hit or stay after the initial cards are dealt.
     * The turn continues until the player either chooses to stay or busts.
     *
     * @return true if the player has busted (total value exceeds 21), false otherwise.
     */
    private boolean PlayerTurn() {
        boolean playerBusted = false;
        while (true) {
            System.out.print("Do you want to hit or stay? (h/s): ");
            char choice = scanner.next().toLowerCase().charAt(0);

            if (choice == 'h') {
                player.addCard(deck.dealCard());
                System.out.println("\nPlayer's hand:\n" + player.printHand() +
                        "Total: " + player.getTotalValue());

                if (player.getTotalValue() > 21) {
                    System.out.println("You busted! You lose your bet.");
                    playerBusted = true;
                    break;
                }
            } else if (choice == 's') {
                break;
            } else {
                System.out.println("Invalid choice, please enter 'h' or 's'.");
            }
        }
        return playerBusted;
    }

    /**
     * Manages the dealer's turn after the player has completed theirs.
     * Dealer show their hole card and continue to draw
     * until their total value is 17 or higher.
     * Displays the dealer's final hand and total value.
     */
    private void DealerTurn() {
        System.out.println("\nDealer reveals their hole card:");
        System.out.println(dealer.printHand() + "Total: " + dealer.getTotalValue());
        dealer.playTurn(deck);
        System.out.println("Dealer's final hand:\n" + dealer.printHand() +
                "Total: " + dealer.getTotalValue());
    }

    /**
     * Prompts the player to decide if they want to continue playing another round.
     * Only y or n is accepted. Continue to ask for valid input
     *
     * @return true if the player chooses to continue, false otherwise.
     */
    private boolean askContinue() {
        char continueChoice;
        while (true) {
            System.out.print("\nDo you want to play another round? (y/n): ");
            continueChoice = scanner.next().toLowerCase().charAt(0);
            if (continueChoice == 'y' || continueChoice == 'n') break;
            System.out.println("Invalid input. Please enter 'y' or 'n'.");
        }
        return continueChoice == 'y';
    }

    /**
     * Evaluates the results of the round to determine the winner
     * based on the total values of the player and dealer's hands.
     * If dealer bust, player win the bet. Otherwise, compare totalValue
     * then accounts for wins, losses, and ties.
     */
    private void checkWinner() {
        int playerTotal = player.getTotalValue();
        int dealerTotal = dealer.getTotalValue();

        if (dealerTotal > 21) {
            System.out.println("Dealer busts! You win your bet!");
            player.winBet();
        } else if (playerTotal > dealerTotal) {
            System.out.println("You win!");
            player.winBet();
        } else if (playerTotal < dealerTotal) {
            System.out.println("Dealer wins!");
            player.loseBet();
        } else {
            System.out.println("It's a tie! You retain your bet.");
        }
    }
}
