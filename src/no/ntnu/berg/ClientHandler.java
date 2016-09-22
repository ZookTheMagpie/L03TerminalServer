package no.ntnu.berg;

import java.io.*;
import java.net.*;

/**
 *
 * @author Alexander Eilert Berg
 */
public class ClientHandler extends Thread
{
   private Socket connection;

    public ClientHandler()
    {  
    }

   public void start()
   {
       String line , input = "";
       
       try 
       {
           //Get socket writing and reading streams
           DataInputStream messageIn = new 
       }
       
   }
}
            //Input and output streams
            messageOut = new PrintStream(connection.getOutputStream());
            messageOut.flush();
            messageIn = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
            messageOut.println("Welcome to the server!   ***Server Version 0.1***");
            messageOut.flush();


        