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

package net.heraan.Player.AI;

import net.heraan.Game.Play;
import net.heraan.Player.Player;

/**
 * @description ?
 * 
 * @author Robert Friedland
 * @documentor Quynhanh Nguyen
 * @version March 4, 2012
 */
public final class AI extends Player
{
    // [BEGIN] Constructors [BEGIN]
    
    /**
     * @description: ?
     * 
     * @param ?
     * @postcondition ?
     * @precondition ?
     */
    public AI() {}
    
    public AI(String nickname)
    {
        super.set_Nickname(nickname);
    }
    
    /**
     * @description: ?
     * 
     * @param mind ?
     * @postcondition ?
     * @precondition ?
     */
    public AI(AI_Strategy mind)
    {
        this.set_Strategy(mind);
    }
    
    /**
     * @description: ?
     * 
     * @param nickname ?
     * @param mind ?
     * @postcondition ?
     * @precondition ?
     */
    public AI(String nickname, AI_Strategy mind)
    {
        super.set_Nickname(nickname);
        
        this.set_Strategy(mind);
    }
    
    // [ END ] Constructors [ END ]
    
    /**
     * @description: ?
     * 
     * @return ?
     * @postcondition ?
     * @precondition ?
     */
    public Play play()
    {
        return (mind.calculate_play());
    }
    
    /**
     * @description: ?
     * 
     * @param mind ?
     * @postcondition ?
     * @precondition ?
     */
    public void set_Strategy(AI_Strategy mind)
    {
        this.mind = mind;
    }
    
    /**
     * @description: ?
     * 
     * @return ?
     * @postcondition ?
     * @precondition ?
     */
    public AI_Strategy get_Strategy()
    {
        return (this.mind);
    }
    
    private AI_Strategy mind = null; // ?
    
    
    // [BEGIN] IGNORE: Version 2.0 Stuff [BEGIN]
    
    @Override
    public void import_Player()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void export_Player()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    // [ END ] IGNORE: Version 2.0 Stuff [ EMD ]
}