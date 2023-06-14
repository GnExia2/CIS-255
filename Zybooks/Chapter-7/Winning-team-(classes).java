import java.util.Scanner;

public class WinningTeam {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      Team team = new Team();

      String name = scnr.next();
      int wins = scnr.nextInt();
      int losses = scnr.nextInt();

      team.setName(name);
      team.setWins(wins);
      team.setLosses(losses);

      team.printStanding();
   }
}

public class Team {
   // Declare private fields - name, wins, losses
   private String name;
   private int wins;
   private int losses;

   // Define mutator methods - setName(), setWins(), setLosses()
   public void setName(String userName) {
      name = userName;
   }

   public void setWins(int setWins) {
      wins = setWins;
   }

   public void setLosses(int setLosses) {
      losses = setLosses;
   }

   // Define accessor methods - getName(), getWins(), getLosses()
   public String getName() {
      return name;
   }

   public int getWins() {
      return wins;
   }

   public int getLosses() {
      return losses;
   }

   // Define getWinPercentage()
   public double getWinPercentage() {
      double winPercentage;
      winPercentage = (double) wins / (wins + losses);
      return winPercentage;
   }

   // Define printStanding()
   public void printStanding() {
      System.out.printf("Win percentage: %.2f\n", getWinPercentage());

      if (getWinPercentage() > 0.5) {
         System.out.println("Congratulations, Team " + getName() + " has a winning average!");
      } else {
         System.out.println("Team " + getName() + " has a losing average.");
      }
   }
}
