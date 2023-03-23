/**
 * The Boat class describes a boat object, it is a derived class, from vehicle, that implements all inherited abstract methods.
 *
 * @author Logan Segal
 * @version 11/19/22
 */
public class Boat extends Vehicle
{
    // instance variables - replace the example below with your own
    private int crew;

    /**
     * Constructor for objects of class Boat
     */
    public Boat()
    {
        // initialise instance variables
        super(); 
        this.crew = 0;
    }

    /**
     * Boat - the second boat constructor 
     * @param String destination - the destination of the boat
     * @param double weight - the number of cars on the boat
     * @param double income - the income of the boat
     * @return null 
     */
    public Boat(String destination, double weight, double income) 
    {
        // put your code here
        super(destination, income);  //vehicle takes destination and income
        this.crew = (((int) weight) / 500) + 1;
    }
    
    /**
     * getCrew - getter for crew instance variable 
     * @param none  
     * @return int
     */public int getCrew() 
    {
        return this.crew;
    }
    
    /**
     * overridden 
     * addToTotalProfit- using the individual vehicle profits,adds it to the revenue
     * @param  none
     * @return null
     */
    @Override 
    public void addToTotalProfit() {
        super.setRevenue(this.calculateVehicleProfit());
    }
    
    /**
     * overridden 
     * calculateVehicleProfit - given destination, weight, and income of the shipment, 
     *                          calculate the profit for the vehicle based on location
     * @param  none
     * @return double
     */
    @Override
    public double calculateVehicleProfit() {
        double profit = this.getIncome();
        if (super.getDestination().equals("Lancre")){
            profit -= 1000; //base cost for lancre is 1000 & subtracting that from the profit
            if (this.crew >= 1){
                int crewPrice = 50; //crew cost for lancre is 50
                int priceOfAllCrews = crewPrice * this.crew;
                profit -= (double)priceOfAllCrews;  //subtractng the total crew cost form the profit 
            }
            return profit;
        }
        else if (super.getDestination().equals("Ueberwald") || this.getDestination().equals("Borogravia")){
            profit -= 3000;  //base cost for ueberwald and borogravia is 3000 & subtracting that from the profit
            if (this.crew >= 1){
                int crewPrice = 150; //crew cost for ueberwald and borogravia is 150
                int priceOfAllCrews = crewPrice * this.crew;
                profit -= (double)priceOfAllCrews;  //subtractng the total crew cost form the profit 
            }
            return profit;
        }
        else if (super.getDestination().equals("Klatch")){
            profit -= 1200;  //base cost for klatch is 1200 & subtracting that from the profit
            if (this.crew >= 1){
                int crewPrice = 60;  //crwe cost for klatch is 60
                int priceOfAllCrews = crewPrice * this.crew;
                profit -= (double)priceOfAllCrews;  //subtractng the total crew cost form the profit 
            }
            return profit;
        }
        return profit;
    }
}
