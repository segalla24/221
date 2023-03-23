
/**
 * Cow - describes a cow object, a concrete class, that implements all inherited abstract methods
 *
 * @author Logan Segal
 * @version 12/3/22
 */
public class Cow extends Grazers
{
    // instance variables - replace the example below with your own
    private String type;

    /**
     * Constructor for objects of class Cow
     */
    public Cow() 
    {
        //implicit call to super()
    }
    
    /**
     * second constructor for a cow object
     * @param String tpye - the tpye of cow
     * @param int amount - how many cows of that type
     * @param double price - the price per cow
     * @param boolean maintenace - if the cow requires action for its produce
     */
    public Cow(String type, int amount, double price, boolean maintenance) 
    {
        //explicit call to superconstructor to complete constructor chain
        super(amount, price, maintenance);
        this.type = type;
    }
    
    /**
     * overridden 
     * printProduce from Livestock class - contains the produce produced from the cow
     * @param  none
     * @return String
     */
    @Override 
    public String printProduce() 
    {
        return "milk";
    }
    
    /**
     * overridden 
     * whereToLive from Farm interface - tells the user where the cow lives. 
     * @param  none
     * @return String
     */
    @Override
    public String whereToLive()
    {
        return "barn";
    }
    
    /**
     * overridden 
     * toString from Object class - invoked when a Cow object is printed or concatenated to a String
     * @param  none
     * @return String
     */
    @Override
    public String toString() 
    {
        return "it's " + String.format("$%,8.2f",super.getPrice()) + " per " + this.type + " cow, we have "
            + super.getAmount() + ", and spent " + String.format("$%,8.2f",super.calculateTotalPrice()) +
            " on them. They produce " + this.printProduce() +
            (super.getMaintenance()? " and need to be milked." : ".");
    }
    }
