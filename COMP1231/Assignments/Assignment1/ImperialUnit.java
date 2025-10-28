/**
 * ImperialUnit handles BMI calculation using imperial units
 *
 * @author connkat 
 * @version 2025.10.27
 */
class ImperialUnit extends MyBMI
{
    private double heightFeet;
    private double heightInches;

    /**
     * Default constructor
     */
    public ImperialUnit() {
        super();
        this.heightFeet = 0.0;
        this.heightInches = 0.0;
    }

    /** 
     * Parameterized constructor
     * 
     * @param name the person's name - String
     * @param weightKg the person's weight in kilograms - double
     * @param heightFeet height in feet - double
     * @param heightInches height in inches - double
     */
    public ImperialUnit(String name, double weightKg, double heightFeet, double heightInches) {
        super(name, weightKg);
        this.heightFeet = heightFeet;
        this.heightInches = heightInches;
    }

    /** 
     * Accessor method - get height of person
     * 
     * @return height - double
     */
    public double[] getHeight() {
        return new double[]{heightFeet, heightInches};
    }

    /** 
     * Mutator method - set height of person
     * 
     * @param heightFeet the person's height in feet - double
     * @param heightInches the person's heigh in inches - double
     * @return void
     */    
    public void setHeight(double heightFeet, double heightInches) {
        this.heightFeet = heightFeet;
        this.heightInches = heightInches;
    }

    /**
     * Convert imperial height to meters
     * 1 inch = 2.54 cm, 1 foot = 12 inches
     * 
     * @return height in meters - Double
     */
    @Override
    public double getHeightInMeters() {
        double totalInches = (heightFeet * 12) + heightInches;
        double totalCm = totalInches * 2.54;
        return totalCm / 100.0; // convert cm to meters
    }

    /**
     * Returns string representation of ImperialUnit object
     * 
     * @return string with all details including imperial measurements - String
     */
    @Override
    public String toString() {
        return super.toString() + 
        String.format("%nHeight: %.2f feet %.2f inches", heightFeet, heightInches);
    }
}