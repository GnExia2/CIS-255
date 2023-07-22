public class Pair<TheType extends Comparable<TheType>> {
   private TheType firstVal;
   private TheType secondVal;

   public Pair(TheType aVal, TheType bVal) {
      firstVal = aVal;
      secondVal = bVal;
   }

   public String toString() {
      return "[" + firstVal + ", " + secondVal + "]";
   }

   // Implement Comparable's expected compareTo()
   public int compareTo(Pair<TheType> otherPair) {
      int firstComparison = this.firstVal.compareTo(otherPair.firstVal);
      if (firstComparison != 0) {
         return firstComparison;
      }
      return this.secondVal.compareTo(otherPair.secondVal);
   }

   // Return '<', '=', or '>' according to the ordering of this pair and otherPair
   public char comparisonSymbol(Pair<TheType> otherPair) {
      int compareResult = this.compareTo(otherPair);
      if (compareResult < 0) {
         return '<';
      } else if (compareResult > 0) {
         return '>';
      } else {
         return '=';
      }
   }
}
