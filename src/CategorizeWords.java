import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CategorizeWords {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(".\\sample.txt"))) {
            FileWriter oneLetterFile = new FileWriter("oneletter.txt");
            FileWriter twoLetterFile = new FileWriter("twoletter.txt");
            FileWriter threeLetterFile = new FileWriter("threeletter.txt");

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    int wordLength = word.length();

                    if (wordLength == 1) {
                        oneLetterFile.write(word + " ");
                    } else if (wordLength == 2) {
                        twoLetterFile.write(word + " ");
                    } else if (wordLength == 3) {
                        threeLetterFile.write(word + " ");
                    }

                }
            }


            oneLetterFile.close();
            twoLetterFile.close();
            threeLetterFile.close();

            System.out.println("Words categorized successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
