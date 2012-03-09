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
import net.heraan.Game.Play;
import net.heraan.Game.Result;
import net.heraan.Player.Player;

/**
 * @description An individual round as part of a game.
 * 
 * @author Robert Friedland
 * @documentor Quynhanh Nguyen
 * @version March 9, 2012 (1.0)
 */
public class Round
{
    // [BEGIN] Constructors Section [BEGIN]
    
    public Round()
    {
        players = new ArrayList<Player>();
        plays = new ArrayList<Play>();
    }
    
    public Round(ArrayList<Player> players)
    {
        this.set_Players(players);
        plays = new ArrayList<Play>();
    }
    
    public Round(ArrayList<Player> players, ArrayList<Play> plays)
    {
        this.set_Plays(players, plays);
    }
    
    // [ END ] Constructors Section [ END ]
    
    
    
    // [BEGIN] Setters Section [BEGIN]
    
    public void set_Play(Player player, Play play)
    {
        this.plays.add(play);
    }
    
    public void set_Plays(ArrayList<Player> players, ArrayList<Play> plays)
    {
        this.players = players;
        this.plays = plays;
    }
    
    public void set_Players(ArrayList<Player> players)
    {
        this.players = players;
    }
    
    public void add_Player(Player player)
    {
        this.players.add(player);
    }
    
    public void add_Players(ArrayList<Player> players)
    {
        // CODE
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    // [ END ] Setters Section [ END ]
    
    
    
    
    // [BEGIN] Getters Section [BEGIN]
    
    public Play get_Play(Player player)
    {
        if ( ( this.players.get(0) == player ) )
        {
            return (this.plays.get(0));
        }
        else
        {
            return (this.plays.get(1));
        }
    }
    
    public ArrayList<Player> get_Players()
    {
        return (this.players);
    }
    
    public ArrayList<Player> get_HasPlayedList()
    {
        // CODE
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public ArrayList<Player> get_HasNotPlayedList()
    {
        // CODE
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public Result get_PlayerResult(Player player)
    {
        if ( ( this.is_RoundComplete() == false ) )
        {
            return (null);
        }
        
        if ( ( this.is_Tie() == true ) )
        {
            return (Result.TIE);
        }
        else if ( ( this.get_Winner() == player ) )
        {
            return (Result.WIN);
        }
        else
        {
            return (Result.LOSE);
        }
    }
    
    public Player get_Winner()
    {
        // Round incomplete.
        if ( ( this.is_RoundComplete() == false ) )
        {
            return (null);
        }
        
        // Player 1 win sequences.
        if      ( ( this.plays.get(0) == Play.ROCK ) && ( this.plays.get(1) == Play.SCISSORS ) )
        {
            return (this.players.get(0));
        }
        else if ( ( this.plays.get(0) == Play.PAPER ) && ( this.plays.get(1) == Play.ROCK ) )
        {
            return (this.players.get(0));
        }
        else if ( ( this.plays.get(0) == Play.SCISSORS ) && ( this.plays.get(1) == Play.PAPER ) )
        {
            return (this.players.get(0));
        }
        // Player 2 win sequences.
        else if ( ( this.plays.get(1) == Play.ROCK ) && ( this.plays.get(0) == Play.SCISSORS ) )
        {
            return (this.players.get(1));
        }
        else if ( ( this.plays.get(1) == Play.PAPER ) && ( this.plays.get(0) == Play.ROCK ) )
        {
            return (this.players.get(1));
        }
        else if ( ( this.plays.get(1) == Play.SCISSORS ) && ( this.plays.get(0) == Play.PAPER ) )
        {
            return (this.players.get(1));
        }
        // Tie game.
        else
        {
            return (null);
        }
    }
    
    public Player get_Loser()
    {
        // CODE
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    // [ END ] Getters Section [ END ]
    
    
    
    // [BEGIN] Boolean Section [BEGIN]
    
    public boolean is_RoundComplete()
    {
        if ( (this.plays != null) && ( this.plays.size() == 2 ) )
        {
            return (true);
        }
        else
        {
            return (false);
        }
    }
    
    public boolean has_Played(Player player)
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public boolean is_Winner(Player player)
    {
        if ( ( this.get_Winner() == player ) )
        {
            return (true);
        }
        else
        {
            return (false);
        }
    }
    
    public boolean is_Loser(Player player)
    {
        // CODE
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public boolean is_Tie()
    {
        if      ( ( this.is_RoundComplete() == false ) )
        {
            return (false);
        }
        else if ( ( this.plays.get(0) == this.plays.get(1) ) )
        {
            return (true);
        }
        else
        {
            return (false);
        }
    }
    
    // [ END ] Boolean Section [ END ]

    
    
    // NOTE: These two lists are in order.
    private ArrayList<Player> players; // The players of this round.
    private ArrayList<Play> plays; // Player's moves.
}