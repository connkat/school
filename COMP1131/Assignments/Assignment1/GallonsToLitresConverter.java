
/**
 * An application that converts a volume in 
 * Imperial gallons into litres (1 gallon equals 4.54609 litres). 
 */

import java.util.Scanner;

public class GallonsToLitresConverter{
    public static void main(String[] args)
    {
        double gallons = askQuestion(); //return gallons
        double litres = convert(gallons); //calculate litres from gallons
        
        System.out.printf(gallons + " gallons is equivalent to %.7f litres.%n", litres);
    }
    
    private static double askQuestion() 
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the volume in gallons as a decimal value:");
        double gallons = scanner.nextDouble(); 
        scanner.close();
        
        return gallons;
    }
    // convert function is isolated for testing purposes
    public static double convert(double gallons) {
        final double GALLONS_TO_LITRES = 4.54609;

        double litres = gallons * GALLONS_TO_LITRES;
        
        return litres;
        
    }

}
