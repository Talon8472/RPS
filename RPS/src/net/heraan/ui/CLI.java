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
import net.heraan.Game;
import net.heraan.Game.Play;
import net.heraan.Game.Result;
import net.heraan.Player.AI.AI;
import net.heraan.Player.AI.AI_Strategy;
import net.heraan.Player.AI.Personality.Personality_Random;
import net.heraan.Player.Human.Human;
import net.heraan.Player.Player;
import net.heraan.Round;

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
    public CLI(int rounds_per_game) throws Exception
    {
        this.mind = new Personality_Random();
        
        this.rounds_per_game = rounds_per_game;
        this.current_round = 1;
        
        this.competitors = new ArrayList<Player>();
        
        // Loads the human players from the data files
        this.load_Humans();
        
        // [BEGIN] VERSION 1.0 Implementation [BEGIN]
        {
            // Create Human & add to competitors list.
            Player human = new Human("HUMAN");
            this.competitors.add(human);
            
            // Create AI & add to competitors list.
            Player ai = new AI("AI Random Robert", mind);
            this.competitors.add(ai);

            // Creates a new game.
            this.current_game = new Game(this.competitors);
        }
        // [ END ] VERSION 1.0 Implementation [ END ]
        
        
        // Welcome Message.  NOTE: Change to 12 hour time with AM-PM.  
        System.out.println("Welcome, today is: "+Calendar.getInstance().getTime());
        
        // Starts a command line interface loop to receive user inputs.  
        String quitString = "noquit";
        while ( (quitString.equalsIgnoreCase("quit") == false) )
        {
            this.gameOverHandler();
            
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
                
                this.print_Score();
                
                // IMPORTANT: the "continue" skips the input.close() method until quit is received.
                continue;
            }
            // "Rock" play received.
            else if ( answer.equalsIgnoreCase("rock") )
            {
                this.play_Rock();
                
                // IMPORTANT: the "continue" skips the input.close() method until quit is received.
                continue;
            }
            // "Paper" play received.
            else if ( answer.equalsIgnoreCase("paper") )
            {
                this.play_Paper();
                
                // IMPORTANT: the "continue" skips the input.close() method until quit is received.
                continue;
            }
            // "Scissors" play received.
            else if ( answer.equalsIgnoreCase("scissors") )
            {
                this.play_Scissors();
                
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

    
    
    private void play_Rock()
    {        
        // Command Acknowledgement.
        System.out.println("\n SYSTEM: ROCK play received. Round "+this.current_round+"A.");

        // Human Plays.
        this.current_game.set_Play(null, Play.ROCK);
        
        // AI Plays.
        Play ai_play = ((AI) this.competitors.get(1)).play();
        this.current_game.set_Play(null, ai_play);

        // AI Played.
        System.out.println("\n     AI: "+ai_play+"! Round "+this.current_round+"B.");
        
        this.current_round++;
    }
    
    private void play_Paper()
    {
        // Command Acknowledgement.
        System.out.println("\n SYSTEM: PAPER play received. Round "+this.current_round+"A.");

        // Human Plays.
        this.current_game.set_Play(null, Play.PAPER);
        
        // AI Plays.
        Play ai_play = ((AI) this.competitors.get(1)).play();
        this.current_game.set_Play(null, ai_play);

        // AI Played.
        System.out.println("\n     AI: "+ai_play+"! Round "+this.current_round+"B.");
        
        this.current_round++;
    }
    
    private void play_Scissors()
    {
        // Command Acknowledgement.
        System.out.println("\n SYSTEM: SCISSORS play received. Round "+this.current_round+"A.");

        // Human Plays.
        this.current_game.set_Play(null, Play.SCISSORS);
        
        // AI Plays.
        Play ai_play = ((AI) this.competitors.get(1)).play();
        this.current_game.set_Play(null, ai_play);

        // AI Played.
        System.out.println("\n     AI: "+ai_play+"! Round "+this.current_round+"B.");
        
        this.current_round++;
    }
    
    private void gameOverHandler()
    {
        if ( ( this.current_round > this.rounds_per_game ) && ( this.current_game.get_CurrentRound().is_RoundComplete() == true ) )
        {
            this.competitors.get(0).record_Game(current_game);

            if (this.current_game.get_PlayerResult(this.competitors.get(0)) == Result.TIE)
            {
                System.out.println("\n SYSTEM: Tie game.");
            }
            else if ( this.current_game.get_PlayerResult(this.competitors.get(0)) == Result.WIN )
            {
                System.out.println("\n SYSTEM: Human wins.");
            }
            else
            {
                System.out.println("\n SYSTEM: AI wins.");
            }

            this.current_game = new Game(this.competitors);
            this.current_round = 1;
        }
    }
    
    /**
     * @description: Prints the score information.
     * 
     * @precondition ?
     * @postcondition ?
     */
    private void print_Score()
    {
        int game_wins  = 0;
        int game_ties  = 0;
        int game_loses = 0;
        
        int round_wins  = 0;
        int round_ties  = 0;
        int round_loses = 0;
        
        for ( Game game : this.competitors.get(0).get_GameHistory() )
        {
            if      ( ( game.is_Tie() == true ) )
            {
                game_ties++;
                
            }
            else if ( ( game.is_Winner(this.competitors.get(0)) == true ) )
            {
                game_wins++;
            }
            else
            {
                game_loses++;
            }
            
            for ( Round round : game.get_Rounds() )
            {
                if      ( ( round.is_Tie() ) )
                {
                    round_ties++;
                }
                else if ( ( round.is_Winner(this.competitors.get(0)) == true ) )
                {
                    round_wins++;
                }
                else
                {
                    round_loses++;
                }
            }
        }
        
        System.out.print("\n SYSTEM: Human Game  Win  Total: "+game_wins);
        System.out.print("\n SYSTEM: Human Game  Tie  Total: "+game_ties);
        System.out.print("\n SYSTEM: Human Game  Lose Total: "+game_loses);
        System.out.print("\n SYSTEM: Human Round Win  Total: "+round_wins);
        System.out.print("\n SYSTEM: Human Round Tie  Total: "+round_ties);
        System.out.print("\n SYSTEM: Human Round Lose Total: "+round_loses+"\n");
    }

    /**
     * @description ?
     * 
     * @precondition ?
     * @postcondition ?
     */
    private void load_Humans()
    {
        // FOR VERSION 2.0
        
        this.humans_list = new ArrayList<Player>();
        
        
        this.humans_list.trimToSize();
    }
    
    /**
     * @description: Prints the help information; including command list, play list, and game instructions.
     * 
     * @precondition ?
     * @postcondition ?
     */
    private void print_Help()
    {
        System.out.print("\n         Here are the available actions list and their associated descriptions.");
        System.out.print("\n");
        System.out.print("\n         - Commands: (3 in total.)");
        System.out.print("\n           1.)     quit: Exits the round, game, and application.");
        System.out.print("\n                         No moves are recorded for that round.");
        System.out.print("\n           2.)     help: Displays this help text.");
        System.out.print("\n           3.)    score: Displays the score (win, loss, tie) totals for the human");
        System.out.print("\n                         player for each game and round as well as the time ");
        System.out.print("\n                         associated with each.");
        System.out.print("\n");
        System.out.print("\n         -    Plays: (3 in total.)");
        System.out.print("\n           1.)     rock: Plays the \"rock\" move for the human player. ");
        System.out.print("\n                         Beats the \"scissors\" play. ");
        System.out.print("\n           2.)    paper: Plays the \"paper\" move for the human player.");
        System.out.print("\n                         Beats the \"rock\" play.");
        System.out.print("\n           3.) scissors: Plays the \"scissors\" move for the human player.");
        System.out.print("\n                         Beats the \"paper\" play.");
        System.out.print("\n");
        System.out.print("\n         Game Play Instructions: Rock Paper Scissors is a two player game.");
        System.out.print("\n                                 Each game can consist of any number of rounds");
        System.out.print("\n                                 and can result in a win, loss or tie. A game is");
        System.out.print("\n                                 won by winning the most rounds. Each round");
        System.out.print("\n                                 consists of one play by each player without the");
        System.out.print("\n                                 foreknowledge of the other's play. Each play");
        System.out.print("\n                                 consists of either a rock, paper, or scissors.");
        System.out.print("\n                                 Rock beats scissors. Paper beats rock. Scissors");
        System.out.print("\n                                 beats paper.  If each player plays the same move");
        System.out.print("\n                                 then, a tie is recorded.\n");
    }
    
    
    
    private AI_Strategy mind; // The AI strategy to be used.
    
    private ArrayList<Player> competitors; // The two players (AI-AI, Human-Human, Human-AI) that will be competing.
    private ArrayList<Player> humans_list; // All the human players currently loaded into the game.
    
    private Game current_game; // The current game being played.
    
    private int rounds_per_game; // The number of rounds for each game.
    private int current_round; // The current round being played.
}