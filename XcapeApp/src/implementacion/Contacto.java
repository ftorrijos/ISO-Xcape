/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import dBManager.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.*;

/**
 *
 * @author Alejandro Gutiérrez <agutierrezvivancos@gmail.com>
 */
public class Contacto {



    public Contacto() {

    }
    /**
     *
     * @throws SQLException
     */
    public static Connection c = DBManager.getConnection();
    
    public static void listarUsuarios() throws SQLException {

        try {
            Statement stmt3 = c.createStatement();
            String sql3 = "SELECT * FROM usuarios;";		
            ResultSet rs = stmt3.executeQuery(sql3);
            System.out.println("Lista de Usuarios: ");

            while (rs.next()) {
                int usuario_id = rs.getInt("usuario_id");
                String nombre = rs.getString("nombre");
                Usuario usuario = new Usuario(usuario_id, nombre);
                System.out.println(usuario);
            }
            rs.close();
            stmt3.close();

        } catch (SQLException e) {
        }

    }

    
     public String listarGruposSoloNombre(int id_grupo) throws SQLException{

            String sql = "SELECT nombre FROM grupo WHERE grupo_id=?;";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setInt(1, id_grupo);
            ResultSet rs = prep.executeQuery();
            while(rs.next()){
            String nombre = rs.getString("nombre");
            return nombre;
            }
            
            rs.close();
            prep.close();

            return null;
        
        }
   
    
    
    public static void listarResponsables() throws SQLException {

        try {
            Statement stmt5 = c.createStatement();
            String sql5 = "SELECT * FROM responsables;";		
            ResultSet rs = stmt5.executeQuery(sql5);
            System.out.println("Lista de Usuarios: ");
            
            while (rs.next()) {
                int responsable_id = rs.getInt("responsable_id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int movil = rs.getInt("movil");
                Responsable respon = new Responsable(responsable_id, nombre, apellido,movil);
                System.out.println(respon);
            }
            rs.close();
            stmt5.close();
 
        } catch (SQLException e) {
        }

    }
}