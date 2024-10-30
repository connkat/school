
/**
 * A class that calculates and displays the volume and surface area of a cylinder
 * given the radius and height values using the following equations: 
 * Volume = π r2 h 
 * Surface Area = 2 π r (h + r)
 * 
 * @connkat (Kat Connolly)
 * @version v1.0
 */

//importing
import java.util.Scanner; //imports scanner for reading responses
import java.lang.Math; //imports Math for calculations and values

public class CalculateCylinder
{
    // decalre PI
    private static double pi = Math.PI;

    public static void main(String[] args)
    {
        double radius = askQuestion("What is the radius value: "); //returns radius response
        double height = askQuestion("What is the height value: "); //returns height response
        
        // Calculate Volume:
        double volume = pi * Math.pow(radius, 2) * height;
        
        // Calculate Surface Area:
        double area = 2 * pi * radius * (height + radius);

        // Print response:
        System.out.printf("Volume: %.7f, Surface Area: %.7f", volume, area );
    }
    
     private static double askQuestion(String question) 
    {
        Scanner scanner = new Scanner(System.in); // instantiates the scanner class
        
        System.out.print(question); // asks question given as arg
        double response = scanner.nextDouble(); // assigns response to a variable
        
        return response;
    }
}
