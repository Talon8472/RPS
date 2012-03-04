package net.heraan;

import net.heraan.ui.*;

/**
 * DESC
 * 
 * @author Robert Friedland
 * @version March 3, 2012 
 */
public class Main
{
    /*
     * DESC
     * 
     * @param args the command line arguments
     * @precondition ?
     * @postcondition ?
     */
    public static void main(String[] args)
    {
        if (args.length > 0)
        {
            // ERROR Checking code.  What if a non-integer is given? Or more than one argument?
            // ERROR CODE...
            
            // Start CLI with the given number of rounds per match.
            int rounds_per_match = Integer.parseInt(args[0]);
            CLI ui = new CLI(rounds_per_match);
        }
        else
        {
            // Start CLI with 3 rounds per match.
            CLI ui = new CLI(3);
        }
        
        
//        if (args.length > 0)
//        {
//            for (int arg_number = 1; arg_number >= 2; arg_number++)
//            {
//                if      ( args[(arg_number-1)].equalsIgnoreCase("CLI") )
//                {
//                    // CODE
//                }
//                else if ( args[(arg_number-1)].equalsIgnoreCase("GUI") )
//                {
//                    // CODE
//                }
//                else
//                {
//                    // ERROR CODE
//                }
//            }
//        }
//        else
//        {
//            // READ "RPS_GameDefaults" file.
//        }
    }
}