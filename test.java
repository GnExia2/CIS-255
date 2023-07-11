public class PrintMedia {
   public static void main(String[] args) {
      Episode ep1 = new Episode();
      Song song1 = new Song();

      ep1.setDuration(25);
      song1.setDuration(4, 15);

      ep1.printDuration();
      song1.printDuration();
   }
}

public interface Media {
   public void printDuration();
}

public class Song implements Media {
   private int minutes;
   private int seconds;

   public void setDuration(int durationMins, int durationSecs) {
      minutes = durationMins;
      seconds = durationSecs;
   }

   @Override
   public void printDuration() {
      System.out.println(minutes + ":" + seconds);
   }
}

public class Episode implements Media {
   private int duration;

   public void setDuration(int durationMins) {
      duration = durationMins;
   }

   @Override
   public void printDuration() {
      System.out.println(duration + " minutes");
   }
}
