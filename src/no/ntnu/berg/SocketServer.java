package no.ntnu.berg;

import java.io.*;
import java.net.*;

/**
 * The socket server waits for an connection with a client before sending the client to the client handler.
 * The server can handle multiple clients.
 * 
 * @author Alexander Eilert Berg
 * @version 0.1
 */
public class SocketServer
{

    /**
     * Starts the server. 
     * Creates the sockets for the server and the connection with the clients.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ServerSocket socket = null;
        Socket connection = null;

        try
        {
            //Creates server socket (port, backlog)
            socket = new ServerSocket(5000, 10);

            //Waiting for connection
            echo("Server socket created. Waiting for connection...");

            while (true)
            {
                //Get the connection socket
                connection = socket.accept();

                //Printing hostname and portnumber
                echo("Connection recived from " + connection.getInetAddress().getHostAddress() + " : " + connection.getPort());

                //Create a new thread to handle client
                new ClientHandler(connection).start();
            }

        } catch (IOException ex)
        {
            System.err.println("Encountered an erreor " + ex.getMessage());
        }

        //Closeing the connection and stream
        try
        {
            socket.close();
        } catch (IOException ex)
        {
            System.err.println("Unable to close connection " + ex.getMessage());
        }
    }

    /**
     * Prints the received string
     * 
     * @param message 
     */
    public static void echo(String message)
    {
        System.out.println(message);
    }
}
