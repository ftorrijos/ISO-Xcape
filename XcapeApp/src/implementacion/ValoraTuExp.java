/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import dBManager.DBManager;
import static implementacion.Contacto.c;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Responsable;
import modelo.Usuario;
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
    public static void insertarValoracion(Valoracion valoracion) {

        try {
            String insertSql = "INSERT INTO valora_experiencia(usuario_id,viaje_id,nota,si_no) VALUES(?,?,?,?)";
            PreparedStatement ps = (PreparedStatement) c.prepareStatement(insertSql);

            int usuario_id = valoracion.getUsuario_id();
            int viaje_id = valoracion.getViaje_id();
            int nota = valoracion.getNota();
            String si_no = valoracion.getSi_no();
            

            ps.setInt(1, usuario_id);
            ps.setInt(2, viaje_id);
            ps.setInt(3, nota);
            ps.setString(4, si_no);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

