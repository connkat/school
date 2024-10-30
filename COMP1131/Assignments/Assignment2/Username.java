
/**
 * A class that generates a username from a set of the following inputs: 
 * The username is to be a string composed of the first two characters of the person’s first name, 
 * followed by the first four letters of the person’s last name, 
 * followed by a two-digit random number in the range of 10 to 99.
 *
 * @connkat (Kat Connolly)
 * @version v1.0
 */

//importing 
import java.util.Scanner; //imports scanner for reading responses
import java.util.Random; //imports random class

public class Username
{
    private String x;

    /**
     * Constructor for objects of class Username
     */
    public Username()
    {
        String username = "";
    }

    public static void main(String[] args)
    {
        String firstName = askQuestion("What is your first name: "); // returns first name response
        String lastName = askQuestion("What is your last name: "); // returns last name response
                
        Random generator = new Random(); // instantiates the Random class
        int randomNum = generator.nextInt(90)+10 ; // generates a random number between 10-99
        
        System.out.printf("Your username is: %s%s%s", firstName.substring(0,2), lastName.substring(0,4), Integer.toString(randomNum));
    }
    
     private static String askQuestion(String question) 
    {
         Scanner scanner = new Scanner(System.in); // instantiates the scanner class
        
        System.out.print(question); // asks question given as arg
        String response = scanner.nextLine(); // assigns response to a variable
        
        return response;
    }
}
