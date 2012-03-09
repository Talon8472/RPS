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
import net.heraan.Player.Player;

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
    
    public Game()
    {   
        this.players = new ArrayList<Player>();
        
        this.rounds = new ArrayList<Round>();
        this.rounds.add(new Round(this.players));
    }
    
    public Game(ArrayList<Player> players)
    {   
        this.players = players;
        
        this.rounds = new ArrayList<Round>();
        this.rounds.add(new Round(this.players));
    }
    
    // [ END ] Constructors Section [ END ]
    
    
    
    // [BEGIN] Setters Section [BEGIN]
    
    public void set_Play(Player player, Play play)
    {
        if ( ( this.get_CurrentRound().is_RoundComplete() == true ) )
        {
            this.rounds.add(new Round(this.players));
            this.set_Play(player, play);
        }
        else
        {
            this.get_CurrentRound().set_Play(player, play);
        }
    }
    
    // [ END ] Setters Section [ END ]
    
    
    
    // [BEGIN] Getters Section [BEGIN]
    
    public ArrayList<Player> get_Players()
    {
        return (this.players);
    }
    
    public ArrayList<Round> get_Rounds()
    {
        return (this.rounds);
    }
    
    public int get_CurrentRoundNumber()
    {
        return (this.rounds.size());
    }
    
    public Round get_CurrentRound()
    {
        return (this.rounds.get(this.get_CurrentRoundNumber()-1));
    }
    
    public Result get_PlayerResult(Player player)
    {   
        if      ( ( this.is_Tie() ) )
        {
            return (Result.TIE);
        }
        else if ( ( this.is_Winner(player) == true ) )
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
        int wins = 0;
        int ties = 0;
        int loses = 0;
        
        for (Round round : this.rounds)
        {
            if      ( ( round.is_Tie() == true ) )
            {
                ties++;
            }
            else if ( ( round.is_Winner(this.players.get(0)) == true ) )
            {
                wins++;
            }
            else
            {
                loses++;
            }            
        }
        
        if      ( ( wins == loses ) )
        {
            return (null);
        }
        else if ( ( wins > loses ) )
        {
            return (this.players.get(0));
        }
        else
        {
            return (this.players.get(1));
        }
    }
    
    public Player get_Loser()
    {
        // CODE
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    // [ END ] Getters Section [ END ]
    
    
    
    // [BEGIN] Boolean Section [BEGIN]
    
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
        int wins = 0;
        int ties = 0;
        int loses = 0;
        
        for (Round round : this.rounds)
        {
            if      ( ( round.is_Tie() == true ) )
            {
                ties++;
            }
            else if ( ( round.is_Winner(this.players.get(0)) == true ) )
            {
                wins++;
            }
            else
            {
                loses++;
            }            
        }
        
        if      ( ( wins == loses ) )
        {
            return (true);
        }
        else
        {
            return (false);
        }
    }
    
    // [ END ] Boolean Section [ END ]
    
    
    
    public enum Result {WIN, LOSE, TIE}
    public enum Play {ROCK, PAPER, SCISSORS}
    

    private ArrayList<Player> players;    
    private ArrayList<Round> rounds;
}