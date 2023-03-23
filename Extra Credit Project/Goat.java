
/**
 * Goat - defines a Goat type inheriting from Animal and Edible. This is a concrete class, which means that it has to implement all inherited
 *        abstract methods
 *        
 * @author Logan Segal
 * @version 12/3/22
 */
public class Goat extends MultiUse implements Farm
{
    // instance variables - replace the example below with your own
    private String type;

    /**
     * Constructor for objects of class Goats
     */
    public Goat() 
    {
        //implicit call to super()
    }
    
    /**
     * second constructor for the Goat class
     * @param  String type - the type of goat
     */
    public Goat(String type) {
        //explicit call to superconstructor to complete constructor chain
        super("yoga");
        this.type = type;
    }
    
    /**
     * overridden 
     * whereToLive from Farm interface - tells the user where the goat lives. 
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
     * toString from Object class - invoked when a Goat object is printed or concatenated to a String
     * @param  none
     * @return String
     */
    @Override 
    public String toString() {
        return this.type + " goats are good for " + super.getActivity();
    }
}
