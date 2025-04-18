
/**
 * Represents a standard domino tile with two ends, each having 0-6 pips.
 *
 * @connkat (Kat Connolly)
 * @version v1.0
 */
public class Domino
{
    private int end1;
    private int end2;

    // Array for looking up the text names of the pip values
    private static final String[] NAMES = {"Blank", "One", "Two", "Three", "Four", "Five", "Six"};
    
    /**
      * Constructs a domino with the specified values for each end.
     * @param e1 Value for end 1 (0-6)
     * @param e2 Value for end 2 (0-6)
     * 
     * @return Domino
     */
    public Domino(int e1, int e2) 
    {
        if (e1 < 0 || e1 > 6 || e2 < 0 || e2 > 6) {
            throw new IllegalArgumentException("Domino values must be between 0 and 6");
        }
        end1 = e1;
        end2 = e2;
    }

    /**
     * Returns the value of end1
     *
     * @return int Value of end1
     */
    public int getEnd1()
    {
         return end1;
    }
    
    /**
     * Returns the value of end2
     *
     * @return int Value of end2
     */
    public int getEnd2()
    {
         return end2;
    }
    
    /**
     * Returns a string representation of the domino tile.
     * The larger value is listed last,if both ends have the same value, 
     * it's called a "Double".
     * 
     * @return String A representation of the domino
     */
    public String toString()
    {
         if (end1 == end2) {
            return "Double " + NAMES[end1];
        } else if (end1 > end2) {
            return NAMES[end2] + " - " + NAMES[end1];
        } else {
            return NAMES[end1] + " - " + NAMES[end2];
        }
    }
}
