
/**
 * Testing a rolling a single die of varying sides.
 *
 * @connkat (Kat Connolly)
 * @version v1.0
 */
public class DieDriver
{
 public static void main(String[] args)
    {
        // Part 1: Test default constructor (6-sided die) with 12 rolls
        System.out.println("PART 1: Testing default 6-sided die");
        System.out.println("---------------------------------");
        Die defaultDie = new Die();
        System.out.println("Default die created: " + defaultDie.getMaxFaces() + "-sided");
        System.out.println("Initial state: " + defaultDie);
        System.out.println("\nRolling the default die 12 times:");
        
        for (int i = 1; i <= 12; i++)
        {
            defaultDie.roll();
            System.out.println("Roll " + i + ": " + defaultDie);
        }
        
        // Part 2: Test each of the five regular dice types
        System.out.println("\nPART 2: Testing all five regular dice types");
        System.out.println("---------------------------------------");
        int[] regularDice = {4, 6, 8, 12, 20};
        
        for (int sides : regularDice)
        {
            Die die = new Die(sides);
            System.out.println("\n" + sides + "-sided die created");
            System.out.println("Initial state: " + die);
            int rollCount = sides * 2;
            
            System.out.println("Rolling the " + sides + "-sided die " + rollCount + " times:");
            for (int i = 1; i <= rollCount; i++)
            {
                die.roll();
                System.out.println("Roll " + i + ": " + die);
            }
        }
        
        // Part 3: Test with an illegal number of faces
        System.out.println("\nPART 3: Testing with an illegal number of faces");
        System.out.println("-------------------------------------------");
        Die illegalDie = new Die(10); // 10 is not one of the regular dice types
        System.out.println("Attempted to create a 10-sided die");
        System.out.println("Actual die created: " + illegalDie.getMaxFaces() + "-sided");
        System.out.println("Initial state: " + illegalDie);
        
        System.out.println("\nRolling the die 10 times:");
        for (int i = 1; i <= 10; i++)
        {
            illegalDie.roll();
            System.out.println("Roll " + i + ": " + illegalDie);
        }
    }
}
