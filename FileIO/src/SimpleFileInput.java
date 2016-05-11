import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by stephen.farmer on 5/6/16.
 */
public class SimpleFileInput {
    public static void main(String[] args) {

        String filename = "name.txt";
        String line = null;

        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Using my psychic powers, I have determined your name is " + line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException fileEx) {
            System.out.println("Unable to open file '" + filename + "'");
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
