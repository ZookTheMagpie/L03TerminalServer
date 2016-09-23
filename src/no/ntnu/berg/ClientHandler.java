package no.ntnu.berg;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexander Eilert Berg
 */
public class ClientHandler extends Thread
{
   private Socket connection;

    public ClientHandler(Socket incomingConnection)
    {  
      this.connection = incomingConnection;
    }

   public void run()
   {
       String line , input = "";
       
       try 
       {
           //Get socket writing and reading streams
           DataInputStream messageIn = new DataInputStream(connection.getInputStream());
           PrintStream messageOut = new PrintStream(connection.getOutputStream());
           
           //Sending welcome
           messageOut.println("Welcome to the server!   ***Server Version 0.1***");
           
           //Reading input from client
           while((line = messageIn.readLine()) != null && !line.equals("."))
           {
               //Test reply with the same message
               messageOut.println("I got: " + line);
           }
           
           // Client disconnected, close socket
           connection.close();
          
       } catch (IOException ex)
       {
           System.out.println("IOException on sockek: " + ex);
           ex.printStackTrace();
       }
       
   }
}