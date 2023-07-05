//cat.java
public class Cat extends Pet {
   private String breed;

   public void setBreed(String userBreed) {
      breed = userBreed;
   }

   public String getBreed() {
      return breed;
   }
}

//pet.java
public class Pet {

   protected String name;
   protected int age;

   public void setName(String userName) {
      name = userName;
   }

   public String getName() {
      return name;
   }

   public void setAge(int userAge) {
      age = userAge;
   }

   public int getAge() {
      return age;
   }

   public void printInfo() {
      System.out.println("Pet Information: ");
      System.out.println("   Name: " + name);
      System.out.println("   Age: " + age);
   }

}

import java.util.Scanner;

public class PetInformation {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      Pet myPet = new Pet();
      Cat myCat = new Cat();

      String petName, catName, catBreed;
      int petAge, catAge;

      petName = scnr.nextLine();
      petAge = scnr.nextInt();
      scnr.nextLine();
      catName = scnr.nextLine();
      catAge = scnr.nextInt();
      scnr.nextLine();
      catBreed = scnr.nextLine();

      // Create generic pet (using petName, petAge) and then call printInfo
      myPet.setName(petName);
      myPet.setAge(petAge);
      myPet.printInfo();

      // Create cat pet (using catName, catAge, catBreed) and then call printInfo
      myCat.setName(catName);
      myCat.setAge(catAge);
      myCat.setBreed(catBreed);
      myCat.printInfo();

      // Use getBreed() to output the breed of the cat
      System.out.println("   Breed: " + myCat.getBreed());   }
}
