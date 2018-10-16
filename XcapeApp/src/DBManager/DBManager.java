/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando Torrijos
 */
public class DBManager {

    public DBManager() {

    }

    public static Connection getConnection() {
        //Interfaz Connection
        //System.out.println("Aqui llegamos ?");
        String usuario = "root";
        String clave = "179350";
        String driver = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/dbx";

        Connection connection = null;

        try {
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(URL, usuario, clave);
            System.out.println("Conexión establecida con éxito\n");
            return connection;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
        }
        return null;
    }

    public void cerrarConexion(Connection conector) {
        try {
            conector.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void insertarUsuarios(String nombre){
        Connection c = DBManager.getConnection();
            try {
            String sql = "INSERT INTO usuarios(nombre) VALUES(?)";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setString(1, nombre);
            prep.executeUpdate();
            prep.close();
             
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
			
    }
}
