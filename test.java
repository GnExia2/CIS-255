import java.util.Scanner;

public class CallPerson {
   public static void main(String [] args) {
      String userName;
      String differentUserName;
      Person person1 = new Person();

      userName = "Joe";
      differentUserName = "Ron";

      person1.setFirstName(userName);
      System.out.println("He is not " + person1.getFirstName());
      person1.setFirstName(differentUserName);
      System.out.println("He is " + person1.getFirstName());
   }
}


public class Person {
   private String firstName;

   public void setFirstName(String firstNameToSet) {
      firstName = firstNameToSet;
   }

   public String getFirstName() {
      return firstName;
   }
}
