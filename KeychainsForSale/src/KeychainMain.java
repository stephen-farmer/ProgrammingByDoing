import java.util.Scanner;

/**
 * Created by stephen.farmer on 5/5/16.
 */
public class KeychainMain {

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
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        switch (input) {
            case 1:
                addKeychains();
                break;
            case 2:
                removeKeychains();
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
        System.out.println("ADD KEYCHAINS");
    }

    public static void removeKeychains(){
        System.out.println("REMOVE KEYCHAINS");
    }

    public static void viewKeychains(){
        System.out.println("VIEW KEYCHAINS");
    }

    public static void checkout(){
        System.out.println("CHECKOUT");
    }
}
