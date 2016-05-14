/**
 * Created by stephen.farmer on 5/11/16.
 */
public class Card {
    public int value;
    public String suit;
    public String face;
    public boolean isFaceCard;
    public boolean isAceCard;


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

    public void setFace(int n){
        switch (n) {
            case 1:
                face = "Ace";
                isAceCard = true;
                break;
            case 11:
                face = "Jack";
                isFaceCard = true;
                break;
            case 12:
                face = "Queen";
                isFaceCard = true;
                break;
            case 13:
                face = "King";
                isFaceCard = true;
                break;
        }
    }
}
