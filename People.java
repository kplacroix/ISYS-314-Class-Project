// I use various items from this package, so just import them all.
import java.util.*;


/**
 * This program will collect data about a person and then make decisions based 
 * upon the status of the person. Features include: adding, deleting, 
 * printing, searching, retrieving and modifying of values. The bulk of the 
 * programs lives here. I could not  create a function that would print just the 
 * student because of the way I added values to the TreeMap (concatenated). 
 * The newPerson function is the only function that is public because the map needs 
 * to be 'primed' with at least one valid entry for most all other functions to work. 
 * Once a person is entered, the main menu is shown allowing other actions to be done.
 * 
 * @author Ken LaCroix
 * @version 05/23/2015-6/14/2015
 */
 
// Suppress the warnings I kept on getting, probably because of the way I declared TreeMap, however compiling is still successful.
 @SuppressWarnings("unchecked") public class People
{
    // Have these fields be available on a global level.

    // The basic fields for every person type.
    private String personsFirstName = "";
    private String personsLastName = "";
    private String personsEmail = "";
   
    // Boolean for the menu while loop, keeps going until user quits.
    // Define it globally so we can stop the loop in other functions.
    Boolean keepLoopingMenu = true;
    Boolean keepLoopingNewPerson = true;
    Boolean keepLoopingTypeOfPerson = true;
    
    // Declare the tree map
    TreeMap directory = new TreeMap();
    
     /**
     * A very basic menu system to help the user execute the programs functions instead of instantiating functions.
     * User a switch case that calls other functions to simulate a menu.
     */
    
