package no.ntnu.berg;

import java.io.*;
import java.net.*;

/**
 *
 * @author Alexander Eilert Berg
 */
public class SocketServer
{

    /**
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

    public static void echo(String message)
    {
        System.out.println(message);
    }
}
