import java.util.Scanner;

/**
 * Created by stephen.farmer on 5/5/16.
 */
public class KeychainMain {

    static int numberOfKeychains = 0;
    static int keychainPrice = 10;
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        while (true) {
            mainMenu();
        }
    }

    public static void mainMenu(){

        System.out.println("\nYe Olde Keychain Shoppe\n\n" +
                "1. Add Keychains to Order\n" +
                "2. Remove Keychains from Order\n" +
                "3. View Current Order\n" +
                "4. Checkout\n"
        );

        System.out.println("Please enter your choice: ");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                addKeychains();
                break;
            case 2:
                System.out.printf("\nYou have %d keychains. How many to remove? ", numberOfKeychains);
                int removal = scanner.nextInt();
                removeKeychains(removal);
                System.out.printf("You now have %d keychains\n", numberOfKeychains);
                break;
            case 3:
                viewKeychains();
                break;
            case 4:
                checkout();
                break;
            default:
                System.out.println("Error");
        }
    }

    public static void addKeychains(){
        System.out.printf("\nYou have %d keychains. How many to add? ", numberOfKeychains);
        numberOfKeychains += scanner.nextInt();
        System.out.printf("You now have %d keychains\n", numberOfKeychains);
    }

    public static int removeKeychains(int keychainsToRemove){
        numberOfKeychains -= keychainsToRemove;
        return numberOfKeychains;
    }

    public static void viewKeychains(){
        System.out.printf("\nYou have %d keychains\n", numberOfKeychains);
        System.out.printf("Keychains cost $%d each\n", keychainPrice);
        int total = numberOfKeychains * keychainPrice;
        System.out.printf("Total cost is $%d\n", total);
    }

    public static void checkout(){
        System.out.println("What is your name?");
        String name = scanner.next();
        viewKeychains();
        System.out.printf("Thanks for your order, %s!", name);
        System.exit(0);
    }
}
