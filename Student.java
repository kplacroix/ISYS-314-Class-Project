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
           // A Boolean to be used in a loop to make sure there is valid input
           Boolean keepLoopingStudentStatus = true;
           String classStatus = "";
           while(keepLoopingStudentStatus==true){
               // Give instructions to the user.
               System.out.println("\n");
               System.out.println("Enter the status: freshman, sophmore, junior, senior");
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
                   case "sophmore":
                        classStatus = "sophmore";
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
               //keepLoopingStudentStatus=true;
            }
       return classStatus;
    }
}