    private void MainMenu()
    {
        // Clear any miscellaneous text
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
            System.out.println("6. Exit program");
            // Get user input for choice determination
            String choice = in.nextLine();
        switch (choice){
            case "1":
                // Call the function that will get the info and add to the treemap.
                newPerson();
            case "2":
                // Call the function that will search the map and overwrite an entry.
                modifyPerson();
                break;
            case "3": 
                // Call the function that will search the map by the key.
                searchForName();
                break;
            case "4":
                // Call the function that will search the map and remove an entry by its key.
                removeFromDirectory();
                break;
            case "5": 
                // Iterate through the map and print its entries
                printList();
                break;
            case "6":
                // Simulate exiting the program. Stop the menu loop.
                MiscFunctions.quitProgram();
                keepLoopingMenu = false;
                break;
            default:
                // Shown if an appropriate case was not found. 
                System.out.println("Enter a number between 1-6 \n");
                keepLoopingMenu = true;
        
       }
      }
    }
    
    /**
     * Ask the basic information that pertains to all entries. This function also adds entries into the TreeMap.
     * Uses a while loop with nested a switch case. Entries are added to the map via put. 
     */
    public void newPerson()
    {
        // Clear the terminal window for a blank slate.
        MiscFunctions.clearScreen();
        // Used for later input processing.
        String userInputTwo;
        
         while(keepLoopingNewPerson==true){
                // New scanner object in preparation of accepting user input
                Scanner in = new Scanner(System.in);
                // New Scanner object in preparation for accepting user input.
                Scanner userInput = new Scanner(System.in); 
                System.out.println("\n");
                 
                 // Start asking common questions every person type will have.
                 System.out.println("Enter the details of person you would like to add. \n");
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
                        directory.put(personsLastName + personsFirstName, " Email - " + personsEmail 
                            + ", Class Status - " + studentStatus);
                        System.out.println("\n");
                        System.out.println("Person added \n");
                        System.out.println("Add another person? y or n \n");
                        userInputTwo = in.nextLine().trim().toLowerCase();
                            if (userInputTwo.equals("y")) {
                                newPerson();
                            } else if (userInputTwo.equals("n"))
                                // The user does not wish to continue, so stop loop.
                                keepLoopingNewPerson=false;
                                MainMenu();
                                break;
                    case "staff":
                        int staffOfficeNumber = Staff.GetStaffOfficeNumber();
                        String staffTitle = Staff.GetStaffTitle();  
                        directory.put(personsLastName + personsFirstName, " Email - " + personsEmail
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
                                MainMenu();
                                break;
                    case "faculty":
                        int facultyOfficeNumber = Faculty.GetFacultyOfficeNumber();
                        boolean tenure = Faculty.GetTenureStatus();
                         directory.put(personsLastName + personsFirstName, " Email - " + personsEmail 
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
                                MainMenu();
                                break;
                    default:
                        System.out.println("\n");
                        System.out.println("Invalid person type. Going back to menu. \n");
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
     * Remove an entry from the TreeMap by searching for the key (lastname+firstname).
     * Entries are removed via remove.
     */
    private void removeFromDirectory()
    {   
        // Clear the terminal screen
        MiscFunctions.clearScreen();
        // New scanner object in preparation of accepting user input
        
        System.out.println("Remove From Directory: Search for the key (lastname+firstname) and remove" +
        " it from the TreeMap.");
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
     * Search the list and print the appropriate values from the map.
     */
    private void searchForName()
    {
        // Clear the terminal screen
        MiscFunctions.clearScreen();
        // New scanner object in preparation of accepting user input
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the last name");
        String lastName = in.next();
        System.out.println("\n");
        System.out.println("Enter the first name");
        String firstName = in.next();
        System.out.println("\n");
        String searchName = lastName + firstName;
            if(directory.containsKey(searchName)){
                MiscFunctions.clearScreen();
                System.out.println("\n");
                System.out.println("Search for key: " + searchName + " found!");
                System.out.println("The entry is: " + searchName + ": " + directory.get(searchName) + "\n");
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
     * Print the list using an iterator.
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
        
        System.out.println("Iterate through the TreeMap and print its contents \n");
        // First check to see if the TreeMap is empty, if so display warning. 
        // If not then print all entries
        if(directory.isEmpty()){
            // If map is empty and the user selects this option from the menu
            // just direct them to enter a new user.
            System.out.println("The directory is empty, nothing to show. Returning to main menu");
            MiscFunctions.sleepThread();
            MainMenu();
        } else {
            while(iterator.hasNext()) {
                Map.Entry directory = (Map.Entry)iterator.next();
                System.out.print(directory.getKey() + ": ");
                System.out.println(directory.getValue());
            }
        // Tell the user we are done
        System.out.println("\n");
        System.out.println("Reached end of list");
        MiscFunctions.sleepThread();
        continueMenu();
       }
    }
    
     /**
     * Function to ask the user to continue looping or exit the program, used to reduce duplicate code.
     */
    private void continueMenu()
    {
        // New scanner object in preparation of accepting user input
        Scanner in = new Scanner(System.in);
        System.out.println("\n");
        System.out.println("Continue? y/n");
        String choice = in.next();
        if(choice.equals("y")) {
            MainMenu();
        } else if(choice.equals("n")) {
                MiscFunctions.quitProgram();
                // Stop the loops
                keepLoopingMenu = false;
                keepLoopingNewPerson = false;
        }
    }
    
    /**
     * Function to modify value for an existing key. It uses the existing classes for
     * student, staff and faculty to re obtain information. The email address is recaptured
     * by asking for it again. All we need to do is update the record using the appropriate by 
     * reputting it in the map.
     */
    
    private void modifyPerson()
    {
         // Clear the terminal screen
        MiscFunctions.clearScreen();
        // Boolean used for the while loop
        Boolean keepLoopingTypeOfPerson = true;
        // New scanner object in preparation of accepting user input
        Scanner in = new Scanner(System.in);
        
        System.out.println("Modify a record by searching by the key (lastname+firstname). You" +
        " can change the email and type of person, including any associated data. \n");
        System.out.println("Enter the last name");
        String lastName = in.next();
        System.out.println("\n");
        System.out.println("Enter the first name");
        String firstName = in.next();
        System.out.println("\n");
        String searchName = lastName + firstName;
            if(directory.containsKey(searchName)){
                while(keepLoopingTypeOfPerson==true){
                // Ask specific question about what type the person and do something based on input.
                System.out.println("\n");
                System.out.println("Select a new or the same type of person: student, staff, faculty");
                String typeOfPerson = in.next();
                    switch(typeOfPerson){
                    case "student":
                        System.out.println("\n");
                        System.out.println("What is the email?");
                        String newEmailStudent = in.next();
                        String studentStatus = Student.GetStudentStatus();
                        directory.put(searchName, "Email - " + newEmailStudent + ", Student Status - " + studentStatus);
                        System.out.println("\n");
                        System.out.println("Person modified successfully \n");
                        MiscFunctions.sleepThread();
                        continueMenu();
                                break;
                    case "staff":
                        System.out.println("\n");
                        System.out.println("What is the email?");
                        String newEmailStaff = in.next();
                        int staffOfficeNumber = Staff.GetStaffOfficeNumber();
                        String staffTitle = Staff.GetStaffTitle();
                        // Add the information we have to the directory.
                        directory.put(personsLastName + personsFirstName, " Email - " + newEmailStaff
                            + ", Office Number - " + staffOfficeNumber + ", Staff Title - " + staffTitle);
                        System.out.println("\n");
                        System.out.println("Person modified successfully \n");
                        MiscFunctions.sleepThread();
                        continueMenu();
                                break;
                    case "faculty":
                        System.out.println("\n");
                        System.out.println("What is the email?");
                        String newEmailFaculty = in.next();
                        int facultyOfficeNumber = Faculty.GetFacultyOfficeNumber();
                        boolean tenure = Faculty.GetTenureStatus();
                         directory.put(personsLastName + personsFirstName, " Email - " + newEmailFaculty 
                            + ", Office Number " + facultyOfficeNumber + ", Tenure - " + tenure);
                        System.out.println("\n");
                        System.out.println("Person modified successfully \n");
                        MiscFunctions.sleepThread();
                        continueMenu();
                                break;
                    default:
                        System.out.println("\n");
                        System.out.println("Invalid person type. Going back to menu. \n");
                        MiscFunctions.sleepThread();
                        newPerson();
                }
             keepLoopingTypeOfPerson=false;
            }
                } else {
                    System.out.println("Did not find key: " + searchName + " !");
                    MiscFunctions.sleepThread();
                    // Execute the function that asks the user to continue the program.
                    continueMenu();
                }
    }
   }
