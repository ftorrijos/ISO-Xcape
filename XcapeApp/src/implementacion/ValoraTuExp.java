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
import modelo.Responsable;
import modelo.Valoracion;

/**
 *
 * @author Alejandro
 */
public class ValoraTuExp {
    
     public static Connection c = DBManager.getConnection();
    
    
     public String listarValoracionNotaViaje(int viaje_id) throws SQLException{

            String sql = "SELECT nota FROM valora_experiencia WHERE viaje_id=?;";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setInt(1, viaje_id);
            ResultSet rs = prep.executeQuery();
            while(rs.next()){
            String nota = rs.getString("nota");
            return nota;
            }
            
            rs.close();
            prep.close();

            return null;
        
        }
   
    
    
    public static void listarValoracion() throws SQLException {

        try {
            Statement stmt5 = c.createStatement();
            String sql5 = "SELECT * FROM valoracion;";		
            ResultSet rs = stmt5.executeQuery(sql5);
            System.out.println("Lista de Valoracion: ");
            
            while (rs.next()) {
                int valora_id = rs.getInt("valoracion_id");
                int usuario_id = rs.getInt("usuario_id");
                int viaje_id = rs.getInt("viaje_id");
                int nota = rs.getInt("nota");
                String si_no = rs.getString("si_no");
               
                Valoracion valoracion = new Valoracion(valora_id, usuario_id, viaje_id,nota, si_no);
                System.out.println(valoracion);
            }
            rs.close();
            stmt5.close();
 
        } catch (SQLException e) {
        }

    }
}

