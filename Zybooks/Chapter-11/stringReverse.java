import java.util.Scanner;

public class LabProgram {

   public static String reverseString(String str) {
      // Base case: If the string is empty or has only one character, return the string as is
      if (str.length() <= 1) {
         return str;
      }

      // Recursive case: Move the first character to the end and call reverseString() on the remaining substring
      char firstChar = str.charAt(0);
      String remainingString = str.substring(1);
      String reversedString = reverseString(remainingString);

      return reversedString + firstChar;
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String input, result;

      input = scnr.nextLine();
      result = reverseString(input);
      System.out.printf("Reverse of \"%s\" is \"%s\".", input, result);
   }
}
