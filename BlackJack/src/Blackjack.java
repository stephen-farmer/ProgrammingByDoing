import java.util.Scanner;

/**
 * Created by stephen.farmer on 5/12/16.
 *
 * OBJECTIVES:

 *  - Implement betting money
 *
 * CURRENT STATUS:
 * The ASCII art cards turned out to be way more complicated than I thought. I basically got it working but it only
 * looks good for cards 2-9 and they don't even print on the same line...I could invest a couple more days into it
 * but it just doesn't feel like it's worth it right now. The code for it still exists (Printer and BaseCard classes)
 * but it's not being used anywhere right now.
 *
 * Everything else seems to be working fine though, no major outliers. I'll probably implement the betting
 * functionality since it wouldn't be very difficult to do.
 */

public class Blackjack {
    Hand myHand = new Hand();
    DealerHand dealer = new DealerHand();
    Scanner scanner = new Scanner(System.in);
    Deck deck = new Deck();
    Card hitCard = new Card();
    Sleeper sleeper = new Sleeper();

    public boolean gameOver = false;

    public void run() {
        /*
         * This is the bulk of the game logic which is called in the main method.
         */

        System.out.println("Dealer Steve shuffles the deck and deals your hand...\n");
        deck.cardDeck.clear();
        deck.initDeck();
        deck.shuffle();

        sleeper.sleep1k();
        playerDeal();
        sleeper.sleep1k();
        myHand.checkHand();
        dealerDeal();
        //myHand.initialDeal = true;

        //myHand.initialDeal = false;


        while (!gameOver) {

            sleeper.sleep1k();
            System.out.println("\nWhat would you like to do? (hit/stand)");
            String stringInput = scanner.nextLine();

            if (stringInput.equals("hit")) {
                playerHit();
                if (!myHand.busted){
                    dealerTurn();
                }
            } else if (stringInput.equals("stand")) {
                myHand.stand = true;
                while ((!dealer.stand) && (!dealer.busted)) {
                    dealerTurn();
                }
            }
            if ((myHand.stand) && (dealer.stand)) {
                System.out.println("\nBoth you and Dealer Steve chose to stand. Time to flip the cards and see who wins!\n");
                System.out.println("Your hand was: ");
                myHand.printHand();
                System.out.println("(Total: " + myHand.checkTotal() + ")\n");

                System.out.println("Steve's hand was: ");
                dealer.printDealerHand();
                System.out.println("(Total: " + dealer.total + ")\n");

                // Determine the winner by hand total
                if (myHand.total > dealer.total) {
                    System.out.println("YOU WIN! :D");
                } else if(myHand.total == dealer.total){
                    System.out.println("It was a tie!");
                } else {
                    System.out.println("Aw man, Dealer Steve won :(\n");
                }
                gameOver = true;
            }
        }

        if (gameOver) {
            System.out.println("Would you like to play again? (yes/no)");
            String input = scanner.nextLine();
            if (input.equals("no")) {
                System.exit(0);
            }
        }

    }

    public void playerDeal() {
        /*
         * This method is only called at the beginning of the round on first deal.
         * It pulls two cards from the deck and puts them in the user's hand,
         * checks for a natural blackjack, then prints the hand
         */
        Card card1 = deck.cardDeck.get(0);
        Card card2 = deck.cardDeck.get(1);
        myHand.playerHand.add(card1);
        myHand.playerHand.add(card2);
        deck.cardDeck.remove(0);
        deck.cardDeck.remove(0);

        myHand.total = card1.value + card2.value;
        if (myHand.total == 21) {
            myHand.blackjack = true;
        }

        myHand.printHand();
    }

    public void dealerDeal() {
        /*
         * Very similar to playerDeal().
         * This method is only called at the beginning of the round on first deal.
         * It pulls two cards from the deck and puts them in the dealer's hand,
         * checks for a natural blackjack, then prints one card plus "hidden card"
         */
        Card card1 = deck.cardDeck.get(0);
        Card card2 = deck.cardDeck.get(1);

        dealer.dealerHand.add(card1);
        dealer.dealerHand.add(card2);
        deck.cardDeck.remove(0);
        deck.cardDeck.remove(0);

        dealer.total = card1.value + card2.value;
        if (dealer.total == 21) {
            dealer.blackjack = true;
        }
        dealer.printDealer(card1);
    }

    public void playerHit() {
        /*
         * Method used for when player chooses to hit. Pulls from the top of
         * the shuffled deck, adds to player hand and removes from deck.
         * Then does a hand check to see if the player has busted or not.
         *
         * Also this is when a deck check is run to see if the deck needs
         * to be reshuffled.
         */
        hitCard = deck.cardDeck.get(0);
        myHand.playerHand.add(hitCard);
        deck.cardDeck.remove(hitCard);

        String faceName = hitCard.face == null ? " of " : hitCard.face + " of ";
        if ((hitCard.isFaceCard) || (hitCard.isAceCard)) {
            System.out.println("Steve deals you " + faceName + hitCard.suit);
        } else {
            System.out.println("Steve deals you " + hitCard.value + faceName + hitCard.suit);
        }
        myHand.checkHand();
        if ((myHand.busted)  || (myHand.blackjack)) {
            gameOver = true;
        }
        deck.deckCheck();
    }

    public void dealerHit() {
        /*
         * Method used for when dealer chooses to hit. Pulls from the top of
         * the shuffled deck, adds to dealer hand and removes from deck.
         * Then does a hand check to see if the dealer has busted or not.
         *
         * Also this is when a deck check is run to see if the deck needs
         * to be reshuffled.
         */
        hitCard = deck.cardDeck.get(0);
        dealer.dealerHand.add(deck.cardDeck.get(0));
        deck.cardDeck.remove(0);

        String faceName = hitCard.face == null ? " of " : hitCard.face + " of ";
        if ((hitCard.isFaceCard) || (hitCard.isAceCard)) {
            System.out.println("Dealer Steve gets " + faceName + hitCard.suit);
        } else {
            System.out.println("Dealer Steve gets " + hitCard.value + faceName + hitCard.suit);
        }
        dealer.checkHand();
        if ((dealer.busted) || (dealer.blackjack)) {
            gameOver = true;
        }
        deck.deckCheck();
    }

    public void dealerTurn() {
        /*
         * This runs the logic for what the dealer decides to do on his turn.
         * If he has a 17 or higher he has to hit.
         */
        if (dealer.total <= 16) {
            System.out.println("Dealer Steve hits.");
            dealerHit();
        } else {
            dealer.stand = true;
            System.out.println("Dealer Steve chose to stand.");
        }
    }

    public void acePlayerDeal() {
        /*
         * Used for testing ace value functionality.
         *
         * Replaces playerDeal method, basically just forces the first
         * card in the hand to be the Ace of Spades
         */
        Card card1 = new Card(1, "Spades", 1);
        Card card2 = deck.cardDeck.get(1);
        myHand.playerHand.add(card1);
        myHand.playerHand.add(card2);
        deck.cardDeck.remove(0);
        deck.cardDeck.remove(0);

        myHand.total = card1.value + card2.value;
        if (myHand.total == 21) {
            myHand.blackjack = true;
        }

        myHand.printHand();
        System.out.printf("(Your total is %d)\n\n", myHand.total);
    }

}
