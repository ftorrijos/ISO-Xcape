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
import modelo.*;

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
                System.out.println(incidencia);
            }
            rs.close();
            stmt3.close();

        } catch (SQLException e) {
        }

    }

    // ---------------------------------------  GESTION DE USUARIOS ----------------------------------------------------------------
    public void insertarUsuarios(Usuario usuario) {
        Connection c = DBManager.getConnection();

        try {
            String insertSql = "INSERT INTO usuarios(nombre,apellido,fecha_nacimiento,dni,correo, movil) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = (PreparedStatement) c.prepareStatement(insertSql);

            String nombre = usuario.getNombre();
            String apellido = usuario.getApellido();
            java.sql.Date fecha_nacimiento = (java.sql.Date) usuario.getFecha_nacimiento();
            String dni = usuario.getDni();
            String correo = usuario.getCorreo();
            int movil = usuario.getMovil();

            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setDate(3, fecha_nacimiento);
            ps.setString(4, dni);
            ps.setString(5, correo);
            ps.setInt(6, movil);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String listarUsuariosSoloNombre(int id_usuarios) throws SQLException {

        String sql = "SELECT nombre FROM usuarios WHERE usuario_id=?;";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setInt(1, id_usuarios);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            String nombre = rs.getString("nombre");
            return nombre;
        }

        rs.close();
        prep.close();

        return null;

    }

    //-------------------------------------- LOGIN ----------------------------------------------------------------------
    public String selectPasswordUsuario(String username) throws SQLException {

        String sql = "SELECT password FROM user_login WHERE username=?";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setString(1, username);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            String password = rs.getString("password");
            return password;
        }

        rs.close();
        prep.close();

        return null;
    }

    //----------------------------------------GRUPOS----------------------------------------------------
    public static void listarGrupos() throws SQLException {

        try {
            Statement stmt4 = c.createStatement();
            String sql4 = "SELECT * FROM grupo;";
            ResultSet rs = stmt4.executeQuery(sql4);
            System.out.println("Lista de Usuarios: ");

            while (rs.next()) {
                int grupo_id = rs.getInt("grupo_id");
                String nombre = rs.getString("nombre");
                int responsable_id = rs.getInt("responsable_id");
                int viaje_id = rs.getInt("viaje_id");
                Grupo grupo = new Grupo(grupo_id, responsable_id, viaje_id, nombre);
                System.out.println(grupo);
            }
            rs.close();
            stmt4.close();

        } catch (SQLException e) {
        }
    }

    public void insertarGrupo(Grupo grupo) {
        Connection c = DBManager.getConnection();

        try {
            String insertSql = "INSERT INTO grupo(nombre,responsable_id, viaje_id) VALUES(?,?,?)";
            PreparedStatement ps = (PreparedStatement) c.prepareStatement(insertSql);

            ps.setString(1, grupo.getNombre());
            ps.setInt(2, grupo.getResponsable_id());
            ps.setInt(3, grupo.getViaje_id());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String listarGruposSoloNombre(int id_grupo) throws SQLException {

        String sql = "SELECT nombre FROM grupo WHERE grupo_id=?;";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setInt(1, id_grupo);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            String nombre = rs.getString("nombre");
            return nombre;
        }

        rs.close();
        prep.close();

        return null;

    }
//-------------------------------------------RESPONSABLES-----------------------------------------------

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
                Responsable respon = new Responsable(responsable_id, nombre, apellido, movil);
                System.out.println(respon);
            }
            rs.close();
            stmt5.close();

        } catch (SQLException e) {
        }

    }

    public Responsable listarResponsableYContacto(int responsable_id) throws SQLException {

        String sql = "SELECT * FROM responsables WHERE responsable_id=?;";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setInt(1, responsable_id);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            int movil = rs.getInt("movil");
            Responsable respon = new Responsable(nombre,apellido,movil);
            return respon;
        }

        rs.close();
        prep.close();

        return null;

    }
    
      public void insertarResponsable(Responsable responsable) {
        Connection c = DBManager.getConnection();

        try {
            String insertSql = "INSERT INTO responsables(nombre,apellido,movil) VALUES(?,?,?)";
            PreparedStatement ps = (PreparedStatement) c.prepareStatement(insertSql);

            ps.setString(1,responsable.getNombre());
            ps.setString(2, responsable.getApellido());
            ps.setInt(3,responsable.getMovil());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
