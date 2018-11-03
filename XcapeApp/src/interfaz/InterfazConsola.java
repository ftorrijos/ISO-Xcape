/*
Interfaz
 */
package interfaz;

import implementacion.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro Gutiérrez <agutierrezvivancos@gmail.com>
 */
public class InterfazConsola {
    public static void run(){
           try {
            Login log = new Login();
          log.comprobacion();
          Boolean x = log.comprobacion();
          
          if(x.booleanValue()){
          implementacion.Menu.run();
          }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(InterfazConsola.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(InterfazConsola.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InterfazConsola.class.getName()).log(Level.SEVERE, null, ex);
        }


    
    
    }
            

            }