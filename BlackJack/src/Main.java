
/**
 * Created by stephen.farmer on 5/11/16.
 */
public class Main {
    static Printer printer = new Printer();
    public static void main(String[] args) {
        printer.printTitle();

        while(true){
            Blackjack game = new Blackjack();
            game.run();
        }
    }
}