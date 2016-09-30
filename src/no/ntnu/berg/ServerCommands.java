package no.ntnu.berg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * This class takes the users input and check if it contains a command, if it
 * does it executes that command.
 *
 * @author Alexander Eilert Berg
 * @version 0.1
 */
public class ServerCommands
{

    //Contains a map of the avalible commands mapped to their name in a string.
    private HashMap<String, CommandWord> commands;

    /*
    * Generates the basic commands and adds them to the commands list.  
     */
    public ServerCommands()
    {
        this.commands = new HashMap<>();
        HelpCommand helpCommand = new HelpCommand();
        TimeCommand timeCommand = new TimeCommand();
       // WeatherCommand weatherCommand = new WeatherCommand();

        commands.put("help", helpCommand);
        commands.put("time", timeCommand);
       // commands.put("weather", weatherCommand);
        
        helpCommand.storeCommands(commands);
    }

    public String executeCommand(String userInput)
    {
        String returnString = "";
        CommandParser cleanUserInput = new CommandParser(userInput);

        if (!checkIfValid(cleanUserInput.getName()))
        {
            returnString = "invalid";
        } else if (cleanUserInput.getName().equals("quit")) //TODO: FIX THIS!!!!
        {
            returnString = "quit";
        } else
        {
            returnString = commands.get(cleanUserInput.getName()).process(cleanUserInput.getArgArray());
        }
        return returnString;
    }

    /*
     * Returns a string containing all commands
     *
     * @return Returns a string containing all commands
     */
    public String getAllValidCommands()
    {
        String validCommands = "The valid commands are: " + "\n";
        for (String key : commands.keySet())
        {
            validCommands = validCommands + key + "\n";
        }
        return validCommands;
    }

    /**
     * Checks if clean command is valid, returns true if input is a command or
     * false if not.
     *
     * @param input
     * @return Returns true if command valid or false if not.
     */
    private boolean checkIfValid(String command)
    {
        boolean valid = false;
        if (commands.get(command) != null)
        {
            valid = true;
        }
        return valid;
    }

}
