// Import scanner for user input
import java.util.Scanner;

/**
 * This class will collect the additional information if the user selects
 * 'student' as their person type.
 * 
 * @author Ken LaCroix 
 * @version 05/24/2015
 */
public class Student extends People
{
    /**
     * This function will determine what the type of student is. The user must select
     * from the four choices or the loop will repeat.
     * 
     * @return classStatus
     */
    public static String GetStudentStatus(){
           // A Boolean to be used in a loop to make sure there is valid input
           Boolean keepLoopingStudentStatus = true;
           String classStatus = "";
           while(keepLoopingStudentStatus==true){
               // Give instructions to the user.
               System.out.println("\n");
               System.out.println("Enter the status: freshman, sophomore, junior, senior");
               // Get the input from the user.
               Scanner userInput = new Scanner(System.in);
               // Store the validated input 
               classStatus = userInput.next();
               // Be able to return the validated input for future use.
               
               switch(classStatus){
                   case "freshman":
                        classStatus = "freshman";
                        keepLoopingStudentStatus=false;
                        break;
                   case "sophomore":
                        classStatus = "sophomore";
                        keepLoopingStudentStatus=false;
                        break;
                   case "junior":
                        classStatus = "junior";
                        keepLoopingStudentStatus=false;
                        break;
                   case "senior":
                        classStatus = "senior";
                        keepLoopingStudentStatus=false;
                        break;
                   default:
                        MiscFunctions.clearScreen();
                        keepLoopingStudentStatus=true;
                }
            }
       return classStatus;
    }
}
