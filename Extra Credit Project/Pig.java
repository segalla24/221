
/**
 * Pig - defines a Pig type inheriting from MultiUse and Farm. This is a concrete class, which means that it has to implement all inherited
 *       abstract methods
 *
 * @author Logan Segal
 * @version 12/3/22
 */
public class Pig extends MultiUse implements Farm
{
    // instance variables - replace the example below with your own
    private String type ;
    
    /**
     * Constructor for objects of class Pigs
     */
    public Pig()
    {
        //implicit call to super()
    }
    
    /**
     * second constructor for the Pig class
     * @param  String type - the type of pig
     */
    public Pig(String type)
    {
        //explicit call to superconstructor to complete constructor chain
        super("pets");
        this.type = type;
    }
    
    /**
     * overridden 
     * whereToLive from Farm interface - tells the user where the pig lives. 
     * @param  none
     * @return String
     */
    @Override
    public String whereToLive()
    {
        return "pen";
    }
    
    /**
     * overridden 
     * toString from Object class - invoked when a Pig object is printed or concatenated to a String
     * @param  none
     * @return String
     */    
    @Override
    public String toString() 
    {
        return this.type + " pigs make good " + super.getActivity();
    }
}
