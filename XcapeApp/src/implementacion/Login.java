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
import modelo.LoginObjeto;

/**
 *
 * @author Alejandro
 */
public class Login {

    public LoginObjeto comprobacion() throws NoSuchAlgorithmException, UnsupportedEncodingException, SQLException {

        DBManager db = new DBManager();
        LoginObjeto log = new LoginObjeto();
     
            
        System.out.println("Por favor introducir el nombre del usuario");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        System.out.println("Por favor introducir el password del usuario:");
        String password = sc.nextLine();
        String passHash = hash(password);
        String dbPass = db.selectPasswordUsuario(username);
        // System.out.println(passHash);
        //System.out.println(dbPass);
        if (username.equals("admin") && dbPass.equalsIgnoreCase(passHash)) {
            log.setUsuario_id(db.selectIDUsuario(username));
            log.setPass("okadmin");
            return log;
        } else if (dbPass.equalsIgnoreCase(passHash)) {
            log.setUsuario_id(db.selectIDUsuario(username));
            log.setPass("ok");
            return log;
        } else {
            System.out.println("ACCESSS DENIED BITCH*S");
            comprobacion();
            log.setUsuario_id(0);
            log.setPass("nook");
            return log;
        }
    }

    public static String hash(String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
        msdDigest.update(pass.getBytes("UTF-8"), 0, pass.length());
        pass = DatatypeConverter.printHexBinary(msdDigest.digest());

        return pass;
    }

}
