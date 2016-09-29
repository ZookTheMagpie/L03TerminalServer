package no.ntnu.berg;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import static javafx.util.Duration.millis;

/**
 * This command returns the current server time for the server in the hours,
 * minutes, seconds format. The command doses currently not support any
 * additional arguments.
 *
 * @author Alexander Eilert Berg
 * @version 0.1
 */
class TimeCommand implements CommandWord
{

    /**
     * Returns the name of the command
     *
     * @return Returns the name of the command
     */
    @Override
    public String getName()
    {
        String returnString = "Time";
        return returnString;
    }

    /**
     * Returns the current server time in Hours,minutes,seconds format.
     * Currently does not support any additional arguments.
     *
     * @param arguments additional arguments,currently not in use.
     * @return Returns the current server time in Hours,minutes,seconds format.
     */
    @Override
    public String process(String[] arguments)
    {
        Long millis = System.currentTimeMillis();

        String time = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis)
                - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                TimeUnit.MILLISECONDS.toSeconds(millis)
                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
        String returnString = "The current server time is: " + time;
        return returnString;
    }

    /**
     * Returns a short description of the command
     *
     * @return Returns a short description of the command
     */
    @Override
    public String getShortDesc()
    {
        String returnString = "The time command displays the current server time";
        return returnString;
    }

    /**
     * Returns a long description of the command
     *
     * @return Returns a long description of the command
     */
    @Override
    public String getLongDesc()
    {
        String returnString = "This command displays the server time in the Hours Minutes Secounds format";
        return returnString;
    }

}
