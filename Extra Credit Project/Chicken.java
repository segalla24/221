
/**
 * Chicken describes a Chicken object. It is a concrete class and implements all inherited abstract methods
 *
 * @author Logan Segal
 * @version 12/3/22
 */
public class Chicken extends Poultry
{
    // instance variables - replace the example below with your own
    private String type;

    /**
     * Constructor for objects of class Chicken
     */
    public Chicken()
    {
        //implicit call to super()
    }
    
    /**
     * second constructor for a chicken object
     * @param String tpye - the tpye of chicken
     * @param int amount - how many chickens of that type
     * @param double price - the price per chicken
     * @param boolean maintenace - if the chicken requires action for its produce
     */public Chicken(String type, int amount, double price, boolean maintenance) 
    {
        //explicit call to superconstructor to complete constructor chain
        super(amount,price,maintenance);
        this.type = type;
    }
    
    /**
     * overridden 
     * printProduce from Livestock class - contains the produce produced from the chicken
     * @param  none
     * @return String
     */
    @Override 
    public String printProduce() 
    {
        return "eggs";
    }
    
    /**
     * overridden 
     * whereToLive from Farm interface - tells the user where the chicken lives. 
     * @param  none
     * @return String
     */
    @Override
    public String whereToLive()
    {
        return "coop";
    }
    
    /**
     * overridden 
     * toString from Object class - invoked when a Cicken object is printed or concatenated to a String
     * @param  none
     * @return String
     */
    @Override
    public String toString() 
    {
        return "it's " + String.format("$%.2f",super.getPrice()) + " per " + this.type + " chicken, we have "
            + super.getAmount() + ", and spent " + String.format("$%.2f",super.calculateTotalPrice()) +
            " on them. They produce " + this.printProduce() +
            (super.getMaintenance()? " and need to be collected." : ".");
    }
}
