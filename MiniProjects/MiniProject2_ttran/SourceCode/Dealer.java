/**
 * This class represents the dealer in the card game, extending the Player class.
 * The Dealer inherits methods from the Player class and implements rules
 * specific to dealer actions during gameplay. The dealer must draw cards
 * until the total value of their hand is at least 17
 * @author Tuan Tran
 * @version 1.0
 */

public class Dealer extends Player {

    /**
     * Constructs a Dealer object by calling the constructor of the Player class.
     * The dealer does not have a money constraint, which is typical in
     * most card games since the dealer is not competing for a pot like the players.
     */
    public Dealer() {
        super(); // Dealer doesn't have a money constraint
    }

    /**
     * Implements the rules for the dealer's turn.
     * The dealer draws cards from the deck until their total value
     * is 17 or higher. If the dealer's total is less than 17,
     * they continue to draw cards. The method prints out each card
     * drawn and the dealer's total upon staying.
     *
     * @param deck the Deck object from which the dealer draws cards.
     */

    public void playTurn(Deck deck) {
        Card card;
        while (getTotalValue() < 17 && (card = deck.dealCard()) != null) {
            addCard(card);
            System.out.println("Dealer draws: " + card);
        }
        System.out.println("Dealer stays with total: " + getTotalValue());
    }
}