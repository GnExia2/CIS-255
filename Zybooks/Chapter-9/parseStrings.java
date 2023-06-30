import java.util.Scanner;

public class ParseStrings {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String input;

      while (true) {
         System.out.println("Enter input string:");
         input = scnr.nextLine();

         if (input.equals("q")) {
            break;
         }

         if (!input.contains(",")) {
            System.out.println("Error: No comma in string.");
            System.out.println();
            continue;
         }

         String[] words = input.split(",");
         String firstWord = words[0].trim();
         String secondWord = words[1].trim();

         System.out.println("First word: " + firstWord);
         System.out.println("Second word: " + secondWord);
         System.out.println();
      }
   }
}
