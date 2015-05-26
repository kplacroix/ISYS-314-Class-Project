import java.util.* ;

/**
 * Write a description of class Staff here.
 * 
 * @author Ken LaCroix 
 * @version 05/24/2015
 */
public class Staff extends People
{
   public static int GetStaffOfficeNumber(){
           // Get the input from the user.
           Scanner userInput = new Scanner(System.in);
           int staffOfficeNumber;
          
           do {
           // Give instructions to the user.
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
       
   public static String GetStaffTitle(){
           // Get the input from the user.
           Scanner userInput = new Scanner(System.in);
           
           // Give instructions to the user.
           System.out.println("Enter the Staff's Title, eg. Mr. = M, Ms. = m, Mrs. = R \n");
           // Run a while loop to validate user input.
           while (!userInput.hasNext("[MmR]")){
               // Display error and reiterate instructions.
               System.out.println("Error: You must enter M, m, or R \n");
               // Repeat loop
               userInput.next();
           }
        
            // Store the validated input 
            String staffTitle = userInput.next();
            System.out.println("\n");
            // Be able to return the validated input for future use.
            return staffTitle;
       }
}
