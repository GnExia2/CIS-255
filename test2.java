public class DrawTriangle {
    public static void main(String[] args) {
        int n = 7; // Replace 7 with the desired value of n
        drawTriangle(n);
    }

    public static void drawTriangle(int n) {
        if (n == 1) {
            System.out.println("*".center(19));
        } else {
            drawTriangle(n - 2);
            System.out.println(String.format("%" + 19 + "s", "*".repeat(n)));
        }
    }

    // Helper methods to simulate Python functions not present in Java
    public static String center(int width) {
        int spaces = (width - 1) / 2;
        return String.format("%" + (width - spaces) + "s", "");
    }

    public static String repeat(int count) {
        return new String(new char[count]).replace("\0", "*");
    }
}



import java.util.Scanner;

public class LabProgram {

    // Recursive method to draw the right-side up isosceles triangle
    public static void drawTriangle(int baseLength) {
        // Base case: When the base length is 1, print a single '*'
        if (baseLength == 1) {
            System.out.println("         *");
        } else {
            // Recursive case: Draw the upper part of the triangle with a smaller base length
            drawTriangle(baseLength - 2);

            // Print spaces and '*' characters to form the triangle
            for (int i = 0; i < (9 + (baseLength - 1) / 2); i++) {
                System.out.print(" ");
            }
            for (int i = 0; i < baseLength; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int baseLength;

        baseLength = scnr.nextInt();
        drawTriangle(baseLength);
    }
}
