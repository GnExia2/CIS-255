public class SortScores {

   public static void main(String[] args) {

      final int FINAL_SCORES = 5;

      ArrayList<Integer> scores = new ArrayList<Integer>();

      int i;





      scores.add(19);

      scores.add(15);

      scores.add(13);

      scores.add(17);

      scores.add(11);



       Comparable.compareTo(scores); 

      System.out.println("Sorted numbers: ");

      for (i = 0; i < FINAL_SCORES; ++i) {

         System.out.print(scores.get(i) + " ");

      }

      System.out.println();

   }

}
