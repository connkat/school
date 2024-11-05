
/**
 * An application that repeatedly reads some text from the user, then determines and displays how many of each of the 
 * odd digits (1, 3, 5, 7, and 9) and how many other characters appear in the entire text.
 * After the results for an input are displayed, it prompts the user if they want to do another input.
 *
 * @Kat Connolly (@connkat)
 * @v1.0
 */

import java.util.Scanner; //imports scanner for reading responses

public class OddCounter
{
    // setting all initial values, accessible to any functions in this class: 
    static boolean isActive = false;
    static int countOne = 0;
    static int countThree = 0;
    static int countFive = 0;
    static int countSeven = 0;
    static int countNine = 0;
    static int countOther = 0;

    public static void main(String[] args)    
    {   
        
        do //while the game status isActive, this code will run and/or re-run
        {
            String response = startRound(); // calls the start method of being the game
            
            for (int i = 0; i < response.length(); i++) { //loops through every character entered by the user and checks for value
                char currentChar = response.charAt(i); //sets the value of the current index to a temp variable
                
                // each case checks the value of the current looped index against the count values and adds to each count if true.
                switch (currentChar) {
                case '1':
                    countOne++;
                    break;
                case '3':
                   countThree++;
                   break;
                case '5':
                    countFive++;
                    break;
                case '7':
                    countSeven++;
                    break;
                case '9':
                    countNine++;
                    break;
                // if none of the counter values match, it adds the count to the other character count. 
                default:
                   countOther++;
                   break;         
                }
            }
            
            // Prints out the result of the odd counter
            System.out.printf("The results are:\n 1: %d\n 3: %d\n 5: %d\n 7: %d\n 9: %d\n other: %d \n", 
                countOne, countThree, countFive, countSeven, countNine, countOther);
            
            // Prompts user to start a new game
            String newGame = askQuestion("Enter y to play again, or anything else to exit the game.");
            
            // handles the response of the user to either start a new round or exit the the game.
            if (newGame.equals("y")) {
                OddCounter.isActive = true;
            } else {
                OddCounter.isActive = false;
                System.out.println("Goodbye");
                break;
            }
        } while (isActive = true);
    }
    
    /**
     * askQuestion:
     * Asks a question (param question) to the user and returns the reponse given back to main
     *
     * @param:    String question
     * @return    String respose
     */
    private static String askQuestion(String question) 
    {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in); // instantiates the scanner class
        String response = scanner.nextLine(); // assigns response to a variable
        
        return response;
    }
    
     
    /**
     * startRound:
     * Sends the prompt message to the user and sets/resets all of the count values to 0. 
     * Returns the user response to main.
     *
     * @return    String respose
     */
    private static String startRound() 
    {        
        String response = askQuestion("Plz feed me text, I need numbers to survive:"); //asks for input
        
        // sets all the values to 0 at the start of a new round
        OddCounter.countOne = 0;
        OddCounter.countThree = 0;
        OddCounter.countFive = 0;
        OddCounter.countSeven = 0;
        OddCounter.countNine = 0;
        OddCounter.countOther = 0;
        
        return response;
    }
}
