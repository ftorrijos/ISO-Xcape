/*
Interfaz
 */
package interfaz;

import implementacion.*;
import java.io.IOException;
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

    public static void run() throws SQLException {
        try {
            login();
            // Menu.run();
        } catch (IOException ex) {
            Logger.getLogger(InterfazConsola.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void login() throws IOException {
        try {
            Login log = new Login();
          // log.comprobacion();
           String x = log.comprobacion();

            if (x.equalsIgnoreCase("okadmin")){
                Menu.run();
            }else if(x.equalsIgnoreCase("ok")){
                MenuAdmin ma = new MenuAdmin();
                ma.Menuadmin();
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | SQLException ex) {
            Logger.getLogger(InterfazConsola.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
