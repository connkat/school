
/**
 * Demonstrates the interactive testing of a Cat named Fluffy climbing a pole.
 *
 * @connkat (Kat Connolly)
 * @version v1.0
 */

import java.util.Scanner;

public class CatDriver
{
    /**
    * Allows the user to test Cat with simple commands
    */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Cat cat = new Cat(); // Create a new Cat at position 0, climbing up
        
        System.out.println("Cat Interactive Test");
        System.out.println("===================");
        System.out.println("Commands:");
        System.out.println("O - Output the cat's current state");
        System.out.println("C - Make the cat climb one unit");
        System.out.println("R - Reverse the cat's climbing direction");
        System.out.println("E - Exit the program");
        
         boolean running = true;
        while (running)
        {
            System.out.print("\nEnter command (O/C/R/E): ");
            String input = scanner.nextLine().trim().toUpperCase();
            
            if (input.isEmpty())
            {
                continue;
            }
            
            char command = input.charAt(0);
            
            switch (command)
            {
                case 'O': // Output
                    System.out.println("Current state: " + cat.toString());
                    break;
                    
                case 'C': // Climb
                    // Check if cat is at position 0 and trying to climb down
                    if (!cat.toString().contains("climbing up") && cat.toString().contains("position 0"))
                    {
                        System.out.println("Cat is safely on the ground and cannot climb down any further.");
                    }
                    else
                    {
                        cat.climb();
                        System.out.println("The cat climbed.");
                    }
                    break;
                    
                case 'R': // Reverse direction
                    cat.changeDirection();
                    System.out.println("The cat changed direction.");
                    break;
                    
                case 'E': // Exit
                    System.out.println("Exiting the program. Goodbye!");
                    running = false;
                    break;
                    
                default:
                    System.out.println("Unknown command. Please try again.");
                    break;
            }
        }
        
        scanner.close();
    }        
}


