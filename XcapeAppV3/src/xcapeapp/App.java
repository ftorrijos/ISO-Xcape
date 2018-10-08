/*
Aplicación
 */
package xcapeapp;


import java.sql.SQLException;

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
        interfaz.InterfazConsola.run();
        System.out.println("Cerrando App...");

    }

}
