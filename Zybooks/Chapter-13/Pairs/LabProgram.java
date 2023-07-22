import java.util.Scanner;

public class LabProgram {
   public static Pair<Integer> readIntegerPair(Scanner scnr) {
      int val1 = scnr.nextInt();
      int val2 = scnr.nextInt();
      return new Pair<>(val1, val2);
   }

   public static Pair<Double> readDoublePair(Scanner scnr) {
      double val1 = scnr.nextDouble();
      double val2 = scnr.nextDouble();
      return new Pair<>(val1, val2);
   }

   public static Pair<String> readWordPair(Scanner scnr) {
      String val1 = scnr.next();
      String val2 = scnr.next();
      return new Pair<>(val1, val2);
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      Pair<Integer> integerPair1 = readIntegerPair(scnr);
      Pair<Integer> integerPair2 = readIntegerPair(scnr);

      Pair<Double> doublePair1 = readDoublePair(scnr);
      Pair<Double> doublePair2 = readDoublePair(scnr);

      Pair<String> wordPair1 = readWordPair(scnr);
      Pair<String> wordPair2 = readWordPair(scnr);

      System.out.println(integerPair1 + " " + integerPair1.comparisonSymbol(integerPair2) + " " + integerPair2);
      System.out.println(doublePair1 + " " + doublePair1.comparisonSymbol(doublePair2) + " " + doublePair2);
      System.out.println(wordPair1 + " " + wordPair1.comparisonSymbol(wordPair2) + " " + wordPair2);
   }
}
