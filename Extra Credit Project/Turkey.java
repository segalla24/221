
/**
 * Turkey - describes a turkey object, a concrete class, that implements all inherited abstract methods
 *
 * @author Logan Segal
 * @version 12/3/22 
 */
public class Turkey extends Poultry
{
    // instance variables - replace the example below with your own
    private String type;

    /**
     * Constructor for objects of class Turkey
     */
    public Turkey() 
    {
        //implicit call to super()
    }
    
    /**
     * second constructor for a turkey object
     * @param String typw - the tpye of turkey
     * @param int amount - how many turkeys of that type
     * @param double price - the price per turkey
     * @param boolean maintenace - if the turkey requires action for its produce
     */
    public Turkey (String type,int amount, double price, boolean maintenance) 
    {
        //explicit call to superconstructor to complete constructor chain
        super(amount, price, maintenance);
        this.type = type;
    }
    
    /**
     * overridden 
     * printProduce from Livestock class - contains the produce produced from the turkey
     * @param  none
     * @return String
     */
    @Override 
    public String printProduce() 
    {
        return "thanksgiving dinner";
    }
    
    /**
     * overridden 
     * whereToLive from Farm interface - tells the user where the turkey lives. 
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
     * toString from Object class - invoked when a Turkey object is printed or concatenated to a String
     * @param  none
     * @return String
     */
    @Override
    public String toString() 
    {
        return "it's " + String.format("$%.2f",super.getPrice()) + " per " + this.type + " turkey, we have "
            + super.getAmount() + ", and spent " + String.format("$%.2f",super.calculateTotalPrice()) +
            " on them. They produce " + this.printProduce() +
             (super.getMaintenance()? " and need to be collected." : ".");
    }
}
