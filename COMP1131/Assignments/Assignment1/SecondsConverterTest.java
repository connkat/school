



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * The test class SecondsConverterTest.
 *
 */
public class SecondsConverterTest
{
    /**
     * Default constructor for test class SecondsConverterTest
     */
    public SecondsConverterTest()
    {
    }

    @Test
    public void testSecondsConversionWithValue0()
    {   
        List T1 = SecondsConverter.convert(0);
        int hours = 0 / 3600; 
        int minutes = (0 % 3600) / 60; 
        int seconds = 0 % 60;  //
        
        List<Object> time = Arrays.asList(hours, minutes, seconds); 
        Assertions.assertEquals(T1, time);
        
    }
    
    @Test 
    public void testSecondsConversionWithValue1()
    {   
        List T2 = SecondsConverter.convert(1);
        int hours = 1 / 3600; 
        int minutes = (1 % 3600) / 60;  
        int seconds = 1 % 60; 
        
        List<Object> time = Arrays.asList(hours, minutes, seconds); 
        Assertions.assertEquals(T2, time);
        
    }
    
    @Test
    public void testSecondsConversionWithValue60()
    {           
        List T3 = SecondsConverter.convert(60);
        int hours = 60 / 3600; 
        int minutes = (60 % 3600) / 60;  
        int seconds = 60 % 60; 
        
        List<Object> time = Arrays.asList(hours, minutes, seconds); 
        Assertions.assertEquals(T3, time);
        
    }
       
    @Test
    public void testSecondsConversionWithValue3600()
    {   
        List T4 = SecondsConverter.convert(3600);
        int hours = 3600 / 3600; 
        int minutes = (3600 % 3600) / 60;  
        int seconds = 3600 % 60; 
        
        List<Object> time = Arrays.asList(hours, minutes, seconds); 
        Assertions.assertEquals(T4, time);
        
    }
        
    @Test
    public void testSecondsConversionWithValue3661()
    {           
        List T5 = SecondsConverter.convert(3661);
        int hours = 3661 / 3600; 
        int minutes = (3661 % 3600) / 60;  
        int seconds = 3661 % 60; 
        
        List<Object> time = Arrays.asList(hours, minutes, seconds); 
        Assertions.assertEquals(T5, time);
        
    }
    
    @Test
    public void testSecondsConversionWithValue9999()
    {           
        List T6 = SecondsConverter.convert(9999);
        int hours = 9999 / 3600; 
        int minutes = (9999 % 3600) / 60;  
        int seconds = 9999 % 60; 
        
        List<Object> time = Arrays.asList(hours, minutes, seconds); 
        Assertions.assertEquals(T6, time);
        
    }
}


