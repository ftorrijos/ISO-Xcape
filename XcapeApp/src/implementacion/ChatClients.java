/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author usuario
 */
public class ChatClients {
    public static void main(String args[]) throws Exception
	{
		Socket sk=new Socket("127.0.0.1",5000);
		BufferedReader sin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintStream sout=new PrintStream(sk.getOutputStream());
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while (  true )
		{
			System.out.print("Client : ");
			s=stdin.readLine();
			sout.println(s);
                        if ( s.equalsIgnoreCase("BYE") )
                        {
                           System.out.println("Connection ended by client");
 			   break;
                        }
			s=sin.readLine();
			System.out.print("Server : "+s+"\n");
  			
		}
		 sk.close();
		 sin.close();
		 sout.close();
 		stdin.close();
	}
    
}
