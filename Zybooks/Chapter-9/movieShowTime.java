import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

public class LabProgram {
    public static void main(String[] args) throws IOException {
        Scanner scnr = new Scanner(System.in);

        String fileName = scnr.nextLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        Scanner fileScanner = new Scanner(fileInputStream);

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] fields = line.split(",");

            String title = fields[1].length() > 44 ? fields[1].substring(0, 44) : fields[1];
            String rating = fields[2];

            StringBuilder showtimes = new StringBuilder();
            for (int i = 0; i < fields.length - 3; i++) {
                showtimes.append(fields[i]);
                if (i < fields.length - 4) {
                    showtimes.append(" ");
                }
            }

            System.out.printf("%-44s | %5s | %s%n", title, rating, showtimes);
        }

        fileScanner.close();
        fileInputStream.close();
    }
}
