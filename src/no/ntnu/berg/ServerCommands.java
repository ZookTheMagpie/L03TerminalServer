package no.ntnu.berg;

import java.util.List;

/**
 *
 * @author Alexander Eilert Berg
 */
public class ServerCommands
{
    //Contains an array of all commands
    private String[] validCommands =
    {"time","help","command","weather"};
    
    /*
    * Generates the implimented commnds  
    */
    public ServerCommands()
    {
        HelpCommand help = new HelpCommand();
        TimeCommand time = new TimeCommand();
        CommandCommand addCommand = new CommandCommand();
        WeatherCommand weather = new WeatherCommand();
    }
    

    public List getAllValidCommands()
    {
        return validCommands;
    }
    
    public boolean checkIfValid()
    {
        boolean valid = false;
        
        
        
        return valid;
    }
    
    public String cleanUpInCommand(String inCommand)
    {
        return cleanInString
    }

}
