// I use various items from this package, so just import them all.
import java.util.*;

/**
 * This class holds miscellaneus functions that I didnt want in tthe 
 * people superclass to avoid cluttering of the code.
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
}
