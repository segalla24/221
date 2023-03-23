
/**
 * Write a description of class Mail here.
 *
 * @author (your name)
 * Start Date: Sunday Sept. 4, 2022
 */
public class Mail
{
    // instance variables - replace the example below with your own
    private String type;
    private String destination;
    private int units;
    private double postagePerUnit;

    /**
     * Constructor for objects of class Mail
     */
    public Mail()
    {
        // initialise instance variables
        this.type = "";
        this.destination = "";
        this.units = 0;
        this.postagePerUnit = 0.0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setDestination(String dest) {this.destination = dest;}
    public void setUnits(int howMany) {this.units = howMany;}
    public void setPostagePerUnit(double stamps) {this.postagePerUnit = stamps;}
    public void setType(String type) {this.type = type;}
    
    public String getDestination() {return this.destination;}
    public int getUnits() {return this.units;}
    public double getPostagePerUnit() {return this.postagePerUnit;}
    public String getType() {return this.type;}
    
}
