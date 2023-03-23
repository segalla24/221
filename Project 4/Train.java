/**
 * The Train class proivdes the information the Project 4 class will need to be successful. Most of our math and
 * logic take place in this class. This class sets up the information and methods that will help us construct our array. 
 *
 *
 * author @Logan Segal
 * version @10/21/22
 */
public class Train
{
    // instance variables - replace the example below with your own
    private String origin;
    private int departureTime;
    private int arrivalTime;
    private boolean sameDayArrival;
    private String cargo;
    private double weightOfTrainCargo;
    private static double weightOfAllCargo;
    
    /**
    * Constructor for objects of class Train
    */
   public Train()
    { 
        // initialise instance variables
        this.origin = "";
        this.departureTime = 0;
        this.arrivalTime = 0;
        this.sameDayArrival = false;
        this.cargo = "";
        this.weightOfTrainCargo = 0.0;
        weightOfAllCargo++;
    }

   /**
    * Train()
    * second constructor for the train class
    * @param origin
    * @param departure
    * @param stops
    * @param duration
    * @return null, sets objects to its proper variables
    */
   public Train( String origin, int departure, int stops, int duration ) 
    {
        // put your code here
        this.origin = origin;
        this.departureTime = departure;
        calculateArrivalTime(stops,duration);
        this.cargo = "";
    }
    
    /** 
    * calculateArrivalTime()
    * calculates the time of arrival based on the stops, duration, and departure time
    * @param stops object that represents the amount of stops taken 
    * @param duration object that represents the duration of the trip
    * @return time of arrival in military time
    */
    public void calculateArrivalTime( int stops, int duration ) 
    {
        int stopsInMins = stops * 10; //10 represents the minitues each stop is
        int time = duration + stopsInMins;
        int convertToHours = (time / 60) * 100; // hours
        int findingTheMins = time % 60; // mins
        int totalTime = convertToHours + findingTheMins; //adding hours and mins
        totalTime += this.departureTime;
        
        //overflow baby
        if ((totalTime % 100) >= 60) {
            convertToHours += 100;
            findingTheMins -= 60;
            totalTime = convertToHours + findingTheMins;
            totalTime += this.departureTime;
        }
        
        
        if (totalTime >= 2400) {
            this.arrivalTime = totalTime - 2400;
        }
        else {
            this.arrivalTime = totalTime;
        }
   }
    
   //getters
   public String getOrigin() { return this.origin; }
   public int getArrivalTime() { return this.arrivalTime; }
   public int getDepartureTime() { return this.departureTime; }
   public boolean getSameDayArrival() { 
       int time = this.arrivalTime + this.departureTime ;
       if (time > 0000) {
            return true;
       }
       else {
           return false;
       }
   }
   public String getCargo() { return this.cargo; }
   public double getWeightOfTrainCargo() { return this.weightOfTrainCargo; }
   public static double getWeightOfAllCargo() { return weightOfAllCargo; }
    
    /** 
    * loadCargo()
    * loads up the cargo that belongs on the train
    * @param cargoType the type the train holds
    * @param units the quanity
    * @param weightPerItem the indivudual weight of 
    * @return the amount, weights, and type of cargo the trains hold
    */
   public void loadCargo( String cargoType, int units, double weightPerItem ) 
    {
        double totalWeight = units * weightPerItem; 
        this.weightOfTrainCargo += totalWeight;
        if (this.cargo.equals("")) {
            this.cargo += units + " " + cargoType;
        }
        else {
            this.cargo += " and " + units + " " + cargoType;
        }  
        weightOfAllCargo += totalWeight;
    }
}
