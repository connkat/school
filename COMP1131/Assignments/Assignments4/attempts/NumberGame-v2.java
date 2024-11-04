
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
 import java.util.Optional;
 
 public class NumberGame
 {
     static boolean isActive = true;
     static int gameNum = 0;
     
     public static void main(String[] args)
     {
             int[] newGame = startGame();
             
             int guess = newGame[0];
             int count = newGame[1];
             NumberGame.gameNum = newGame[2];
         
         while (isActive) {
             Object response = askQuestion(count);
             
             if (response.equals("quit"))
                 {
                      System.out.println("Goodbye");
                         isActive = false;
                         break;
                 }
             
             boolean isValidNum = validate(response);
         
             if (!isValidNum) {
             System.out.println("Please enter a value between -50 and +50 or 'quit' to exit");   
             }
             
             else { 
                 guess = Integer.parseInt((String) response); 
         
                 if (guess == gameNum) 
                     {
                         response = gameOver(count);
                         
                         if (response.equals("y"))
                     {
                         startGame();
                     }
                         else 
                     {
                         System.out.println("Goodbye");
                         isActive = false;
                         break;
                     }
                     }
                 
                 else if (guess >= 51 || guess <= -51)
                 {
                     System.out.println("Please give a whole value between -50 and +50");
                 }
                 
                 else 
                 {
                     System.out.println("Not quite, please guess again");
                     count ++;
                 }
             }
             
         }
         
     }
     
     /**
      *
      * @return    response of question
      */
     
     private static Object askQuestion(int count) 
     {
         Scanner scanner = new Scanner(System.in); // instantiates the scanner class
         
         System.out.print("What is your guess: "); // asks question
         Object response = scanner.nextLine(); // assigns response to a variable        
         
         return response;
     }  
     
     private static boolean validate(Object response) 
     {
         try {
             int guess = Integer.parseInt((String) response); // Parse String to int
                 return true; 
             } catch (NumberFormatException e) {
                 return false;
             }
     }
 
     
     /**
      *
      * @param     count  int
      * @param     win boolean
      * @return    void
      */ 
     private static String gameOver(int count) 
     {
         String result;
             
         System.out.println("__     ______  _    _    __        __     ");
         System.out.println("\\ \\   / / __ \\| |  | |   \\ \\      / (_)    ");
         System.out.println(" \\ \\_/ / |  | | |  | |    \\ \\ /\\ / / _   _ __");
         System.out.println("  \\   /| |  | | |  | |     \\ V  V / | | / `_ \\ ");
         System.out.println("   | | | |__| | |__| |      \\_/\\_/  | | | | | |");
         System.out.println("   |_|  \\____/ \\____/               |_| |_| |_|");
         
         System.out.println("The game was completed in " + count + " rounds.");
         
         System.out.println("Would you like to play again? y/n");
         Scanner scanner = new Scanner(System.in); // instantiates the scanner class
         String response = scanner.nextLine();
         
         return response;
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
         gameNum = random.nextInt(101) - 50; // generates a random number between -50 and +50
         
         System.out.println("THE ORIGINAL NUM IS:" + gameNum);
         System.out.println("Welcome! Guess a number between -50 and +50 (or type 'quit' to exit)");
 
         int guess = 0;
         int count = 1;
         
         return new int[]{guess, count, gameNum};
 
     }
     
 }
 