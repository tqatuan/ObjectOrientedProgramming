/**
 * This class represents a single card in a deck of 52 cards
 * used in the game of Blackjack. Each card has a rank, suit,
 * and a point value.
 *
 * Cards are essential for gameplay mechanics in Blackjack
 * as they determine the player's and dealer's hands.
 * @author Tuan Tran
 * @version 1.0
 */
public class Card {

    // All of those fields are private and final
    // to make sure the fields can only 0be accessed directly in this class
    // and once they're assigned, they can't change
    private final String rank;   // The rank: e.g., "2", "10", "J", "Q", "K", or "A"
    private final String suit;   // The suit: e.g., "Hearts", "Clubs", "Spades", "Diamonds"
    private final int value;     // The card's numeric value for Blackjack (2–10, or 1 for Ace)

    /**
     * Build a constructor for cards. Each cards will have 3 fields
     *
     * @param rank the rank of the card (e.g., "A", "2", ..., "K")
     * @param suit the suit of the card (e.g., "Hearts", "Diamonds")
     * @param value the point value of the card (1 for Ace, 10 for face cards, etc.)
     * Example: new Card("A", "Spades", 1)
     */
    public Card(String rank, String suit, int value) {
        this.rank = rank;   // Store the rank provided by whoever creates the card
        this.suit = suit;   // Store the suit
        this.value = value; // Store the numeric value
    }

    /**
     * Returns the rank (like "A" or "7").
     */
    public String getRank() {
        return rank;
    }

    /**
     * Returns the suit (like "Hearts" or "Spades").
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Returns true if this card is an Ace (the rank equals "A").
     * This boolean value is crucial during the game's scoring system
     * for deciding if Ace counts as 1 or 11.
     */
    public boolean isAce() {
        return rank.equalsIgnoreCase("A");
    }
    /**
     * Returns the numeric value of this card.
     * For example: 10 for "K", or 1 for "A".
     */
    public int getValue() {
        return value;
    }

    // No setter since once the cards are built, they remain the same throughout the game

    /**
     * Returns a readable string for printing.
     * Example: "A of Hearts" or "10 of Spades".
     *
     * Using overrise to replace the default 'toString()' behavior
     */
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
