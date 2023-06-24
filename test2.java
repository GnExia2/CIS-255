public class IntNode {
   private int dataVal;         // Node data
   private IntNode nextNodePtr; // Reference to the next node

   public IntNode() {
      dataVal = 0;
      nextNodePtr = null;
   }

   // Constructor
   public IntNode(int dataInit) {
      this.dataVal = dataInit;
      this.nextNodePtr = null;
   }

   // Constructor
   public IntNode(int dataInit, IntNode nextLoc) {
      this.dataVal = dataInit;
      this.nextNodePtr = nextLoc;
   }

   /* Insert node after this node.
    Before: this -- next
    After:  this -- node -- next
    */
   public void insertAfter(IntNode nodeLoc) {
      IntNode tmpNext;

      tmpNext = this.nextNodePtr;
      this.nextNodePtr = nodeLoc;
      nodeLoc.nextNodePtr = tmpNext;
   }

   // Get location pointed by nextNodePtr
   public IntNode getNext() {
      return this.nextNodePtr;
   }

   // Get node value
   public int getNodeData() {
      return this.dataVal;
   }

   // Print node value
   public void printNodeData() {
      System.out.println(this.dataVal);
   }
}

public static int findMax(IntNode headObj) {
   if (headObj.getNext() == null) {
      // Empty list, return -99
      return -99;
   }

   int max = Integer.MIN_VALUE;
   IntNode currNode = headObj.getNext();

   while (currNode != null) {
      int nodeData = currNode.getNodeData();
      if (nodeData > max) {
         max = nodeData;
      }
      currNode = currNode.getNext();
   }

   return max;
}

   public static void main(String[] args) {
      IntNode headObj;
      IntNode currObj;
      IntNode lastObj;
      int i;
      int max;

      // Create head node
      headObj = new IntNode(-1);
      lastObj = headObj;

      // Add nodes to the list
      for (i = 0; i < 20; ++i) {
         currObj = new IntNode(i);
         lastObj.insertAfter(currObj);
         lastObj = currObj;
      }

      max = findMax(headObj);
      System.out.println(max);
   }
}
