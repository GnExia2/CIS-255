import java.util.Scanner;

//Playlist.java
public class Playlist {

   // TODO: Write method to ouptut list of songs
   public static void printPlaylist(SongNode songs){
      SongNode song = songs.getNext();
      while(song != null){
         song.printSongInfo();
         System.out.println();
         song = song.getNext();
      }
   }


   public static void main (String[] args) {
      Scanner scnr = new Scanner(System.in);

      SongNode headNode;
      SongNode currNode;
      SongNode lastNode;

      String songTitle;
      int songLength;
      String songArtist;

      // Front of nodes list
      headNode = new SongNode();
      lastNode = headNode;

      // Read user input until -1  entered
      songTitle = scnr.nextLine();
      while (!songTitle.equals("-1")) {
         songLength = scnr.nextInt();
         scnr.nextLine();
         songArtist = scnr.nextLine();

         currNode = new SongNode(songTitle, songLength, songArtist);
         lastNode.insertAfter(currNode);
         lastNode = currNode;

         songTitle = scnr.nextLine();
      }

      // Print linked list
      System.out.println("LIST OF SONGS");
      System.out.println("-------------");
      printPlaylist(headNode);
   }
}

//SongNode.java
public class SongNode {
   private String songTitle;
   private int songLength;
   private String songArtist;
   private SongNode nextNodeRef; // Reference to the next node

   public SongNode() {
      songTitle = "";
      songLength = 0;
      songArtist = "";
      nextNodeRef = null;
   }

   // Constructor
   public SongNode(String songTitleInit, int songLengthInit, String songArtistInit) {
      this.songTitle = songTitleInit;
      this.songLength = songLengthInit;
      this.songArtist = songArtistInit;
      this.nextNodeRef = null;
   }

   // Constructor
   public SongNode(String songTitleInit, int songLengthInit, String songArtistInit, SongNode nextLoc) {
      this.songTitle = songTitleInit;
      this.songLength = songLengthInit;
      this.songArtist = songArtistInit;
      this.nextNodeRef = nextLoc;
   }

   // insertAfter
   public void insertAfter(SongNode nodeLoc) {
      SongNode tmpNext;

      tmpNext = this.nextNodeRef;
      this.nextNodeRef = nodeLoc;
      nodeLoc.nextNodeRef = tmpNext;
   }

   // Get location pointed by nextNodeRef
   public SongNode getNext() {
      return this.nextNodeRef;
   }

   // TODO: Write printSongInfo() method
   public void printSongInfo() {
      System.out.println("Title: " + this.songTitle);
      System.out.println("Length: " + this.songLength);
      System.out.println("Artist: " + this.songArtist);

   }
}
