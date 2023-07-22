import java.util.Scanner;
import java.util.InputMismatchException;

public class NameAgeChecker {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        String inputName = ""; // Initialize to an empty string
        int age;

        while (scnr.hasNext()) {
            try {
                inputName = scnr.next();
                if (inputName.equals("-1")) {
                    break;
                }

                age = scnr.nextInt();
                System.out.println(inputName + " " + (age + 1));
            } catch (InputMismatchException e) {
                // If the age is not an integer, set age to 0 and print the name with age 0
                age = 0;
                System.out.println(inputName + " " + age);
                scnr.nextLine(); // Consume the rest of the line to avoid parsing errors
            }
        }
    }
}
