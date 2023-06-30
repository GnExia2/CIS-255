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

      // Read word and letter from the user
      String word = scnr.next();
      char letter = scnr.next().charAt(0);

      // Open the corresponding text file
      FileInputStream fileInputStream = new FileInputStream(word + ".txt");

      // Read the contents of the text file into the array
      StringBuilder fileContent = new StringBuilder();
      int content;
      while ((content = fileInputStream.read()) != -1) {
         fileContent.append((char) content);
      }
      fileInputStream.close();

      // Split the file content into lines
      String[] lines = fileContent.toString().split("\n");

      // Store the synonyms into the array
      for (String line : lines) {
         words = line.split(" ");
         char firstLetter = words[0].charAt(0);
         int rowIndex = firstLetter - 'a';
         for (int i = 0; i < words.length; i++) {
            synonyms[rowIndex][i] = words[i];
         }
      }

      // Search the array and output synonyms that begin with the input letter
      int letterIndex = letter - 'a';
      boolean foundSynonyms = false;
      for (int i = 0; i < MAX_WORDS; i++) {
         if (synonyms[letterIndex][i] != null && synonyms[letterIndex][i].charAt(0) == letter) {
            System.out.println(synonyms[letterIndex][i]);
            foundSynonyms = true;
         }
      }

      // Output message if no synonyms were found
      if (!foundSynonyms) {
         System.out.println("No synonyms for " + word + " begin with " + letter + ".");
      }
   }
}
