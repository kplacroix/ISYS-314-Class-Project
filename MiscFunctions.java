/**
 * This class holds miscellaneous functions that I didn't want in the 
 * people superclass to avoid cluttering of the code and making the
 * super class unduly long.
 * 
 * @author Kenneth LaCroix 
 * @version 06/09/2015
 */
public class MiscFunctions extends People
{   
    /**
     * A very simple way to clear the screen that will work on any system.
     */
    public static void clearScreen()
    {
        for(int clear = 0; clear < 1000; clear++)
        {
            System.out.println("\b") ;
        }
    }
    
    /**
     * Sleep the program, used in various places.
     */
    public static void sleepThread()
    {
        // Try-catch block that pauses execution for 3 seconds. Purely for cosmetics.
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
    
    /**
     * An easy to 'quit' the program
     */
    public static void quitProgram()
    {
        // Message telling the user the program is done, used later.
        String done = "You have selected to exit the program. The program is now terminated.";
        clearScreen();
        System.out.println(done);
    }
}
