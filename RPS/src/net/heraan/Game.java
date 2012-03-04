package net.heraan;

import java.util.ArrayList;

/**
 * @description: ?
 * 
 * @author Robert Friedland
 * @version March 3, 2012 
 */
public class Game
{
    /**
     * @description: ?
     * 
     * @precondition ?
     * @postcondition ?
     */
    public Game()
    {
        // CODE
    }

    /**
     * @description: ?
     * 
     * @param rounds the number of rounds to be played. [Size = 1 ... 50]
     * @param players the two players who will be playing this game. [Size = 2]
     * @precondition ?
     * @postcondition ?
     */
    public Game(int rounds, Player[] players)
    {
        this.rounds = rounds;
        this.players = players;
    }
    
    /**
     * @description: ?
     * 
     * @param player "0" is the first player, "1" is the second player.
     * @param play "rock", "paper", "scissors"
     * @precondition ?
     * @postcondition ?
     */    
    public void play(Player player, Play move)
    {
        if ( this.is_GameOver() == false )
        {
            // CODE
            
        }
        else
        {
            // CODE
        }
    }
    
    
    public int get_currentRound()
    {
        return 0;
    }
    
    public boolean is_GameOver()
    {
        return false;
    }


    private enum Result {WIN, LOSE, TIE}
    public enum Play {ROCK, PAPER, SCISSORS}
    
    private final int rounds;
    private final Player[] players;
    
    private ArrayList<Round> RoundResults;
    
   /**
    * @description: ?
    * 
    * @author Robert Friedland
    * @version March 3, 2012 
    */
    private class Round
    {
        // CODE
        
        public Round()
        {
            // CODE
        }
    }
}