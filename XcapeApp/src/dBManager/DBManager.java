package dBManager;

import static implementacion.Contacto.c;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.*;

/**
 *
 * @author Fernando Torrijos
 */
public class DBManager {

    public static void insertarUsuario_Grupo(Usuario user, Grupo grupo) {
        Connection c = getConnection();
        try {
            String insertSql = "INSERT INTO usuario_grupo (user_id,grupo_id) VALUES(?,?)";
            PreparedStatement ps = (PreparedStatement) c.prepareStatement(insertSql);
            System.out.println(user);
            System.out.println(grupo);
            ps.setInt(1, user.getUsuario_id());
            ps.setInt(2, grupo.getGrupo_id());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
        Connection c = getConnection();

        try {
            Statement stmt3 = c.createStatement();
            String sql3 = "SELECT * FROM incidencias;";
            ResultSet rs = stmt3.executeQuery(sql3);
            System.out.println("Lista de Incidencias: ");
            while (rs.next()) {
                int id = rs.getInt("incidencia_id");
                int usuario_id = rs.getInt("usuario_id");
                int grupo_id = rs.getInt("grupo_id");
                String mensaje = rs.getString("mensaje");
                Incidencia incidencia = new Incidencia(id, usuario_id, grupo_id, mensaje);
                System.out.println(incidencia);
            }
            rs.close();
            stmt3.close();

        } catch (SQLException e) {
        }

    }

    public static void listarIncidenciasUserID(int user_id) throws SQLException {
        Connection c = getConnection();

        String sql = "SELECT * FROM incidencias WHERE usuario_id=?";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setInt(1, user_id);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            int incidencia_id = rs.getInt("incidencia_id");
            int grupo_id = rs.getInt("grupo_id");
            String mensaje = rs.getString("mensaje");
            Incidencia inci = new Incidencia(incidencia_id, user_id, grupo_id, mensaje);
            System.out.println(inci);
        }

        rs.close();
        prep.close();

    }

    public static Incidencia listarIncidenciasUserIDDevuelveIncidencia(int user_id) throws SQLException {

        String sql = "SELECT * FROM incidencias WHERE usuario_id=?";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setInt(1, user_id);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            int incidencia_id = rs.getInt("incidencia_id");
            int grupo_id = rs.getInt("grupo_id");
            String mensaje = rs.getString("mensaje");
            Incidencia inci = new Incidencia(incidencia_id, user_id, grupo_id, mensaje);
            return inci;
        }

