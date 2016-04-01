import java.util.Random;
import java.util.Scanner;
class newBigGameRunner{
  public static int roundPoints;
  public static int gamePoints;
  public static boolean sit = false;

  public static void noRoundPoints(){
    roundPoints = 0;
    sit = true;
  }
  public static void eraseGamePoints(){
    gamePoints = 0;
    sit = true;
  }
  public static void pointset(int points){
    roundPoints += points;
  }
  public static void gamePointSet(int pointsRound){
    gamePoints += pointsRound;
  }
  public static int gamePointGet(){
    return gamePoints;
  }

// Making the random dice
  public static int DiceRoll(int min, int max){
    Random rand = new Random();
    int randomNum = rand.nextInt((max - min) + 1) + min;
    return randomNum;
  }
  public static void RollResponseCheck(int roll1, int roll2){
    if ((roll1 == 2 && roll2 == 6) || (roll1 == 6 && roll2 == 2)){
      noRoundPoints();
      System.out.println("You lost all of your round points.");
    }
    else if ((roll1 == 3 && roll2 == 5) || (roll1 == 5 && roll2 == 3)){
      noRoundPoints();
      System.out.println("You lost all of your round points.");
    }
    else if (roll1 == 1 && roll2 == 1){
      eraseGamePoints();
      System.out.println("You lost all of your accumulated points.");
    }
    else{
      gamePointSet(roundPoints);
      System.out.println("You gained " + (roll1 + roll2) + "points this roll");
    }
  }


// Round setup
  public static void main (String[] args){
    int totalRounds = 5;
    int roll1;
    int roll2;
    String playerChoice;
    for (int i = 0; i < totalRounds; i++){
      sit = false;
      roundPoints = 0;
      while (sit == false){
        roll1 = DiceRoll(1, 6);
        roll2 = DiceRoll(1, 6);
        System.out.println("You rolled a " + roll1 + "," + roll2);
        roundPoints += (roll1 + roll2);
        RollResponseCheck(roll1, roll2);
        if (sit == true){
          System.out.println("Next Round!");
          break;
        } //asking user to sit or stay standig
        System.out.println("You have " + roundPoints + " points.");
        System.out.println("Would you like to sit?");
        System.out.println("(Please answer with a Y or a N)");
        Scanner input = new Scanner(System.in);
        playerChoice = input.nextLine();
        if (playerChoice == "Y"){
          sit = true;
          System.out.println("Next Round!");
        }

        }

      }
    int gamePointsGR = gamePointGet();
    System.out.println("You got a grand total of " + gamePointsGR);
    }
}
