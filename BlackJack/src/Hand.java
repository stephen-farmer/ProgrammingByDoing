import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by stephen.farmer on 5/11/16.
 */
public class Hand {

    ArrayList<Card> playerHand = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    BaseCard baseCard = new BaseCard();
    Printer printer = new Printer();
    public int total;
    public boolean blackjack;
    public boolean stand = false;
    public boolean busted = false;
    public boolean initialDeal; // This is so stupid, but it's a quick fix to avoid the player total
                                // printing twice at the start of the game

    public void printHand(){
        for (Card c : playerHand) {
            String faceName = c.face == null ? " of " : c.face + " of ";
            if ((c.isFaceCard) || (c.isAceCard)){
                System.out.println(faceName + c.suit);
            } else {
                System.out.println(c.value + faceName + c.suit);
            }
            //printer.printCard(baseCard, c);
        }
    }
    public int checkHand(){
        // Will be periodically used to check hand total
        total = 0;
        for (Card c : playerHand) {
            // If card is an ace and hasn't been prompted yet, prompt user for value
            if (c.isAceCard) {
                acePrompt(c);
            }
            total += c.value;
        }

        if (total > 21) {
            System.out.println("BUST! You lose :(");
            busted = true;
        } else if (!initialDeal){
            System.out.printf("(Your total is %d)\n\n", total);
        }

        return total;
    }

    public int checkTotal(){
        total = 0;
        for (Card c : playerHand) {
            total = total+c.value;
        }
        return total;
    }

    public int acePrompt(Card card) {
        /*
         * For each Ace the user is holding the program will ask if they want the value
         * to be high or low. This is really the only way I can think of to tackle the issue
         * of Ace values.
         */
        if (card.isAceCard) {
            System.out.println("Your hand:" );
            printHand();
            System.out.println("\nYou have an Ace of " + card.getSuit() + ".");
            System.out.println("Take it high or low?");
            String aceAnswer = scanner.nextLine();

            if (aceAnswer.equals("high")) {
                card.setValue(11);
            } else if (aceAnswer.equals("low")) {
                card.setValue(1);
            }
        }
        return card.value;
    }

}
