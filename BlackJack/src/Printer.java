import java.util.ArrayList;

/**
 * Created by stephen.farmer on 5/13/16.
 *
 *     suits_symbols = ['♠', '♦', '♥', '♣']
 *
 *     Indexes to replace: 1, 4, 7
 */
public class Printer {
    ArrayList<String> playingCard = new ArrayList<>();

    public void printCard(){
        playingCard.add("┌─────────┐");
        playingCard.add("│         │");
        playingCard.add("│         │");
        playingCard.add("│         │");
        playingCard.add("│         │");
        playingCard.add("│         │");
        playingCard.add("│         │");
        playingCard.add("│         │");
        playingCard.add("└─────────┘");
    }

    public void printTitle(){
        System.out.println("   _____ __                _                            \n" +
                "  / ___// /____ _   _____ ( )_____                      \n" +
                "  \\__ \\/ __/ _ \\ | / / _ \\|// ___/                      \n" +
                " ___/ / /_/  __/ |/ /  __/ (__  )                       \n" +
                "/________/____/|___/\\____________    _____   ________ __\n" +
                "   / __ )/ /   /   | / ____/ //_/   / /   | / ____/ //_/\n" +
                "  / __  / /   / /| |/ /   / ,< __  / / /| |/ /   / ,<   \n" +
                " / /_/ / /___/ ___ / /___/ /| / /_/ / ___ / /___/ /| |  \n" +
                "/_____/_____/_/  |_\\____/_/ |_\\____/_/  |_\\____/_/ |_|  \n" +
                "                                                        \n");
    }
}
