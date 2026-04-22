/**
 * This class represents a standard deck of 52 playing cards.
 * It builds all combinations of ranks and suits using arrays
 * and establishes a has-a relationship between cards and the deck.
 * This class provides methods for shuffling the deck and dealing cards,
 * crucial for gameplay mechanics which Game class will use
 *
 * @author Tuan Tran
 * @version 1.0
 */
public class Deck {

    private final Card[] cards;     // Array of 52 cards
    private int currentCardIndex;   // Index of the next card to deal

    /**
     * Constructor: builds a standard 52-card deck by initializing
     * all combinations of ranks and suits. Shuffle the deck upon creation.
     *
     * @param suits is an array of 4 suit
     * @param ranks is an array of 13 rank
     * @param cards is an array of 52 cards
     */
    public Deck() {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        cards = new Card[52]; // fixed-size array for 52 cards
        int index = 0;

        // Build each card and put it into the array
        // starting by looping through all 4 suits
        for (int i = 0; i < suits.length; i++) { // suits.length = 4
            //looping through all ranks
            for (int j = 0; j < ranks.length; j++) { // ranks.length = 13
                String rank = ranks[j];
                String suit = suits[i];

                //variable to hold the numeric value
                int value;

                // Determine card value for Blackjack
                if (rank.equals("A")) {
                    value = 11; // initially treat ace as 11, adjust to 1 later
                } else if (rank.equals("J") || rank.equals("Q") || rank.equals("K")) {
                    value = 10;
                } else {
                    value = Integer.parseInt(rank);
                }

                // finally, add 52 objects Card to array cards
                cards[index] = new Card(rank, suit, value);
                index++;
            }
        }

        shuffle(); // Shuffle when deck is created
        currentCardIndex = 0;
    }

    /**
     * Randomly shuffles the deck of cards to ensure a random dealing order.
     */
    public void shuffle() {
        // loop through every card in deck
        for (int i = 0; i < cards.length; i++) { // cards.length = 52

            //generate random index between 0 and cards.length -1
            int randomIndex = (int)(Math.random() * cards.length);

            // Swap current card with a random one
            Card temp = cards[i];
            cards[i] = cards[randomIndex];
            cards[randomIndex] = temp;
        }
        currentCardIndex = 0; // Reset deal position
    }

    /**
     * This method return a value of type card, used to deal one card from deck
     * @return the next Card, or null if there are no cards left in the deck.
     */
    public Card dealCard() {
        if (currentCardIndex < cards.length) { //checks if there are still cards left in the deck to deal
            Card dealt = cards[currentCardIndex]; //retrieves the next card from the deck.
            currentCardIndex++; //next card
            return dealt; //returns the card that was just dealt out.
        } else {
            return null; // deck is empty
        }
    }

    /**
     * Returns the number of remaining cards in the deck that can be dealt.
     *
     * @return the number of cards left in the deck.
     */
    public int cardsRemaining() {
        return cards.length - currentCardIndex;
    }

    /**
     * Prints all cards in the deck to the console, primarily for debugging purposes.
     */
    public void printDeck() {
        for (int i = 0; i < cards.length; i++) {
            System.out.println(cards[i]);
        }
    }
}
