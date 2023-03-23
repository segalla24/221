/**
 * The Train class describes a train object, it is a derived class, from vehicle, that implements all inherited abstract methods.
 *
 * @author Logan Segal
 * @version 11/19/22
 */
public class Train extends Vehicle
{
    // instance variables - replace the example below with your own
    private int cars;

    /**
     * Constructor for objects of class Train
     */
    public Train()
    {
        // initialise instance variables
        super();
        this.cars = 0;
    }

    /**
     * Train - the second train constructor 
     * @param String destination -  the destination of the train
     * @param int cars - the number of cars on the train
     * @param double income - the income of the train
     * @return null
     */
    public Train(String destination, int cars, double income )
    {
        // put your code here
        super(destination, income); //vehicle takes destination and income
        this.cars = cars;
    }
    
    /**
     * getCars - getter for cars instance variable 
     * @param none  
     * @return int
     */
    public int getCars() 
    {
        return this.cars;
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
        double profit = super.getIncome();
        if (super.getDestination().equals("Lancre")){
            profit -= 600;   //base cost for lancre is 600 & subtracting that from the profit
            if (this.cars >= 1) {
                int trainCarCost = 100;  //train car cost for lancre is 100
                int priceOfAllCars = trainCarCost * this.cars;
                profit -= (double)priceOfAllCars;  //subtractng the total car cost form the profit 
            }
            return profit;
        }
        else if (super.getDestination().equals("Ueberwald") || this.getDestination().equals("Borogravia")){
            profit -= 4000;   //base cost for ueberwald and borograiva is 4000 & subtracting that from the profit
            if (this.cars >= 1) {
                int trainCarCost = 100;   //train car cost for ueberwald and borogravia is 100
                int priceOfAllCars = trainCarCost * this.cars;
                profit -= (double)priceOfAllCars;  //subtractng the total car cost form the profit 
            }
            return profit;
        }
        else if (super.getDestination().equals("Klatch")){
            profit -= 2100;   //base cost for klatch is 2100 & subtracting that from the profit
            if (this.cars >= 1) {
                int trainCarCost = 100;   //train car cost for klatch is 100
                int priceOfAllCars = trainCarCost * this.cars;
                profit -= (double)priceOfAllCars;  //subtractng the total car cost form the profit 
            }
            return profit;
        }
        return profit;
    }
}
