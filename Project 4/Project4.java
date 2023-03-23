import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * The Project 4 class consists of Main() the 2 main methods that we created. We first read the file and gather input that
 * we store into our Train[] array. Then we use the information we stored in the arrray to write a report summary 
 * giving the user information regarding the trains running in the next 48 hours. 
 *
 * author @Logan Segal
 * version @10/21/22
 */
public class Project4 {
    //WHEN DID YOU FIRST START WORKING ON THIS ASSIGNMENT (date and time): <---------------
    //ANSWER: 10/12/22 @2:30pm

    //DO NOT ALTER THE MAIN METHOD
    public static void main( String[] args ) {
        Train[] train = readFile( "departures.txt" );
        
        PrintWriter outStream = null;
        try { outStream = new PrintWriter( "arrivals.txt" ); }
        catch ( FileNotFoundException fnf ) { System.exit( -2 ); }
        
        //each trip will arive by the end of next day
        outStream.printf( "%d trains arriving today and tomorrow with total cargo %.2f lbs%n", train.length, Train.getWeightOfAllCargo() );
        writeReport(    0,  759, true, train, outStream );
        writeReport(  800, 1559, true, train, outStream );
        writeReport( 1600, 2359, true, train, outStream );
        
        writeReport(    0,  759, false, train, outStream );
        writeReport(  800, 1559, false, train, outStream );
        writeReport( 1600, 2359, false, train, outStream );
        
        outStream.close();
    }//DO NOT ALTER THE MAIN METHOD
    
    /** 
    * readFile()
    * reads the given files so we can gather input for our report 
    * @param inputFileName the name of the input file to read from 
    * @return Train[] the array containing all the information that was contained in the document 
    */
    public static Train[] readFile( String inputFileName ) {
        //IMPLEMENT THIS METHOD
        Scanner in = null;
        
        //attempting to open the file
        try { 
            in = new Scanner(new File(inputFileName));
        }
        catch (FileNotFoundException e){
            System.out.println("The file you are trying to open cannot be found");
        }
        
        int numOfTrains = in.nextInt(); //reading the amount of trains that are included (4)
        Train[] train = new Train[numOfTrains]; //creating the array
        
        //loop going through the amount of trains and incrementing af
            for(int i = 0; i < numOfTrains; i++){
                String origin = in.next(); //reading the orgin the string (Klatch)
            
                int departureTime = in.nextInt();  //reading through the next number (1915)
                int numOfStops = in.nextInt();
                int durationTime = in.nextInt();
                int typesOfCargo = in.nextInt();
                Train thomas = new Train(origin, departureTime, numOfStops, durationTime); //object to store the values
                //loop going through how many items of cargo the train has
                for (int j = 0; j < typesOfCargo; j++) {
                    int numberOfItems = in.nextInt();
                    double theWeightOfItem = in.nextDouble();
                    String whatIsTheCargo = in.nextLine().trim();
                    thomas.loadCargo(whatIsTheCargo, numberOfItems, theWeightOfItem);
                }
                train[i] = thomas; //appending our object to the array
        }
        
        in.close();
        
        return train;
    }
        
    /** 
    * writeReport()
    * fill out
    * @param start object that is used for departure time
    * @param end object that is used for arrival time
    * @param today object that helps us figure out if the train is coming today
    * @param t object for the Train[] array
    * @param out helps us use the PrintWriter method the print on the file.
    * @return the full report of all the train action that has happened
    */
    public static void writeReport( int start, int end, boolean today, Train[] t, PrintWriter out ) {
        //IMPLEMENT THIS METHOD
        int count= 0;
        String whateverDay = ""; 
        int crewMembers = 1;  //1 because we will always have at least 1 member
         
        if (today == true) {
            whateverDay = "today";
        }
        else if (today == false) {
            whateverDay = "tomorrow";
        }
        
        out.printf("%nArriving %s %04d-%04d%n",whateverDay, start, end); //opening message 
        
        //loop that iterates through through the array
        for (int i = 0; i < t.length ; i++ ){
            if ((t[i].getArrivalTime() >= start) && (t[i].getArrivalTime() <= end) && (today == t[i].getSameDayArrival())) {
                out.printf("%3s %04d: The %04d train from %s%n", "",t[i].getArrivalTime(), t[i].getDepartureTime(), t[i].getOrigin());
                out.printf("%9s %.2f lbs of %s%n", "", t[i].getWeightOfTrainCargo(), t[i].getCargo());
                count++;
                if (t[i].getWeightOfTrainCargo() <= 500 && count >  1 ){
                    out.printf("Unloading crews needed: %d%n", crewMembers);
                }
                else if (t[i].getWeightOfTrainCargo() > 500) {
                    crewMembers = (int) Math.ceil(t[i].getWeightOfTrainCargo()/ 500);
                    out.printf("Unloading crews needed: %d%n", crewMembers);
                }
            }
        }
        
        //if ther if no train this will happen
        if (count == 0) {
            out.println("No trains.");
        } 
    }
}
