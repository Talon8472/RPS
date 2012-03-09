/**
 * COPYRIGHT (C) 2012 Robert Friedland.  All Rights Reserved.
 *
 * This software is provided under a BSD style license.  Read below for specific details.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1.) Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * 2.) Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * 3.) Neither the name "Heraan Enterprise" nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 **/

package net.heraan.ui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import net.heraan.Player.AI.AI;
import net.heraan.Game;
import net.heraan.Player.Human.Human;
import net.heraan.Player.Player;

/**
 * @description: This is the CLI, Command Line Interface, for the RPS, Rock Paper Scissors, game.  User input is received, processed, and output is given.
 * 
 * @author Robert Friedland
 * @documentor Robert Friedland
 * @version March 8, 2012 (1.0)
 */
public class CLI
{
    // [BEGIN] Constructors Section [BEGIN]

    /*
     * @description: Starts a new CLI for the user.
     * 
     * @param rounds_per_game The default number of rounds per match.
     * @precondition A non-zero integer value is given specifying the number of rounds per game.
     * @postcondition ?
     */
    public CLI(int rounds_per_game)
    {
        // [BEGIN] Creates & performs setup for Players [BEGIN]
        
        Player human = new Human();
        Player ai = new AI();
        
        human.set_Nickname("Pitiful Human Warrior");
        ai.set_Nickname("Pseudo Random Robert");
        
        // [ END ] Creates & performs setup for Players [ END ]
        
        // [BEGIN] Creates & performs setup for Game [BEGIN]
        
        ArrayList<Player> competitors = new ArrayList<Player>();
        competitors.add(human);
        competitors.add(ai);
        competitors.trimToSize();
        
        Game championship = new Game(rounds_per_game, competitors);
        
        // [ END ] Creates & performs setup for Game [ END ]
        
        // Welcome Message.  NOTE: Change to 12 hour time with AM-PM.  
        System.out.println("Welcome, today is: "+Calendar.getInstance().getTime());
        
        // Starts a command line interface loop to receive user inputs.  
        String quitString = "noquit";
        while ( (quitString.equalsIgnoreCase("quit") == false) )
        {
            Scanner input = new Scanner(System.in);
			
            System.out.print("\n SYSTEM: Please enter a command (quit, help, score) or play (rock, paper, scissors).\n  INPUT: ");
        
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
    
    // [ END ] Constructors Section [ END ]
    
    private void process_Input(String answer)
    {
        throw new UnsupportedOperationException("Not yet implemented");
        
        
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