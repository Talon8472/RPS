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

/**
 * @description ?
 * 
 * @author Robert Friedland
 * @version March 4, 2012
 */
public class Human extends Player
{
    // [BEGIN] Constructors [BEGIN]
    public Human()
    {
        // CODE
    }
    
    // [ END ] Constructors [ END ]
    
    public void save()
    {
        // CODE
    }
    
    // [BEGIN] Name Handling [BEGIN]
    
    public void set_FirstName(String first_name)
    {
        this.human_first_name = first_name;
    }
    
    public void set_LastName(String last_name)
    {
        this.human_last_name = last_name;
    }
    
    public String get_FirstName()
    {
        return (this.human_first_name);
    }
    
    public String get_LastName()
    {
        return (this.human_last_name);
    }
    
    // [ END ] Name Handling [ END ]

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
    
    private String human_first_name;
    private String human_last_name;
}