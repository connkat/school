import java.util.Random; //import Random library
/**
 * Driver class to test the Euclid implementation.
 * 
 * @connkat (Kat Connolly)
 * @v1.0 
 */
public class EuclidDriver
{
    public static void main(String[] args)
    {
       // Test the provided examples
        System.out.println("Testing provided examples:");
        testGCD(40, 24);  // Expected GCD: 8
        testGCD(40, 10);  // Expected GCD: 10
        testGCD(17, 51);  // Expected GCD: 17
        
          
        System.out.println("\nGenerating 30 random test cases:");
        
        // Generate 30 random test cases
        Random random = new Random();
        for (int i = 1; i <= 30; i++) {
            // Generate random integers between 1 and 100
            int num1 = random.nextInt(100) + 1;
            int num2 = random.nextInt(100) + 1;
            
            testGCD(num1, num2);
        }
    }

    /**
     * Helper method to test the GCD calculation and print the result.
     *
     * @param num1 first positive integer
     * @param num2 second positive integer
     * 
     * @return void
     */
    private static void testGCD(int num1, int num2) 
    {
        int result = Euclid.gcd(num1, num2);
        System.out.printf("GCD of %d and %d is %d%n", num1, num2, result);
    }
}
