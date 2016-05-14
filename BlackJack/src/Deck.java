import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by stephen.farmer on 5/11/16.
 */
public class Deck {
    public ArrayList<Card> cardDeck = new ArrayList<>();

    public void initDeck() {

        // Create Spades
        for (int i = 1; i < 14; i++) {
            Card card = new Card();
            card.setSuit("Spades");
            if (i < 11) {
                card.setValue(i);
            } else {
                card.setValue(10);
            }
            card.setFace(i);
            cardDeck.add(card);
        }

        // Create Clubs
        for (int i = 1; i < 14; i++) {
            Card card = new Card();
            card.setSuit("Clubs");
            if (i < 11) {
                card.setValue(i);
            } else {
                card.setValue(10);
            }
            card.setFace(i);
            cardDeck.add(card);
        }

        // Create Diamonds
        for (int i = 1; i < 14; i++) {
            Card card = new Card();
            card.setSuit("Diamonds");
            if (i < 11) {
                card.setValue(i);
            } else {
                card.setValue(10);
            }
            card.setFace(i);
            cardDeck.add(card);
        }

        // Create Hearts
        for (int i = 1; i < 14; i++) {
            Card card = new Card();
            card.setSuit("Hearts");
            if (i < 11) {
                card.setValue(i);
            } else {
                card.setValue(10);
            }
            card.setFace(i);
            cardDeck.add(card);
        }
    }

    public void shuffle(){
        Collections.shuffle(cardDeck); // LOL that's it??
    }

    public void deckCheck(){
        if (cardDeck.size() <= 5) {
            cardDeck.clear();
            initDeck();
            shuffle();
            System.out.println("Deck Check run: Cards shuffled");
        }
    }

    public void printDeck(){
        // Print deck (Really just for testing/verification purposes)
        for (Card c : cardDeck) {
            String faceName = c.face == null ? " of " : c.face + " of ";
            if ((c.isFaceCard) || (c.isAceCard)){
                System.out.println(faceName + c.suit);
            } else {
                System.out.println(c.value + faceName + c.suit);
            }
        }
    }
}