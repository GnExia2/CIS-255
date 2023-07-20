import java.util.Scanner;

public class LabProgram {

    public static int digitCount(int num) {
        // Base case: When the number is 0, return 1 (since it has one digit)
        if (num == 0) {
            return 1;
        }

        // Recursive case: Divide the number by 10 and increment the digit count by 1
        return 1 + digitCount(num / 10);
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int num, digits;

        num = scnr.nextInt();
        digits = digitCount(num);
        System.out.println(digits);
    }
}
