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

package net.heraan.Player.AI.Personality;

import java.util.Random;
import net.heraan.Game.Play;
import net.heraan.Player.AI.AI_Strategy;

/**
 * @description Pseudo randomly chooses a play.
 * 
 * @author Robert Friedland
 * @documentor Robert Friedland
 * @version March 8, 2012 (1.0)
 */
public class Personality_Random implements AI_Strategy
{
    /**
     * @description Calculates and returns a play pseudo randomly. 
     * 
     * @return A play choice that is pseudo randomly picked.
     * @precondition None.
     * @postcondition Returns a pseudo randomly chosen Play.
     */
    @Override
    public Play calculate_play()
    {
        int unique_plays = Play.values().length;
        
        Random play_chooser = new Random();
        
        int play_integer = play_chooser.nextInt(unique_plays);
        
        if      ( ( play_integer == 0 ) )
        {
            return (Play.PAPER);
        }
        else if ( (play_integer == 1 ) )
        {
            return (Play.ROCK);
        }
        else
        {
            return (Play.SCISSORS);
        }
    }
}