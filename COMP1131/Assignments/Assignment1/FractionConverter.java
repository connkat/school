
/**
 * An application that converts fractions to 
 * decimal equivalent. 
 */

import java.util.Scanner;

public class FractionConverter{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        int numerator = askQuestion("numerator"); // returns numerator
        int denominator = askQuestion("denominator"); //returns denominator
        scanner.close();

        double fraction = convert(numerator, denominator); //calculates fraction into decimal value
        
        System.out.printf("The fraction as an integer is to %.7f", fraction);
    }
    
    private static int askQuestion(String fractionPrompt) 
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the " + fractionPrompt + " as a whole number: ");
        int response = scanner.nextInt(); 
        
        return response;
    }
    
    // convert function is isolated for testing purposes
    public static double convert(int numerator, int denominator) {
        double fraction = (double) numerator / denominator;
        
        return fraction;
    }

}
