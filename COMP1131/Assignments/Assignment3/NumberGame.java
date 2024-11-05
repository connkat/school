
/**
 * Number Game: 
 * The program picks a random number between -50 and 50 (inclusive), then prompts the user to guess 
 *   the number.
 * - On each guess, the program tells the user that they are correct, or that the target number 
 *   is to the left or right of the guess. 
 * - It will continue accepting guesses until the user guesses correctly or chooses to quit.
 * - The program counts the number of guesses and report that value when the user guesses correctly. 
 * - If a guess is out of the range an error is displayed and the guess is not counted. 
 * - At the end of each game (by quitting or a correct guess), the program sends a prompt to determine 
 *   whether the user wants to play again. 
 *
 * @connkat (Kat Connolly)
 * @version v1.0
 */

import java.util.Scanner; // imports scanner for reading responses
import java.util.Random; // imports random class for generating random number

public class NumberGame
{
    static boolean isActive = true; // while the game isActive, it will continue
    static int gameNum = 0; // instantiate the initial value (for the user to guess) before assigning it a value
    
    public static void main(String[] args)
    {
        int[] newGame = startGame(); //sets and/pr resets values for a new game
            
        int guess = newGame[0];
        int count = newGame[1];
        NumberGame.gameNum = newGame[2];
        
        while (isActive) { //while the game is active, this code block continues to loop through
            Object response = askQuestion(count);
            
            // If the user tries to quit, end current round and ask if they want to start a new round: 
            if (response.equals("quit")) {
                    gameOver(count, false); 
                }
            
            boolean isValidNum = validate(response); //check to see if the value entered is an int or something else
        
            if (!isValidNum) {
                System.out.println("Please enter a value between -50 and +50 or 'quit' to exit"); // tell user to enter expected value
            } else { 
                guess = Integer.parseInt((String) response); // if it is an int, set it as the value of `guess`
        
                if (guess == gameNum) {
                        gameOver(count, true); // if the guess is correct, end the game
                } else if (guess >= 51 || guess <= -51) { //if the guess is outside of -50 and +50
                    System.out.println("Please give a whole value between -50 and +50 or 'quit' to exit game");
                } else { // direct user to correct guess direction                   
                    if (guess <= gameNum) {
                           System.out.println("Your guess is to the LEFT of the number."); 
                    }
                        
                    if (guess >= gameNum) {
                           System.out.println("Your guess is to the RIGHT of the number."); 
                    }
                    count ++; //add count after every guess that is not `quit` and also is a valid number within the -50/+50 range
                }
            }
        }
        
    }
    
    /**
     * startGame: 
     * A function to start a new game and set the new gameNum value, guess, and count to default values. 
     * 
     * @return    int[]
     */ 
    private static int[] startGame() 
    {
        Random random = new Random(); // instantiates the Random class
        gameNum = random.nextInt(101) - 50; // generates a random number between -50 and +50
        
        System.out.println("Welcome! Guess a number between -50 and +50 (or type 'quit' to exit.)");
        System.out.println("-50---------------0---------------+50");
        System.out.println("Depending on your guess, I will tell you if your number is to the left or right of the correct answer");

        int guess = 0;
        int count = 1;
        
        return new int[]{guess, count, gameNum}; //returns all the new values

    }
    
    /**
     * askQuestion:
     * A funtion that asks the user for their answer and returns it as an object, as it could be many different
     * data types at this point. 
     * 
     * @return    Object response of question
     */
    
    private static Object askQuestion(int count) 
    {
        Scanner scanner = new Scanner(System.in); // instantiates the scanner class
        
        System.out.print("What is your guess: "); // asks question
        Object response = scanner.nextLine(); // assigns response to a variable        
        
        return response;
    }  
    
    /**
     * gameOver: A function that is called either when the user wins a game or chooses to quit.
     * The round count is reported to the user and they are prompted to play another round or quit the game entirely. 
     * It then handles the answer and either quits or starts a new round.
     *
     * @param     count  int
     * @param     hasWon boolean
     * @return    void
     */ 
    private static void gameOver(int count, boolean hasWon) 
    {   
        if (hasWon) {
        System.out.println("__     ______  _    _    __        __     ");
        System.out.println("\\ \\   / / __ \\| |  | |   \\ \\      / (_)    ");
        System.out.println(" \\ \\_/ / |  | | |  | |    \\ \\ /\\ / / _   _ __");
        System.out.println("  \\   /| |  | | |  | |     \\ V  V / | | / `_ \\ ");
        System.out.println("   | | | |__| | |__| |      \\_/\\_/  | | | | | |");
        System.out.println("   |_|  \\____/ \\____/               |_| |_| |_|");
        }
        
        System.out.println("The game was completed in " + count + " rounds.");
        
        System.out.println("Would you like to play again?");
        System.out.println("press y to start new game or any other character to exit");
        Scanner scanner = new Scanner(System.in); // instantiates the scanner class
        String response = scanner.nextLine();
        
        if  (response.equals("y")) {
            startGame();
        } else {
            System.out.println("Goodbye");
            isActive = false;
        }
    }
    
    /**
     * validate:
     * A funtion that tests if the response is the expected (int) or an unexpected character. 
     * It returns true if it is and int and false if it isn't. 
     * 
     * @param      Object response
     * @return     boolean
     */
    
    private static boolean validate(Object response) 
    {
        try {
            int guess = Integer.parseInt((String) response); // Parse String to int
                return true; 
            } catch (NumberFormatException e) { // If response isn't an int, this will throw an error. 
                return false;
            }
    }
    
}
