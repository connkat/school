
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
    public static void main(String[] args)
    {
        boolean isActive = true;
        
           int[] newGame = startGame();
            
            int guess = newGame[0];
            int count = newGame[1];
            int gameNum = newGame[2];
        
        while (isActive){
            guess = askQuestion(count);
            
            if (guess == gameNum) {
                isActive = false;
            }
            
            if (guess >= 50 || guess <= -50)
            {
            System.out.println("Please give a whole value between -50 and +50");
                askQuestion(count);
            }
            
            else {
            System.out.println("Not quite, please guess again");
            count ++;
            guess = askQuestion(count);
            }
            
        }
        
          System.out.println("THIS SHOULD BE GAME OVER:" + guess + gameNum);
            if (guess == gameNum)
            isActive = gameOver(count, true);
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
        
        int guess = 100;
        
        if (response.equals("quit"))
        {
            gameOver(count, false);
            guess = 100;
            return guess;
        }
        
        else {
            try {
                guess = Integer.parseInt((String) response); // Parse String to int
                return guess; 
            } catch (NumberFormatException e) {
                System.out.println("Please enter a value between -50 and +50 or 'quit' to exit");
                askQuestion(count);
                
                return guess;
            }
        }
        
    }
    
    /**
     *
     * @param     count  int
     * @param     win boolean
     * @return    void
     */ 
    private static boolean gameOver(int count, boolean win) 
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
            return true;
        }
        else 
        {
            System.out.println("Goodbye");
            return false;
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
