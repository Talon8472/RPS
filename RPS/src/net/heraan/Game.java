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

import net.heraan.Player.Player;
import java.util.ArrayList;

/**
 * @description: ?
 * 
 * @author Robert Friedland
 * @documentor Quynhanh Nguyen
 * @version March 3, 2012 (1.0)
 */
public class Game
{
    // [BEGIN] Constructors Section [BEGIN]
    
    /**
     * @description: ?
     * 
     * @param max_rounds the number of rounds to be played. [Size = 1 ... 50]
     * @param players the two players who will be playing this game. [Size = 2]
     * @precondition ?
     * @postcondition ?
     */
    public Game(int max_rounds, ArrayList<Player> players)
    {
        this.max_rounds = max_rounds;
        
        this.players = new Player[2];
        this.players[0] = players.get(0);
        this.players[1] = players.get(1);
    }
    
    // [ END ] Constructors Section [ END ]
    

    public void play(Player player, Play move) throws Exception
    {
        if ( (this.is_GameOver() ) )
        {
            throw new Exception("Game is already over, move not available.");
        }
        else
        {
            this.rounds.get(this.get_CurrentRoundNumber()).play(player, move);
        }
    }
    
    // Create game & round_get_times: total time, start, end; going to want a Calendar / Time Class
    
    public Result get_PlayerResult(Player player) throws Exception
    {
        if      ( ( this.is_Winner(player) == true ) )
        {
            return (Result.WIN);
        }
        else if ( ( this.is_Loser(player) == true ) )
        {
            return (Result.LOSE);
        }
        else
        {
            return (Result.TIE);
        }
    }
    
    public Player get_Winner() throws Exception
    {
        if ( ( this.is_Winner(this.players[0]) == true ) )
        {
            return (this.players[0]);
        }
        else
        {
            return (this.players[1]);
        }
    }
    
    public Player get_Loser() throws Exception
    {
        if ( ( this.is_Loser(this.players[0]) == true ) )
        {
            return (this.players[0]);
        }
        else
        {
            return (this.players[1]);
        }
    }
    
    public boolean is_Winning(Player player) throws Exception
    {
        int total_wins  = 0;
        int total_loses = 0;
        
        for (Round round : rounds)
        {
            if ( ( round.is_RoundComplete() ) )
            {
                if ( ( round.is_Winner(player) == true ) )
                {
                    total_wins++;
                }
                else if ( ( round.is_Loser(player) == true ) )
                {
                    total_loses++;
                }
            }
        }

        if ( ( total_wins > total_loses ) )
        {
            return (true);
        }
        else
        {
            return (false);
        }
    }
    
    public boolean is_Losing(Player player) throws Exception
    {
        int total_wins  = 0;
        int total_loses = 0;
        
        for (Round round : rounds)
        {
            if ( ( round.is_RoundComplete() ) )
            {
                if ( ( round.is_Winner(player) == true ) )
                {
                    total_wins++;
                }
                else if ( ( round.is_Loser(player) == true ) )
                {
                    total_loses++;
                }
            }
        }

        if ( ( total_wins < total_loses ) )
        {
            return (true);
        }
        else
        {
            return (false);
        }
    }
    
    public boolean is_Tying() throws Exception
    {
        int total_wins  = 0;
        int total_loses = 0;
        
        for (Round round : rounds)
        {
            if ( ( round.is_RoundComplete() ) )
            {
                // Doesn't matter if player 1 or 2 (indexes: 0, 1) given the nature of tying.
                if ( ( round.is_Winner(this.players[0]) == true ) )
                {
                    total_wins++;
                }
                else if ( ( round.is_Loser(this.players[0]) == true ) )
                {
                    total_loses++;
                }
            }
        }

        if ( ( total_wins == total_loses ) )
        {
            return (true);
        }
        else
        {
            return (false);
        }
    }
    
    public boolean is_Winner(Player player) throws Exception
    {
        if ( ( this.is_GameOver() == true ) )
        {
            int total_wins  = 0;
            int total_loses = 0;
            
            for (Round round : rounds)
            {
                if ( ( round.is_Winner(player) == true ) )
                {
                    total_wins++;
                }
                else if ( ( round.is_Loser(player) == true ) )
                {
                    total_loses++;
                }
            }
            
            if ( ( total_wins > total_loses ) )
            {
                return (true);
            }
            else
            {
                return (false);
            }
        }
        else
        {
            throw new Exception("Game is not over, winner incalculable.");
        }
    }
    
    public boolean is_Loser(Player player) throws Exception
    {
        if ( ( this.is_GameOver() == true ) )
        {
            int total_wins  = 0;
            int total_loses = 0;
            
            for (Round round : rounds)
            {
                if ( ( round.is_Winner(player) == true ) )
                {
                    total_wins++;
                }
                else if ( ( round.is_Loser(player) == true ) )
                {
                    total_loses++;
                }
            }
            
            if ( ( total_wins < total_loses ) )
            {
                return (true);
            }
            else
            {
                return (false);
            }
        }
        else
        {
            throw new Exception("Game is not over, loser incalculable.");
        }
    }
    
    public boolean is_Tie(Player player) throws Exception
    {
        if ( ( this.is_GameOver() == true ) )
        {
            int total_wins  = 0;
            int total_loses = 0;
            
            for (Round round : rounds)
            {
                if ( ( round.is_Winner(player) == true ) )
                {
                    total_wins++;
                }
                else if ( ( round.is_Loser(player) == true ) )
                {
                    total_loses++;
                }
            }
            
            if ( ( total_wins == total_loses ) )
            {
                return (true);
            }
            else
            {
                return (false);
            }
        }
        else
        {
            throw new Exception("Game is not over, tie incalculable.");
        }
    }
    
    public int get_CurrentRoundNumber() throws Exception
    {
        if ( (this.is_GameOver() ) )
        {
            throw new Exception("Game is already over, current round not applicable.");
        }
        else
        {
            return (this.rounds.size());
        }
    }
    
    public Round get_CurrentRound() throws Exception
    {
        if ( (this.is_GameOver() ) )
        {
            throw new Exception("Game is already over, current round not applicable.");
        }
        else
        {
            // The "-1' is necessary since ArrayList starts at index 0.
            return (this.rounds.get(this.get_CurrentRoundNumber()-1));
        }
    }
    
    public Round get_Round(int round_number) throws Exception
    {
        if      ( ( this.max_rounds < round_number ) )
        {
            throw new Exception("There are only "+this.max_rounds+" total rounds.");
        }
        else if ( ( this.get_CurrentRoundNumber() < round_number ) )
        {
            throw new Exception("There are only "+this.get_CurrentRoundNumber()+" rounds in play or played at the moment.");
        }
        else
        {
            return (this.rounds.get(round_number));
        }
    }
    
    public boolean is_GameOver()
    {
        if ( ( this.rounds.size() == this.max_rounds ) )
        {
            // The "-1" is necessary because ArrayList starts at index 0.
            if ( ( this.rounds.get(this.max_rounds-1).is_RoundComplete() ) )
            {
                // Saves space-memory in case game is ended early.
                rounds.trimToSize();
                
                return (true);
            }
            else
            {
                return (false);
            }
        }
        else
        {
            return (false);
        }
    }


    public enum Result {WIN, LOSE, TIE}
    public enum Play {ROCK, PAPER, SCISSORS}
    
    private final int max_rounds; // Maximum number of rounds for this game.
    private final Player[] players;
    
    private ArrayList<Round> rounds;
}