/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.berg;

/**
 *
 * @author Alexander Eilert Berg
 */
public class HelpCommand implements CommandWord
{
    @Override
    public String getName()
    {
        return "Help"; 
    }

    @Override
    public String process(String[] arguments)
    {
        
    }

    @Override
    public String getShortDesc()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLongDesc()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
