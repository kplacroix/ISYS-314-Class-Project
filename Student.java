import java.util.*;

/**
 * Write a description of class Student here.
 * 
 * @author Ken LaCroix 
 * @version 05/24/2015
 */
public class Student extends People
{
    public static String GetStudentStatus(){
           // Get the input from the user.
           Scanner userInput = new Scanner(System.in);

           // Give instructions to the user.
           System.out.println("Enter you status: F = Freshman, s = Sophmore, J = Junior, S = Senior \n");
           // Run a while loop to validate user input.
           while (!userInput.hasNext("[FsJS]")){
               // Display error and reiterate instructions.
               System.out.println("You must enter either F, s, J, or S");
               // Repeat loop
               userInput.next();
           }
        
            // Store the validated input 
            String classStatus = userInput.next();
            // Be able to return the validated input for future use.
            return classStatus;
       }
}
