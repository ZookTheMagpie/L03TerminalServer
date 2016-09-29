package no.ntnu.berg;

import java.io.*;
import java.net.*;

/**
 * The Client handler is responsible for handling the client. When a client is
 * received it is given a welcome message and a menu with available commands to
 * choose from.
 *
 * @author Alexander Eilert Berg
 */
public class ClientHandler extends Thread
{

    private Socket connection;
    InputStream messageIn;
    PrintStream messageOut;

    /**
     * Receives the client connection and tires to create input and output
     * streams with it.
     *
     * @param incomingConnection
     */
    public ClientHandler(Socket incomingConnection)
    {
        this.connection = incomingConnection;

        //Create commands
        ServerCommands command = new ServerCommands();

        //Get socket writing and reading streams
        try
        {
            this.messageIn = connection.getInputStream();
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
    @Override
    public void run()
    {
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(messageIn));
        ServerCommands command = new ServerCommands();
        try
        {
            //Sending welcome message
            welcomeMessage();
            showMenu();
            boolean running = true;
            //User Interface
            while (running)
            {
                line = reader.readLine();
                if (line != null)
                {
                    String returnCommandString = command.executeCommand(line);
                    System.out.println("Output : " + returnCommandString);
                    if (returnCommandString.contains("quit"))
                    {
                        messageOut.println("Farewell");
                        running = false;
                    } else if (returnCommandString.contains("error"))
                    {
                        invalidInputMessage();
                    } else
                    {
                        messageOut.println(returnCommandString);
                    }
                }
                //   messageOut.println("I got : " + line);
            }

            //Client disconnected, close socket
            connection.close();

        } catch (IOException ex)
        {
            System.out.println("IOException on socket: " + ex);
        }
    }

    /**
     * Prints out the welcome message to the client
     */
    private void welcomeMessage()
    {
        messageOut.println("Welcome to the server!   ***Server Version 0.1***");
        messageOut.println("Created by Alexander Eilert Berg");
        messageOut.println();
        messageOut.println("Please use the commands below and use one command at a time");
        messageOut.println("use 'help' to dispaly more information, type 'quit' to exit the server");
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

    /**
     * prints a short message to the user, informing them that the string was
     * invalid. Lists suggestions for correcting the error
     */
    private void invalidInputMessage()
    {
        messageOut.println("Your commands were invalid, please try again!");
        messageOut.println("\n" + "Here are some suggestions for writing the commands: " + "\n");
        messageOut.println("Try using only small letters and with have a space between each word" + "\n"
                + "Try typing help to see the avalible commands and their valid arguments" + "\n"
                + "If you type 'help' and then another commandword you will get a more detailed description of that command" + "\n"
                + "Please try again and, thank you for your patience");
    }
}
