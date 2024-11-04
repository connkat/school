
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

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main(String[] args)
    {
        String response = askQuestion();
        
        for (char 
        
    }
    
     private static String askQuestion() 
    {
        Scanner scanner = new Scanner(System.in); // instantiates the scanner class
        
        System.out.print("Plz feed me text, I need numbers to survive."); // asks question given as arg
        String response = scanner.nextLine(); // assigns response to a variable
        
        return response;
    }
}
