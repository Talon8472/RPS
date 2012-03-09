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

package net.heraan;

import net.heraan.ui.CLI;

/**
 * @description The start point of the RPS program.  Here, command line arguments are processed and a UI is selected and started.
 * 
 * @author Robert Friedland
 * @documentor Robert Friedland
 * @version March 8, 2012 (1.0)
 */
public class Main
{
    /**
     * @description Start point of the RPS program.  Processes command line arguments and starts a UI.
     * 
     * @param args the command line arguments (only argument is supported, an integer that specifies number of rounds per game.)
     * @precondition At most one argument is given, and that argument is an integer value.
     * @postcondition A Rock-Paper-Scissors game will be started with a CLI.
     */
    public static void main(String[] args) throws Exception
    {
        // If there are arguments given.
        if (args.length > 0)
        {
            // ERROR Checking code.  What if a non-integer is given? Or more than one argument?
            // ERROR CODE... <INSERT HERE> // Future additions.
            
            // Start CLI with the given number of rounds per match.
            int rounds_per_match = Integer.parseInt(args[0]);
            CLI ui = new CLI(rounds_per_match-1);
        }
        // If no argument is given.
        else
        {
            // Start CLI with 3 rounds per match.
            CLI ui = new CLI(3);
        }
        
        
        // [BEGIN] IGNORE: Version 2.0 Stuff [BEGIN]
        
        int version = 1;
        if (version == 2)
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
                        // ERROR CODE
                    }
                }
            }
            else
            {
                // READ "RPS_GameDefaults" file.
            }
        }
        
        // [ END ] IGNORE: Version 2.0 Stuff [ END ]
    }
}