import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by stephen.farmer on 5/17/16.
 */
public class Game {
    public String player1 = "Steve";
    public String player2 = "Mike";
    ArrayList<Integer> pileA = new ArrayList<>();
    ArrayList<Integer> pileB = new ArrayList<>();
    ArrayList<Integer> pileC = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public boolean currentlyPlayerOneTurn = true;

    public void run(){
//        System.out.println("Player 1, enter your name:");
//        player1 = scanner.next();
//        System.out.println("Player 2, enter your name:");
//        player2 = scanner.next();

        for (int a=0; a<3; a++) {
            pileA.add(a);
        }
        for (int b=0; b<4; b++) {
            pileB.add(b);
        }
        for (int c=0; c<5; c++) {
            pileC.add(c);
        }

        while (true) {
            printPiles();
            if (currentlyPlayerOneTurn) {
                System.out.printf("%s, choose a pile: ", player1);
                playerTurn();
                currentlyPlayerOneTurn = false;
            } else {
                System.out.printf("%s, choose a pile: ", player2);
                playerTurn();
                currentlyPlayerOneTurn = true;
            }

        }

    }

    public void playerTurn(){
        String pileSelection = scanner.next();
        System.out.printf("How many to remove from pile %s: ", pileSelection);
        int pileRemovalNum = scanner.nextInt();

        switch (pileSelection) {
            case "A":
                for(int i=0; i<=pileRemovalNum-1; i++) {
                    pileA.remove(0);
                }
                break;
            case "B":
                for(int i=0; i<=pileRemovalNum-1; i++) {
                    pileB.remove(0);
                }
                break;
            case "C":
                for(int i=0; i<=pileRemovalNum-1; i++) {
                    pileC.remove(0);
                }
                break;
        }
    }


    public void printPiles(){
        int aSize = pileA.size();
        int bSize = pileB.size();
        int cSize = pileC.size();

        if ((aSize == 0) && (bSize == 0) && (cSize == 0)) {
            if (!currentlyPlayerOneTurn) {
                System.out.printf("\nGame over! %s wins!", player2);
                System.exit(0);
            } else {
                System.out.printf("\nGame over! %s wins!", player1);
                System.exit(0);
            }
        }
        System.out.printf("\nA: %s    B: %s   C: %s\n\n", aSize, bSize, cSize);
    }
}
