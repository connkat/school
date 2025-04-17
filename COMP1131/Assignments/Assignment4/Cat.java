
/**
 * Cat: The program represents a cat climbing a vertical utility pole. 
 * The cat can only climb for one unit of distance at a time. 
 * The direction in which it is climbing can be either up or down. 
 * The cat can decide to change direction 
 * Cat requires a toString method to return both the current position and the 
 * direction climbing to the driver so it can be output. 
 *
 * @connkat (Kat Connolly)
 * @version v1.0
 */
public class Cat
{
    private int position;      // Current position of the cat on the pole
    private boolean climbingUp; // Direction of climbing (true for up, false for down)
    
     /**
     * Default constructor initializes a cat at position 0, climbing up.
     */
    public Cat() {
        position = 0;
        climbingUp = true;
    }
    
    /**
     * Constructor for setting the initial position/direction. 
     * If negative position is provided, it will default to 0.
     * 
     * @param initialPosition The starting position of the cat
     * @param isClimbingUp The initial direction (true for up, false for down)
     */
    public Cat(int initialPosition, boolean isClimbingUp)
    {
         position = (initialPosition < 0) ? 0 : initialPosition;
        climbingUp = isClimbingUp;
    }

    /**
     * Makes the cat climb by one unit in current direction. 
     * The cat cannot climb past zero
     *
     * @return void
     */
   public void climb() {
        if (climbingUp) {
            position++;
        } else { // Only decrease position if the cat won't go below ground
             if (position > 0) {
                position--;
            }
        }
    }
    
    /**
     * Changes the direction in which the cat is climbing.
     *
     * @return void
     */
    public void changeDirection() {
        climbingUp = !climbingUp;
    }
    
    /**
     * Returns a string representation of the cat's current state,
     * including its position and climbing direction.
     * 
     * @return String 
     */
    @Override
    public String toString() {
        String direction = climbingUp ? "up" : "down";
        return "Cat is at position " + position + " and climbing " + direction;
    }
    
}
