/**
 * The MailCoach class proivdes the information the Project 3 class will need to be successful. Most of our math and
 * logic take place in the setters which sets the amount of mail, and provides the program also with the leftover
 * amount.
 *
 * author @Logan Segal
 * version @10/9/22
 */
public class MailCoach
{
    // instance variables - replace the example below with your own
    private String route;
    private int capacity;
    private int letters;
    private int packages;
    private boolean dispatched;

    /**
     * Constructor for objects of class MailCoach
     */
    public MailCoach()
    {
        // initialise instance variables
        this.route = "";
        this.capacity = 0;
        this.letters = 0;
        this.letters = 0;
        this.packages = 0;
        this.dispatched = false;
    }

    /**
     * Mailcoach
     * Second constructor for MailCoach
     * @param route
     * @param capacity
     * @return null, sets route and capcity to its proper variables
     */
    public MailCoach(String route, int capacity) 
    {
        // put your code here
        this.route = route;
        this.capacity = capacity;
    }
    
    //getters
    public String getRoute() { return this.route; }
    public int getCapacity() { return this.capacity; }
    public int getLetters() { return this.letters; }
    public int getPackages() { return this.packages; }
    public boolean getDispatched() { return this.dispatched; }
    
    //setters
    public int setLetters(int lettersToLoad) { 
        int totalLetters = this.capacity - lettersToLoad; 
        if (totalLetters < 0) {
            this.letters = totalLetters + lettersToLoad;
            this.capacity = 0;
            if (this.capacity == 0) {
                this.dispatched = true;
            }
            return totalLetters;
        }
        else {
            this.letters += lettersToLoad;
            this.capacity -= lettersToLoad;
            if (this.capacity == 0) {
                this.dispatched = true;
            }
            return lettersToLoad;
        }
    }
    public int setPackages(int packagesToLoad) { 
        int timesTwentyConversion = packagesToLoad * 20; //multiplying by 20 because because the package capacity is 20
        int totalPackages = this.capacity - timesTwentyConversion;
        int returningBack = (int)Math.ceil((double)totalPackages / (double) 20); //converting back
        if (totalPackages < 0) {    
            this.packages =(int)Math.ceil((double)(totalPackages + timesTwentyConversion) / (double)20);
            this.capacity = 0;
            if (this.capacity == 0) {
                this.dispatched = true;
            }
            return returningBack;
        }
        else {
            this.packages += packagesToLoad;
            this.capacity -= timesTwentyConversion;
            if (this.capacity == 0) {
                this.dispatched = true;
            }
            return packagesToLoad;
        }
        }
}
