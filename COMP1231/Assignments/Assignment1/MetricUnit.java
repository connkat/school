/**
 * MetricUnit handles BMI calculation using metric units
 *
 * @author connkat 
 * @version 2025.10.27
 */
class MetricUnit extends MyBMI
{
    private double heightCm;
    
    /**
     * Default constructor
     */
    public MetricUnit() {
        super();
        this.heightCm = 0.0;
    }
    
    /**
     * Parameterized constructor
     * 
     * @param name the person's name
     * @param weightKg the person's weight in kilograms
     * @param heightCm height in centimeters
     */
    public MetricUnit(String name, double weightKg, double heightCm) {
        super(name, weightKg);
        this.heightCm = heightCm;
    }
    
     /** 
     * Accessor method - get height of person
     * 
     * @return heightCm - double
     */
    public double getHeightCm() {
        return heightCm;
    }
    
    /** 
     * Mutator method - set height of person
     * 
     * @param heightCm the person's height in CM - double
     * @return void
     */  
    public void setHeightCm(double heightCm) {
        this.heightCm = heightCm;
    }
    
    /**
     * Convert height from centimeters to meters
     * 
     * @return height in meters - double
     */
    @Override
    public double getHeightInMeters() {
        return heightCm / 100.0;
    }
    
    /**
     * Returns string representation of MetricUnit object
     * 
     * @return string with all details including metric measurements - String
     */
    @Override
    public String toString() {
        return super.toString() + 
               String.format("%nHeight: %.2f cm", heightCm);
    }
}