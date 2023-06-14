import java.util.Scanner;

/*
ArtworkLabel.java
*/

public class ArtworkLabel {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      String userTitle, userArtistName;
      int yearCreated, userBirthYear, userDeathYear;

      userArtistName = scnr.nextLine();
      userBirthYear = scnr.nextInt();
      scnr.nextLine();
      userDeathYear = scnr.nextInt();
      scnr.nextLine();
      userTitle = scnr.nextLine();
      yearCreated = scnr.nextInt();

      Artist userArtist = new Artist(userArtistName, userBirthYear, userDeathYear);

      Artwork newArtwork = new Artwork(userTitle, yearCreated, userArtist);

      newArtwork.printInfo();
   }
}

/*
Artist.java
*/

public class Artist {
   // TODO: Declare private fields - artistName, birthYear, deathYear
   private String artistName;
   private int birthYear;
   private int deathYear;

   public Artist(){
      artistName = "unknown";
      birthYear = -1;
      deathYear = -1;
      }

   // TODO: Define default constructor
   public Artist(String artistName, int birthYear, int deathYear){
      this.artistName = artistName;
      this.birthYear = birthYear;
      this.deathYear = deathYear;
      }


   // TODO: Define get methods: getName(), getBirthYear(), getDeathYear()
   public String getName(){
      return artistName;
      }

      public int getBirthYear(){
         return birthYear;
         }

      public int getDeathYear(){
         return deathYear;
         }

   // TODO: Define printInfo() method
   //      If deathYear is entered as -1, only print birthYear
   public void printInfo(){
      System.out.print("Artist: ");
      System.out.print(artistName);
      if(deathYear == -1 && birthYear == -1){
         System.out.println(" (unknown)");
         }
         else if (birthYear > -1 && deathYear == -1){
            System.out.println(" (" + birthYear + " to present)"); // make sure when you type this line
            }

         else {
            System.out.println(" (" + birthYear + " to " + deathYear + ")"); // make sure when you type this line
            }
      }
}

/*
Artwork.java
*/

public class Artwork {
   // TODO: Declare private fields - title, yearCreated

   private String title;
   private int yearCreated;

    // TODO: Declare private field artist of type Artist
   private Artist artist;

   // TODO: Define default constructor
   public Artwork() {
      title = "unknown";
      yearCreated = -1;
      artist = new Artist();
      }

   // TODO: Define get methods: getTitle(), getYearCreated()
   public String getTitle() {
      return title;
      }

      public int getYearCreated() {
         return yearCreated;
         }

   // TODO: Define second constructor to initialize
   //       private fields (title, yearCreated, artist)
   public Artwork(String title, int yearCreated, Artist artist) {
      this.title = title;
      this.yearCreated = yearCreated;
      this.artist = artist;
      }

   // TODO: Define printInfo() method
   public void printInfo() {
      artist.printInfo();
      System.out.println("Title: " + title + ", " + yearCreated);

   }
}
