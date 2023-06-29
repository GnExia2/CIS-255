import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class LabProgram {
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        int NUM_CHARACTERS = 26;      // Maximum number of letters
        int MAX_WORDS = 10;           // Maximum number of synonyms per starting letter

        String[][] synonyms = new String[NUM_CHARACTERS][MAX_WORDS];  // Declare 2D array for all synonyms
        String[] words = new String[MAX_WORDS]; // The words of each input line

        String word = scnr.nextLine();
        char letter = scnr.nextLine().charAt(0);

        String filename = word + ".txt";
        FileInputStream fileInputStream = new FileInputStream(filename);

        Scanner fileScanner = new Scanner(fileInputStream);

        // Read the file and store synonyms in the array
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            words = line.split(" ");
            int index = letter - 'a';
            synonyms[index] = words;
        }

        fileScanner.close();
        fileInputStream.close();

        int index = letter - 'a';
        String[] wordSynonyms = synonyms[index];

        // Output synonyms that begin with the input letter
        boolean foundSynonyms = false;
        if (wordSynonyms != null) {
            for (String synonym : wordSynonyms) {
                if (synonym != null && synonym.charAt(0) == letter) {
                    System.out.println(synonym);
                    foundSynonyms = true;
                }
            }
        }

        if (!foundSynonyms) {
            System.out.println("No synonyms for " + word + " begin with " + letter + ".");
        }
    }
}
