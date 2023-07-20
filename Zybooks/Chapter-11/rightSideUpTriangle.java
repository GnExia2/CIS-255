import java.util.Scanner;

public class LabProgram {

    public static void drawTriangle(int baseLength) {
        drawTriangleHelper(baseLength, 0);
    }

    private static void drawTriangleHelper(int baseLength, int spaces) {
        if (baseLength <= 0) {
            return;
        }

        drawTriangleHelper(baseLength - 2, spaces + 1);

        printSpaces(spaces);
        printStars(baseLength);
    }

    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private static void printStars(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int baseLength;

        baseLength = scnr.nextInt();
        drawTriangle(baseLength);
    }
}
