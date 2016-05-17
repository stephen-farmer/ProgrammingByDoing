/**
 * Created by stephen.farmer on 5/16/16.
 */
public class Sleeper {

    public void sleep1k(){
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException ex)
        {
        }
    }

    public void sleep2k(){
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex)
        {
        }
    }

    public void sleep3k(){
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException ex)
        {
        }
    }
}
