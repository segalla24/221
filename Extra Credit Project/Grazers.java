
/**
 * Grazers - describes a grazers object; abstract class, because the class doesn't implement all inherited abstract methods
 *
 * @author Logan Segal
 * @version 12/3/22
 */
public abstract class Grazers extends Livestock
{
    // instance variables - replace the example below with your own
    private int amount;
    
    /**
     * the class is abstract and cannot be instantiated but the inheritance chain needs to be kept intact
     */
    protected Grazers()
    {
        //implicit call to super()
    }
    
    /**
     * second constructor for a grazer object
     * @param int amount - the amount of grazer
     * @param double price - the price per grazer
     * @param boolean maintenace - if the grazer requires action for its produce
     */
    protected Grazers(int amount, double price, boolean maintenance)
    {
        super(maintenance, price);
        this.amount = amount;
    }
    
    /**
     * getAmount - getter for the amount instance variable
     * @param  none
     * @return int
     */
    public int getAmount() 
    {
        return this.amount;
    }
    
    /**
     * calculateTotalPrice - given amount and price per animal, calculate total price 
     * @param  none
     * @return double
     */
    public double calculateTotalPrice() {
        return this.amount * super.getPrice();
    }
}
