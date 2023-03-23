import java.util.Scanner;
/**
 * The Project 3 class consists of Main()the 4 primary methods we created that allow this program to run and compile. 
 * In the methods we primarily use 3 different objects that represent each of the 3 cities that mail can go to, and 
 * those objects get information from the MailCoach class . 
 *
 * author @Logan Segal
 * version @10/9/22
 */
public class Project3 {
    //DATE AND TIME YOU FIRST START WORKING ON THIS ASSIGNMENT (date AND time): <--------------------
    //ANSWER:     9/29/22 @8:30pm           <--------------------
    
    //DO NOT ALTER THE MAIN METHOD
    public static void main( String[] args ) {
        //use this method to test your entity class, comment it out when you've passed all tests
        //testEntityClass();
        
        MailCoach stolat = new MailCoach( "Stolat", 1200 );
        MailCoach borogravia = new MailCoach( "Borogravia", 750 );
        MailCoach quirm = new MailCoach( "Quirm", 366 );
        
        System.out.println( "Welcome to the Ankh-Morpork Post Office new routes mail coach dispatch!" );
        //print the initial menu
        printMenu( stolat, borogravia, quirm );
        //call go and load up as much mail as is possible
        go( stolat, borogravia, quirm );
        //print report when all mail coaches have been dispatched
        printReport( stolat, borogravia, quirm );
    } //DO NOT ALTER THE MAIN METHOD
    
    //DO NOT ALTER THE testEntityClass METHOD
    public static void testEntityClass() {
        MailCoach test1 = new MailCoach();
        
        assert test1.getRoute().equals( "" ) && 
                test1.getCapacity() + test1.getLetters() + test1.getPackages() == 0  && 
                !test1.getDispatched() : "standard constructor fail";
        
        MailCoach test2 = new MailCoach( "City", 134 );
        assert test2.getRoute().equals( "City" ) : "second constructor instance variable route not properly set";
        assert test2.getLetters() + test2.getPackages() == 0 : "second constructor instance variables letters and/or packages not properly set";
        assert test2.getCapacity() == 134 : "second constructor instance variables capacity not properly set";
        assert !test2.getDispatched() : "second constructor instance variables dispatched not properly set";
        
        assert test2.setLetters( 20 ) == 0 : "setLetters not correct return value";
        assert test2.getLetters() == 20 : "setLetters not correct updating letters loaded";
        assert test2.getCapacity() == 114 : "setLetters not correct updating capacity";
        assert test2.setLetters( 150 ) == 36 : "setLetters not correct return value";
        assert test2.getLetters() == 134 : "setLetters not correct updating letters loaded";
        assert test2.getCapacity() == 0 : "setLetters not correct updating capacity";
        assert test2.getDispatched() : "setLetters not correct updating dispatch status";
        
        MailCoach test3 = new MailCoach( "City", 134 );
        assert test3.setPackages( 2 ) == 0 : "setPackages not correct return value";
        assert test3.getPackages() == 2 : "setPackages not correct updating letters loaded";
        assert test3.getCapacity() == 94 : "setPackages not correct updating capacity";
        assert test3.setPackages( 10 ) == 6 : "setPackages not correct return value";
        assert test3.getPackages() == 6 : "setPackages not correct updating letters loaded";
        assert test3.getCapacity() == 14 : "setPackages not correct updating capacity";
        assert test3.setLetters( 15 ) == 1 : "setLetters not correct return value";
        assert test3.getCapacity() == 0 : "setPackages not correct updating capacity";
        assert test3.getDispatched() : "setPackages not correct updating dispatch status";
        
        System.out.print( "MailCoach class all tests passed.\n" );        
    } //DO NOT ALTER THE testEntityClass METHOD
    
