import java.util.ArrayList;

/**
 * Created by stephen.farmer on 5/16/16.
 */
public class BaseCard {
    ArrayList<String> playingCard = new ArrayList<>();

    public BaseCard(){

        playingCard.add("┌─────────┐");
        playingCard.add("│{0}        │");
        playingCard.add("│         │");
        playingCard.add("│         │");
        playingCard.add("│    {1}    │");
        playingCard.add("│         │");
        playingCard.add("│         │");
        playingCard.add("│       {0} │");
        playingCard.add("└─────────┘");
    }

    @Override
    public String toString(){
        String results = "";
        for (String s : playingCard) {
            results += s + "\n";
        }
        return results;
    }
}
