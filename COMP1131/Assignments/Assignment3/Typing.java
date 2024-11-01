
/**
 * Write a description of class Typing here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Scanner; //imports scanner for reading responses

public class Typing
{

    public static void main(String[] args) {
        Object anyValue;

        anyValue = askQuestion("What is your new guess: "); //returns guess response
        System.out.println(anyValue);

        anyValue = 42; // Now storing an Integer
        System.out.println(anyValue);

    }
    
    private static String askQuestion(String question) 
    {
        Scanner scanner = new Scanner(System.in); // instantiates the scanner class
        
        System.out.print(question); // asks question given as arg
        String response = scanner.nextLine(); // assigns response to a variable
        
        return response;
  
    }
    
}
