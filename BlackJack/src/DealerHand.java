import java.util.ArrayList;

/**
 * Created by stephen.farmer on 5/11/16.
 */
public class DealerHand {

    ArrayList<Card> dealerHand = new ArrayList<>();
    public int total;
    public boolean stand = false;
    public boolean busted = false;
    public boolean blackjack = false;

    public void printDealer(Card c){
        String faceName = c.face == null ? " of " : c.face + " of ";
        if ((c.isFaceCard) || (c.isAceCard)) {
            System.out.println("The dealer has a " + faceName + c.suit + " and a hidden card.");
        } else {
            System.out.println("The dealer has a " + c.value + faceName + c.suit + " and a hidden card.");

        }
//        System.out.println("Dealer's total: " + total); //JUST FOR TESTING
    }

    public void printDealerHand(){
        /*
         * Prints dealer's hand. This is really only used for end game purposes (when both player and dealer choose to stand) or just general testing
         */
        for (Card c : dealerHand) {
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
        total = 0;
        for (Card c : dealerHand) {
            total += c.value;
            //System.out.println(total);
        }

        if (total > 21) {
            System.out.printf("Dealer Steve BUSTED with %d! YOU WIN! :D\n", total);
            busted = true;
        }
        // Below is old code for checking blackjack, needs to be re-written
        // with better rules

//        } else if (total == 21) {
//            System.out.println("Dealer Steve got Blackjack!\n");
//            blackjack = true;
//            printDealerHand();
//            System.out.println("You lose :(\n");
//        }
        return total;
    }
}
