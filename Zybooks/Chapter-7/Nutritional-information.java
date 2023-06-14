import java.util.Scanner;

public class NutritionalInfo {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      FoodItem foodItem;

      String itemName = scnr.next();
      if(itemName.equals("Water") || itemName.equals("water")) {
         foodItem = new FoodItem();

         foodItem.printInfo();
         System.out.printf("Number of calories for %.2f serving(s): %.2f\n", 1.0,
                          foodItem.getCalories(1.0));
      }

      else {
         double amountFat = scnr.nextDouble();
         double amountCarbs = scnr.nextDouble();
         double amountProtein = scnr.nextDouble();

         foodItem = new FoodItem(itemName, amountFat, amountCarbs, amountProtein);

         double numServings = scnr.nextDouble();

         foodItem.printInfo();
         System.out.printf("Number of calories for %.2f serving(s): %.2f\n", 1.0,
                             foodItem.getCalories(1.0));

         System.out.printf("Number of calories for %.2f serving(s): %.2f\n", numServings,
                             foodItem.getCalories(numServings));
      }
   }
}

public class FoodItem {
   private String name;
   private double fat;
   private double carbs;
   private double protein;

   // TODO: Define default constructor
   public FoodItem(){
      this("Water", 0.0, 0.0, 0.0);
   }
   // TODO: Define second constructor with parameters to initialize private fields (name, fat, carbs, protein)
      public FoodItem(String name, double fat, double carbs, double protein){
      this.name = name;
      this.fat = fat;
      this.carbs = carbs;
      this.protein = protein;
      }


   public String getName() {
      return name;
   }

   public double getFat() {
      return fat;
   }

   public double getCarbs() {
      return carbs;
   }

   public double getProtein() {
      return protein;
   }

   public double getCalories(double numServings) {
      // Calorie formula
      double calories = ((fat * 9) + (carbs * 4) + (protein * 4)) * numServings;
      return calories;
   }

   public void printInfo() {
      System.out.println("Nutritional information per serving of " + name + ":");
      System.out.printf("  Fat: %.2f g\n", fat);
      System.out.printf("  Carbohydrates: %.2f g\n", carbs);
      System.out.printf("  Protein: %.2f g\n", protein);
   }
}