        rs.close();
        prep.close();
        return null;

    }

    public static Incidencia selectIncidenciaPorUserIdYMensaje(int user_id, String mensaje) throws SQLException {

        String sql = "SELECT * FROM incidencias WHERE usuario_id=? and mensaje=?";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setInt(1, user_id);
        prep.setString(2, mensaje);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            int incidencia_id = rs.getInt("incidencia_id");
            int grupo_id = rs.getInt("grupo_id");
            Incidencia inci = new Incidencia(incidencia_id, user_id, grupo_id, mensaje);
            return inci;
        }

        rs.close();
        prep.close();
        return null;

    }

    public static ArrayList<Incidencia> listarIncidenciasUserIDDevuelveArrayList(int user_id) throws SQLException {
        ArrayList<Incidencia> arr = new ArrayList<Incidencia>();

        String sql = "SELECT * FROM incidencias WHERE usuario_id=?";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setInt(1, user_id);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            int incidencia_id = rs.getInt("incidencia_id");
            int grupo_id = rs.getInt("grupo_id");
            String mensaje = rs.getString("mensaje");
            Incidencia inci = new Incidencia(incidencia_id, user_id, grupo_id, mensaje);
            arr.add(inci);
            System.out.println(inci);
        }

        rs.close();
        prep.close();
        return arr;

    }

    public static void insertarIncidencia(Incidencia inci) {

        try {
            String insertSql = "INSERT INTO incidencias(usuario_id,grupo_id, mensaje) VALUES(?,?,?)";
            PreparedStatement ps = (PreparedStatement) c.prepareStatement(insertSql);

            ps.setInt(1, inci.getUsuario_id());
            ps.setInt(2, inci.getGrupo_id());
            ps.setString(3, inci.getMensaje());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // ---------------------------------------  GESTION DE USUARIOS ----------------------------------------------------------------
    public static void listarUsuarios() throws SQLException {

        try {
            Statement stmt3 = c.createStatement();
            String sql3 = "SELECT * FROM usuarios;";
            ResultSet rs = stmt3.executeQuery(sql3);
            System.out.println("Lista de Usuarios: ");
            while (rs.next()) {
                int id = rs.getInt("usuario_id");
                String nombre = rs.getString("nombre");
                Date fecha_nacimiento = rs.getDate("fecha_nacimiento");
                String apellido = rs.getString("apellido");
                String dni = rs.getString("dni");
                String correo = rs.getString("correo");
                int movil = rs.getInt("movil");
                Usuario usuario = new Usuario(id, movil, nombre, apellido, dni, correo, fecha_nacimiento);
                System.out.println(usuario);
            }
            rs.close();
            stmt3.close();

        } catch (SQLException e) {
        }

    }

    public static int selectIDUsuarioTablaUsuarios(String username, String apellido, String dni) throws SQLException {

        String sql = "SELECT usuario_id FROM usuarios WHERE nombre=? AND apellido=? AND dni=?";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setString(1, username);
        prep.setString(2, apellido);
        prep.setString(3, dni);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            int user_id = rs.getInt("usuario_id");
            return user_id;
        }

        rs.close();
        prep.close();

        return 0;
    }

    public static void UpdateUsuario(Usuario user) {
        try {
            String sql = "UPDATE usuarios SET nombre=?, apellido=?, fecha_nacimiento=?,dni=?,correo=?,movil=? WHERE usuario_id=? ";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setString(1, user.getNombre());
            prep.setString(2, user.getApellido());

            Instant instant = (user.getFecha_nacimiento()).toInstant();
            ZoneId zoneId = ZoneId.of("Europe/Paris");
            ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneId);
            LocalDate localDate = zdt.toLocalDate();
            java.sql.Date fecha_nacimiento = java.sql.Date.valueOf(localDate);

            prep.setDate(3, fecha_nacimiento);
            prep.setString(4, user.getDni());
            prep.setString(5, user.getCorreo());
            prep.setInt(6, user.getMovil());
            prep.setInt(7, user.getUsuario_id());
            prep.executeUpdate();
            prep.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static Usuario seleccionar_usuarioPorID(int id) throws SQLException {

        String selectSql = "SELECT * FROM usuarios WHERE usuario_id=?;";
        PreparedStatement ps = (PreparedStatement) c.prepareStatement(selectSql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String nombre = rs.getString(2);
            String apellido = rs.getString(3);
            Date fecha_nacimiento = rs.getDate(4);
            String correo = rs.getString(6);
            String dni = rs.getString("dni");
            int movil = rs.getInt(7);

            Usuario usuario = new Usuario(movil, nombre, apellido, dni, correo, fecha_nacimiento);
            System.out.println(usuario);

            rs.close();
            ps.close();
            return usuario;
        }
        return null;
    }

    public Usuario seleccionar_usuario(String dni) throws SQLException {

        String selectSql = "SELECT * FROM usuarios WHERE dni=?;";
        PreparedStatement ps = (PreparedStatement) c.prepareStatement(selectSql);
        ps.setString(1, dni);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt(1);
            String nombre = rs.getString(2);
            String apellido = rs.getString(3);
            Date fecha_nacimiento = rs.getDate(4);
            String correo = rs.getString(6);
            int movil = rs.getInt(7);

            Usuario usuario = new Usuario(id, movil, nombre, apellido, dni, correo, fecha_nacimiento);

            rs.close();
            ps.close();
            return usuario;
        }
        return null;
    }

    public static Usuario selectNombreApellidoUsuarioPorUserID(int user_id) throws SQLException {

        String selectSql = "SELECT nombre,apellido FROM usuarios WHERE usuario_id=?;";
        PreparedStatement ps = (PreparedStatement) c.prepareStatement(selectSql);
        ps.setInt(1, user_id);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            Usuario user = new Usuario(0, nombre, apellido, null, null, null);
            return user;
        }
        rs.close();
        ps.close();
        return null;
    }

    public static void insertarUsuarios(Usuario usuario) {
        Connection c = getConnection();
        System.out.println("HELLO");
        System.out.println(usuario);
        try {
            String insertSql = "INSERT INTO usuarios(nombre,apellido,fecha_nacimiento,dni,correo, movil) VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(insertSql);
            String nombre = usuario.getNombre();
            String apellido = usuario.getApellido();
            Instant instant = (usuario.getFecha_nacimiento()).toInstant();
            ZoneId zoneId = ZoneId.of("Europe/Paris");
            ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneId);
            LocalDate localDate = zdt.toLocalDate();

            java.sql.Date fecha_nacimiento = java.sql.Date.valueOf(localDate);

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
        Connection c = getConnection();

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

    public static void insertarTablaUserPassword(int usuario_id, String username, String password) {
        Connection c = DBManager.getConnection();

        try {
            String insertSql = "INSERT INTO user_login(user_id,username,password) VALUES(?,?,sha1(?))";
            PreparedStatement ps = (PreparedStatement) c.prepareStatement(insertSql);

            ps.setInt(1, usuario_id);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String selectUserNameUsuario(int user_id) throws SQLException {

        String sql = "SELECT username FROM user_login WHERE user_id=?";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setInt(1, user_id);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            String username = rs.getString("username");
            return username;
        }

        rs.close();
        prep.close();

        return null;
    }

    public int selectIDUsuario(String username) throws SQLException {

        String sql = "SELECT user_id FROM user_login WHERE username=?";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setString(1, username);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            int user_id = rs.getInt("user_id");
            return user_id;
        }

        rs.close();
        prep.close();

        return 0;
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

    public static int IdGrupoPorIdUsuarios(int usuario_id) throws SQLException {

        try {
            String sql = "SELECT grupo_id FROM usuario_grupo WHERE user_id=?;";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setInt(1, usuario_id);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                int grupo_id = rs.getInt("grupo_id");
                return grupo_id;
            }

            rs.close();
            prep.close();

        } catch (SQLException e) {
        }
        return 0;
    }

    public static int IdViajePorIdGrupo(int grupo_id) throws SQLException {

        try {
            String sql = "SELECT viaje_id FROM grupo WHERE grupo_id=?;";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setInt(1, grupo_id);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                int viaje_id = rs.getInt("viaje_id");
                return viaje_id;
            }

            rs.close();
            prep.close();

        } catch (SQLException e) {
        }
        return 0;
    }

    public static int selectIDGrupoPorIDusuario(int usuario_id) {
        try {
            String sql = "SELECT grupo_id FROM usuario_grupo WHERE user_id=?;";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setInt(1, usuario_id);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                int grupo_id = rs.getInt("grupo_id");
                return grupo_id;
            }

            rs.close();
            prep.close();

        } catch (SQLException e) {
        }
        return 0;

    }

    public int IdResponsablePorGrupoID(int grupo_id) throws SQLException {

        try {
            String sql = "SELECT responsable_id FROM grupo WHERE grupo_id=?;";
            PreparedStatement prep = c.prepareStatement(sql);
            prep.setInt(1, grupo_id);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                int responsable_id = rs.getInt("responsable_id");
                return grupo_id;
            }

            rs.close();
            prep.close();

        } catch (SQLException e) {
        }
        return 0;
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

    public Grupo selectGrupoPorNombre(String nombre_grupo) throws SQLException {

        String sql = "SELECT * FROM grupo WHERE nombre=?;";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setString(1, nombre_grupo);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            Grupo grupo = new Grupo(rs.getInt("grupo_id"), rs.getInt("responsable_id"), rs.getInt("viaje_id"), nombre_grupo);
            return grupo;
        }
        rs.close();
        prep.close();
        return null;
    }

    public void listarComponentesGrupoPorID(int id_grupo) throws SQLException {

        String sql = "SELECT user_id FROM usuario_grupo WHERE grupo_id=?;";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setInt(1, id_grupo);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            int user_id = rs.getInt("user_id");
            Usuario user = selectNombreApellidoUsuarioPorUserID(user_id);
            System.out.println("Nombre= " + user.getNombre() + " , Apellido=" + user.getApellido());
        }

        rs.close();
        prep.close();

    }

    public static ArrayList<Usuario> selectComponentesArrayListUsuarioPorUserID(int id_usuario) throws SQLException {
        int id_grupo = selectIDGrupoPorIDusuario(id_usuario);

        ArrayList<Usuario> arrayUser = new ArrayList<>();
        String sql = "SELECT user_id FROM usuario_grupo WHERE grupo_id=?;";
        try (PreparedStatement prep = c.prepareStatement(sql)) {
            prep.setInt(1, id_grupo);
            try (ResultSet rs = prep.executeQuery()) {
                while (rs.next()) {
                    int user_id = rs.getInt("user_id");
                    Usuario user = seleccionar_usuarioPorID(user_id);
                    arrayUser.add(user);
                }
            }
        }
        return arrayUser;
    }

