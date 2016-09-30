package no.ntnu.berg;

import java.io.*;
import java.net.*;

/**
 * This command returns the weather report from the default area (Aalesund).  
 * 
 * @author Alexander Eilert Berg
 * @version 0.1
 */
class WeatherCommand implements CommandWord
{

    /**
     * Returns the name of the command
     *
     * @return Returns the name of the command
     */
    @Override
    public String getName(
    {
        return "Weather"; 
    }

    @Override
    public String process(String[] arguments)
    {
        Socket socket = new Socket();
        String host = "http://www.yr.no/place/Norway/M%C3%B8re_og_Romsdal/%C3%85lesund/%C3%85lesund/";
        PrintWriter messageOut = null;
        BufferedReader messageIn = null;
        
        try 
        {
            socket.connect(new InetSocketAddress(host, 80));
            System.out.println("Connected");
            
            //Writer for socket
            messageOut = new PrintWriter(socket.getOutputStream(), true);
            //Reader for socket
            messageIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (UnknownHostException ex)
        {
            System.err.println("Unknown host : " + host);
            System.exit(1);
        } catch (IOException ex)
        {
            System.err.println("An error has occured :" + ex);
        }
        
        //Sends a message to the server
        String message = "GET / HTTP/1.1\r\n\r\n";
        messageOut.println(message);
        
        System.out.println("Message sent");
        
        //Get response from server
        String response;
        String returnString = "Weather report: " + "\n";
        try
        {
            while ((response = messageIn.readLine()) != null)            
            {
                returnString = returnString + response;
            }
        } catch (IOException ex)
        {
            System.err.println("An error has occured :" + ex);
        }
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
        String returnString = "The weather command returns the local weather report.";
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
        String returnString = "The weather command returns the local weather report, by default the weather report is from Aalesund." + "\n" + 
                              "You can add the name of an area as an argument in the form of 'weather istanbul' by doing this you'll receive the weather report from that area. (Not implimented)";
        return returnString;
    }
    
}
