/**
 * This class represents a player in the game of Blackjack, extending the Player class.
 * The BlackJackPlayer inherits methods from the Player class and includes traits
 * that is specific to player aka managing money and bet
 * The player decide bet amount each round
 * and has the options to hit or stay during the game
 *
 * @author Tuan Tran
 * @version 1.0
 */

import java.util.Scanner;

public class BlackJackPlayer extends Player {
    private double money;  // total money the player has
    private double bet;    // current bet for the round
    private Scanner scanner;

    /**
     * Constructs a BlackJackPlayer object, initializing the player's total money and creating a Scanner
     * for user input. It calls the no-argument constructor of the Player class to set up the deck and hand.
     *
     * @param money the initial amount of money the player has for bets.
     */
    public BlackJackPlayer(double money) {
        super();  // calls Player's no-arg constructor
        this.money = money;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Places a bet for the current round. The bet must be between 0
     * and the available money the player has. If the bet is invalid,
     * an IllegalArgumentException is thrown.
     *
     * @param amount the amount to bet in this round.
     * @throws IllegalArgumentException if the bet is less than 0
     *         or greater than the available money.
     */
    public void placeBet(double amount) {
        if (amount <= money && amount >= 0) {
            this.bet = amount;
        } else {
            throw new IllegalArgumentException(
                    "Bet must be between $0 and available money."
            );
        }
    }

    /**
     * Returns the total amount of money the player currently has.
     *
     * @return the current amount of money of the player.
     */
    // Getter - get the inital money
    public double getMoney() {
        return money;
    }

    /**
     * Returns the current bet amount for the round.
     *
     * @return the bet amount placed by the player.
     */
    // Getter - get the bet
    public double getBet() {
        return bet;
    }

    /**
     * Increases the player's money by the bet amount if they win the round.
     * Prints the updated money total.
     */
    public void winBet() {
        money += bet;
        System.out.println("You won! Money is now: $" + money);
    }

    /**
     * Deduct the player's money by the bet amount if they lose the round
     * Print the updated total money
     */
    public void loseBet() {
        money -= bet;
        System.out.println("You lost. Money is now: $" + money);
    }

    /**
     * Implements the player's turn according to Blackjack rules.
     * The player draws cards until they choose to stay or burst
     * If the total value is exactly 21, the player wins immediately.
     * If the total exceeds 21, the player busts and loses bet
     * The player can choose to hit to draw another card or stay to end their turn.
     *
     * @param deck the Deck object from which the player draws cards during their turn.
     */
    @Override
    public void playTurn(Deck deck) {
        // Variable to control the loop and determine when the player's turn ends
        boolean turnOver = false;

        while (!turnOver) {
            System.out.println("Your hand:");
            printHand(); // Inherit from Player class

            // Computes the current total value based on the cards in the player's hand
            System.out.println("Total value: " + getTotalValue());

            if (getTotalValue() == 21) { // If the point total is exactly 21 the player wins immediately
                System.out.println("Blackjack! You have 21.");
                turnOver = true;
            } else if (getTotalValue() > 21) { // If the total point is > 21,  player burst
                System.out.println("Bust! You exceeded 21.");
                turnOver = true;
            } else {
                // Ask player to hit or stay
                System.out.print("Do you want to hit or stay? (h/s): ");
                String choice = scanner.nextLine().trim().toLowerCase();

                if (choice.equals("h")) {
                    Card newCard = deck.dealCard(); // Deal new card if user choose hit
                    if (newCard != null) {
                        System.out.println("You drew: " + newCard);
                        addCard(newCard); // addCard to player's hand
                    } else {
                        System.out.println("Deck is empty!");
                        turnOver = true;
                    }
                } else if (choice.equals("s")) {
                    turnOver = true;
                } else {
                    System.out.println("Invalid choice. Please type 'h' or 's'.");
                }
            }
        }
    }
}
