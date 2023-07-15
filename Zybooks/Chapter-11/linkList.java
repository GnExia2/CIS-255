import java.util.Scanner;

public class LabProgram {

   public static void printLinkedList(IntNode node) {
      if (node == null) {
         return; // Reached the end of the linked list
      }

      node.printData(); // Print the value of the current node

      // Call printLinkedList() recursively with the next node
      printLinkedList(node.getNext());
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int size;
      int value;

      size = scnr.nextInt();
      value = scnr.nextInt();
      IntNode headNode = new IntNode(value);
      IntNode lastNode = headNode;
      IntNode newNode = null;

      for (int n = 0; n < size - 1; ++n) {
         value = scnr.nextInt();
         newNode = new IntNode(value);
         lastNode.insertAfter(newNode);
         lastNode = newNode;
      }

      printLinkedList(headNode);
   }
}
