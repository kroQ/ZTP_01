
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author mati
 */
public class Client {
        public static void main(String[] args) {
            //System.out.println(args[0] + args[1]);
            
            Levenshtein lev = new Levenshtein();
            
            String imie = "imie1";
            
        String fileName = "./folder/file.txt";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String tmp;
            while ((tmp = reader.readLine()) != null) {
                System.out.println(tmp);
                System.out.println(lev.levenshteinDistance(imie, tmp));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
