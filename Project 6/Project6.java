import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
/**
 * The project 6 class uses the information we created in the other classes in order to set us up for the rest of the project.  We first start 
 * off with reading the data and storing the data we collected into ArrayLists that is unsorted. We then move on to sorting the data, and then 
 * finally create a report using the newly sorted information (by locations and vehicle type) we have in our ArrayLists. Throughoutthe process 
 * we are also keeping up with the profits/losses of the revnunue and adding it all together so we know how much the post office made in profits. 
 * 
 * @author Logan Segal
 * @version 11/19/22
 */public class Project6 {
    //DATE AND TIME YOU FIRST START WORKING ON THIS ASSIGNMENT (date AND time): <--------------------
    //ANSWER:      <-------------------- November 9, 2022 @ 11:15am
    
    //DO NOT ALTER THE MAIN METHOD
    public static void main( String[] args ) throws FileNotFoundException {
        //input stream
        Scanner in = new Scanner( new File( "info1.txt" ) );
        
        //read the input file and populate the array list
        ArrayList< Vehicle > allUnsorted = readData( in );
        
        //output for half credit
        printVehicles( allUnsorted );
        
        //sort the array list by destination 
        //1. Lancre, 2. Ueberwald, 3. Borogravia, 4. Klatch
        //and for each destination 1. boats, 2. trains, 3. coaches
        ArrayList< Vehicle > allSorted = sortVehicles( allUnsorted );
        
        //output for half credit
        printVehicles( allSorted );
        
        //print revenue
        System.out.printf( "Today's Ankh-Morpork Post Office Profit:  $%,10.2f%n%n", Vehicle.getRevenue() );
    } //DO NOT ALTER THE MAIN METHOD
    
    /**
     * readData - reads the input file data and adds it into an ArrayList of Vehicle objects
     * @param Scanner in - the name of the scanner used to read through the file
     * @return ArrayList< Vehicle > - the ArrayList that is populated with vehicle objects
     */
    public static ArrayList< Vehicle > readData( Scanner in ) {
        //FINISH AND DOCUMENT THIS METHOD
        in = null;
        
        //attempting to open the file
        try { 
            in = new Scanner(new File("info1.txt"));
        }
        catch (FileNotFoundException e){
            System.out.println("The file you are trying to open cannot be found");
        }
        
        ArrayList< Vehicle > unsorted = new ArrayList<>(); //creating the unsorted array list 
        
        while(in.hasNext()){
            String destination = in.next(); //reading the destination
            String vehicle = in.next(); //reading the vehicle type
            //swtitch for the differnt types of vehicle 
            switch (vehicle) {
               case "boat": //if the vehicle is a boat
                   double boatCargoWeight = in.nextDouble(); //reading the weight of the boat cargo
                   double boatIncome = in.nextDouble();  //reading the income of the boat 
                   Boat titanic = new Boat (destination, boatCargoWeight, boatIncome); //creating a boat object
                   titanic.addToTotalProfit();  //adding the boat profit to the overall profit
                   unsorted.add(titanic);       //appending to the ArrayList 
                   break; //breaking the code once that is complete so it can move on to the next 
               case "train": //if the vehicle is a train 
                   int trainCargoCars = in.nextInt(); //reading the amoung of train cars 
                   double trainIncome = in.nextDouble(); //reading the income of the train
                   Train thomas = new Train (destination, trainCargoCars, trainIncome); //creating a train object
                   thomas.addToTotalProfit(); //adding the train progit to the overall
                   unsorted.add(thomas); //appending our train object to the array list
                   break; //breaking the code once that is complete so it can move on to the next 
               case "coach": //if the vehicle is a coach
                   double coachCargoWeight = in.nextDouble(); //reading the weight of the coach cargo
                   double coachIncome = in.nextDouble(); //reading the income of the coach 
                   Coach fedEx = new Coach (destination, coachCargoWeight, coachIncome); //creating a coach object  
                   fedEx.addToTotalProfit(); //adding the coach profit to overall
                   unsorted.add(fedEx); //apending to the array list
                   break; //breaking the code once that is complete so it can move on to the next 
            }
        }
        in.close();
        return unsorted;
    }
    
    /**
     * sortVehicles -  sorts the data by location then sorts by each vehicles then adds it to the sorted ArrayList
     * @param ArrayList< Vehicle > unsorted - the Vehicle ArrayList
     * @return ArrayList< Vehicle > sorted - the newly sorted ArrayList
     */
    public static ArrayList< Vehicle > sortVehicles( ArrayList< Vehicle > unsorted ) {
        //FINISH AND DOCUMENT THIS METHOD
        ArrayList <Vehicle> lancre = new ArrayList<>(); //ArrayList for Lancre objects
        ArrayList <Vehicle> borogravia = new ArrayList<>(); //ArrayList for Borogravia objects
        ArrayList <Vehicle> ueberwald = new ArrayList<>(); //ArrayList for Ueberwald objects
        ArrayList <Vehicle> klatch = new ArrayList<>(); //ArrayList for Klatch objects
        ArrayList< Vehicle > sorted = new ArrayList<>(); //ArrayList for sorted objects 
        
        //sorting by destination 
        for (int i = 0; i < unsorted.size(); i++) {
            if(unsorted.get(i).getDestination().equals("Lancre")) {
                lancre.add(unsorted.get(i));    //lancre
            }
            if(unsorted.get(i).getDestination().equals("Borogravia")) {
                borogravia.add(unsorted.get(i));    //borograiva
            }
            if(unsorted.get(i).getDestination().equals("Ueberwald")) {
                ueberwald.add(unsorted.get(i));  //ueberwald
            }
            if(unsorted.get(i).getDestination().equals("Klatch")) {
                klatch.add(unsorted.get(i));    //klatch
            }
        }
        
        //Lancre
        ArrayList <Vehicle> trainsToLancre = new ArrayList<>(); //creating an ArrayList for Lancre trains
        ArrayList <Vehicle> boatsToLancre = new ArrayList<>();  //creating an ArrayList for Lancre boats
        ArrayList <Vehicle> coachesToLancre = new ArrayList<>(); //creating an ArrayList for Lancre coaches
        for(int l = 0; l < lancre.size(); l++) {
            if(lancre.get(l) instanceof Boat) {
                boatsToLancre.add(lancre.get(l));  //adding the Lancre boats to the designated ArrayList
            }else if (unsorted.get(l) instanceof Train) {
                trainsToLancre.add(lancre.get(l));  //adding the Lancre trains to the designated ArrayList
            }
            else{
                coachesToLancre.add(lancre.get(l));  //adding the Lancre coaches to the designated ArrayList
            }
        }
        sorted.addAll(boatsToLancre);  //adding all Lancre boats to the sorted ArrayList
        sorted.addAll(trainsToLancre);  //adding all Lancre trains to the sorted ArrayList
        sorted.addAll(coachesToLancre);  //adding all Lancre coaches to the sorted ArrayList
        
        //Ueberwald
        ArrayList <Vehicle> trainsToUeberwald = new ArrayList<>();  //creating an ArrayList for Ueberwlad trains
        ArrayList <Vehicle> boatsToUeberwald = new ArrayList<>();  //creating an ArrayList for Ueberwald boats
        ArrayList <Vehicle> coachesToUberwald = new ArrayList<>();  //creating an ArrayList for Ueberwald coaches
        for( int u = 0; u < ueberwald.size(); u++) {
            if (unsorted.get(u) instanceof Boat) {
                boatsToUeberwald.add(ueberwald.get(u));  //adding the Ueberwald boats to the designated ArrayList
            }
            else if(unsorted.get(u) instanceof Train) {
                trainsToUeberwald.add(ueberwald.get(u));  //adding the Ueberwald trains to the designated ArrayList
            }
            else{
                coachesToUberwald.add(ueberwald.get(u));  //adding the Ueberwald coaches to the designated ArrayList
            }
        }
        sorted.addAll(boatsToUeberwald);  //adding all Ueberwald boats to the sorted ArrayList
        sorted.addAll(trainsToUeberwald);  //adding all Ueberwald trains to the sorted ArrayList
        sorted.addAll(coachesToUberwald);  //adding all Ueberwald coaches to the sorted ArrayList
        
        //Borogravia
        ArrayList <Vehicle> trainsToBorogravia = new ArrayList<>();  //creating an ArrayList for Borogravia trains
        ArrayList <Vehicle> boatsToBorogravia = new ArrayList<>();  //creating an ArrayList for Borogravia boats
        ArrayList <Vehicle> coachesToBorogravia = new ArrayList<>();  //creating an ArrayList for Borogravia coaches
        for(int b = 0; b < borogravia.size(); b++) {
            if (unsorted.get(b) instanceof Boat) {
                boatsToBorogravia.add(borogravia.get(b));  //adding the Borogravia boats to the designated ArrayList
            }
            else if(unsorted.get(b) instanceof Train) {
                trainsToBorogravia.add(borogravia.get(b));  //adding the Borogravia trains to the designated ArrayList
            }
            else{
                coachesToBorogravia.add(borogravia.get(b));  //adding the Borogravia coaches to the designated ArrayList
            }
        }
        sorted.addAll(boatsToBorogravia);  //adding all Borogravia boats to the sorted ArrayList
        sorted.addAll(trainsToBorogravia);  //adding all Borogravia trains to the sorted ArrayList
        sorted.addAll(coachesToBorogravia);  //adding all Borogravia coaches to the sorted ArrayList
        
        //Klatch
        ArrayList <Vehicle> trainsToKlatch = new ArrayList<>();  //creating an ArrayList for Klatch trains
        ArrayList <Vehicle> boatsToKlatch = new ArrayList<>();  //creating an ArrayList for Klatch boats
        ArrayList <Vehicle> coachesToKlatch = new ArrayList<>();  //creating an ArrayList for Klatch coaches
        for(int k = 0; k < klatch.size(); k++) {
            if (unsorted.get(k) instanceof Boat) {
                boatsToKlatch.add(klatch.get(k));  //adding the Klatch boats to the designated ArrayList
            }
            else if(unsorted.get(k) instanceof Train) {
                trainsToKlatch.add(klatch.get(k));  //adding the Klatch trains to the designated ArrayList
            }
            else{
                coachesToKlatch.add(klatch.get(k));  //adding the Klatch coaches to the designated ArrayList
            }
        }
        sorted.addAll(boatsToKlatch);  //adding all Klatch boats to the sorted ArrayList
        sorted.addAll(trainsToKlatch);  //adding all Klatch trains to the sorted ArrayList
        sorted.addAll(coachesToKlatch);  //adding all Klatch coaches to the sorted ArrayList
        
        return sorted;
        }

    /** 
    * printVehicles - uses the data from the sorted ArrayList to create a report for the dispatches leaving from Ankh-Morpork
    * @param ArrayList< Vehicle > v - the ArrayList populated with Vehicle objects
    * @return the report of the shipments and the total profit from the shipments
    */
    public static void printVehicles( ArrayList< Vehicle > v ) {
        //FINISH AND DOCUMENT THIS METHOD
        System.out.println("Ankh-Morpork Post Office mail dispatches:"); //prints the opening message

        for ( Vehicle vehicle : v ) {
            if( vehicle instanceof Boat ) {
                if(vehicle.calculateVehicleProfit() < 0) {
                    //message for losses
                    System.out.printf( "%-5s to %10s (%3d %s %10s $%2s%,8.2f %n", "Boat", vehicle.getDestination(),((Boat)vehicle).getCrew(), "crew)", "LOSS:", "",Math.abs(vehicle.calculateVehicleProfit())); 
                }
                else {
                    //message for profits
                    System.out.printf( "%-5s to %10s (%3d %s %10s $%2s%,8.2f %n", "Boat", vehicle.getDestination(),((Boat)vehicle).getCrew(), "crew)", "PROFIT:", "",Math.abs(vehicle.calculateVehicleProfit()));
                }
            }
            else if( vehicle instanceof Train ) {
                if(vehicle.calculateVehicleProfit() < 0) {
                    //message for losses
                    System.out.printf( "%-5s to %10s (%3d %s %10s $%2s%,8.2f %n", "Train", vehicle.getDestination(),((Train)vehicle).getCars(), "cars)","LOSS:", "",Math.abs(vehicle.calculateVehicleProfit()) );
                 }
                else {
                    //message for profits
                    System.out.printf( "%-5s to %10s (%3d %s %10s $%2s%,8.2f %n", "Train", vehicle.getDestination(),((Train)vehicle).getCars(), "cars)", "PROFIT:","",Math.abs(vehicle.calculateVehicleProfit()) ); 
                }
            }
            else {
                if(vehicle.calculateVehicleProfit() < 0) {
                    //message for losses
                    System.out.printf( "%-5s to %10s (%3d %s %8s $%2s%,8.2f %n", "Coach", vehicle.getDestination(), ((Coach)vehicle).getHorses(), "horses)","LOSS:","",Math.abs(vehicle.calculateVehicleProfit()) );
                }
                else {
                    //message for profits
                    System.out.printf( "%-5s to %10s (%3d %s %8s $%2s%,8.2f %n", "Coach", vehicle.getDestination(), ((Coach)vehicle).getHorses(), "horses)","PROFIT:","",Math.abs(vehicle.calculateVehicleProfit()) );
                }
            }
        }
        System.out.println(); //new line
    }
}
