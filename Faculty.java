import java.util.*;

/**
 * Write a description of class Faculty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Faculty extends People
{
     public static int GetFacultyOfficeNumber(){
           // Get the input from the user.
           Scanner userInput = new Scanner(System.in);
           int facultyOfficeNumber;
          
           do {
           // Give instructions to the user.
           System.out.println("\n");
           System.out.println("Enter the Staff's Office Number eg. 101");
           // Run a while loop to validate user input.
           while (!userInput.hasNextInt()){
               // Display error and reiterate instructions.
               System.out.println("Error: that is not a number! \n");
               // Repeat loop
               userInput.next();
            }
            // Store the validated input.
            facultyOfficeNumber = userInput.nextInt();
            System.out.println("\n");
        } while (facultyOfficeNumber <= 0);  
            // Be able to return the validated input for future use. Since it passed number validation.
            return facultyOfficeNumber;
       }
       
   public static boolean GetTenureStatus(){
           // Make field available for input from the user.
           String userInput;
           // The boolean for the tenure status
           boolean tenureStatus;
           // New scanner object
           Scanner in = new Scanner(System.in);
           // Give instructions to the user.
           System.out.println("If the faculty tenured? y or n");
           // Run a while loop to validate user input.
           while (true) {
               userInput = in.nextLine().trim().toLowerCase();
               if (userInput.equals("y")) {
                   tenureStatus = true;
                   break;
                } else if (userInput.equals("n")) {
                    tenureStatus = false;
                    break;
                } else {
                    System.out.println("Error: Please enter either y or n as your response \n");
                }
            } 
            // Be able to return the validated input for future use.
            return tenureStatus;
       }
}
