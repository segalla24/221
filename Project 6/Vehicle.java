/**
 * The Vehicle class describes a vehicle object. This is an abstract parents class, and is used by the child classes through inheritance 
 * @author Logan Segal
 * @version 11/19/22
 */
public abstract class Vehicle
{
    // instance variables - replace the example below with your own
    private String destination;
    private double income;
    private static double revenue;

    /**
     * Constructor for objects of class Vehicle
     */
    protected Vehicle()
    {
        // initialise instance variables
        this.destination = "";
        this.income = 0.0;
        revenue++;
    }

    /**
     * Vehicle - the second vehicle constructor 
     * @param String destination - the destination of the vehicle
     * @param double income - the income of the vehicle 
     */
    protected Vehicle (String destination, double income) 
    {
        // put your code here
        this.destination = destination;
        this.income = income;
    }
    
    /**
     * getDestination - getter for destination instance variable 
     * @param none  
     * @return String
     */
    public String getDestination() 
    {
        return this.destination;
    }
    
    /**
     * getIncome - getter for the income instance variable
     * @param none
     * @return double
     */
    public double getIncome() 
    {
        return this.income;
    }
    
    /**
     * setRevenue - setter for the revenue instance variable 
     * @param double addRevenue - adding individual revenue to the total 
     * @return null
     */
    public static void setRevenue(double addRevenue) 
    {
        revenue += addRevenue ;
    }
    
    /**
     * getRevenue - getter for the revenue instance variable
     * @param none  
     * @return double
     */
    public static double getRevenue() {
        return revenue; 
    }
    
    /**
     * addToTotalProfit - abstract prototype, must be overridden
     * @param none 
     * @return null
     */
    public abstract void addToTotalProfit(); 
    
    /**
     * calculateVehicleTotal - abstract prototype, must be overridden 
     * @param none
     * @return double
     */
    public abstract double calculateVehicleProfit();
}
