/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import dBManager.DBManager;
import java.io.Console;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;
import static jdk.nashorn.tools.ShellFunctions.input;

/**
 *
 * @author Alejandro
 */
public class Login {

  
   public Boolean comprobacion() throws NoSuchAlgorithmException, UnsupportedEncodingException, SQLException {
      
      
        Boolean ok = true;
        Boolean nook = false;
        
        
        System.out.println("Porfavor introducir el nombre del usuario:");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        System.out.println("Porfavor introducir el password del usuario:");
        String password = sc.nextLine();
        String passHash = hash(password);
        String dbPass =   dBManager.DBManager.selectPasswordUsuario(username);
        System.out.println(dbPass);
        return null ;
        
       
    }
    private String hash(String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
        msdDigest.update(pass.getBytes("UTF-8"), 0, pass.length());
        pass = DatatypeConverter.printHexBinary(msdDigest.digest());

        return pass;
} 
     
            
           
}
