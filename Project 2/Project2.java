/**
 * The Poject 2 class holds our Main() and the 4 methods we created in order for our program to compile. 
 * Here the program uses the information we created in the Delivery Class and runs based of the inputs 
 * provided. 
 *
 * @author Logan Segal
 * @version 9/27/22
 */
public class Project2 {
    //DATE AND TIME YOU FIRST START WORKING ON THIS ASSIGNMENT (date AND time): <--------------------
    //ANSWER:  September 19, 2022 at 5:30pm
        
    //DO NOT CHANGE THIS METHOD EXCEPT TO COMMENT TEST CASES IN AND OUT
    public static void main( String[] args ) {
        //ONLY COMMENT IN ONE TEST CASE AT A TIME
        //Test case 1:
        //args = new String[]{ "Unseen University library", "book chains", "16", "141", "no", "City Watch", "uniforms", "17", "95", "no", "Seamstresses Guild", "ribbon", "1100", "3", "no" };
        //Test case 2: 
        args = new String[]{ "Lady Ramkin's Dragon Sanctuary", "almost cheese", "400", "5", "yes", "", "", "", "", "", "Assassin's Guild", "black capes", "21", "19", "no" };
        //Test case 3: 
        //args = new String[]{ "Unseen University", "pointy hats", "14", "66", "no", "Post Office", "stamp books", "200", "1", "no", "", "", "", "", "" };
        //Test case 4: 
        //args = new String[]{ "CMOT Dibbler", "frozen rats", "80", "8", "no", "", "", "", "", "", "Patrician's Office", "dissident", "1", "2560", "yes" };
        
        Delivery fromAnkhMorpork, fromPseudopolis, fromUeberwald;
        
    
        //check if there is a shipment from Ankh-Morpork for delivery
        if ( checkForValidDelivery( args[ 0 ] ) ) //if there is, create a Delivery object with the data from the test case
            fromAnkhMorpork = new Delivery( args[ 0 ], "Ankh-Morpork", args[ 1 ], Integer.parseInt( args[ 2 ] ), Integer.parseInt( args[ 3 ] ), args[ 4 ] );
        else //if there isn't, create a dummy Delivery object
            fromAnkhMorpork = new Delivery();
        //check if there is a shipment from Pseudopolis for delivery
        if ( checkForValidDelivery( args[ 5 ] ) ) //if there is, create a Delivery object with the data from the test case   
            fromPseudopolis = new Delivery( args[ 5 ], "Pseudopolis", args[ 6 ], Integer.parseInt( args[ 7 ] ), Integer.parseInt( args[ 8 ] ), args[ 9 ] );
        else //if there isn't, create a dummy Delivery object
            fromPseudopolis = new Delivery();
        //check if there is a shipment from Ueberwald for delivery
        if ( checkForValidDelivery( args[ 10 ] ) ) //if there is, create a Delivery object with the data from the test case
            fromUeberwald   = new Delivery( args[ 10 ], "Ueberwald", args[ 11 ], Integer.parseInt( args[ 12 ] ), Integer.parseInt( args[ 13 ] ), args[ 14 ] );
        else //if there isn't, create a dummy Delivery object
            fromUeberwald   = new Delivery();
        
        //print out delivery order
        if ( !fromAnkhMorpork.getHazardous() )  printDeliveryOrder( fromAnkhMorpork );          //delivery from Ankh-Morpork today
        else                                    printHazardousDeliveryOrder( fromAnkhMorpork ); //hazardous delivery from Ankh-Morpork today
        if ( !fromPseudopolis.getHazardous() )  printDeliveryOrder( fromPseudopolis );          //delivery from Pseudopolis today
        else                                    printHazardousDeliveryOrder( fromPseudopolis ); //hazardous delivery from Pseudopolis today
        if ( !fromUeberwald.getHazardous() )    printDeliveryOrder( fromUeberwald );            //delivery from Ueerwald today
        else                                    printHazardousDeliveryOrder( fromUeberwald );   //hazardous delivery from Ueerwald today        
        
        //print the total money to collect today from all 3 deliveries
        System.out.printf( "Today's total $%,.2f%n%n", feeTotal( fromAnkhMorpork, fromPseudopolis, fromUeberwald ) );
    }
    
    /** 
    * checkForValidDelivery()
    * Prints special message for hazarous deliveries
    * @param receiver 
    * @return true or false depending on the input
    */
    public static boolean checkForValidDelivery(String receiver) {  //creating the checkForValidDelivery method
        if (receiver.equals("")){ 
            return false;
        }
        else {
            return true;
        }
    }
    
    /** 
    * printDeliveryOrder()
    * Prints normal message for deliveries
    * @param deliv_1 an object so we can retrieve values from Delivery class
    * @return print statement for normal deliveries
    */
    public static void printDeliveryOrder(Delivery deliv_1) {  //creating the printDeliveryOrder method
        String receiver = deliv_1.getReceiver(); //gets the receiver from the Delivery class
        String origin = deliv_1.getOrigin(); //gets the origin from the Delivery class
        String item = deliv_1.getItem(); //gets the item from the Delivery class
        double fee = deliv_1.getFee(); //gets the fee from the Delivery class
        if (!receiver.equals("")){
            System.out.printf("Delivery to %s from %s today: %s (collect $%1.2f on delivery)%n" , receiver, origin, item, fee);
        }
    }
    
    /** 
    * printHazardousDeliveryOrder()
    * Prints special message for hazarous deliveries
    * @param deliv_1 an object so we can retrieve values from Delivery class
    * @return print statement for hazardous deliveries
    */
    public static void printHazardousDeliveryOrder(Delivery deliv_1) { //creating the printHazardousDelivery method
        String receiver = deliv_1.getReceiver();
        String origin = deliv_1.getOrigin();
        String item = deliv_1.getItem();
        double fee = deliv_1.getFee();
        if(!receiver.equals("")){
            System.out.printf("Delivery (-HAZARD-) to %s from %s today: %s (collect $%1.2f on delivery)%n" , receiver, origin, item, fee);
        }
    }
    
    /** 
    * feeTotal()
    * Finds overall total of the three fees 
    * @param feeOne first number to add
    * @param feeTwo second number to add
    * @param feeThree third number to add
    * @return the totalFee of all the added fees
    */
    public static double feeTotal(Delivery deliv_1, Delivery deliv_2, Delivery deliv_3) { //creating the feeTotal method
        double feeOne = deliv_1.getFee(); 
        double feeTwo = deliv_2.getFee();  
        double feeThree = deliv_3.getFee();
        double totalFee = feeOne + feeTwo + feeThree; //adding up all the fees to get the totals
        return totalFee;
    }
}
