import java.util.ArrayList;

/**
 * Created by stephen.farmer on 5/11/16.
 */
public class Hand {

    ArrayList<Card> playerHand = new ArrayList<>();
    public int total;
    public boolean blackjack;
    public boolean stand = false;
    public boolean busted = false;

    public void printHand(){
        for (Card c : playerHand) {
            String faceName = c.face == null ? " of " : c.face + " of ";
            if ((c.isFaceCard) || (c.isAceCard)){
                System.out.println(faceName + c.suit);
            } else {
                System.out.println(c.value + faceName + c.suit);
            }
        }
    }

    public int checkHand(){
        // Will be periodically used to check hand total
        for (Card c : playerHand) {
            total = total+c.value;
        }
        if (total > 21) {
            System.out.println("BUST! You lose :(");
            busted = true;
        } else {
            System.out.printf("(Your total is %d)\n\n", total);
        }

        return total;
    }

    public int checkTotal(){
        for (Card c : playerHand) {
            total = total+c.value;
        }
        return total;
    }


}
