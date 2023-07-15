import java.util.Scanner;

public class NumberPattern {
   // Recursive method to print the number pattern
   public static void printNumPattern(int num1, int num2) {
      System.out.print(num1 + " ");

      // Base case: Stop recursion when num1 becomes negative
      if (num1 < 0) {
         return;
      }

      // Recursive case: Subtract num2 and recursively call printNumPattern()
      printNumPattern(num1 - num2, num2);

      // Print the numbers while adding num2 until num1 is reached again
      System.out.print(num1 + " ");
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int num1;
      int num2;

      num1 = scnr.nextInt();
      num2 = scnr.nextInt();
      printNumPattern(num1, num2);
   }
}
