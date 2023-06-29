import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;

public class courseGrade {
   public static void main(String[] args) throws IOException {
      Scanner scnr = new Scanner(System.in);
       /* TODO: Declare any necessary variables here. */
       int students = 0, Midterm1, Midterm2, finalScore;
       double Midterm1Total = 0, Midterm2Total = 0, finalScoreTotal = 0, average;
       String letterGrade, fileName, outputFileName = "report.txt";
       Scanner reader = null;
       PrintWriter writer = null;

       /* TODO: Read a file name from the user and read the tsv file here. */
       System.out.print("Enter the tsv filename: ");
       fileName = scnr.nextLine();
       reader = new Scanner(new FileInputStream(fileName));
       writer = new PrintWriter(new FileOutputStream(outputFileName));
       while (reader.hasNextLine()) {

           String[] details = reader.nextLine().split("\t");
           Midterm1 = Integer.parseInt(details[2]);
           Midterm2 = Integer.parseInt(details[3]);
           finalScore = Integer.parseInt(details[4]);
           Midterm1Total += Midterm1;
           Midterm2Total += Midterm2;
           finalScoreTotal += finalScore;
           students += 1;
           average = Midterm1 + Midterm2 + finalScore;
           average /= 3;
           if (average >= 90) letterGrade = "A";
           else if (average >= 80) letterGrade = "B";
           else if (average >= 70) letterGrade = "C";
           else if (average >= 60) letterGrade = "D";
           else letterGrade = "F";

           writer.write(String.format("%s\t%s\t%d\t%d\t%d\t%s\r\n",
             details[0], details[1], Midterm1, Midterm2, finalScore, letterGrade));
           writer.flush();
       }
       /* TODO: Compute student grades and exam averages, then output results to a text file here. */
       writer.write(String.format("\r\nAverages: Midterm1 %.2f, Midterm2 %.2f, Final %.2f\n",
               Midterm1Total / students, Midterm2Total / students, finalScoreTotal / students));

     // close the resources
       writer.flush();
       writer.close();
       reader.close();
   }
}
