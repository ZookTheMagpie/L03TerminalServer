package no.ntnu.berg;

import java.util.HashMap;

/**
 *
 * @author Alexander Eilert Berg
 */
public class HelpCommand implements CommandWord
{

    private HashMap availableCommands;

    @Override
    public String getName()
    {
        return "Help";
    }

    /**
     * Returns a string containing the help message. If the command had an
     * argument(another command),it will return the long description of that
     * command. If no extra argument was given it will return a list of the
     * current available commands.
     *
     * @param arguments
     * @return Returns a string with the help message.
     */
    @Override
    public String process(String[] arguments)
    {
        
    }

    @Override
    public String getShortDesc()
    {
        String returnString = "These are the available commands :" + "\n";
    
        return returnString;
    }

    @Override
    public String getLongDesc()
    {
        
    }

    void storeCommands(HashMap<String, CommandWord> commands)
    {
        this.availableCommands = new HashMap<>();
        commands = this.availableCommands;
    }
}
