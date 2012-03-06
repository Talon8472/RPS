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

import java.util.ArrayList;
import java.util.Calendar;
import net.heraan.Game.Play;
import net.heraan.Game.Result;

/**
 * @description ?
 * 
 * @author Robert Friedland
 * @documentor: Quynhanh Nguyen
 * @version March 4, 2012 (1.0)
 */
public class Round
{
    /**
     * @description: ?
     * 
     * @param players ?
     * @postcondition ?
     * @precondition ?
     */
    public Round(Player[] players)
    {
        this.players = players;
        
        this.player_Moves[0] = null;
        this.player_Moves[1] = null;
    }
    
    /**
     * @description: ?
     * 
     * @param player ?
     * @param play ?
     * @throws ?
     * @postcondition ?
     * @precondition ?
     */
    public void play(Player player, Play play) throws Exception
    {
        if      ( ( ( this.players[0] == player ) && ( this.player_Moves[0] == null ) ) )
        {
            this.player_Moves[0] = play;
            this.player_MoveTimes[0] = Calendar.getInstance().getTime().toString();
        }
        else if ( ( ( this.players[0] == player ) && ( this.player_Moves[0] != null ) ) )
        {
            throw new Exception("Player has already played.");
        }
        else if ( ( ( this.players[1] == player ) && ( this.player_Moves[1] == null ) ) )
        {
            this.player_Moves[1] = play;
            this.player_MoveTimes[1] = Calendar.getInstance().getTime().toString();
        }
        else if ( ( ( this.players[1] == player ) && ( this.player_Moves[1] != null ) ) )
        {
            throw new Exception("Player has already played.");
        }
    }
    
     /**
     * @description: ?
     * 
     * @param player 
     * @return ?
     * @throws ?
     * @postcondition ?
     * @precondition ?
     */   
    public Play get_Play(Player player) throws Exception
    {
        if      ( ( this.players[0] == player ) && ( this.player_Moves[0] == null ) )
        {
            throw new Exception("Player has not played yet.");
        }
        else if ( ( this.players[0] == player ) && ( this.player_Moves[0] != null ) )
        {
            return (this.player_Moves[0]);
        }
        else if ( ( this.players[1] == player ) && ( this.player_Moves[1] == null ) )
        {
            throw new Exception("Player has not played yet.");
        }
        else if ( ( this.players[1] == player ) && ( this.player_Moves[1] != null ) )
        {
            return (this.player_Moves[1]);
        }
        
        
        throw new Exception("Unknown error has occurred.");
    }
    
    /**
     * @description: ?
     * 
     * @return ?
     * @throws ?
     * @postcondition ?
     * @precondition ?
     */ 
    public ArrayList<Player> get_WaitingOn()
    {
        ArrayList<Player> result = new ArrayList<Player>();
        
        if ( ( this.player_Moves[0] == null ) )
        {
            result.add(this.players[0]);
        }
        if ( ( this.player_Moves[1] == null ) )
        {
            result.add(this.players[1]);
        }
        
        return result;
    }
    
    /**
     * @description: ?
     * 
     * @param player 
     * @return ?
     * @throws ?
     * @postcondition ?
     * @precondition ?
     */ 
    public Result get_PlayerResult(Player player) throws Exception
    {
        if      ( ( this.is_RoundComplete() == false ) )
        {
            throw new Exception("Round incomplete, results incaculable.");
        }
        else if ( ( this.is_Tie() == true ) )
        {
            return (Result.TIE);
        }
        else if ( ( this.is_Winner(player) == true ) )
        {
            return (Result.WIN);
        }
        // If round is complete, and not a winner or tie, then loser.
        else
        {
            return (Result.LOSE);
        }
    }
    
    /**
     * @description: ?
     * 
     * @param player 
     * @return ?
     * @throws ?
     * @postcondition ?
     * @precondition ?
     */   
    public String get_MoveTimes(Player player) throws Exception
    {
        if      ( ( this.players[0] == player ) && ( this.player_Moves[0] == null ) )
        {
            throw new Exception("Player has not played yet.");
        }
        else if ( ( this.players[0] == player ) && ( this.player_Moves[0] != null ) )
        {
            return (this.player_MoveTimes[0]);
        }
        else if ( ( this.players[1] == player ) && ( this.player_Moves[1] == null ) )
        {
            throw new Exception("Player has not played yet.");
        }
        else if ( ( this.players[1] == player ) && ( this.player_Moves[1] != null ) )
        {
            return (this.player_MoveTimes[1]);
        }
        
        
        throw new Exception("Unknown error has occurred.");
    }

