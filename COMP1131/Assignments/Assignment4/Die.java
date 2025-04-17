
/**
 * Represents one die with faces showing values between 1 and the maximum
 * number of faces, supporting 4, 6, 8, 12, and 20-sided dice.
 *
 * @connkat (Kat Connolly)
 * @version v1.0
 */
public class Die
{
    private int maxFaces;    // maximum face value
    private int faceValue;   // current value showing on the die

    /**
     * Constructor for objects of class Die with default values
     */
    public Die()
    {
         maxFaces = 6; //deafult 6 sides
         faceValue = 1;
    }

    /**
     * Constructor: Set the initial face value to 1 and the number of faces based on the param.
     * Only allows 4, 6, 8, 12, or 20 sided dice, defaults to 6 if no param is provided
     *
     * @param faces The number of faces on the die
     * @return void
     */
    public Die(int faces)
    {
        // Check if the number of faces is valid (4, 6, 8, 12, or 20)
        if (faces == 4 || faces == 6 || faces == 8 || faces == 12 || faces == 20)
            maxFaces = faces;
        else
            maxFaces = 6;  // Default to 6 sides if invalid
            
        faceValue = 1;
    }
    
     /**
     * Generates a number possible given the faces of the die
     *
     * @return faceValue A randomized number between 1 and the maxFaces value
     */
    public int roll()
    {
        faceValue = (int)(Math.random() * maxFaces) + 1;
        return faceValue;
    }
    
     /**
     * Sets the faceValue if the value passed is valid
     *
     * @param value
     * @return void
     */
    public void setFaceValue(int value)
    {
        if (value > 0 && value <= maxFaces)
            faceValue = value;
    }
    
    /**
     * Accessor: makes the value of faceValue accessible
     *
     * @return faceValue The value of the face
     */
    public int getFaceValue()
    {
        return faceValue;
    }
    
    /**
     * Returns the textual name of the current face value
     *
     * @return String The text value of the number of the die
     */
    public String getTextualFaceValue()
    {
        switch (faceValue)
        {
            case 1:  return "One";
            case 2:  return "Two";
            case 3:  return "Three";
            case 4:  return "Four";
            case 5:  return "Five";
            case 6:  return "Six";
            case 7:  return "Seven";
            case 8:  return "Eight";
            case 9:  return "Nine";
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
            case 20: return "Twenty";
            default: return "Unknown";
        }
    }
    
    /**
     * Returns the number of faces on the Die
     *
     * @return macFaces The number of faces given by the user
     */
    public int getMaxFaces()
    {
        return maxFaces;
    }
    
    /**
     * Returns a string with the response
     *
     * @return String The final response containing the calculated face value
     */
    public String toString()
    {
        return faceValue + " : " + getTextualFaceValue();
    }
}
