
/**
 * Poultry - describes a poultry object; abstract class, because the class doesn't implement all inherited abstract method
 *
 * @author Logan Segal
 * @version 12/3/22
 */
public abstract class Poultry extends Livestock
{
    // instance variables - replace the example below with your own
    private int amount;

    /**
     * the class is abstract and cannot be instantiated but the inheritance chain needs to be kept intact
     */
    protected Poultry()
    {
        //implicit call to super()
    }
    
    /**
     * second constructor for a poultry object
     * @param int amount - the amount of poultry
     * @param double price - the price per poultry
     * @param boolean maintenace - if the poultry requires action for its produce
     */
    protected Poultry(int amount, double price, boolean maintenance) {
        //explicit call to superconstructor to complete constructor chain
        super(maintenance,price);
        this.amount = amount;
    }
    
    /**
     * getAmount - getter for the amount instance variable
     * @param  none
     * @return int
     */
    public int getAmount() {
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
