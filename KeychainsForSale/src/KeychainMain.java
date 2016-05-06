import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by stephen.farmer on 5/5/16.
 */
public class KeychainMain {

    static int numberOfKeychains = 0;
    static int keychainPrice = 10;
    static Scanner scanner = new Scanner(System.in);
    static double salesTax = .0825;
    static int orderShippingCost = 5;

    public static void main(String[] args) {
        while (true) {
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
                    System.out.println("Error, please select valid menu number");
            }
        }
    }

    public static void addKeychains(){
        System.out.printf("\nYou have %d keychains. How many to add? ", numberOfKeychains);
        numberOfKeychains += scanner.nextInt();
        System.out.printf("You now have %d keychains\n", numberOfKeychains);
    }

    public static int removeKeychains(int keychainsToRemove){
        if(keychainsToRemove<numberOfKeychains){
            numberOfKeychains -= keychainsToRemove;
        } else {
            System.out.printf("You cannot remove %d keychains when you only have %d\n", keychainsToRemove, numberOfKeychains);
        }

        return numberOfKeychains;
    }

    public static void viewKeychains(){
        // Display (on separate lines) number of keychains in order, price per keychain,
        // shipping charges on order, subtotal before tax, tax on the order, and final cost of order
        System.out.printf("\nYou have %d keychains\n", numberOfKeychains);
        System.out.printf(" • Keychains cost $%d each\n", keychainPrice);
        System.out.printf(" • Shipping charges: $%d\n", orderShippingCost);

        int beforeTax = numberOfKeychains * keychainPrice;

        System.out.printf(" • Total cost before tax: $%d\n", beforeTax);

        DecimalFormat formatter = new DecimalFormat("#0.00");
        double tax = beforeTax*salesTax;
        System.out.println(" • Tax on the order: $" + formatter.format(tax));

        double afterTax = tax + beforeTax;
        System.out.println("** Final cost of order: $" + formatter.format(afterTax) + " **");
    }

    public static void checkout(){
        System.out.println("What is your name?");
        String name = scanner.next();
        viewKeychains();
        System.out.printf("Thanks for your order, %s!", name);
        System.exit(0);
    }
}
