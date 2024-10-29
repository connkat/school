

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The test class FractionConverterTest.
 *
 */
public class FractionConverterTest
{
    @Test
    public void testFractionConversion()
    {   
        
        double T1 = FractionConverter.convert(0, 1);
        Assertions.assertEquals(T1, (double)0/1);
        
        double T2 = FractionConverter.convert(1, 2);
        Assertions.assertEquals(T2, (double)1/2);
        
        double T3 = FractionConverter.convert(3, 8);
        Assertions.assertEquals(T3, (double)3/8);
        
        double T4 = FractionConverter.convert(2, 3);
        Assertions.assertEquals(T4, (double)2/3);
        
        double T5 = FractionConverter.convert(25, 7);
        Assertions.assertEquals(T5, (double)25/7);
    }
}

