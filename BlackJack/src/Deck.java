import java.util.ArrayList;

/**
 * Created by stephen.farmer on 5/11/16.
 */
public class Deck {
    ArrayList<Card> cardDeck = new ArrayList<>();

    public void initDeck() {

        // Create Spades
        for (int i = 1; i < 14; i++) {
            Card card = new Card();
            card.setSuit("Spades");
            card.setValue(i);
            card.setFace(i);
            cardDeck.add(card);
        }

        // Create Clubs
        for (int i = 1; i < 14; i++) {
            Card card = new Card();
            card.setSuit("Clubs");
            card.setValue(i);
            card.setFace(i);
            cardDeck.add(card);
        }

        // Create Diamonds
        for (int i = 1; i < 14; i++) {
            Card card = new Card();
            card.setSuit("Diamonds");
            card.setValue(i);
            card.setFace(i);
            cardDeck.add(card);
        }

        // Create Hearts
        for (int i = 1; i < 14; i++) {
            Card card = new Card();
            card.setSuit("Hearts");
            card.setValue(i);
            card.setFace(i);
            cardDeck.add(card);
        }

    }

    public void printDeck(){
        // Print deck (Really just for testing/verification purposes)
        for (Card c : cardDeck) {
            String faceName = c.face == null ? " of " : c.face + " of ";
            if ((c.value < 2) || (c.value > 10)) {
                System.out.println(faceName + c.suit);
            } else {
                System.out.println(c.value + faceName + c.suit);
            }
        }
    }
}
