import java.text.MessageFormat;

/**
 * Created by stephen.farmer on 5/13/16.
 */
public class Printer {

    MessageFormat cardFormatter;

    public void printCard(BaseCard baseCard, Card card){
        Object[] cardArray = {card.value, card.suitImage};
        if (card.value < 10) {
            cardFormatter = new MessageFormat(baseCard.toString());
        } else {

        }


        String format = cardFormatter.format(cardArray);
        System.out.print(format);
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
