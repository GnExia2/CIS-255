import java.util.Scanner;
import java.lang.Math;

public class CarValue {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      Car myCar = new Car();

      int userYear = scnr.nextInt();
      int userPrice = scnr.nextInt();
      int userCurrentYear = scnr.nextInt();

      myCar.setModelYear(userYear);
      myCar.setPurchasePrice(userPrice);
      myCar.calcCurrentValue(userCurrentYear);

      myCar.printInfo();
   }
}

public class Car {
   private int modelYear;
   // TODO: Declare purchasePrice field (int)
   private int purchasePrice;
   private int currentValue;

   public void setModelYear(int userYear){
      modelYear = userYear;
   }

   public int getModelYear() {
      return modelYear;
   }

   // TODO: Define setPurchasePrice() method
   public void setPurchasePrice(int userPrice) {
      purchasePrice = userPrice;
   }

   // TODO: Define getPurchasePrice() method
    public int getPurchasePrice() {
      return purchasePrice;
   }

   public void calcCurrentValue(int currentYear) {
      double depreciationRate = 0.15;
      int carAge = currentYear - modelYear;

      // Car depreciation formula
      currentValue = (int)
         Math.round(purchasePrice * Math.pow((1 - depreciationRate), carAge));
   }

   // TODO: Define printInfo() method to output modelYear, purchasePrice, and currentValue
      public void printInfo() {
      System.out.println("Car's information:");
      System.out.println("  Model year: " + modelYear);
      System.out.println("  Purchase price: $" + purchasePrice);
      System.out.println("  Current value: $" + currentValue);
  }
}
