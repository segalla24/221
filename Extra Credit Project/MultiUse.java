
/**
 * MultiUse - defines a generic farm animal that can make be used for multiple things
 *
 * @author Logan Segal
 * @version 12/3/22
 */
public class MultiUse
{
    // instance variables
    private String activity;
    
    /**
     * standard constructor - for completeness
     */
    protected MultiUse() {}
    
    /**
     * second constructor
     * @param String type - where the livestock lives
     */
    protected MultiUse(String activity)
    {
        // initialise instance variables
        this.activity = activity;
    }

    /**
     * getType - getter for the type intance variable
     * @param none
     * @return String
     */
    public String getActivity() 
    {
        // put your code here
        return this.activity;
    }
}
