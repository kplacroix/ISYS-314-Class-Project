import java.util.* ;

/**
 * If the user selects "staff" as their person type, this function is called
 * to gather the additional information. It does have some basic error checking
 * to see if the office number entered is a number. Staff title does not have any
 * error checking.
 * 
 * @author Ken LaCroix 
 * @version 05/24/2015
 */
public class Staff extends People
{
    
    /***
     * Get the office number
     * @return staffOfficeNumber
     */
   public static int GetStaffOfficeNumber(){
           // Get the input from the user.
           Scanner userInput = new Scanner(System.in);
           //Initialize as zero now and every-time this code is ran.
           int staffOfficeNumber = 0;
          
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
            staffOfficeNumber = userInput.nextInt();
            System.out.println("\n");
        } while (staffOfficeNumber <= 0);  
            // Be able to return the validated input for future use. Since it passed number validation.
            return staffOfficeNumber;
       }
   
   /**
    * Get the staff title
    * @return staffTitle
    */
   public static String GetStaffTitle(){
           // Initialize as blank now and any time is code is ran.
           String staffTitle = "";
           // Give instructions to the user.
           System.out.println("Enter the Staff's Title: Analysts, IT, Management, etc.");
           // Get the input from the user.
           Scanner userInput = new Scanner(System.in);
           // Store the validated input 
           staffTitle = userInput.next();
           System.out.println("\n");
           // Return the input for future callers.
            return staffTitle;
       }
}
