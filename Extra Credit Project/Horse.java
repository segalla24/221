
/**
 * Horse - describes a horse object, a concrete class, that implements all inherited abstract methods
 *
 * @author Logan Segal
 * @version 12/3/22
 */
public class Horse extends Grazers
{
    // instance variables - replace the example below with your own
    private String type;

    /**
     * Constructor for objects of class Cow
     */
    public Horse() 
    {
        //implicit call to super()
    }
    
    /**
     * second constructor for a cow object
     * @param String tpye - the tpye of horse
     * @param int amount - how many horses of that type
     * @param double price - the price per horse
     * @param boolean maintenace - if the horse requires action for its produce
     */
    public Horse(String type, int amount, double price, boolean maintenance) 
    {
        //explicit call to superconstructor to complete constructor chain
        super(amount, price, maintenance);
        this.type = type;
    }

    /**
     * overridden 
     * printProduce from Livestock class - contains the produce produced from the horse
     * @param  none
     * @return String
     */
    @Override 
    public String printProduce() 
    {
        return "a mean of transportation";
    }
    
    /**
     * overridden 
     * whereToLive from Farm interface - tells the user where the horse lives. 
     * @param  none
     * @return String
     */
    @Override
    public String whereToLive()
    {
        return "stable";
    }
    
    /**
     * overridden 
     * toString from Object class - invoked when a Horse object is printed or concatenated to a String
     * @param  none
     * @return String
     */
    @Override
    public String toString() 
    {
        return "it's " + String.format("$%,8.2f",super.getPrice()) + " per " + this.type + " horse, we have "
            + super.getAmount() + ", and spent "  + String.format("$%,8.2f",super.calculateTotalPrice()) +
            " on them. They produce " + this.printProduce() +
            (super.getMaintenance()? " and need to be collected." : ".");
    }
}
