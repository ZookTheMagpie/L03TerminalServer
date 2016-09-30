package no.ntnu.berg;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This command returns the current server time for the server in the hours,
 * minutes format. The command doses currently not support any
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
     * Returns the current server time in Hours,minutes format.
     * Currently does not support any additional arguments.
     *
     * @param arguments additional arguments,currently not in use.
     * @return Returns the current server time in Hours,minutes format.
     */
    @Override
    public String process(String[] arguments)
    {
        DateFormat dataFormat = new SimpleDateFormat("HH:mm");
         Calendar calendar = Calendar.getInstance();

        String returnString = "The current server time is: " + dataFormat.format(calendar.getTime());
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
        String returnString = "This command displays the server time in the Hours Minutes format." + "\n" +
                              "Example: 'The current server time is: 09:19";
        
        return returnString;
    }

}

/**
 * 	   DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	   //get current date time with Date()
	   Date date = new Date();
	   System.out.println(dateFormat.format(date));

	   //get current date time with Calendar()
	   Calendar cal = Calendar.getInstance();
	   System.out.println(dateFormat.format(cal.getTime()));

 */