import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class LabProgram {

    public static String findID(String studentName, Scanner infoScnr) throws Exception {
        while (infoScnr.hasNext()) {
            String name = infoScnr.next();
            String id = infoScnr.next();
            if (name.equals(studentName)) {
                return id;
            }
        }
        throw new Exception("Student ID not found for " + studentName);
    }

    public static String findName(String studentID, Scanner infoScnr) throws Exception {
        while (infoScnr.hasNext()) {
            String name = infoScnr.next();
            String id = infoScnr.next();
            if (id.equals(studentID)) {
                return name;
            }
        }
        throw new Exception("Student name not found for " + studentID);
    }

    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);
        String studentName;
        String studentID;
        String studentInfoFileName;
        FileInputStream studentInfoStream = null;
        Scanner studentInfoScanner = null;

        // Read the text file name from the user
        studentInfoFileName = scnr.next();

        // Open the text file
        studentInfoStream = new FileInputStream(studentInfoFileName);
        studentInfoScanner = new Scanner(studentInfoStream);

        // Read search option from the user. 0: findID(), 1: findName()
        int userChoice = scnr.nextInt();

        try {
            if (userChoice == 0) {
                studentName = scnr.next();
                studentID = findID(studentName, studentInfoScanner);
                System.out.println(studentID);
            } else {
                studentID = scnr.next();
                studentName = findName(studentID, studentInfoScanner);
                System.out.println(studentName);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (studentInfoStream != null) {
                studentInfoStream.close();
            }
        }
    }
}
