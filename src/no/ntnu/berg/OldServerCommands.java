package no.ntnu.berg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * This class takes the users input and check if it contains a command, if it
 * does it executes that command.
 *
 * @author Alexander Eilert Berg
 * @version 0.1
 */
public class OldServerCommands
{
    //Contains a map of the avalible commands mapped to their name in a string.
    private HashMap<String, CommandWord> commands;
    //Contains the user input after formatting.
    private ArrayList<String> cleanInput;

    /*
    * Generates the basic commands and adds them to the commands list.  
     */
    public OldServerCommands()
    {
        this.commands = new HashMap<>();
        this.cleanInput = new ArrayList<>();
        HelpCommand helpCommand = new HelpCommand();
        TimeCommand timeCommand = new TimeCommand();
        AddCommand addCommand = new AddCommand();
        WeatherCommand weatherCommand = new WeatherCommand();

        commands.put("help", helpCommand);
        commands.put("time", timeCommand);
        commands.put("add", addCommand);
        commands.put("weather", weatherCommand);
    }

    public String executeCommand(String Userinput)
    {
        String returnString = "executed";

      //  cleanInput(Userinput);
        if (!checkIfValid())
        {
            returnString = "error";
        } else if ("quit".equals(cleanInput.get(0)))
        {
            returnString = "quit";
        } else
        {
            Set<String> keySet = commands.keySet();
            Iterator keySetIterator = keySet.iterator();
            while (keySetIterator.hasNext())
            {
                Iterator inputIterator = cleanInput.iterator();
                while (inputIterator.hasNext())
                {
                    if (commands.containsKey(inputIterator.next()))
                    {
                        returnString = commands.get(inputIterator).process(cleanInput);                                                                
                    }
                }
            }
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
    private boolean checkIfValid()
    {
        boolean valid = false;
        Set<String> keySet = commands.keySet();
        Iterator keySetIterator = keySet.iterator();
        while (keySetIterator.hasNext())
        {
            Iterator inputIterator = cleanInput.iterator();
            while (inputIterator.hasNext())
            {
                if (commands.containsKey(inputIterator.next()))
                {
                    valid = true;
                }
            }
        }
        return valid;
    }

    /**
     * Takes the input string and cleans it up.
     *
     * @param input
     */
    private void cleanInput(String input)
    {
        Parser cleaner = new Parser();
        this.cleanInput = cleaner.clean(input);
    }
}
