
/**
 * Livestock - describes a generic livestock object; abstract class
 *
 * @author Logan Segal
 * @version 12/3/22
 */
public abstract class Livestock implements Farm 
{
    // instance variables - replace the example below with your own
    private boolean maintenance;
    private double price;

    /**
     * the class is abstract and cannot be instantiated but the inheritance chain needs to be kept intact
     */
    protected Livestock()
    {
        //implicit call to super()
    }
    /**
     * second constructor for a livestock object
     * @param double price - the price per livestock
     * @param boolean maintenace - if the livestock requires action for its produce
     */
    protected Livestock(boolean maintenance, double price) {
        this.maintenance = maintenance;
        this.price = price;
    }
    /**
     * getMaintenance - getter for the maintenance instance variable
     * @param  none
     * @return boolean
     */
    public boolean getMaintenance() {
        return this.maintenance;
    }
    /**
     * getPrice - getter for the price instance variable
     * @param  none
     * @return double
     */
    public double getPrice() {
        return this.price;
    }
    /**
     * printProduce - abstract prototype, must be overridden by concrete derived classes
     * @param  none
     * @return String
     */
    public abstract String printProduce();
}
