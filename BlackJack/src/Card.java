/**
 * Created by stephen.farmer on 5/11/16.
 */
public class Card {
    public int value;
    public String suit;
    public String face;

    public void setValue(int cardValue) {
        value = cardValue;
    }

    public int getValue() {
        return value;
    }

    public void setSuit(String cardSuit) {
        suit = cardSuit;
    }

    public String getSuit(){
        return suit;
    }

    public void setFace(int v){
        value = v;
        switch (value) {
            case 1:
                face = "Ace";
                break;
            case 11:
                face = "Jack";
                break;
            case 12:
                face = "Queen";
                break;
            case 13:
                face = "King";
                break;
        }
    }
}
