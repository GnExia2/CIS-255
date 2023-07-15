import java.util.Scanner;
import java.util.ArrayList;

public class FindName {
   public static void findMatch(ArrayList<String> namesList, int minIndex, int maxIndex) {
      int rangeSize;
      int midIndex;

      /* Your code goes here */

      System.out.println("Number of elements in the range: " + rangeSize);
      System.out.println("Middle index: " + midIndex);
      System.out.println("Element at middle index: " + namesList.get(midIndex));
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      ArrayList<String> dataList = new ArrayList<String>();
      int numData;
      int i;

      numData = scnr.nextInt();
      for (i = 0; i < numData; ++i) {
         dataList.add(scnr.next());
      }
      findMatch(dataList, 0, dataList.size() - 1);
   }
}
