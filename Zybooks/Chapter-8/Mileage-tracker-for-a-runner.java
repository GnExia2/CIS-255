import java.util.Scanner;

public class MileageTrackerLinkedList {
   public static void main (String[] args) {
      Scanner scnr = new Scanner(System.in);

      // References for MileageTrackerNode objects
      MileageTrackerNode headNode;
      MileageTrackerNode currNode;
      MileageTrackerNode lastNode;

      double miles;
      String date;
      int i;

      // Front of nodes list
      headNode = new MileageTrackerNode();
      lastNode = headNode;


      // TODO: Scan the number of nodes
      int count = scnr.nextInt();

      for (i = 0; i < count; i++) {
           miles = scnr.nextDouble();
           date = scnr.next();
           currNode = new MileageTrackerNode(miles, date);
           lastNode.insertAfter(currNode);
           lastNode = currNode;
        }

      // TODO: For the scanned number of nodes, scan
      //       in data and insert into the linked list
      currNode = headNode.getNext();
      for (i =0; i< count; i++) {
         currNode.printNodeData();
         currNode = currNode.getNext();
      }


      // TODO: Call the printNodeData() method
      //       to print the entire linked list

   }
}
