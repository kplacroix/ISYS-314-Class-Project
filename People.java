// I use various items from this package, so just import them all.
import java.util.*;


/**
 * This program will collect data about a person and then make decisions based 
 * upon the status of the person. Features include: adding, deleting, 
 * printing (all entries and just students) and retrieving.
 * 
 * @author Ken LaCroix
 * @version 05/23/2015
 */
 // Surpress the warnings I kept on getting, probably because of the way I declared TreeMap, however compiling is still successfull, so surpress..
 @SuppressWarnings("unchecked") public class People
{
    // Have these fields be available on a global level.

    // Init to zero length for later error checking. 
    private String personsFirstName = "";
    private String personsLastName = "";
    private String personsEmail = "";
    // Message telling the user the program is done, used later.
    String done = "Nothing else to do right now. You can use other functions to do what you need!";

    // Declare the tree map
    TreeMap directory = new TreeMap();

    /**
     * Ask the basic information that pertains to all entries.
     */
    public void newPerson()
    {
        // Clear the terminal window for a blank slate.
        clearScreen();
        //Clear the input, if there was any.
        clearInput();
        // Make field available for input from the user.
        String userInputTwo;
        // Boolean for following while loop, keeps going until valid input is recieved.
        Boolean keepLooping = true;
        
         while(keepLooping==true){
                // New scanner object in preparation of accepting user input
                Scanner in = new Scanner(System.in);
                
                 // New Scanner object in preparation for accepting user input.
                Scanner userInput = new Scanner(System.in); 
                System.out.println("\n");
                 
                 // Start asking common questions every person type will have.
                 System.out.println("Enter the details of person you would like to add: \n");
                 System.out.println("What is the last name? \n");
                 personsLastName = userInput.next();
                 System.out.println("What is the first name?");
                 personsFirstName = userInput.next();
                 System.out.println("\n");
                 System.out.println("What is the Email?");
                 personsEmail = userInput.next();
                 System.out.println("\n");
                
                 // Ask specific question about what type the person and do something based on input.
                System.out.println("Select the type of person: student, staff, faculty \n");
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
                                keepLooping=true;
                                break;
                            } else if (userInputTwo.equals("n"))
                                clearScreen();
                                System.out.println(done);
                               // The user does not wish to continue, so stop loop.
                                keepLooping=false;
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
                                keepLooping=true;
                                break;
                            } else if (userInputTwo.equals("n"))
                                clearScreen();
                                System.out.println(done);
                                // The user does not wish to continue, so stop loop.
                                keepLooping=false;
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
                                keepLooping=true;
                                break;
                            } else if (userInputTwo.equals("n"))
                                clearScreen();
                                System.out.println(done);
                                // The user does not wish to continue, so stop loop.
                                keepLooping=false;
                                break;
                    default:
                        System.out.println("Error: enter either student, staff or faculty \n");
                        // Restart the loop because of invalid input.
                        keepLooping=true;
                }
           }
    }

    /**
     * A very simple way to clear the screen that will work on any system.
     */
    public void clearScreen()
    {
        for(int clear = 0; clear < 1000; clear++)
        {
            System.out.println("\b") ;
        }
    }

    /**
     * Clear the variables for next iterations
     */

    public void clearInput()
    {
        personsFirstName = "";
        personsLastName = "";
        personsEmail = "";
    }

    /**
     * Print the list
     */
    public void printList()
    {   
        //Clear the screen for any miscellaneous print
        clearScreen();
        // Get a set of the entries from the TreeMap
        Set directorySet = directory.entrySet();
        // Get an iterator
        Iterator iterator = directorySet.iterator();
        // Display elements
        while(iterator.hasNext()) {
            Map.Entry me = (Map.Entry)iterator.next();
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
    }
    
    /**
     * Search the list
     */
    public void searchForName()
    {
        // Clear the terminal screen
        clearScreen();
        // New scanner object in preparation of accepting user input
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the last name");
        String lastName = in.next();
        System.out.println("Enter the first name");
        String firstName = in.next();
        String searchName = lastName + firstName;
            if(directory.containsKey(searchName)){
                clearScreen();
                System.out.println("Search for " + searchName + "complete!");
                System.out.println("The entry is: "+ directory.get(searchName));
                } else {
                    System.out.println("Did not find key! " + searchName + "\n");
        }
    }
   }
