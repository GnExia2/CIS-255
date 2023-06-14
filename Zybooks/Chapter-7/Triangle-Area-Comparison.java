import java.util.Scanner;

public class TriangleArea {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      Triangle triangle1 = new Triangle();
      Triangle triangle2 = new Triangle();

      // TODO: Read and set base and height for triangle1 (use setBase() and setHeight())
      triangle1.setBase(scnr.nextDouble());
      triangle1.setHeight(scnr.nextDouble());

      // TODO: Read and set base and height for triangle2 (use setBase() and setHeight())
      triangle2.setBase(scnr.nextDouble());
      triangle2.setHeight(scnr.nextDouble());


      System.out.println("Triangle with smaller area:");

      // TODO: Determine smaller triangle (use getArea())
      //       and output smaller triangle's info (use printInfo())
      if (triangle1.getArea() < triangle2.getArea()){
         triangle1.printInfo();
         } else {
            triangle2.printInfo();
         }

   }
}

public class Triangle {
   private double base;
   private double height;

   public void setBase(double userBase){
      base = userBase;
   }
   public void setHeight(double userHeight) {
      height = userHeight;
   }

   public double getArea() {
      double area = 0.5 * base * height;
      return area;
   }

   public void printInfo() {
      System.out.printf("Base: %.2f\n", base);
      System.out.printf("Height: %.2f\n", height);
      System.out.printf("Area: %.2f\n", getArea());
   }
}
