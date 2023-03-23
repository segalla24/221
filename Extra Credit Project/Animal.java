import java.util.Scanner;
/**
 * This boundary class creates an array of type Farm (Interface) and fills it with objects of types implementing the interface, 
 * then for every element in the array, invokes the overridden interface method whereToLive and the overridden toString methods 
 * for every derived type
 *
 * @author Logan Segal
 * @version 12/3/22
 */
public class Animal {
    //DATE AND TIME YOU FIRST START WORKING ON THIS ASSIGNMENT (date AND time): <--------------------
    //ANSWER:      <-------------------- November 27, 2022 @ 1pm
    
    public static void main( String[] args ) {
        Farm [] animal = new Farm[9]; //creating the array of size 9 
        animal[0] = new Chicken("Golden Comet", 7, 3.91, true); //adding a chicken object
        animal[1] = new Chicken("Orpington", 5,3.62, true); //adding a chicken object 
        animal[2] = new Turkey("Bourbon Reds", 2,14.80, false); //adding a turkey object
        animal[3] = new Cow("Holstein", 2, 1800, true ); //adding a cow object
        animal[4] = new Horse("Clysdale", 2, 5000, false); //adding a horse object
        animal[5] = new Horse("American Cream", 1, 12000, false); //adding a horse object
        animal[6] = new Horse("Percheron", 2, 3500, false); //adding a horse object
        animal[7] = new Pig("Teacup"); //adding a pig object
        animal[8] = new Goat("Nigerian Dwarf"); //adding a goat object
    
        System.out.println("Welcome To My Farm!"); //intro message 
        //loop to print the objects from the array ~ this is where the toString method will be used
        for (int i = 0; i < animal.length; i++) {
            System.out.printf("lives in a %-7s: ", animal[i].whereToLive());
            System.out.println(animal[i]);
            System.out.printf("%17s%n", "-".repeat(13));
        }
        Scanner keyboard = new Scanner( System.in ); //creating a scanner
        System.out.printf("%n%nShould we add more animals to our farm?%n");
        String additionalAnimalResponse;
        additionalAnimalResponse = keyboard.next(); //reading and storing the input from the user
        additionalAnimalResponse = additionalAnimalResponse.trim(); //triming any extra whitespace
        additionalAnimalResponse = additionalAnimalResponse.toLowerCase(); //putting the response in all lowers
        String species;
        switch(additionalAnimalResponse){
            case "yes": //if user types yes
            System.out.println("What animal should we add to our farm?");
            species = keyboard.next(); //reading and storing the input from the user
            System.out.println("Ok thank you! I will consider adding " + species + "s to my farm!");
            break;
            case "no": //if user tpyes no
            System.out.println("I'm glad you like my farm the way it is!"); 
            break;
            default: //opetion if user types something other than yes or no 
            System.out.println("I'm sorry, your response was useless. I guess you don't want to improve my farm :(");
            break;
        }
        System.out.printf("%n%nCome visit my farm again soon!"); //closing message 
    }
    }

