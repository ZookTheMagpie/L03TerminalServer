package no.ntnu.berg;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A simple parser that cleans up a string and returns its components in an array.
 * 
 * @author Alexander Eilert Berg
 * @version 0.1
 */
public class Parser
{ 
    /**
     * Takes the user input and changes it to lower case, removes everything thats not the letters a-z, and separates the words and adds them to an array.
     * 
     * @param userInput
     * @return Returns an ArrayList with the cleaned and separated user input.
     */
     public ArrayList<String> clean(String userInput)
    {
        ArrayList<String> cleanedString = new ArrayList<>();
        
        String cleaning = userInput.toLowerCase().replaceAll("[^a-z]","");
        
        Pattern patteren = Pattern.compile(" (.*?) ");
        Matcher match = patteren.matcher(cleaning);
        
        int currentWords = 0;
        while(match.find() && currentWords <= 2)
        {
            cleanedString.add(match.group());
            currentWords ++;
        }
        
        return cleanedString;
    }
}
