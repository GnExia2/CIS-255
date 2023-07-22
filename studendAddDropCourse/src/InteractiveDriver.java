import java.util.Scanner;

public class InteractiveDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum roster size: ");
        int maxRosterSize = scanner.nextInt();
        System.out.print("Enter the maximum waitlist size: ");
        int maxWaitlistSize = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Course course = new Course("Example Course", maxRosterSize, maxWaitlistSize);
        boolean running = true;

        while (running) {
            System.out.println("\nSelect an action:");
            System.out.println("1. Add Student");
            System.out.println("2. Drop Student");
            System.out.println("3. View Course");
            System.out.println("4. Exit");
            System.out.print("Enter the option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Has the student paid tuition? (true/false): ");
                    boolean tuitionPaid = scanner.nextBoolean();
                    scanner.nextLine(); // Consume the newline character

                    Student student = new Student(id, firstName, lastName, tuitionPaid);
                    boolean added = course.addStudent(student);
                    System.out.println(added ? "Student added successfully." : "Failed to add student.");
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    int dropId = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    Student dropStudent = new Student(dropId, "", "", false);
                    boolean dropped = course.dropStudent(dropStudent);
                    System.out.println(dropped ? "Student dropped successfully." : "Failed to drop student.");
                    break;
                case 3:
                    System.out.println(course.toString());
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
