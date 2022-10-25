import java.util.Random;
import java.util.Timer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
  public static void main(String[] args) {
    
    System.out.println(pluralize("sword", -12));
    System.out.println(pluralize("fork", 0));
    System.out.println(pluralize("bazooka", 1));
    System.out.println(pluralize("meat pie", 73));
    
    flipNHeads(5);

    clock();
  }

  public static String pluralize(String str, int i){
    if(i == 1){
      return "I own " + i + " " + str + ".";
    } else if (i < 0) {
      return (i + " is a negative number. You can not use a negative number, please retry using zero or a positive number.");
    } else {
      return "I own " + i + " " + str + "s.";
    }
  }

  public static void flipNHeads(int consecutiveFlips){
    int consecutiveCount = 0;
    int totalFlips = 0;

    if(consecutiveFlips > 0){

      while (consecutiveCount < consecutiveFlips){
        Random rnd = new Random();
        float newRnd = rnd.nextFloat(1);

        if(newRnd < 0.5f){
          totalFlips++;
          System.out.println("Tails");
          consecutiveCount = 0;

        } else {
          totalFlips++;
          System.out.println("Heads");
          consecutiveCount++;
        }
      }

      if(totalFlips == 1){
        System.out.println("It took " + totalFlips + " to flip " + consecutiveFlips + " head in a row.");
      } else {
        System.out.println("It took " + totalFlips + " to flips " + consecutiveFlips + " head in a row.");
      }
      

    } else if (consecutiveFlips == 0){
      System.out.println("You must flip at least one time for results.");
    } else {
      System.out.println("You can not flip " + consecutiveFlips + " times. Try again with a positive number.");
    }
  }

  //My understanding of how to use LocalDateTime was derived from https://www.javatpoint.com/java-localdatetime

  public static void clock(){
    
    boolean runClock = true;
    LocalDateTime now = LocalDateTime.now();
    int currentSecond;
    int lastSecond = now.getSecond();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
    String time = now.format(format);
    System.out.println(time);

    while (runClock){
      now = LocalDateTime.now();
      currentSecond = now.getSecond();
      
      if((lastSecond == 59 && currentSecond == 0) || currentSecond > lastSecond){
        
        time = now.format(format);
        System.out.println(time);
        lastSecond = now.getSecond();
      }
    }
  }
}