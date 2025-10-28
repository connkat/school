/**
 * MyBMI abstract class serves as the base for BMI calculations
 * with different unit systems
 *
 * @author connkat 
 * @version 2025.10.27
 */
abstract class MyBMI
{
    private String name;
    private double weightKg;
    
    /**
     * Default constructor
     */
    public MyBMI() {
        this.name = "";
        this.weightKg = 0.0;
    }
    
    /**
     * Parameterized constructor
     * 
     * @param name the person's name - String
     * @param weightKg the person's weight in kilograms - double
     */
    public MyBMI(String name, double weightKg) {
        this.name = name;
        this.weightKg = weightKg;
    }
    
    /**
     * Accessor Method - returns person data as an array
     * [0] = name (String), [1] = weightKg (double)
     * 
     * @return Object array containing name and weight - {String, double}
     */
    public Object[] getPersonData() {
        return new Object[]{name, weightKg};
    }
    
    /**
     * Mutator Method - sets both name and weight
     * 
     * @param name the person's name - String
     * @param weightKg the person's weight in kilograms - double
     * @return void
     */
    public void setPersonData(String name, double weightKg) {
        this.name = name;
        this.weightKg = weightKg;
    }
    
    /**
     * Abstract method to get height in meters - must be implemented by subclasses
     * 
     * @return height in meters double
     */
    public abstract double getHeightInMeters();
    
    /**
     * Calculate BMI using weight in kg and height in meters - double
     * 
     * @return BMI value - double
     */
    public double calculateBMI() {
        double heightMeters = getHeightInMeters();
        return weightKg / (heightMeters * heightMeters);
    }
    
    /**
     * Analyze BMI to determine category
     * 
     * @return BMI category analysis - String
     */
    public String analyzeBMI() {
        double bmi = calculateBMI();
        if (bmi < 18.5) {
            return "Underweight - BMI is below normal range";
        } else if (bmi >= 18.5 && bmi < 25.0) {
            return "Normal weight - BMI is within normal range";
        } else {
            return "Overweight - BMI is above normal range";
        }
    }
    
    /**
     * Returns string representation of MyBMI object
     * 
     * @return string with name, weight, BMI, and analysis
     */
    @Override
    public String toString() {
        return String.format("Name: %s%nWeight: %.2f kg%nBMI: %.2f%nAnalysis: %s",
                           name, weightKg, calculateBMI(), analyzeBMI());
    }
}