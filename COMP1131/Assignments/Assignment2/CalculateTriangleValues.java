
/**
 * A class that returns the sin, cos, and tan values given the adjacent and 
 * opposite values as decimals
 *
 * @connkat (Kat Connolly)
 * @version v1.0
 */

//importing
import java.util.Scanner; //imports scanner for reading responses
import java.lang.Math; //imports Math for calculations

public class CalculateTriangleValues
{

    public static void main(String[] args)
    {
        double adjacent = askQuestion("What is the adjacent decimal value: "); //returns adjacent response
        double opposite = askQuestion("What is the opposite decimal value: "); //returns opposite response
        
        // Calculate hypotenuse:
        double hypotenuse = Math.sqrt(Math.pow(opposite, 2) + Math.pow(adjacent, 2));
        
        // Calculate sin, cos, and tan:
        double sin = opposite / hypotenuse;
        double cos = adjacent / hypotenuse;
        double tan = opposite / adjacent;
        
        // Print response:
        System.out.printf("Sin: %.3f, Cos: %.3f, Tan: %.3f", sin, cos, tan );
    }
    
     private static double askQuestion(String question) 
    {
        Scanner scanner = new Scanner(System.in); // instantiates the scanner class
        
        System.out.print(question); // asks question given as arg
        double response = scanner.nextDouble(); // assigns response to a variable
        
        return response;
    }
}
