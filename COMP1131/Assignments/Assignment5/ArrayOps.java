
/**
 * A program to find the minimum value, maximum value, and average value and return their values
 * as Strings given a double array.
 *
 * @connkat (Kat Connolly)
 * @version v1.0
 */
public class ArrayOps
{
    private double[] array;

    /**
     * Constructor: Allocates and initializes the array with random values
     * @param size The size of the array
     * @return void
     */
    public ArrayOps(int size)
    {
        array = new double[size];
        for (int i = 0; i < size; i++) {
            array[i] = (Math.random() * 2 * size) - size;
        }
    }

    /**
     * findMin: Finds the minimum value in the array
     *
     * @return double
     */
    public double findMin()
    {
        if (array.length == 0) {
            throw new IllegalStateException("Array is empty");
        }
        
        double min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) { 
                min = array[i];
            }
        }
        return min;
    }
    
    /**
     * findMax: Finds the maximuum value in the array
     *
     * @return double
     */
    public double findMax()
    {
        if (array.length == 0) {
            throw new IllegalStateException("Array is empty");
        }
        
        double max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) { 
                max = array[i];
            }
        }
        return max;
    }
    
    /**
     * findAvg: Finds the average value in the array
     *
     * @return double
     */
    public double findAvg()
    {
        if (array.length == 0) {
            throw new IllegalStateException("Array is empty");
        }
        
        double sum = 0;
        for (double value : array) {
            sum += value;
        }
        return sum / array.length;
    }
    
    /**
     * Returns a string representation of the array values.
     * @return String containing all array values
     */
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            result.append(String.format("%.2f", array[i]));
            if (i < array.length - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
