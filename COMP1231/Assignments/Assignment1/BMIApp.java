/**
 * BMIApp driver class to demonstrate BMI calculation system
 *
 * @author connkat 
 * @version 2025.10.27
 */
public class BMIApp
{
    public static void main(String[] args) {
        MyBMI[] bmiList = new MyBMI[6];

        //Imperial
        bmiList[0] = new ImperialUnit("Peter", 50.60, 5, 5);
        bmiList[1] = new ImperialUnit("Jenny", 40.60, 5, 3);
        bmiList[2] = new ImperialUnit("Betty", 60.00, 5, 6);

        //Metric
        bmiList[3] = new MetricUnit("John", 80.00, 165);
        bmiList[4] = new MetricUnit("Mary", 55.55, 173);
        bmiList[5] = new MetricUnit("David", 70.00, 16);

        // Display details of all objects using a single println in a loop
        for (int i = 0; i < bmiList.length; i++) {
            System.out.println(bmiList[i] + "\n");
        }
    }
}