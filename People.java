// I use various items from this package, so just import them all.
import java.util.*;


/**
 * This program will collect data about a person and then make decisions based 
 * upon the status of the person. Features include: adding, deleting, 
 * printing (all entries and just students) and retrieving. The bulk of the programs
 * lives here.
 * 
 * @author Ken LaCroix
 * @version 05/23/2015
 */
 
// Surpress the warnings I kept on getting, probably because of the way I declared TreeMap, however compiling is still successfull, so surpress.
 @SuppressWarnings("unchecked") public class People
{
    // Have these fields be available on a global level.

    // Init to zero length for later error checking. 
    private String personsFirstName = "";
    private String personsLastName = "";
    private String personsEmail = "";
    // Message telling the user the program is done, used later.
    String done = "You have selected to exit the program. The program is now terminated.";
   
    // Boolean for the menu while loop, keeps going until user quits.
    // Define it globally so we can stop loop in other functions.
    Boolean keepLoopingMenu = true;
    
    // Declare the tree map
    TreeMap directory = new TreeMap();
    
     /**
     * A very basic menu system to help the user execute the programs functions instead of instantizing functions.
     */
    
    private void RunProgram()
    {
        // Clear any miscelaneus text
        MiscFunctions.clearScreen();
        // New scanner object in preparation of accepting user input
        Scanner in = new Scanner(System.in);

        // A switch case nested in a while loop that emulates a menu system.
        while(keepLoopingMenu==true){
            //Clear the screen
            MiscFunctions.clearScreen();
            // Welcome screen and menu choices.
            System.out.println("Welcome to the University directory. \n");
            System.out.println("Choose from one of the following options: 1-6");
            System.out.println("1. Add a person");
            System.out.println("2. Modify a person");
            System.out.println("3. Search for a person");
            System.out.println("4. Remove a person");
            System.out.println("5. Print the directory");
            System.out.println("6. Exit Program \n");
            // Get user input for choice determination
            String choice = in.nextLine();
        switch (choice){
            case "1":
                newPerson();
            case "2":
                modifyPerson();
            case "3": 
                searchForName();
            case "4":
                removeFromDirectory();
            case "5": 
                printList();  
            case "6":
                keepLoopingMenu = false;
                MiscFunctions.clearScreen();
                System.out.println(done);
                break;
            default:
                System.out.println("Enter a number between 1-6 \n");
                keepLoopingMenu = true;
        
       }
      }
    }
    
    /**
     * Ask the basic information that pertains to all entries.
     */
    public void newPerson()
    {
        // Clear the terminal window for a blank slate.
        MiscFunctions.clearScreen();
        // Make field available for input from the user.
        String userInputTwo;
        // Boolean for following while loop, keeps going until 
        // valid input is recieved.
        Boolean keepLoopingNewPerson = true;
        // Boolean for the typeOfPerson loop, keeps going until 
        // valid input is recieved.
        Boolean keepLoopingTypeOfPerson = true;
        
         while(keepLoopingNewPerson==true){
                // New scanner object in preparation of accepting user input
                Scanner in = new Scanner(System.in);
                // New Scanner object in preparation for accepting user input.
                Scanner userInput = new Scanner(System.in); 
                System.out.println("\n");
                 
                 // Start asking common questions every person type will have.
                 System.out.println("Enter the details of person you would like to add: \n");
                 System.out.println("What is the last name?");
                 personsLastName = userInput.next();
                 System.out.println("\n");
                 System.out.println("What is the first name?");
                 personsFirstName = userInput.next();
                 System.out.println("\n");
                 System.out.println("What is the Email?");
                 personsEmail = userInput.next();
                 
                while(keepLoopingTypeOfPerson==true){
                // Ask specific question about what type the person and do something based on input.
                System.out.println("\n");
                System.out.println("Select the type of person: student, staff, faculty");
                String typeOfPerson = in.nextLine();
                    switch(typeOfPerson){
                    case "student":
                        String studentStatus = Student.GetStudentStatus();
                        directory.put(personsLastName + personsFirstName, " Email " + personsEmail 
                            + ", Class Status " + studentStatus);
                        System.out.println("\n");
                        System.out.println("Person added \n");
                        System.out.println("Add another person? y or n \n");
                        userInputTwo = in.nextLine().trim().toLowerCase();
                            if (userInputTwo.equals("y")) {
                                newPerson();
                            } else if (userInputTwo.equals("n"))
                                // The user does not wish to continue, so stop loop.
                                keepLoopingNewPerson=false;
                                RunProgram();
                                break;
                    case "staff":
                        int staffOfficeNumber = Staff.GetStaffOfficeNumber();
                        String staffTitle = Staff.GetStaffTitle();  
                        directory.put(personsLastName + personsFirstName, " Email " + personsEmail
                            + ", Office Number - " + staffOfficeNumber + ", Staff Title - " + staffTitle);
                        System.out.println("\n");
                        System.out.println("Person added \n");
                        System.out.println("Add another person? y or n \n");
                        userInputTwo = in.nextLine().trim().toLowerCase();
                            if (userInputTwo.equals("y")) {
                                newPerson();
                            } else if (userInputTwo.equals("n"))
                                // The user does not wish to continue, so stop loop.
                                keepLoopingNewPerson=false;
                                RunProgram();
                                break;
                    case "faculty":
                        int facultyOfficeNumber = Faculty.GetFacultyOfficeNumber();
                        boolean tenure = Faculty.GetTenureStatus();
                        directory.put(personsLastName + personsFirstName, " Email " + personsEmail 
                            + ", Office Number " + facultyOfficeNumber + ", Tenure - " + tenure);
                        System.out.println("\n");
                        System.out.println("Person added \n");
                        System.out.println("Add another person? y or n \n");
                        userInputTwo = in.nextLine().trim().toLowerCase();
                            if (userInputTwo.equals("y")) {
                                newPerson();
                            } else if (userInputTwo.equals("n"))
                                // The user does not wish to continue, so stop loop.
                                keepLoopingNewPerson=false;
                                RunProgram();
                                break;
                    default:
                        System.out.println("\n");
                        System.out.println("Error: enter either student, staff or faculty. Going back to menu. \n");
                        MiscFunctions.sleepThread();
                        newPerson();
                }
             keepLoopingTypeOfPerson=false;
            }
           keepLoopingNewPerson=false;
           //keepLoopingTypeOfPerson=false;
        }
    }

   
    /**
     * Remove an entry from the TreeMap
     */
    private void removeFromDirectory()
    {   
        // Clear the terminal screen
       MiscFunctions.clearScreen();
        // New scanner object in preparation of accepting user input
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the last name");
        String lastName = in.next();
        System.out.println("Enter the first name");
        String firstName = in.next();
        System.out.println("\n");
        String searchName = lastName + firstName;

        if(directory.containsKey(searchName)){
         // Ask for verification.
         System.out.println("Do you want to remove " + searchName + " ? y/n");
         String choice = in.next();
         System.out.println("\n");
         // What to do based on the answer inputted.
            if(choice.equals("y")){
                directory.remove(searchName);
                System.out.println("Entry removed");
                MiscFunctions.sleepThread();
                continueMenu();
            } else if(choice.equals("n")){
                 // Execute the function that asks the user to continue the program.
                 continueMenu();
            }
            } else {
                 MiscFunctions.clearScreen();
                 System.out.println("Did not find key: " + searchName + "!");
                 MiscFunctions.sleepThread();
                 // Execute the function that asks the user to continue the program.
                 continueMenu();
            }
        
    }
   
    
    
