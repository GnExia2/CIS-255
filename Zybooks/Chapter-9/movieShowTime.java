import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class LabProgram {
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);

        String fileName = scnr.nextLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        Scanner fileScanner = new Scanner(fileInputStream);

        String prevTitle = null;
        String title = null;
        String rating = null;
        StringBuilder showtimes = new StringBuilder();

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] movieData = line.split(",");

            // Extract movie data from the CSV file
            String time = movieData[0];
            title = movieData[1].trim();
            rating = movieData[2].trim();

            // Check if it's a new movie title
            if (prevTitle != null && !title.equals(prevTitle)) {
                printFormattedRow(prevTitle, rating, showtimes.toString());
                showtimes = new StringBuilder();
            }

            showtimes.append(time).append(" ");
            prevTitle = title;
        }

        // Print the last movie after the loop ends
        if (title != null) {
            printFormattedRow(title, rating, showtimes.toString());
        }

        fileScanner.close();
        fileInputStream.close();
        scnr.close();
    }

    public static void printFormattedRow(String title, String rating, String showtimes) {
        // Truncate title if it exceeds 44 characters
        if (title.length() > 44) {
            title = title.substring(0, 44);
        }

        // Format and output the row
        System.out.printf("%-44s | %5s | %s%n", title, rating, showtimes.trim());
    }
}
