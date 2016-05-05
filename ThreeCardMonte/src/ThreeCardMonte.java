import java.util.Random;
import java.util.Scanner;

/**
 * Created by stephen.farmer on 5/4/16.
 */
public class ThreeCardMonte {
    public static int money = 50;
    public static void main(String[] args) {

        boolean playing = true;

        System.out.printf("You have $%d.", money);
        System.out.println(
                "\nYou slide up to Fast Eddie's card table.\n" +
                        "The game is Three Card Monte, it costs $10 to play. You plop down your cash.\n" +
                        "He glances at you out of the corner of his eye and starts shuffling.\n" +
                        "He lays down three cards.\n"
        );

        while (playing) {
            play();
            System.out.println("Would you like to play again?");
            Scanner scan = new Scanner(System.in);
            String answer = scan.nextLine();
            if (answer.equals("yes") || answer.equals("Yes") || answer.equals("YES")) {
                playing = true;
            } else if (answer.equals("no") || answer.equals("No") || answer.equals("NO")){
                playing = false;
            }
        }


    }

    public static void play() {
        Random random = new Random();
        int num = random.nextInt((3-1)+1)+1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Which one has the ace?\n");
        System.out.println("\t\t##  ##  ##\n" +
                "\t\t##  ##  ##\n" +
                "\t\t1   2   3"
        );

        int input = scanner.nextInt();
        if (input == num) {
            System.out.println("You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.\n");
            money = money +10;
        } else {
            System.out.printf("Ha! Fast Eddie wins again! The ace was card number %d.\n\n", num);
            money = money-10;
        }

        switch(num){
            case 1:
                printOne();
                break;
            case 2:
                printTwo();
                break;
            case 3:
                printThree();
                break;
        }

        System.out.printf("You have $%d.\n\n", money);

        if (money < 10) {
            System.out.println("Bank busted! You don't have enough to play.");
            System.exit(0);
        }
    }

    public static void printOne(){
        System.out.println("\t\tAA  ##  ##\n" +
                "\t\tAA  ##  ##\n" +
                "\t\t1   2   3\n"
        );
    }

    public static void printTwo(){
        System.out.println("\t\t##  AA  ##\n" +
                "\t\t##  AA  ##\n" +
                "\t\t1   2   3\n"
        );
    }

    public static void printThree(){
        System.out.println("\t\t##  ##  AA\n" +
                "\t\t##  ##  AA\n" +
                "\t\t1   2   3\n"
        );
    }
}
