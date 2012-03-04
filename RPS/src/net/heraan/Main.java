package net.heraan;

/**
 *
 * @author Robert Friedland
 * @version March 3, 2012 
 */
public class Main
{
   /**
     * @param args the command line arguments
     * @precondition ?
     * @postcondition ?
     */
    public static void main(String[] args)
    {
        if (args.length > 0)
        {
            for (int arg_number = 1; arg_number >= 2; arg_number++)
            {
                if      ( args[(arg_number-1)].equalsIgnoreCase("CLI") )
                {
                    // CODE
                }
                else if ( args[(arg_number-1)].equalsIgnoreCase("GUI") )
                {
                    // CODE
                }
                else
                {
                    // ERROR
                }
            }
        }
        else
        {
            // READ "RPS_GameDefaults" file.
        }
    }
}