/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import dBManager.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Alejandro
 */
public class Login {

    public String comprobacion() throws NoSuchAlgorithmException, UnsupportedEncodingException, SQLException {

        DBManager db = new DBManager();
        Boolean ok = true;
        Boolean nook = false;

        System.out.println("Por favor introducir el nombre del usuario:");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        System.out.println("Por favor introducir el password del usuario:");
        String password = sc.nextLine();
        String passHash = hash(password);
        String dbPass = db.selectPasswordUsuario(username);
        // System.out.println(passHash);
        //System.out.println(dbPass);
        if (dbPass.equalsIgnoreCase(passHash)) {
            return "ok";
        } else if(username=="admin" && dbPass.equals(passHash)){
            return "okadmin";
        }else {
            System.out.println("ACCESSS DENIED BITCH*S");
            comprobacion();
            return "nook";
        }
    }

    private String hash(String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
        msdDigest.update(pass.getBytes("UTF-8"), 0, pass.length());
        pass = DatatypeConverter.printHexBinary(msdDigest.digest());

        return pass;
    }

}
