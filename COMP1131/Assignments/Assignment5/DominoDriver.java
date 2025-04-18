
/**
 * Driver class to test the Domino and DominoSet classes.
 *
 * @connkat (Kat Connolly)
 * @version v1.0
 */
public class DominoDriver
{
    /**
     * Constructor for objects of class DominoDriver
     */
    public static void main(String[] args)
    {
        // Create a new set of dominoes
        DominoSet set = new DominoSet();
        
        // Display the initial set to verify it's complete
        System.out.println("Initial Domino Set:");
        System.out.println(set);
        System.out.println("Total tiles: " + set.getTilesLeft());
        System.out.println();
        
        // Shuffle the set
        set.shuffle();
        System.out.println("Shuffled Domino Set:");
        System.out.println(set);
        System.out.println();
        
        // Deal and display each tile
        System.out.println("Dealing all tiles:");
        Domino tile;
        while ((tile = set.deal()) != null) {
            System.out.println("Dealt: " + tile + ", Tiles left: " + set.getTilesLeft());
        }
        
        // Verify no tiles are left
        System.out.println("\nTiles remaining: " + set.getTilesLeft());
    }

}
