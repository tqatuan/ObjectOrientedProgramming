/**
 * Abstract Player class — shared logic for Dealer and Player.
 * This class manages a collection of cards for the player, provides methods to
 * draw cards, clear the hand, and calculate the total value of the hand.
 * Subclasses must implement the playTurn method to define specific actions.
 *
 * @author Tuan Tran
 * @version 1.0
 */
public abstract class Player {

    // Stores all cards the player currently has in their hand.
    // Allows subclasses to access it directly
    protected Card[] hand; // Each hand is an array of cards

    // Tracks how many cards are currently in the hand
    protected int cardCount;

    // Build Player constructor
    // Each player is dealt cards, called a hand and has 12 cards max

    /**
     * Constructs a Player object. Each player is dealt cards,
     * represented as a hand, with a maximum capacity of 12 cards.
     */
    public Player() {
        hand = new Card[12]; // Max 12 cards before busting
        cardCount = 0;
    }

    /**
     * Adds a card to the player's hand.
     * If the hand is already full, the card will not be added.
     *
     * @param card the Card object to add to the hand.
     */
    public void addCard(Card card) {
        if (cardCount < hand.length) {
            hand[cardCount] = card;
            cardCount++;
        }
    }

    /**
     * Calculates the total value of the hand, treating Aces as either 1 or 11.
     *
     * Aces are initially counted as 1, and if the total is 21 or less,
     * an Ace can be counted as 11. This adjustment is made to maximize
     * the hand's value without exceeding 21.
     *
     * @return the total point value of the hand.
     */
    public int getTotalValue() {
        int total = 0;
        int aceCount = 0;

        for (int i = 0; i < cardCount; i++) { // Loops through all cards in the hand
            // Each hand is a card object so it inherit all methods from Card object including getValue & isAce
            total += hand[i].getValue(); // sum all values and assign to total

            // Handles Aces
            if (hand[i].isAce()) {
                aceCount++;
            }
        }

        // Add 10 for each Ace if it does not cause a bust
        while (aceCount > 0 && total + 10 <= 21) { // If we upgrade one Ace from 1 → 11, the total will not bust
            total += 10;
            aceCount--;
        }

        // Returns the current total point value of the hand.
        return total;
    }

    /**
     * Clears the hand between rounds by setting all elements in the hand
     * array to null and resetting the card count to zero.
     */
    public void clearHand() {
        for (int i = 0; i < cardCount; i++) {
            hand[i] = null;
        }
        cardCount = 0;
    }

    /**
     * Returns a string representation of all cards currently in the player's hand.
     * Each card is displayed on a new line.
     *
     * @return a string showing the cards in the hand, one per line.
     */
    public String printHand() {
        StringBuilder handString = new StringBuilder();
        for (int i = 0; i < cardCount; i++) {
            // Append each card's string representation followed by a newline
            handString.append(hand[i].toString()).append("\n");
        }
        return handString.toString(); // Return the complete string representation of the hand
    }

    /**
     * Abstract method that defines the logic for player actions (hit or stay).
     * Must be implemented by subclasses to specify how the player or dealer
     * will take their turn in the game.
     *
     * @param deck the Deck object from which to draw cards during the turn.
     */
    public abstract void playTurn(Deck deck);
}
