
import java.util.Scanner; //import scanner
/**
 * A Driver to test the ArrayOps class that prompts the user for an array size, then 
 * creates an ArrayOps object and displats the array conents and stats. 
 *
 * @connkat (Kat Connolly)
 * @version v1.0
 */

public class ArrayOpsDriver
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("What is the size of the array?");
        int size = scanner.nextInt();
        
        while (size <= 0) { //input validation
            System.out.print("Please try again with a positive number");
            size = scanner.nextInt();
        }
        
        ArrayOps arrayOps = new ArrayOps(size); //Create obj with the specific size
        
        // Display array contents and stats
        
        System.out.println("\nArray Contents: " + arrayOps);
        System.out.printf("Minimum value: %.2f\n", arrayOps.findMin());
        System.out.printf("Maximum value: %.2f\n", arrayOps.findMax());
        System.out.printf("Average value: %.2f\n", arrayOps.findAvg());
        
        scanner.close();
    }

}