    /**
     * Search the list
     */
    private void searchForName()
    {
        // Clear the terminal screen
        MiscFunctions.clearScreen();
        // New scanner object in preparation of accepting user input
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the last name");
        String lastName = in.next();
        System.out.println("Enter the first name");
        String firstName = in.next();
        System.out.println("\n");
        String searchName = lastName + firstName;
            if(directory.containsKey(searchName)){
                MiscFunctions.clearScreen();
                System.out.println("\n");
                System.out.println("Search for key: " + searchName + " found!");
                System.out.println("The entry is: "+ directory.get(searchName) + "\n");
                // Execute the function that asks the user to continue the program.
                continueMenu();
                } else {
                    MiscFunctions.clearScreen();
                    System.out.println("Did not find key: " + searchName + "!");
                    MiscFunctions.sleepThread();
                     // Execute the function that asks the user to continue the program.
                    continueMenu();
                }
          
            }
            
     /**
     * Print the list
     */
     private void printList()
    {   
        //Clear the screen for any miscellaneous print
        MiscFunctions.clearScreen();
        // Get a set of the entries from the TreeMap
        Set directorySet = directory.entrySet();
        // Get an iterator
        Iterator iterator = directorySet.iterator();
        // Display elements
        
        // First check to see if the TreeMap is empty, if so display warning. 
        // If not then print all entries
        if(directory.isEmpty()){
            // If map is empty and the user selects this option from the menu
            // just direct them to enter a new user.
            System.out.println("The directory is empty, nothing to show. Returning to main menu");
            MiscFunctions.sleepThread();
            RunProgram();
        } else {
            while(iterator.hasNext()) {
                Map.Entry me = (Map.Entry)iterator.next();
                System.out.print(me.getKey() + ": ");
                System.out.println(me.getValue());
            }
        // Tell the user we are done
        System.out.println("\n");
        System.out.println("Reached end of list");
        MiscFunctions.sleepThread();
        continueMenu();
       }
    }
   
     /**
     * Function to continue looping the main menu, used to reduce duplicate code.
     */
    private void continueMenu()
    {
        // New scanner object in preparation of accepting user input
        Scanner in = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Continue? y/n");
        String choice = in.next();
        if(choice.equals("y")) {
            keepLoopingMenu=true;
        } else if(choice.equals("n")) {
                keepLoopingMenu=false;
                MiscFunctions.clearScreen();
                System.out.println(done);
                continueMenu();
        }
    }
    
    /**
     * Function to modify value for an existing key
     */
    
    private void modifyPerson()
    {
         // Clear the terminal screen
        MiscFunctions.clearScreen();
        // New scanner object in preparation of accepting user input
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the last name");
        String lastName = in.next();
        System.out.println("Enter the first name");
        String firstName = in.next();
        System.out.println("\n");
        String searchName = lastName + firstName;
            if(directory.containsKey(searchName)){
                String newEmail;
                // Execute the function that asks the user to continue the program.
                continueMenu();
                } else {
                     // Execute the function that asks the user to continue the program.
                    continueMenu();
                }
    }
   }