    /**
     * @description: ?
     * 
     * @return ?
     * @throws ?
     * @postcondition ?
     * @precondition ?
     */   
    public Player get_Winner() throws Exception
    {
        if ( ( this.is_RoundComplete() == false ) )
        {
            throw new Exception("Round incomplete, winner incaculable.");
        }
        
        // Player 1 win sequences.
        if      ( ( ( this.player_Moves[0] == Play.ROCK ) && ( this.player_Moves[1] == Play.SCISSORS ) ) )
        {
            return (players[0]);
        }
        else if ( ( ( this.player_Moves[0] == Play.PAPER ) && ( this.player_Moves[1] == Play.ROCK ) ) )
        {
            return (players[0]);
        }
        else if ( ( ( this.player_Moves[0] == Play.SCISSORS ) && ( this.player_Moves[1] == Play.PAPER ) ) )
        {
            return (players[0]);
        }
        // Player 2 win sequences.
        else if ( ( ( this.player_Moves[0] == Play.ROCK ) && ( this.player_Moves[1] == Play.PAPER ) ) )
        {
            return (players[1]);
        }
        else if ( ( ( this.player_Moves[0] == Play.PAPER ) && ( this.player_Moves[1] == Play.SCISSORS ) ) )
        {
            return (players[1]);
        }
        else if ( ( ( this.player_Moves[0] == Play.SCISSORS ) && ( this.player_Moves[1] == Play.ROCK ) ) )
        {
            return (players[1]);
        }
        // Tie Game.
        else
        {
            return (null);
        }
    }
    
    /**
     * @description: ?
     * 
     * @return ?
     * @throws ?
     * @postcondition ?
     * @precondition ?
     */   
    public Player get_Loser() throws Exception
    {
        if      ( ( this.is_RoundComplete() == false ) )
        {
            throw new Exception("Round incomplete, loser incaculable.");
        }
        else if ( ( this.get_Winner() == null ) )
        {
            return (null);
        }
        else if ( ( this.get_Winner() == this.players[0] ) )
        {
            return (this.players[1]);
        }
        else
        {
            return (this.players[0]);
        }
    }
    
    /**
     * @description: ?
     * 
     * @param player 
     * @return ?
     * @throws ?
     * @postcondition ?
     * @precondition ?
     */   
    public boolean is_Winner(Player player) throws Exception
    {
        if      ( ( this.is_RoundComplete() == false ) )
        {
            throw new Exception("Round incomplete, winner incaculable.");
        }
        else if ( ( this.get_Winner() == player ) )
        {
            return (true);
        }
        else
        {
            return (false);
        }
    }
    
    /**
     * @description: ?
     * 
     * @param player 
     * @return ?
     * @throws ?
     * @postcondition ?
     * @precondition ?
     */   
    public boolean is_Loser(Player player) throws Exception
    {
        if      ( ( this.is_RoundComplete() == false ) )
        {
            throw new Exception("Round incomplete, loser incaculable.");
        }
        else if ( ( this.get_Loser() == player ) )
        {
            return (true);
        }
        else
        {
            return (false);
        }
    }
    
    /**
     * @description: ?
     * 
     * @return ?
     * @throws ?
     * @postcondition ?
     * @precondition ?
     */   
    public boolean is_Tie() throws Exception
    {
        if      ( (this.is_RoundComplete() == false) )
        {
            throw new Exception("Round incomplete, tie incaculable.");
        }
        else if ( ( this.player_Moves[0] == this.player_Moves[1] ) )
        {
            return (true);
        }
        else
        {
            return (false);
        }
    }
    
    /**
     * @description: ?
     * 
     * @return ?
     * @postcondition ?
     * @precondition ?
     */   
    public boolean is_RoundComplete()
    {
        if ( ( ( this.player_Moves[0] == null ) || ( this.player_Moves[1] == null) ) )
        {
            return (false);
        }
        else
        {
            return (true);
        }
    }
    
    private final Player[] players; // ?
    
    private Play[] player_Moves; // ?
    private String[] player_MoveTimes; // ?
}