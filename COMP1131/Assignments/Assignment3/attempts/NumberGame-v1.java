
/**
 * Number Game: 
 * The program picks a random number between -50 and 50 (inclusive), then prompts the user to guess 
 *   the number.
 * On each guess, the program tells the user that they are correct, or that the target number 
 *   is to the left or right of the guess. 
 * It will continue accepting guesses until the user guesses correctly or chooses to quit.
 * The program counts the number of guesses and report that value when the user guesses correctly. 
 * If a guess is out of the range an error is displayed and the guess is not counted. 
 * At the end of each game (by quitting or a correct guess), the program sends a prompt to determine 
 *   whether the user wants to play again. 
 *
 * @connkat (Kat Connolly)
 * @version v1.0
 */

 import java.util.Scanner; //imports scanner for reading responses
 import java.util.Random; //imports random class
 
 public class NumberGame
 {
     public static void main(String[] args)
     {
         
         int[] newGame = startGame();
         
         int guess = newGame[0];
         int count = newGame[1];
         int gameNum = newGame[2];
         
         guess = askQuestion(count); //returns guess response
         
         if (guess >= -50 || guess <= 50)
         {
         System.out.println("Please give a value between -50 and +50");
         guess = askQuestion(count);
         }
         
         while (guess != gameNum && guess != 100)
         {
             System.out.println("Wrong answer, try again!");
             count ++;
             guess = askQuestion(count);
         }
         
         if (guess == gameNum)
         gameOver(count, true);
     }
     
     /**
      *
      * @return    response of question
      */
     
     private static int askQuestion(int count) 
     {
         Scanner scanner = new Scanner(System.in); // instantiates the scanner class
         
         System.out.print("What is your guess: "); // asks question
         Object response = scanner.nextLine(); // assigns response to a variable        
         
         int number = 100;
         if (response.equals("quit"))
         {
             gameOver(count, false);
         }
         
          else if (response instanceof String) {
             try {
                 number = Integer.parseInt((String) response); // Parse String to int
                 return number;
             } catch (NumberFormatException e) {
                 System.out.println("Please enter a value between -50 and +50 or 'quit' to exit");
                 askQuestion(count);
             }
         }
           
         return number;
     }
     
     /**
      *
      * @param     count  int
      * @param     win boolean
      * @return    void
      */ 
     private static void gameOver(int count, boolean win) 
     {
         String result;
         
         if (win == true)
             result = "won";
         else
             result = "lost";
         
         System.out.println("Game Over! You have " + result + " the game.");
         System.out.println("The game was completed in " + count + " rounds.");
         
         System.out.println("Would you like to play again? y/n");
         Scanner scanner = new Scanner(System.in); // instantiates the scanner class
         String response = scanner.nextLine();
         
         if (response.equals("y"))
         {
             startGame();
         }
         else 
         {
             System.out.println("Goodbye");
         }
     }
     
     /**
      *
      * @param     count  int
      * @param     win boolean
      * @return    void
      */ 
     private static int[] startGame() 
     {
        Random random = new Random(); // instantiates the Random class
         int gameNum = random.nextInt(101) - 50; // generates a random number between -50 and +50
         
         System.out.println("THE NUM IS:" + gameNum);
         System.out.println("Welcome! Guess a number between -50 and +50 (or type 'quit' to exit)");
 
         int guess = 0;
         int count = 1;
         
         return new int[]{guess, count, gameNum};
 
     }
     
 }
 