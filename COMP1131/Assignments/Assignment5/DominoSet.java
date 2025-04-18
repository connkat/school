import java.util.Random; //import Random
/**
 * A representation of a standard set of 28 domino tiles
 *
 * @connkat (Kat Connolly)
 * @version v1.0
 */
public class DominoSet
{
    private static final int TOTAL_DOMINOES = 28;
    private Domino[] dominoes;
    private int tilesLeft;
    private Random random;

    /**
     * Constructs a complete set of dominoes.
     * Uses nested loops to create tiles with all possible combinations (0,0) 
     * through (6,6).
     */
    public DominoSet()
    {
        dominoes = new Domino[TOTAL_DOMINOES];
        random = new Random();
        tilesLeft = TOTAL_DOMINOES;
        
        int index = 0;
        // Nested loops to create all combinations (higher end containing lower end)
        for (int higher = 0; higher <= 6; higher++) {
            for (int lower = 0; lower <= higher; lower++) {
                dominoes[index] = new Domino(lower, higher);
                index++;
            }
        }
    }

    /**
     * Shuffles the domino set by randomly swapping pairs of tiles.
     *
     * @return void
     */
    public void shuffle()
    {
        // Perform multiple swaps to ensure thorough shuffling
        for (int i = 0; i < tilesLeft * 3; i++) {
            int index1 = random.nextInt(tilesLeft);
            int index2 = random.nextInt(tilesLeft);
            
            // Swap the dominoes at the two random indices
            Domino temp = dominoes[index1];
            dominoes[index1] = dominoes[index2];
            dominoes[index2] = temp;
        }
    }
    
    /**
     * Returns the number of tiles left in the set.
     *
     * @return int The number of tiles left
     */
    public int getTilesLeft()
    {
        return tilesLeft;
    }
    
    /**
     * Deals a tile from the set (removes it from the available tiles).
     *
     * @return Domino The dealt domino, or none if no dominos are left
     */
    public Domino deal()
    {
         if (tilesLeft <= 0) {
            return null;  // No tiles left to deal
        }
        
        // Get the last available tile and decrement the counter
        return dominoes[--tilesLeft];
    }
    
    /**
     * Returns a string representation of all dominoes currently in the set.
     *
     * @return String A string containing all the dominoes in the set
     */
    public String toString()
    {
         StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < tilesLeft; i++) {
            result.append(dominoes[i]);
            if (i < tilesLeft - 1) {
                result.append(", ");
            }
        }
        
        return result.toString();
    }
}
