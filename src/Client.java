
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author mati
 */
public class Client {

    public static void main(String[] args) {
        Levenshtein lev = new Levenshtein();
        String imie = args[1];
        int line = 0;
        String fileName = args[0];
        BufferedReader reader = null;
        int min = Integer.MAX_VALUE;
        findResult(reader, fileName, line, lev, imie, min);
    }

    private static void findResult(BufferedReader reader, String fileName,
            int line, Levenshtein lev, String imie, int min) {
        try {
            reader = new BufferedReader(new FileReader(fileName));
            int tmpInt = 0, result =0;
            readLines(reader, tmpInt, line, lev, imie, min, result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeReader(reader);
        }
    }

    private static void readLines(BufferedReader reader, int tmpInt,
            int line, Levenshtein lev, String imie, int min, int result)
            throws IOException {
        String tmp;
        while ((tmp = reader.readLine()) != null) {
            line++;
            tmpInt = lev.levenshteinDistance(imie, tmp.trim());
            if (min == 0) {
                System.out.println("Linia : " + line);
                System.exit(0);
            }
            if (min > tmpInt) {
                min = tmpInt;
                result = line;
            }
        }
        System.out.println("Linia: " + result);
    }

    private static void closeReader(BufferedReader reader) {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
