
/**
 * An application that repeatedly reads some text from the user, then determines and displays how many of each of the 
 * odd digits (i.e., 1, 3, 5, 7, and 9) appear in the entire text. 
 *
 * Have a separate counter for each digit. Also count and print the number of all other characters.
 * The logic must include a switch-case structure to determine which counter to increment. 
 * After the results for an input are displayed, prompt the user if they want to do another input.
 *
 * @Kat Connolly (@connkat)
 * @v1.0
 */

import java.util.Scanner; //imports scanner for reading responses

public class OddCounter
{
    static boolean isActive = false;
    static int countOne = 0;
    static int countThree = 0;
    static int countFive = 0;
    static int countSeven = 0;
    static int countNine = 0;
    static int countOther = 0;

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String[] args)    
    {   
        
        do
        {
            String response = start(); 
            
            for (int i = 0; i < response.length(); i++) 
            {
                char currentChar = response.charAt(i);
                
                switch (currentChar)
              {
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
                
                default:
                   countOther++;
                   break;         
                    }
            
            }
            
            System.out.printf("The results are:\n 1: %d\n 3: %d\n 5: %d\n 7: %d\n 9: %d\n other: %d \n", 
                countOne, countThree, countFive, countSeven, countNine, countOther);
            
            String newGame = askQuestion("Enter y to play again, or anything else to exit the game.");
            
            if (newGame.equals("y")) {
                OddCounter.isActive = true;
            }
            else 
            {
                OddCounter.isActive = false;
                System.out.println("Goodbye");
                break;
            }
        }while (isActive = true);
    }
    
     private static String askQuestion(String question) 
    {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in); // instantiates the scanner class
        String response = scanner.nextLine(); // assigns response to a variable
        
        return response;
    }
    
     private static String start() 
    {        
        String response = askQuestion("Plz feed me text, I need numbers to survive.");
        
        OddCounter.countOne = 0;
        OddCounter.countThree = 0;
        OddCounter.countFive = 0;
        OddCounter.countSeven = 0;
        OddCounter.countNine = 0;
        OddCounter.countOther = 0;
        
        return response;
    }
}