    /** 
    * go()
    * Asks user for input then uses the scnaner object that to read the input that the user provides
    * @param stolat object created by MailCoach class (primarily used for stolat)
    * @param borogravia object created by MailCoach class (primarily used for borogravia)
    * @param quirm object created by MailCoach class (primarily used for quirm)
    * @return questions that the user answers and then calls the other methods to run 
    */
    public static void go( MailCoach stolat, MailCoach borogravia, MailCoach quirm ) {     
        //IMPLEMENT THIS METHOD
        while (stolat.getCapacity() != 0 || borogravia.getCapacity() != 0 || quirm.getCapacity() != 0) { //while the capacity does not equal 0
            Scanner keyboard = new Scanner( System.in ); //scanner object creation
            System.out.printf("%nWhat is the destination? "); // asking the user where they want to send to
            String destinationOfMail; 
            destinationOfMail = keyboard.next(); //destination scanner
            destinationOfMail = destinationOfMail.trim();
            destinationOfMail = destinationOfMail.toLowerCase();
            switch (destinationOfMail) {
                case "stolat":
                    if (stolat.getDispatched() == true) { 
                        System.out.println("The mail coach to Stolat has already been dispatched. Try again tommorow");
                    }
                    else{
                        System.out.print("What are you shipping to " + stolat.getRoute() + "? "); //asking what is being shipped
                        int amountOfMail; 
                        amountOfMail = keyboard.nextInt(); //amount of mail scanner
                        String typeOfMail;
                        typeOfMail = keyboard.next(); //type of mail scanner
                        loadUp(stolat, typeOfMail, amountOfMail); 
                    }
                    break;
                case "1":
                    if (stolat.getDispatched() == true) {
                        System.out.println("The mail coach to Stolat has already been dispatched. Try again tommorow");
                    }
                    else {
                        System.out.print("What are you shipping to " + stolat.getRoute() + "? ");
                        int amountOfMail;
                        amountOfMail = keyboard.nextInt();
                        String typeOfMail;
                        typeOfMail = keyboard.next();
                        loadUp(stolat, typeOfMail, amountOfMail);
                    }
                    break;
                case "borogravia":
                    if (borogravia.getDispatched() == true) {
                        System.out.println("The mail coach to Bologravia has already been dispatched. Try again tommorow");
                    }
                    else {
                        System.out.print("What are you shipping to " + borogravia.getRoute() + "? ");
                        int amountOfMail;
                        amountOfMail = keyboard.nextInt();
                        String typeOfMail;
                        typeOfMail = keyboard.next();
                        loadUp(borogravia, typeOfMail, amountOfMail);
                    }
                    break;
                case "2":
                    if (borogravia.getDispatched() == true) {
                        System.out.println("The mail coach to Bologravia has already been dispatched. Try again tommorow");
                    }
                    else {
                        System.out.println("What are you shipping to " + borogravia.getRoute() + "? ");
                        int amountOfMail;
                        amountOfMail = keyboard.nextInt();
                        String typeOfMail;
                        typeOfMail = keyboard.next();
                        loadUp(borogravia, typeOfMail, amountOfMail);
                    }
                    break;
                case "quirm":
                    if (quirm.getDispatched() == true) {
                        System.out.println("The mail coach to Quirm has already been dispatched. Try again tommorow");
                    }
                    else {
                        System.out.println("What are you shipping to " + quirm.getRoute() + "? ");
                        int amountOfMail;
                        amountOfMail = keyboard.nextInt();
                        String typeOfMail;
                        typeOfMail = keyboard.next();
                        loadUp(quirm, typeOfMail, amountOfMail);
                    }
                    break;
                case "3":
                    if (quirm.getDispatched() == true) {
                        System.out.println("The mail coach to Quirm has already been dispatched. Try again tommorow");
                    }
                    else {
                        System.out.println("What are you shipping to " + quirm.getRoute() + "? ");
                        int amountOfMail;
                        amountOfMail = keyboard.nextInt();
                        String typeOfMail;
                        typeOfMail = keyboard.next();
                        loadUp(quirm, typeOfMail, amountOfMail);
                    }
                    break;
                default:
                    System.out.println("We don't ship to " + destinationOfMail + ". Back of the line!");
                    break;
            }
         System.out.println();
         printMenu(stolat, borogravia, quirm); //printing menu again 
        }
    }
    
