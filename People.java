import java.util.*;

/**
 * This program will collect data about a person and then make decisions based 
 * upon the status of the person. Features include: adding, deleting, 
 * printing (all entries and just students) and retrieving.
 * 
 * @author Ken LaCroix
 * @version 05/23/2015
 */
public class People
{
      // Have these fields be available on a global level.
      
      // Init to zero length for later error checking. 
       private String personsFirstName = "";
       private String personsLastName = "";
       private String personsEmail = "";
           
      /**
       * Ask the basic information that pertains to all entries.
       */
       public void AddPersons()
       {
           // Clear the terminal window for a blank slate.
           ClearScreen();
           
           // New Scanner object in preparation for accepting user input.
           Scanner userInput = new Scanner(System.in); 
           System.out.println("\n");
           System.out.println("Enter the details of person you would like to add: \n");
            // Get and store the basic information about the person.
           System.out.println("What is the first name?");
           // Capture the input and store it
           personsFirstName = userInput.next();
           System.out.println("\n");
           System.out.println("What is the last name?");
           personsLastName = userInput.next();
           System.out.println("\n");
           System.out.println("What is the Email?");
           personsEmail = userInput.next();
           System.out.println("\n");
       
           // Call the method for logic and adding information to the list.
           Logic();
    }
        
        /**
         * Use (probably unnecessarily complicated?) nested if-elseif statements to determine what additional
         * information to collect based on the status of the person. I also use method calls to 
         * get additional information from the other classes. A bunch of if-else-esleif statements 
         * might be clunky but it should help reduce duplications and other errors.
         */
        public void Logic()
       {
           // Running this method before running the AddPersons method will cause a corrupt list! There are no checks made.
            // Make field available for input from the user.
           String userInputTwo;
           // New scanner object in preparation of accepting user input
           Scanner in = new Scanner(System.in);
          
           // Check to if the personsFirstName field is empty because that means the user is trying to run this function first, which would be pointless. 
           if(personsFirstName.length() == 0) {
               ClearScreen();
               System.out.println("Error: This function can not work by itself. Run 'AddPersons'. ");
            } else {
                System.out.println("Is the person a Student? y or n");
                userInputTwo = in.nextLine().trim().toLowerCase();
                System.out.println("\n");
                  if (userInputTwo.equals("y")) {
                      String studentStatus = Student.GetStudentStatus();
                      System.out.println("\n" + "Record: " + personsFirstName 
                      + " " +personsLastName + ", " + personsEmail 
                      + ", " + "Class Status: " + studentStatus 
                      + ", has been added. \n"); 
                      System.out.println("Add another person? y or n \n");
                      userInputTwo = in.nextLine().trim().toLowerCase();
                    
                   
                     if (userInputTwo.equals("y")) {
                               personsFirstName = "";
                               personsLastName = "";
                               personsEmail = "";
                               AddPersons();
                           } else if (userInputTwo.equals("n"))
                           ClearScreen(); 
                           System.out.println("\n"); 
                           System.out.println(" Nothing else to do right now. You can use " +
                           "other functions to do what you need! 2");
                           // code to add to list
                     } else if (userInputTwo.equals("n")){
                    System.out.println("Is a Staff? y or n \n");
                    userInputTwo = in.nextLine().trim().toLowerCase();
                    System.out.println("\n");
                    if (userInputTwo.equals("y")) {
                        int staffOfficeNumber = Staff.GetStaffOfficeNumber();
                        String staffTitle = Staff.GetStaffTitle();
                        
                        System.out.println("\n" + "Record: " + personsFirstName 
                           + " " +personsLastName + ", " + personsEmail 
                           + ", " + "Office Number: " + staffOfficeNumber + ", " 
                           + "Title: " +  staffTitle + ", has been added. \n"); 
                           
                           System.out.println("Add another person? y or n \n");
                           userInputTwo = in.nextLine().trim().toLowerCase();
                           if (userInputTwo.equals("y")) {
                               personsFirstName = "";
                               personsLastName = "";
                               personsEmail = "";
                               AddPersons();
                           } else if (userInputTwo.equals("n"))
                           ClearScreen(); 
                           System.out.println("\n"); 
                           System.out.println(" Nothing else to do right now. You can use " +
                           "other functions to do what you need! 2");
                           // code to add to list
                        
                    } else if (userInputTwo.equals("n")) {
                           System.out.println("Is a Faculty? y or n \n");
                           userInputTwo = in.nextLine().trim().toLowerCase();
                           System.out.println("\n");
                           if (userInputTwo.equals("y")) {
                           // Create some fields for later use.
                           int facultyOfficeNumber = Faculty.GetFacultyOfficeNumber();
                           boolean tenure = Faculty.GetTenureStatus();

                           // Print the information collected.
                           System.out.println("\n" + "Record: " + personsFirstName 
                           + " " +personsLastName + ", " + personsEmail 
                           + ", " + "Office Number: " + facultyOfficeNumber + ", " 
                           + "Tenure: " +  tenure + ", has been added. \n"); 
                           
                           System.out.println("Add another person? y or n \n");
                           userInputTwo = in.nextLine().trim().toLowerCase();
                           if (userInputTwo.equals("y")) {
                               personsFirstName = "";
                               personsLastName = "";
                               personsEmail = "";
                               AddPersons();
                           } else if (userInputTwo.equals("n"))
                           ClearScreen();
                           System.out.println("\n"); 
                           System.out.println("Nothing else to do right now. You can use " +
                           " other functions to do what you need! 3");
                           // code to add to list
                        }
     
                    } else if (userInputTwo.equals("n")) {
                            System.out.println("You must enter y or n -- Exiting.");
                            AddPersons();
                        } else {
                            ClearScreen();
                            System.out.println("You must enter y or n -- Exiting.");
                        }
           }
        }
    }
    
        /**
         * A very simple way to clear the screen that will work on any system.
         */
        public void ClearScreen()
       {
        for(int clear = 0; clear < 1000; clear++)
           {
               System.out.println("\b") ;
           }
    }
}
        