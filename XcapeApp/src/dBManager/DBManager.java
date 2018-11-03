package dBManager;

import static implementacion.Contacto.c;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Incidencia;

/**
 *
 * @author Fernando Torrijos
 */
public class DBManager {

    public DBManager() {

    }

    public static Connection getConnection() {

        String usuario = "root";
        String clave = "root";
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
   //----------------------------------- TODO LO QUE TIENE QUE VER CON INCIDENCIAS ---------------------------------------------
    // ----------------------------------- LISTAR E INSERTAR INCIDENCIAS -----------------------------------------------------------
       
    public static void listarIncidencias() throws SQLException {

        try {
            Statement stmt3 = c.createStatement();
            String sql3 = "SELECT * FROM incidencias;";		
            ResultSet rs = stmt3.executeQuery(sql3);
            System.out.println("Lista de Incidencias: ");
            while (rs.next()) {
                int incidencia_id = rs.getInt("incidencia_id");
                System.out.println(incidencia_id);
		int usuario_id = rs.getInt("usuario_id");
		int grupo_id = rs.getInt("grupo_id");
                String mensaje = rs.getString("mensaje");
                Incidencia incidencia = new Incidencia(incidencia_id, usuario_id, grupo_id, mensaje);
                System.out.println(incidencia.getIncidencia_id());
            }
            rs.close();
            stmt3.close();

        } catch (SQLException e) {
        }

    }
    
 // ---------------------------------------  GESTION DE USUARIOS ----------------------------------------------------------------
    public void insertarUsuarios(String nombre) {
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
    
          public String listarUsuariosSoloNombre(int id_usuarios) throws SQLException{

            String sql = "SELECT nombre FROM usuarios WHERE usuario_id=?;";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setInt(1, id_usuarios);
            ResultSet rs = prep.executeQuery();
            while(rs.next()){
            String nombre = rs.getString("nombre");
            return nombre;
            }
            
            rs.close();
            prep.close();

            return null;
        
        }
    
    //-------------------------------------- LOGIN ----------------------------------------------------------------------
    
       public  String selectPasswordUsuario(String username) throws SQLException{

            String sql = "SELECT password FROM user_login WHERE username=?";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setString(1,username);
            ResultSet rs = prep.executeQuery();
            while(rs.next()){
            String password = rs.getString("password");
            return password;
            }
            
            rs.close();
            prep.close();

            return null;
   }
       
       
 
    
    
       
    //----------------------------------------GRUPOS----------------------------------------------------
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

}
