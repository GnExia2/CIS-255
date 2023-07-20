import java.util.Scanner;

public class WhatOrder {
   public static <T extends Comparable<T>> int checkOrder(T item1, T item2, T item3, T item4) {
      if (item1.compareTo(item2) < 0 && item2.compareTo(item3) < 0 && item3.compareTo(item4) < 0) {
         return -1; // Ascending order
      } else if (item1.compareTo(item2) > 0 && item2.compareTo(item3) > 0 && item3.compareTo(item4) > 0) {
         return 1; // Descending order
      } else {
         return 0; // Neither ascending nor descending
      }
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      // Check order of four strings
      System.out.println("Order: " + checkOrder(scnr.next(), scnr.next(), scnr.next(), scnr.next()));

      // Check order of four doubles
      System.out.println("Order: " + checkOrder(scnr.nextDouble(), scnr.nextDouble(), scnr.nextDouble(), scnr.nextDouble()));
   }
}