//-------------------------------------------RESPONSABLES-----------------------------------------------
    public void listarResponsables() throws SQLException {

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

    public Responsable selectResponsableYContactoPorNombre(String nombre) throws SQLException {

        String sql = "SELECT * FROM responsables WHERE nombre=?;";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setString(1, nombre);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            int responsable_id = rs.getInt("responsable_id");
            String apellido = rs.getString("apellido");
            int movil = rs.getInt("movil");
            Responsable respon = new Responsable(responsable_id, nombre, apellido, movil);
            return respon;
        }

        rs.close();
        prep.close();

        return null;
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
            Responsable respon = new Responsable(nombre, apellido, movil);
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

            ps.setString(1, responsable.getNombre());
            ps.setString(2, responsable.getApellido());
            ps.setInt(3, responsable.getMovil());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//------------------------------------VIAJES----------------------------------------------
    public void listarViajes() throws SQLException {

        try {
            Statement stmt5 = c.createStatement();
            String sql5 = "SELECT * FROM info_viaje;";
            ResultSet rs = stmt5.executeQuery(sql5);
            System.out.println("Lista de Viajes: ");

            while (rs.next()) {
                int viaje_id = rs.getInt("viaje_id");
                String hotel = rs.getString("hotel");
                String direccion_hotel = rs.getString("direccion_hotel");
                String regimen = rs.getString("regimen");
                String estacion_forfait = rs.getString("estacion_forfait");
                int duracion = rs.getInt("duracion");
                Viaje viaj = new Viaje(viaje_id, hotel, direccion_hotel, regimen, estacion_forfait, duracion);
                System.out.println(viaj);
            }

            rs.close();
            stmt5.close();

        } catch (SQLException e) {
        }

    }

    public void listarViajePorID(int viaje_id) throws SQLException {

        String sql = "SELECT * FROM info_viaje WHERE viaje_id=?;";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setInt(1, viaje_id);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            String hotel = rs.getString("hotel");
            String direccion_hotel = rs.getString("direccion_hotel");
            String regimen = rs.getString("regimen");
            String estacion_forfait = rs.getString("estacion_forfait");
            int duracion = rs.getInt("duracion");
            Viaje viaj = new Viaje(viaje_id, hotel, direccion_hotel, regimen, estacion_forfait, duracion);
            System.out.println(viaj);

        }

        rs.close();
        prep.close();

    }

    public static Viaje selectViajePorNombre(String nombre_hotel) throws SQLException {

        String sql = "SELECT * FROM info_viaje WHERE hotel=?;";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setString(1, nombre_hotel);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            int viaje_id = rs.getInt("viaje_id");
            String hotel = rs.getString("hotel");
            String direccion_hotel = rs.getString("direccion_hotel");
            String regimen = rs.getString("regimen");
            String estacion_forfait = rs.getString("estacion_forfait");
            int duracion = rs.getInt("duracion");
            Viaje viaj = new Viaje(viaje_id, hotel, direccion_hotel, regimen, estacion_forfait, duracion);
            return viaj;
        }

        rs.close();
        prep.close();
        return null;
    }

    public Viaje selectViajePorUserId(int usuario_id) throws SQLException {

        int id_grupo = selectIDGrupoPorIDusuario(usuario_id);
        int id_viaje = IdViajePorIdGrupo(id_grupo);

        String sql = "SELECT * FROM info_viaje WHERE viaje_id=?;";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setInt(1, id_viaje);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            String hotel = rs.getString("hotel");
            String direccion_hotel = rs.getString("direccion_hotel");
            String regimen = rs.getString("regimen");
            String estacion_forfait = rs.getString("estacion_forfait");
            int duracion = rs.getInt("duracion");
            Viaje viaje = new Viaje(id_viaje, hotel, direccion_hotel, regimen, estacion_forfait, duracion);
            return viaje;

        }

        rs.close();
        prep.close();

        return null;

    }

    public void insertarViajes(Viaje viaje) {
        Connection c = DBManager.getConnection();

        try {
            String insertSql = "INSERT INTO info_viaje(hotel,direccion_hotel,regimen,estacion_forfait,duracion) VALUES(?,?,?,?,?)";
            PreparedStatement ps = (PreparedStatement) c.prepareStatement(insertSql);

            ps.setString(1, viaje.getHotel());
            ps.setString(2, viaje.getDireccion_hotel());
            ps.setString(3, viaje.getRegimen());
            ps.setString(4, viaje.getEstacion_forfait());
            ps.setInt(5, viaje.getDuracion());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//-----------------------------------------------------PAGOS----------------------------------------------------------
    public void listarPagos() throws SQLException {

        try {
            Statement stmt5 = c.createStatement();
            String sql5 = "SELECT * FROM pagos;";
            ResultSet rs = stmt5.executeQuery(sql5);
            System.out.println("Lista de Pagos: ");

            while (rs.next()) {
                int pago_id = rs.getInt("pago_id");
                String metodo_pago = rs.getString("metodo_pago");
                String primer_pago = rs.getString("primer_pago");
                String segundo_pago = rs.getString("segundo_pago");
                int usuario_id = rs.getInt("usuario_id");
                String dni = rs.getString("DNI");
                Pagos pago = new Pagos(pago_id, metodo_pago, primer_pago, segundo_pago, usuario_id, dni);
                System.out.println(pago);
            }

            rs.close();
            stmt5.close();

        } catch (SQLException e) {
        }

    }

    public void listarPagosPorUserID(int usuario_id) throws SQLException {

        String sql = "SELECT * FROM pagos WHERE usuario_id=?;";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setInt(1, usuario_id);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            Pagos pago = new Pagos(rs.getInt("pago_id"), rs.getString("metodo_pago"), rs.getString("primer_pago"), rs.getString("segundo_pago"), usuario_id, rs.getString("DNI"));
            System.out.println(pago);
        }

        rs.close();
        prep.close();

    }

    public static Pagos listarPagosPorUserIDDevuelvePago(int usuario_id) throws SQLException {

        String sql = "SELECT * FROM pagos WHERE usuario_id=?;";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setInt(1, usuario_id);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            Pagos pago = new Pagos(rs.getInt("pago_id"), rs.getString("metodo_pago"), rs.getString("primer_pago"), rs.getString("segundo_pago"), usuario_id, rs.getString("DNI"));
            return pago;
        }

        rs.close();
        prep.close();
        return null;
    }

    public void insertarPagos(Pagos pagos) {
        Connection c = DBManager.getConnection();

        try {
            String insertSql = "INSERT INTO pagos(metodo_pago,primer_pago,segundo_pago,usuario_id,DNI) VALUES(?,?,?,?,?)";
            PreparedStatement ps = (PreparedStatement) c.prepareStatement(insertSql);

            ps.setString(1, pagos.getMetodo_pago());
            ps.setString(2, pagos.getPrimer_pago());
            ps.setString(3, pagos.getSegundo_pago());
            ps.setInt(4, pagos.getUsuario_id());
            ps.setString(5, pagos.getDni());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Pagos pagosPorUserID(int usuario_id) throws SQLException {

        String sql = "SELECT * FROM pagos WHERE usuario_id=?;";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setInt(1, usuario_id);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            Pagos pago = new Pagos(rs.getInt("pago_id"), rs.getString("metodo_pago"), rs.getString("primer_pago"), rs.getString("segundo_pago"), usuario_id, rs.getString("DNI"));
            return pago;
        }

        rs.close();
        prep.close();
        return null;
    }

    public static void realizarPago1(int user_id) {
        Connection c = DBManager.getConnection();

        try {
            String insertSql = "UPDATE pagos set primer_pago='ok' where usuario_id=?;";
            PreparedStatement ps = (PreparedStatement) c.prepareStatement(insertSql);
            ps.setInt(1, user_id);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void realizarPago2(int user_id) {
        Connection c = DBManager.getConnection();

        try {
            String insertSql = "UPDATE pagos set segundo_pago='ok' where usuario_id=?;";
            PreparedStatement ps = (PreparedStatement) c.prepareStatement(insertSql);
            ps.setInt(1, user_id);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //---------------------------------------------- EVENTOS -------------------------------------------------------------
    public void listarEventos() {
        try {
            Statement stmt5 = c.createStatement();
            String sql5 = "SELECT * FROM eventos;";
            ResultSet rs = stmt5.executeQuery(sql5);
            System.out.println("Lista de Eventos: ");

            while (rs.next()) {
                int evento_id = rs.getInt("evento_id");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String ciudad = rs.getString("ciudad");
                String fecha = rs.getString("fecha");
                int listas = rs.getInt("listas");
                Evento evento = new Evento(evento_id, nombre, direccion, ciudad, fecha, listas);
                System.out.println(evento);
            }

            rs.close();
            stmt5.close();

        } catch (SQLException e) {
        }
    }

    public Evento selectEventoPorNombre(String nombre) throws SQLException {

        String sql = "SELECT * FROM eventos WHERE nombre=?;";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setString(1, nombre);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            Evento evento = new Evento(rs.getInt("evento_id"), rs.getString("nombre"), rs.getString("direccion"), rs.getString("ciudad"), rs.getString("fecha"), rs.getInt("listas"));
            return evento;
        }

        rs.close();
        prep.close();
        return null;
    }

    public static ArrayList<Evento> selectTodosLosEventosArrayList() throws SQLException {
        ArrayList<Evento> arrayEvento = new ArrayList<Evento>();
        String sql = "SELECT * FROM eventos";
        PreparedStatement prep = c.prepareStatement(sql);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            Evento evento = new Evento(rs.getInt("evento_id"), rs.getString("nombre"), rs.getString("direccion"), rs.getString("ciudad"), rs.getString("fecha"), rs.getInt("listas"));
            arrayEvento.add(evento);
        }

        rs.close();
        prep.close();
        return arrayEvento;
    }

    public int asistenciaEventos(int evento_id) {
        try {
            String insertSql = "SELECT listas from eventos where  evento_id=?";
            PreparedStatement ps = (PreparedStatement) c.prepareStatement(insertSql);
            ps.setInt(1, evento_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("listas");
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void insertarEventos(Evento evento) {
        try {
            String insertSql = "INSERT INTO eventos(nombre,direccion,ciudad,fecha,listas) VALUES(?,?,?,?,?)";
            PreparedStatement ps = (PreparedStatement) c.prepareStatement(insertSql);

            ps.setString(1, evento.getNombre());
            ps.setString(2, evento.getDireccion());
            ps.setString(3, evento.getCiudad());
            ps.setString(4, evento.getFecha());
            ps.setInt(5, evento.getListas());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateAsistentesEvento(int evento_id) {
        try {
            String sql = "UPDATE eventos set listas=? where evento_id=? ";
            PreparedStatement prep = c.prepareStatement(sql);
            int newAsistencia = asistenciaEventos(evento_id) + 1;
            prep.setInt(1, newAsistencia);
            prep.setInt(2, evento_id);
            prep.executeUpdate();
            prep.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //------------------------------------VALORA TU EXPERIENCIA ---------------------------------------
    public String listarValoracionNotaViaje(int viaje_id) throws SQLException {

        String sql = "SELECT nota FROM valora_experiencia WHERE viaje_id=?;";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setInt(1, viaje_id);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
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

                Valoracion valoracion = new Valoracion(valora_id, usuario_id, viaje_id, nota, si_no);
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

    public static Valoracion selectValoracioUserIdViajeId(int user_id, int viaje_id) throws SQLException {

        String sql = "SELECT * FROM valora_experiencia WHERE usuario_id=? and viaje_id=?;";
        PreparedStatement prep = c.prepareStatement(sql);
        prep.setInt(1, user_id);
        prep.setInt(2, viaje_id);
        ResultSet rs = prep.executeQuery();
        while (rs.next()) {
            Valoracion valora = new Valoracion(rs.getInt("valora_id"), user_id, viaje_id, rs.getInt("nota"), rs.getString(("si_no")));
            return valora;
        }
        rs.close();
        prep.close();
        return null;
    }
}
