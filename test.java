//InteractiveDriver.java
import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;


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

//course.java

public class Course {
    private String courseName;
    private Student[] roster;
    private Student[] waitlist;
    private int maxRosterSize;
    private int maxWaitlistSize;
    private int rosterSize;
    private int waitlistSize;

    public Course(String courseName, int maxRosterSize, int maxWaitlistSize) {
        this.courseName = courseName;
        this.roster = new Student[maxRosterSize];
        this.waitlist = new Student[maxWaitlistSize];
        this.maxRosterSize = maxRosterSize;
        this.maxWaitlistSize = maxWaitlistSize;
        this.rosterSize = 0;
        this.waitlistSize = 0;
    }

    public Student[] getRoster() {
        return roster;
    }

    public Student[] getWaitlist() {
        return waitlist;
    }

    public int getMaxRosterSize() {
        return maxRosterSize;
    }

    public int getMaxWaitlistSize() {
        return maxWaitlistSize;
    }

    //@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course: ").append(courseName).append("\n");
        sb.append("Roster: ").append(rosterSize).append("/").append(maxRosterSize).append("\n");
        for (int i = 0; i < rosterSize; i++) {
            sb.append(roster[i]).append("\n");
        }
        sb.append("Waitlist: ").append(waitlistSize).append("/").append(maxWaitlistSize).append("\n");
        for (int i = 0; i < waitlistSize; i++) {
            sb.append(waitlist[i]).append("\n");
        }
        return sb.toString();
    }

    public boolean addStudent(Student student) {
        if (student == null || !student.isTuitionPaid()) {
            return false;
        }

        if (rosterSize < maxRosterSize && !containsStudent(roster, student)) {
            roster[rosterSize++] = student;
            return true;
        } else if (waitlistSize < maxWaitlistSize && !containsStudent(waitlist, student)) {
            waitlist[waitlistSize++] = student;
            return true;
        }

        return false;
    }

    public boolean dropStudent(Student student) {
        if (student == null) {
            return false;
        }

        if (removeFromList(roster, student)) {
            if (waitlistSize > 0) {
                roster[rosterSize++] = waitlist[0];
                shiftListLeft(waitlist);
                waitlistSize--;
            }
            return true;
        } else if (removeFromList(waitlist, student)) {
            return true;
        }

        return false;
    }

    private boolean removeFromList(Student[] list, Student student) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && list[i].equals(student)) {
                list[i] = null;
                shiftListLeft(list);
                return true;
            }
        }
        return false;
    }

    private void shiftListLeft(Student[] list) {
        int i = 0;
        while (i < list.length - 1 && list[i] != null) {
            list[i] = list[i + 1];
            i++;
        }
    }

    private boolean containsStudent(Student[] list, Student student) {
        for (Student s : list) {
            if (s != null && s.equals(student)) {
                return true;
            }
        }
        return false;
    }
}




//Student.java
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private boolean tuitionPaid;

    public Student(int id, String firstName, String lastName, boolean tuitionPaid) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tuitionPaid = tuitionPaid;
    }

    //@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        // Check if all relevant fields are equal (ignore case for firstName and lastName)
        return id == student.id &&
                tuitionPaid == student.tuitionPaid &&
                Objects.equals(firstName.toLowerCase(), student.firstName.toLowerCase()) &&
                Objects.equals(lastName.toLowerCase(), student.lastName.toLowerCase());
    }

    //@Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, tuitionPaid);
    }

    //@Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", tuitionPaid=" + tuitionPaid +
                '}';
    }

    public boolean isTuitionPaid() {
        return tuitionPaid;
    }
}
