
/**
 * Implementation of Euclid's algorithm to find the
 * greatest common divisor of two positive integers.
 *
 * @connkat (Kat Connolly)
 * @v1.0
 */
public class Euclid
{
     /**
     * Calculates the greatest common divisor of two positive integers
     * using Euclid's algorithm recursively.
     * 
     * @param m first positive integer
     * @param n second positive integer
     * @return the greatest common divisor of m and n
     */

    public static int gcd(int m, int n) //function to find the greatest common divisor (GCD)
    {
       // Check for valid input
        if (m <= 0 || n <= 0) {
            throw new IllegalArgumentException("Both numbers must be positive");
        }
        
        // If m < n, swap the values
        if (m < n) {
            return gcd(n, m);
        }
        
        // If n evenly divides m, n is the gcd
        if (m % n == 0) {
            return n;
        }
        
        // Recursive case: gcd(m, n) = gcd(n, m % n)
        return gcd(n, m % n);
    }
}
