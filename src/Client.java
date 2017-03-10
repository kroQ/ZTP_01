
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

//        String imie = "imie1";
        String imie = args[1];
        int linia = 0;

        //String fileName = "./folder/file.txt";
        String fileName = args[0];
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String tmp;
            int min = 999_999_999;
            int tmpInt = 0;
            while ((tmp = reader.readLine()) != null) {
                linia++;
                //System.out.println(tmp);
                //System.out.println(lev.levenshteinDistance(imie, tmp.trim()));
                tmpInt = lev.levenshteinDistance(imie, tmp.trim());
                if (min == 0) {
                    System.out.println("Linia : " + linia);
                    return;
                }
                if (min > tmpInt) {
                    min = tmpInt;
                }
            }
            System.out.println(min);
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
