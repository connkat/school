
/**
 * An application that converts seconds to 
 * Hours, Minutes, and Seconds
 */

import java.util.*;

public class SecondsConverter{
    public static void main(String[] args)
    {
        int totalSeconds = askQuestion(); //returns seconds
        List<Object> time = convert(totalSeconds); //calculates seconds to HMS format
        
        System.out.printf("%d seconds is equivalent to %d hours, %d minutes, and %d seconds.%n", totalSeconds, time.get(0), time.get(1), time.get(2));
    }
    
    private static int askQuestion() 
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the time in seconds:");
        int seconds = scanner.nextInt(); 
        scanner.close();
        
        return seconds;
    }
    
    // convert function is isolated for testing purposes
    public static List<Object> convert(int totalSeconds) {
        int hours = totalSeconds / 3600;  // 1 hour = 3600 seconds
        int minutes = (totalSeconds % 3600) / 60;  // 1 minute = 60 seconds
        int seconds = totalSeconds % 60;  // Remaining seconds
        
        return Arrays.asList(hours, minutes, seconds); 
                
    }

}
