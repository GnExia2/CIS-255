import java.util.Scanner;

//ShoppingList.java
public class ShoppingList {
   public static void main (String[] args) {
      Scanner scnr = new Scanner(System.in);

      ItemNode headNode;  // Create intNode objects
      ItemNode currNode;
      ItemNode lastNode;

      String item;
      int i;

      // Front of nodes list
      headNode = new ItemNode();
      lastNode = headNode;

      int input = scnr.nextInt();

      for(i = 0; i < input; i++ ){
         item = scnr.next();
         currNode = new ItemNode(item);
         lastNode.insertAtEnd(headNode, currNode);
         lastNode = currNode;
      }

      // Print linked list
      currNode = headNode.getNext();
      while (currNode != null) {
         currNode.printNodeData();
         currNode = currNode.getNext();
      }
   }
}

//ItemNode.java
public class ItemNode {
   private String item;
   private ItemNode nextNodeRef; // Reference to the next node

   public ItemNode() {
      item = "";
      nextNodeRef = null;
   }

   // Constructor
   public ItemNode(String itemInit) {
      this.item = itemInit;
      this.nextNodeRef = null;
   }

   // Constructor
   public ItemNode(String itemInit, ItemNode nextLoc) {
      this.item = itemInit;
      this.nextNodeRef = nextLoc;
   }

   // Insert node after this node.
   public void insertAfter(ItemNode nodeLoc) {
      ItemNode tmpNext;

      tmpNext = this.nextNodeRef;
      this.nextNodeRef = nodeLoc;
      nodeLoc.nextNodeRef = tmpNext;
   }

   // TODO: Define insertAtEnd() method that inserts a node
   //       to the end of the linked list
   public void insertAtEnd(ItemNode headNode, ItemNode currNode) {
     while(headNode.nextNodeRef != null) headNode = headNode.nextNodeRef;
     headNode.nextNodeRef = currNode;
   }
   // Get location pointed by nextNodeRef
   public ItemNode getNext() {
      return this.nextNodeRef;
   }

   public void printNodeData() {
      System.out.println(this.item);
   }
}
