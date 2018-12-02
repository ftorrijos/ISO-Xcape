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
     *
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws SQLException, InterruptedException {
        System.out.println("Cargando App...\n");
        interfaz.InterfazGrafica.run();
        // interfaz.InterfazConsola.run();
        //System.out.println("Cerrando App...");

    }

}
