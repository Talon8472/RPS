package net.heraan.ui;

import java.io.*;
import java.util.*;

/**
 * @description: This is the CLI, Command Line Interface, for the RPS, Rock Paper Scissors, game.  User input is received, processed, and output is given.
 * 
 * @author Robert Friedland
 * @version March 3, 2012
 */
public class CLI
{
    /*
     * @description: Starts a new CLI for the user.
     * 
     * @precondition ?
     * @postcondition ?
     */
    public CLI()
    {
        throw new UnsupportedOperationException("Not yet implemented");
        
        // Notes: Will read from RPS_GameDefaults.
    }
    
    
    /*
     * @description: Starts a new CLI for the user.
     * 
     * @param rounds_per_match The default number of rounds per match.
     * @precondition ?
     * @postcondition ?
     */
    public CLI(int rounds_per_match)
    {
        // Welcome Message.  NOTE: Change to 12 hour time with AM-PM.  
        System.out.println("Welcome, today is: "+Calendar.getInstance().getTime());
        
        // Starts a command line interface loop to receive user inputs.  
        String quitString = "noquit";
        while ( (quitString.equalsIgnoreCase("quit") == false) )
        {
            Scanner input = new Scanner(System.in);
			
            System.out.print("\n SYSTEM: Please enter a command (quit, help, score) or play (rock, paper, scissors).\nCommand: ");
        
            String answer = input.next();
            
            // "Quit" command received.
            if      ( answer.equalsIgnoreCase("quit") )
            {
                quitString = "quit";
                System.out.println("\n SYSTEM: Quit command received.  Goodbye.");
            }
            // "Help" command received.
            else if ( answer.equalsIgnoreCase("help") )
            {
                // Command acknowledgement.
                System.out.println("\n SYSTEM: Help command received.");
                
                // Prints the Help Doc.
                this.print_Help();
                
                // IMPORTANT: the "continue" skips the input.close() method until quit is received.
                continue;
            }
            // "Score" command received.
            else if ( answer.equalsIgnoreCase("score") )
            {
                // Command acknowledgement.
                System.out.println("\n SYSTEM: Score command received.");
                
                // IMPORTANT: the "continue" skips the input.close() method until quit is received.
                continue;
            }
            // "Rock" play received.
            else if ( answer.equalsIgnoreCase("rock") )
            {
                // Command acknowledgement.
                System.out.println("\n SYSTEM: Rock play received.");
                
                // IMPORTANT: the "continue" skips the input.close() method until quit is received.
                continue;
            }
            // "Paper" play received.
            else if ( answer.equalsIgnoreCase("paper") )
            {
                // Command acknowledgement.
                System.out.println("\n SYSTEM: Paper play received.");
                
                // IMPORTANT: the "continue" skips the input.close() method until quit is received.
                continue;
            }
            // "Scissors" play received.
            else if ( answer.equalsIgnoreCase("scissors") )
            {
                // Command acknowledgement.
                System.out.println("\n SYSTEM: Scissors play received.");
                
                // IMPORTANT: the "continue" skips the input.close() method until quit is received.
                continue;
            }            
            // Unsupported command handling.
            else
            {
                // Command acknowledgement.
                System.out.println("\n SYSTEM: Unsupported command received.");
                
                // IMPORTANT: the "continue" skips the input.close() method until quit is received.
                continue; 
            }
            
            // IMPORTANT: Closes the Scanner Input.
            input.close();
        }
    }
    
    /*
     * @description: Prints the help information; including command list, play list, and game instructions.
     * 
     * @precondition ?
     * @postcondition ?
     */
    private void print_Help()
    {
        // CODE
    }

    /*
     * @description: Prints the score information.
     * 
     * @precondition ?
     * @postcondition ?
     */
    private void print_Score()
    {
        // CODE
    }
}