package no.ntnu.berg;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Client handler is responsible for handling the client.
 * When a client is received it is given a welcome message and a menu with available commands to choose from. 
 * 
 * @author Alexander Eilert Berg
 */
public class ClientHandler extends Thread
{

    private Socket connection;
    DataInputStream messageIn;
    PrintStream messageOut;

    /**
     * Receives the client connection and tires to create input and output streams with it.  
     * @param incomingConnection 
     */
    public ClientHandler(Socket incomingConnection)
    {
        this.connection = incomingConnection;

        //Get socket writing and reading streams
        try
        {
            this.messageIn = new DataInputStream(connection.getInputStream());
        } catch (IOException ex)
        {
            System.err.println("Unable to get input stream: " + ex);
        }
        try
        {
            this.messageOut = new PrintStream(connection.getOutputStream());
        } catch (IOException ex)
        {
            System.err.println("Unable to get output stream: " + ex);
        }
    }

    /**
     * Runs the client handler
     */
    public void run()
    {
        String line, input = "";

        try
        {
            //Sending welcome message
            welcomeMessage();

            //User Interface
            while ((line = messageIn.readLine()) != null && !line.equals("."))
            {

            }

            // Client disconnected, close socket
            connection.close();

        } catch (IOException ex)
        {
            System.out.println("IOException on sockek: " + ex);
            ex.printStackTrace();
        }

    }

    /**
     * Prints out the welcome message to the client
     */
    private void welcomeMessage()
    {
        messageOut.println("                Welcome to the server!   ***Server Version 0.1***");
        messageOut.println("Please use the commands below, use Help to dispaly more informatio, use Quit to exit the server");
    }
    
    /**
     * Prints out the command menu for the user
     */
    private void showMenu()
    {
        messageOut.println();
        messageOut.println("Commands: ");
        messageOut.println("Time");
        messageOut.println("Weather");
        messageOut.println("Command");
        messageOut.println("Help");
        messageOut.println("Quit");
        messageOut.println();
    }
}