    /** 
    * printMenu()
    * Prints the menu options to users see when they run the program
    * @param stolat object created by MailCoach class (primarily used for stolat)
    * @param borogravia object created by MailCoach class (primarily used for borogravia)
    * @param quirm, object created by MailCoach class (primarily used for quirm)
    * @return null message letting the user know of either how much space is remaining before dispatch or if the for 
    * the destination has been dispatched already   
    */
    public static void printMenu( MailCoach stolat, MailCoach borogravia, MailCoach quirm ) {
        //IMPLEMENT THIS METHOD  
        System.out.printf("Remaining mail coach capacity:");
        if (stolat.getDispatched() == true) {
            System.out.printf("%n%11s dispatched", "Stolat -"); //tells the user the shipment has been dispatched
        }
        else {
            System.out.printf("%n%13s remaining capacity " + stolat.getCapacity(), "1. Stolat:"); //telling user how much room is left before dispatch
        }
        if (borogravia.getDispatched() == true) {
            System.out.printf("%n%15s dispatched", "Borogravia -" ); 
        }
        else {
            System.out.printf("%n%17s remaining capacity " + borogravia.getCapacity(), "2. Borogravia:"); 
        }
        if (quirm.getDispatched() == true) {
            System.out.printf("%n%10s Dispatched","Quirm -");
        }
        else {
            System.out.printf("%n%12s remaining capacity " + quirm.getCapacity(), "3. Quirm:"); 
        }
    }
    
    /** 
    * loadUp()
    * Stores all the different instances/situations that can happen based on the user input
    * @param d object created by MailCoach class
    * @param type the type of mail the user inputs 
    * @param quantity the amount of mail  
    * @return the correct message based upon the users input
    */
    public static void loadUp( MailCoach d, String type, int quantity ) {
        //IMPLEMENT THIS METHOD 
        if (type.equals("letter") || type.equals("letters")){ 
            int inputLetters = d.setLetters(quantity);
            if (inputLetters  < 0) {
                System.out.println(Math.abs(inputLetters) + " out of your " + quantity + " letters couldn't be dispatched today, bring them back tommorrow.");
            }
            else {
            System.out.println("Your " + quantity + " letters have been loaded for delivery.");
            }
        }
        else if (type.equals("package") || type.equals("packages")){
            int inputPackages = d.setPackages(quantity);
            if (inputPackages < 0) {
                System.out.println(Math.abs(inputPackages) + " out of your " + quantity + " packages couldn't be dispatched today, bring them back tommorrow.");
            }
            else {
            System.out.println("Your " + quantity + " packages have been loaded for delivery.");
            }
        }

        else if (!type.equals("letter") && !type.equals("letters") && !type.equals("package") && !type.equals("packages")) {
            System.out.println( "We don't ship " + type + ". Back of the Line!" ); //if type inputed is not one of the 4 options
        }
        else if (quantity <= 0){
            System.out.println( "This is not a valid amount. Back of the Line!"); //if amount is 0 or below
        }
    }
    
    /** 
    * printReport()
    * Print final report once locations have been dispatched
    * @param stolat object created by MailCoach class (primarily used for stolat)
    * @param borogravia object created by MailCoach class (primarily used for borogravia)
    * @param quirm object created by MailCoach class (primarily used for quirm)
    * @return summary of how many letters and packaages have been sent to each location
    */
    public static void printReport( MailCoach stolat, MailCoach borogravia, MailCoach quirm ) {
        //IMPLEMENT THIS METHOD 
        System.out.printf("%nAll mail coaches have been dispatched for the day");
        System.out.printf("%nDispatched: mail coach to %-12s- %3s letters, %3s packages","Stolat:", stolat.getLetters(), stolat.getPackages());
        System.out.printf("%nDispatched: mail coach to %-12s- %3s letters, %3s packages","Borogravia:", borogravia.getLetters(), borogravia.getPackages());
        System.out.printf("%nDispatched: mail coach to %-12s- %3s letters, %3s packages %n","Quirm:", quirm.getLetters(), quirm.getPackages());
        System.out.printf("%nThank you for using Ankh-Morpork Post Office. Goodbye!");
    }
}
