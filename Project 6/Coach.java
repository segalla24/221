/**
 * The Coach class describes a coach object, it is a derived class, from vehicle, that implements all inherited abstract methods.
 *
 * @author Logan Segal
 * @version 11/19/22
 */
public class Coach extends Vehicle
{
    // instance variables - replace the example below with your own
    private int horses;
    private int crew;

    /**
     * Constructor for objects of class Coach
     */
    public Coach()
    {
        // initialise instance variables
        super();
        this.horses = 0;
        this.crew = 0;
    }

    /**
     * Coach - the second Coach constructor 
     * @param String destination - the destination of the coach
     * @param double weight - the weight of the cargo on the coach
     * @param double income - the income of the coach
     * @return null 
     */
    public Coach (String destination, double weight, double income)
    {
        // put your code here
        super(destination, income);  //vehicle takes destination and income
        this.horses = (((int)weight) / 100) + 1;
        this.crew = (this.horses / 4) + 1 ;
    }
    
    /**
     * getHorses - getter for horses instance variable 
     * @param none  
     * @return int
     */
    public int getHorses() 
    {
        return this.horses;
    }
    
    /**
     * getCrew - getter for crew instance variable 
     * @param none  
     * @return int
     */
    public int getCrew() {
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
        double profit = super.getIncome();
        if (super.getDestination().equals("Lancre")){
            profit -= 200;  //base cost for lancre is 200 & subtracting that from the profit
            if (this.horses >= 1){
                int horsePrice = 30; //horse cost for lancre is 30
                int priceOfAllHorses = horsePrice * this.horses;
                profit -= (double)priceOfAllHorses;  //subtractng the total horse cost form the profit 
            }
            if (this.crew >= 1) {
                int crewPrice = 50; //crew cost for lancre is 50
                int priceOfAllCrews = crewPrice * this.crew;
                profit -= (double)priceOfAllCrews;  //subtractng the total crew cost form the profit 
            }
            return profit;
        }
        else if (super.getDestination().equals("Ueberwald")){
            profit -= 200;  //base cost for ueberwlad is 200 & subtracting that from the profit
            if (this.horses >= 1){
                int horsePrice = 100;  //horse cost for ueberwald is 100
                int priceOfAllHorses = horsePrice * this.horses;
                profit -= (double)priceOfAllHorses;  //subtractng the total horse cost form the profit 
            }
            if (this.crew >= 1) {
                int crewPrice = 150;  //crew cost for ueberwald is 150
                int priceOfAllCrews = crewPrice * this.crew;
                profit -= (double)priceOfAllCrews;  //subtractng the total crew cost form the profit 
            }
            return profit;
        }
        else if(super.getDestination().equals("Borogravia")){
            profit -= 200;  //base cost for borogravia is 200 & subtracting that from the profit
            if (this.horses >= 1) {
                int horsePrice = 100;  //horse cost for borogravia is 100
                int priceOfAllHorses = horsePrice * this.horses;
                profit -= (double)priceOfAllHorses;  //subtractng the total horse cost form the profit 
            }
            if (this.crew >= 1) {
                int crewPrice = 150;  //crew cost for borogravia is 150
                int priceOfAllCrews = crewPrice * this.crew;
                profit -= (double)priceOfAllCrews;  //subtractng the total crew cost form the profit 
            }
            return profit;
        }
        else if (super.getDestination().equals("Klatch")){
            profit -= 200;  //base cost for klatch is 200 & subtracting that from the profit
            if (this.horses >= 1){
                int horsePrice = 50;  //horse cost for klatch is 50
                int priceOfAllHorses = horsePrice * this.horses;
                profit -= (double)priceOfAllHorses;  //subtractng the total horse cost form the profit 
            }
            if (this.crew >= 1) {
                int crewPrice = 60;  //crew cost for klatch is 60
                int priceOfAllCrews = crewPrice * this.crew;
                profit -= (double)priceOfAllCrews;  //subtractng the total crew cost form the profit 
                }
            return profit;
        }
        return profit;
    }
}