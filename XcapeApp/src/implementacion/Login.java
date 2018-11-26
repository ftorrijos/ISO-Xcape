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

    LoginObjeto log = new LoginObjeto();

    public LoginObjeto comprobacion() throws NoSuchAlgorithmException, UnsupportedEncodingException, SQLException {

        System.out.println("Por favor introducir el nombre del usuario");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        System.out.println("Por favor introducir el password del usuario:");
        String password = sc.nextLine();

        return comprobarUserPassword(username, password);

    }

    public LoginObjeto comprobarUserPassword(String username, String password) throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException {
        DBManager db = new DBManager();
        String dbPass = db.selectPasswordUsuario(username);
        String passHash = hash(password);

        if (username.equals("admin") && dbPass.equalsIgnoreCase(passHash)) {
            log.setUsuario_id(db.selectIDUsuario(username));
            log.setPass("okadmin");
            return log;
        } else if (dbPass == null) {
            System.out.println("ACCESSS DENIED BITCH*S");
            log.setUsuario_id(0);
            log.setPass("nook");
            comprobacion();
            return log;

        } else if (dbPass.equalsIgnoreCase(passHash)) {
            //////-----------------ERROR SI NO EXISTE LA BASE DE DATOS DA NULL Y FALLA
            log.setUsuario_id(db.selectIDUsuario(username));
            log.setPass("ok");
            return log;
        } else {
            return null;
        }

    }

    public static String hash(String pass) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
        msdDigest.update(pass.getBytes("UTF-8"), 0, pass.length());
        pass = DatatypeConverter.printHexBinary(msdDigest.digest());

        return pass;
    }

}
