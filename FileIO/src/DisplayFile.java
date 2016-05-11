import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by stephen.farmer on 5/6/16.
 */
public class DisplayFile {
    public static String fileName = null;
    public static void main(String[] args) {
        System.out.println("Enter file to open: (score or letter)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        switch (input) {
            case "score":
                fileName = "score.txt";
                break;
            case "letter":
                fileName = "letter.txt";
                break;
        }
        print();
    }

    public static void print() {
        String line;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException mFileNotFoundException) {
            System.out.println("Unable to open '" + fileName);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
