/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbManager;

import implementacion.*;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import dBManager.DBManager;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author usuario
 */
public class DBManagerTest {

    DBManager db = new DBManager();

    //primer test de prueba
    @Test
    public void testAdd1Plus1() {
        int x = 1;
        int y = 1;
        assertEquals(2, (x + y));
    }

    //--------------------------------------Test de Login ------------------------------------------------------
    Login log = new Login();

    @Test
    public void testLogHash() throws NoSuchAlgorithmException, UnsupportedEncodingException {

        assertEquals("5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8", Login.hash("password").toLowerCase());
    }

    @Test
    public void testLoginAdmin() {
        String username = "admin";
        String password = "admin";
        LoginObjeto logobj = new LoginObjeto(10, "okadmin");

        try {
            assertEquals(logobj.getPass(), log.comprobarUserPassword(username, password).getPass());
        } catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testLoginUser() throws SQLException {
        Connection c = db.getConnection();
        c.setAutoCommit(false);
        String username = "FernandoTorrijos";
        String password = "password";
        
        Date date = new Date(1991/10/10);
        
        Usuario user = new Usuario(5000,0,null,null,null,null,date);
        DBManager.insertarUsuarios(user);
        DBManager.insertarTablaUserPassword(5000, username, password);
        
        LoginObjeto logobj = new LoginObjeto(10, "ok");
        try {
            assertEquals(logobj.getPass(), log.comprobarUserPassword(username, password).getPass());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        c.rollback();
        c.close();
    }

   

//-----------------------------------------TEST CORRESPONDIENTES A DB_Manager------------------------------------------------
//http://tutorials.jenkov.com/java-unit-testing/database-testing-crud.html    
}
