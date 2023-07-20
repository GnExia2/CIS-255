import java.util.Scanner;
import java.util.NoSuchElementException;

public class LabProgram {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int val1;
        int val2;
        int val3;
        int max;

        val1 = 0;
        val2 = 0;
        val3 = 0;

        try {
            val1 = scnr.nextInt();
            val2 = scnr.nextInt();
            val3 = scnr.nextInt();

            max = Math.max(val1, Math.max(val2, val3));

            System.out.println(max);
        } catch (NoSuchElementException e) {
            int count = 0;
            if (val1 != 0) count++;
            if (val2 != 0) count++;
            if (val3 != 0) count++;

            if (count == 0) {
                System.out.println("0 input(s) read:");
                System.out.println("No max");
            } else {
                System.out.println(count + " input(s) read:");
                System.out.println("Max is " + Math.max(val1, Math.max(val2, val3)));
            }
        }
    }
}
