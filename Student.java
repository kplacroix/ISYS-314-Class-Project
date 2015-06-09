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
           // Give instructions to the user.
           System.out.println("Enter the status: Freshman, Sophmore, Junior, Senior \n");
           // Get the input from the user.
           Scanner userInput = new Scanner(System.in);
            // Store the validated input 
            String classStatus = userInput.next();
            // Be able to return the validated input for future use.
            return classStatus;
       }
}
