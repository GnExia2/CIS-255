import java.util.Scanner;

public class LabProgram {

   public static void drawTriangle(int baseLength) {
      if (baseLength <= 0) {
         return;
      }

      // Output spaces before the first '*' on each line
      for (int i = 0; i < (9 - baseLength / 2); i++) {
         System.out.print(" ");
      }

      // Output '*' characters for the current line
      for (int i = 0; i < baseLength; i++) {
         System.out.print("*");
      }
      System.out.println();

      // Recursive call with a smaller base length
      drawTriangle(baseLength - 2);
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int baseLength;

      baseLength = scnr.nextInt();
      drawTriangle(baseLength);
   }
}
