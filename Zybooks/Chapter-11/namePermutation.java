import java.util.Scanner;
import java.util.ArrayList;

public class PhotoLineups {

   // Method to create and output all permutations of the list of names.
   public static void printAllPermutations(ArrayList<String> permList, ArrayList<String> nameList) {
      // Base case: If the nameList is empty, print the permutation
      if (nameList.size() == 0) {
         for (int i = 0; i < permList.size(); i++) {
            System.out.print(permList.get(i));
            if (i < permList.size() - 1) {
               System.out.print(", ");
            }
         }
         System.out.println();
      }
      // Recursive case: Generate permutations by selecting each name and recursively permuting the remaining names
      for (int i = 0; i < nameList.size(); i++) {
         String name = nameList.get(i);
         permList.add(name);
         nameList.remove(i);
         printAllPermutations(permList, nameList);
         nameList.add(i, name);
         permList.remove(permList.size() - 1);
      }
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      ArrayList<String> nameList = new ArrayList<String>();
      ArrayList<String> permList = new ArrayList<String>();
      String name;

      // Read a list of names into nameList; stop when -1 is read
      while (true) {
         name = scnr.next();
         if (name.equals("-1")) {
            break;
         }
         nameList.add(name);
      }

      // Call recursive method to print all permutations
      printAllPermutations(permList, nameList);
   }
}
