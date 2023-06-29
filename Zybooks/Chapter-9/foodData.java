import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class foodData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();

        List<String> categories = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<String> descriptions = new ArrayList<>();
        List<String> availability = new ArrayList<>();

        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split("\t");

                String category = data[0];
                String name = data[1];
                String description = data[2];
                String avail = data[3];

                categories.add(category);
                names.add(name);
                descriptions.add(description);
                availability.add(avail);
            }

            fileScanner.close();

            // Output the available food items
            for (int i = 0; i < categories.size(); i++) {
                if (availability.get(i).equals("Available")) {
                    System.out.printf("%s (%s) -- %s%n", names.get(i), categories.get(i), descriptions.get(i));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
