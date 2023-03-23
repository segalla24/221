
/**
 * The Delivery Class provides the information with the information we will use throughout the rest 
 * of the project in the Main(). Most of the math and logic we need is seen in the second constuctor 
 * of this class.
 *
 * @author Logan Segal
 * @version 9/27/22
 */
public class Delivery
{
    // instance variables - replace the example below with your own
    private String receiver;
    private String origin;
    private String item;
    private boolean hazardous;
    private double fee;
    
    /*
     * Constructor for objects of class Delivery
     */
    public Delivery()
    {
        // initialise instance variables
        this.receiver = "";
        this.origin = "";
        this.item = "";
        this.hazardous = false;
        this.fee = 0.0;
    }
    
    public Delivery( String receiver, String origin, String item, int numberOfItems, int weightPerItemInOz, String hazard) {
      this.receiver = receiver;
      this.origin = origin;
      this.item = item;
      double totalWeight = weightPerItemInOz * numberOfItems;  //finding the total weight
    
      //branching to fee os the shipment based on origin and weight
      if (origin.equals("Ankh-Morpork")) {
          fee = 87 * Math.ceil(totalWeight / (double)1600);
      }
      else if (origin.equals("Pseudopolis")){
          fee = 165 * Math.ceil(totalWeight / (double)1600);
      }
      else if (origin.equals("Ueberwald")){
          fee = 997 * Math.ceil(totalWeight / (double)1600);
      }
      
      //if shipment is hazardous this will be used
      if (hazard.equals("yes")){
          hazardous = true;
          fee += (fee * 0.65);
      }
      
      //special case for receivers
      if (receiver.equals("Patrician's Office") || receiver.equals("Post Office")){
          fee = 0.0;
      }
    }
    

    // the getter methods
    public String getReceiver() {return this.receiver; }
    public String getOrigin() {return this.origin;}
    public String getItem() {return this.item;}
    public boolean getHazardous() {return this.hazardous;}
    public double getFee() {return this.fee;}
}
