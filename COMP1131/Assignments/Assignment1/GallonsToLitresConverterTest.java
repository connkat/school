

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class GallonsToLitresConverterTest.
 *
 */
public class GallonsToLitresConverterTest
{
    /**
     * Default constructor for test class GallonsToLitresConverterTest
     */
    public GallonsToLitresConverterTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testGallonConversion()
    {   final double GALLONS_TO_LITRES = 4.54609;
        
        GallonsToLitresConverter gallonsT1 = new GallonsToLitresConverter();
        
        double T1 = GallonsToLitresConverter.convert(0);
        Assertions.assertEquals(T1, GALLONS_TO_LITRES * 0);
        
        double T2 = GallonsToLitresConverter.convert(1);
        Assertions.assertEquals(T2, GALLONS_TO_LITRES * 1);
        
        double T3 = GallonsToLitresConverter.convert(5);
        Assertions.assertEquals(T3, GALLONS_TO_LITRES * 5);
        
        double T4 = GallonsToLitresConverter.convert(0.25);
        Assertions.assertEquals(T4, GALLONS_TO_LITRES * 0.25);
        
        double T5 = GallonsToLitresConverter.convert(12.34);
        Assertions.assertEquals(T5, GALLONS_TO_LITRES * 12.34);
    }
}

