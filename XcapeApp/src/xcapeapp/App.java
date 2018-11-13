/*
Aplicación
 */
package xcapeapp;


import dBManager.DBManager;
import implementacion.Login;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro Gutiérrez <agutierrezvivancos@gmail.com>
 */
public class App {

    /**
     * En esta clase se arranca la App Cargamos la interfaz correspondiente y
     * pasamos un objeto modificable
     *
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {

            System.out.println("Cargando App...\n");
<<<<<<< HEAD
           interfaz.InterfazGrafica.run();
           //interfaz.InterfazConsola.run();
=======
         //    interfaz.InterfazGrafica.run();
           interfaz.InterfazConsola.run();
>>>>>>> 79139bc59e2b4934082371b215144d90877924ea
           
           System.out.println("Cerrando App...");
      
    }

}
