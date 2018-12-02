/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbManager;

import implementacion.*;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.*;
import dBManager.DBManager;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author usuario
 */
public class DBManagerTest {

    public DBManagerTest() {
    }

    DBManager db = new DBManager();
    Login log = new Login();
    Connection c = getConnection();

//--------- objetos utilizados en la base de datos Ficticia
    Date date = new Date(1991/10/10);
    Usuario mockUser = new Usuario(879123542, "UsuarioPrueba", "ApellidoPrueba", "00000000K", "correo@prueba.com", date);
    LoginObjeto mockLogin = new LoginObjeto();
    Responsable mockResponsable = new Responsable("responsablenombre", "responsableapellido", 655549786);
    Evento mockEvento = new Evento("evento mock", "una dirección", "ciudad", "27/08/1960", 14632);
    Viaje mockViaje = new Viaje("ViajeHotel", "DireccionHotel", "RegimenCompletoTieso", "EstacionTodas", 15000);
    Pagos mockPago = new Pagos("Bitcoin", "ok", "NULL", 0, "");
    Grupo mockGrupo = new Grupo(0, 0, "Viaje-01");
    Valoracion mockValoracion = new Valoracion(0, 0, 99, "si");
    Incidencia mockIncidencia = new Incidencia(0, 0, "Esto es un test de incidencias");

    @Before
    public void setUp() throws Exception {
        System.out.println("Creando la infraestructura de los test");
        createDatabase();
        createTables();
        insertsBBDD();
    }

    // @After
    public void tearDown() throws Exception {
        System.out.println("Destruyendo la infraestrucutra de los test");
        dropDatabase();
    }
//primer test de prueba

    @Test
    public void test1() {
        int x = 1;
        int y = 1;
        assertEquals(x, y);
    }

    //--------------------------------------Test de Login ------------------------------------------------------
    @Test
    public void testLogHash() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String x = "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8";
        String y = Login.hash("password").toLowerCase();
        Assert.assertTrue(x.equalsIgnoreCase(y));

    }
    
   @Test
    public void testSelectUsuario() throws SQLException{
        Usuario usuarioBBDD = seleccionar_usuarioPorID(mockUser.getUsuario_id());
        System.out.println("Aaaaaaaaaaaaaaaaaaaa"+usuarioBBDD);
        assertEquals(mockUser.getUsuario_id(), usuarioBBDD.getUsuario_id());
        assertEquals(mockUser.getNombre(),usuarioBBDD.getNombre());
        assertEquals(mockUser.getApellido(),usuarioBBDD.getApellido());
        assertEquals(mockUser.getFecha_nacimiento(),usuarioBBDD.getFecha_nacimiento());
        assertEquals(mockUser.getDni(),usuarioBBDD.getDni());
        assertEquals(mockUser.getCorreo(),usuarioBBDD.getCorreo());
        assertEquals(mockUser.getMovil(),usuarioBBDD.getMovil());
             
    }

    //----------------------------CREACION/ INSERCCION BBDD PRUEBA Y CONEXIONES ---------------------------------------------
    public void createDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=root");
            Statement st = conn.createStatement();
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS dbxtesting");
            System.out.println("Database created !");
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void createTables() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbxtesting", "root", "root");
            Statement st = conn.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS usuarios(usuario_id int(11) NOT NULL AUTO_INCREMENT,nombre varchar(30) DEFAULT NULL,apellido varchar(30) DEFAULT NULL,fecha_nacimiento date DEFAULT NULL,dni varchar(10) DEFAULT NULL,correo varchar(40) DEFAULT NULL,movil int(9) DEFAULT NULL,PRIMARY KEY (usuario_id))");
            st.execute("CREATE TABLE IF NOT EXISTS user_login(user_id int(11) NOT NULL,username varchar(250) NOT NULL, password varchar(500) DEFAULT NULL,  KEY user_id (user_id),FOREIGN KEY (user_id) REFERENCES usuarios(usuario_id))");
            st.execute("CREATE TABLE IF NOT EXISTS responsables(responsable_id int(11) NOT NULL AUTO_INCREMENT,nombre varchar(30) DEFAULT NULL,apellido varchar(30) DEFAULT NULL,movil int(11) DEFAULT NULL,PRIMARY KEY (responsable_id))");
            st.execute("CREATE TABLE IF NOT EXISTS eventos(evento_id int(11) NOT NULL AUTO_INCREMENT,nombre varchar(30) DEFAULT NULL,direccion varchar(60) DEFAULT NULL,ciudad varchar(50) DEFAULT NULL,fecha varchar(20) DEFAULT NULL,listas int(11) DEFAULT NULL,PRIMARY KEY (evento_id))");
            st.execute("CREATE TABLE IF NOT EXISTS info_viaje(viaje_id int(11) NOT NULL AUTO_INCREMENT,hotel varchar(50) DEFAULT NULL,direccion_hotel varchar(100) DEFAULT NULL,regimen varchar(50) DEFAULT NULL,estacion_forfait varchar(50) DEFAULT NULL,duracion int(11) DEFAULT NULL,PRIMARY KEY (viaje_id))");
            st.execute("CREATE TABLE IF NOT EXISTS pagos(pago_id int(11) NOT NULL AUTO_INCREMENT,metodo_pago varchar(15) DEFAULT NULL,primer_pago varchar(15) DEFAULT NULL,segundo_pago varchar(15) DEFAULT NULL,usuario_id int(11) DEFAULT NULL,DNI varchar(20) DEFAULT NULL,PRIMARY KEY (pago_id), KEY usuario_id(usuario_id),FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id))");
            st.execute("CREATE TABLE IF NOT EXISTS grupo(grupo_id int(11) NOT NULL AUTO_INCREMENT,nombre varchar(10) DEFAULT NULL,responsable_id int(11) DEFAULT NULL,viaje_id int(11) DEFAULT NULL,PRIMARY KEY (grupo_id), KEY responsable_id(responsable_id),KEY viaje_id(viaje_id),FOREIGN KEY (responsable_id) REFERENCES responsables(responsable_id),FOREIGN KEY (viaje_id) REFERENCES info_viaje(viaje_id))");
            st.execute("CREATE TABLE IF NOT EXISTS valora_experiencia(valora_id int(11) NOT NULL AUTO_INCREMENT,usuario_id int(11) DEFAULT NULL,viaje_id int(11) DEFAULT NULL,nota int(3) DEFAULT NULL,si_no varchar(2) DEFAULT NULL,PRIMARY KEY (valora_id),KEY usuario_id (usuario_id),KEY viaje_id(viaje_id),FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id),FOREIGN KEY (viaje_id) REFERENCES info_viaje(viaje_id))");
            st.execute("CREATE TABLE IF NOT EXISTS incidencias(incidencia_id int(11) NOT NULL AUTO_INCREMENT,usuario_id int(11) DEFAULT NULL,grupo_id int(11) DEFAULT NULL,mensaje varchar(500) DEFAULT NULL,PRIMARY KEY (incidencia_id), KEY grupo_id (grupo_id),KEY usuario_id (usuario_id), FOREIGN KEY (grupo_id) REFERENCES grupo(grupo_id),FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id))");
            st.execute("CREATE TABLE IF NOT EXISTS usuario_grupo(user_id int(11) DEFAULT NULL,grupo_id int(11) DEFAULT NULL,fecha varchar(15) DEFAULT NULL,KEY grupo_id(grupo_id),KEY user_id(user_id),FOREIGN KEY (grupo_id) REFERENCES grupo(grupo_id),FOREIGN KEY (user_id) REFERENCES usuarios(usuario_id))");

            System.out.println("Tables created !");
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void insertsBBDD() throws SQLException {
        insertarUsuarios(mockUser);
        Usuario user = seleccionar_usuario(mockUser.getDni());
        mockUser.setUsuario_id(user.getUsuario_id());
        insertarTablaUserPassword(mockUser.getUsuario_id(), "UsuarioPrueba", "passwordprueba");
//     mockLogin.setUsuario_id(user.getUsuario_id());
        insertarResponsable(mockResponsable);
        mockResponsable.setResponsable_id(selectResponsableYContactoPorNombre(mockResponsable.getNombre()).getResponsable_id());
        insertarViajes(mockViaje);
        mockViaje.setViaje_id(selectViajePorNombre(mockViaje.getHotel()).getViaje_id());
        insertarEventos(mockEvento);
        mockEvento.setEvento_id(selectEventoPorNombre(mockEvento.getNombre()).getEvento_id());
        insertarViajes(mockViaje);
        mockViaje.setViaje_id(selectViajePorNombre(mockViaje.getHotel()).getViaje_id());
        mockPago.setUsuario_id(mockUser.getUsuario_id());
        mockPago.setDni(mockUser.getDni());
        insertarPagos(mockPago);
        Pagos pag = pagosPorUserID(mockUser.getUsuario_id());
        mockPago.setPago_id(pag.getPago_id());
        mockGrupo.setViaje_id(mockViaje.getViaje_id());
        mockGrupo.setResponsable_id(mockResponsable.getResponsable_id());
        insertarGrupo(mockGrupo);
        mockGrupo.setGrupo_id(selectGrupoPorNombre(mockGrupo.getNombre()).getGrupo_id());
        mockValoracion.setUsuario_id(mockUser.getUsuario_id());
        mockValoracion.setViaje_id(mockViaje.getViaje_id());
        insertarValoracion(mockValoracion);
        mockValoracion.setValora_id(selectValoracioUserIdViajeId(mockUser.getUsuario_id(), mockViaje.getViaje_id()).getValora_id());
        mockIncidencia.setGrupo_id(mockGrupo.getGrupo_id());
        mockIncidencia.setUsuario_id(mockUser.getUsuario_id());
        insertarIncidencia(mockIncidencia);
        mockIncidencia.setIncidencia_id(selectIncidenciaPorUserIdYMensaje(mockUser.getUsuario_id(), mockIncidencia.getMensaje()).getIncidencia_id());

//        System.out.println(mockUser);
//        System.out.println(mockResponsable);
//        System.out.println(mockValoracion);
//        System.out.println("Pago{" + "pago_id=" + mockPago.getPago_id() + ", metodo de pago =" + mockPago.getMetodo_pago() + ", primer pago =" + mockPago.getPrimer_pago()
//                + " ,segundo pago=" + mockPago.getSegundo_pago() + " ,DNI=" + mockPago.getDni() + " , usuario=" + selectUserNameUsuario(mockUser.getUsuario_id()) + '}');
//        System.out.println(mockViaje);
//        System.out.println("Incidencia{" + "incidencia_id=" + mockIncidencia.getIncidencia_id() + ", usuario=" + listarUsuariosSoloNombre(mockUser.getUsuario_id()) + " ,grupo=" + listarGruposSoloNombre(mockGrupo.getGrupo_id()) + " ,mensaje=" + mockIncidencia.getMensaje() + "}");
//        System.out.println(mockEvento);
//        System.out.println(mockGrupo);

    }

    public static void dropDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=root");
            Statement st = conn.createStatement();
            int myResult = st.executeUpdate("DROP DATABASE dbxtesting");
            System.out.println("Database deleted!");
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {

        String usuario = "root";
        String clave = "root";
        String driver = "com.mysql.jdbc.Driver";
        String URL = "jdbc:mysql://localhost:3306/dbxTesting";

        Connection connection = null;

        try {
            Class.forName(driver).newInstance();
            connection = DriverManager.getConnection(URL, usuario, clave);
            // System.out.println("Conexión establecida con éxito\n");
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

    //----------------------------TODA LA INFRAESTRUCTURA DE BBDD -------------------------------------------
    public void listarIncidencias() throws SQLException {
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

    public void listarIncidenciasUserID(int user_id) throws SQLException {
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

    public Incidencia listarIncidenciasUserIDDevuelveIncidencia(int user_id) throws SQLException {
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
            return inci;
        }

        rs.close();
        prep.close();
        return null;

    }

    public Incidencia selectIncidenciaPorUserIdYMensaje(int user_id, String mensaje) throws SQLException {
        Connection c = getConnection();
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

    public ArrayList<Incidencia> listarIncidenciasUserIDDevuelveArrayList(int user_id) throws SQLException {
        ArrayList<Incidencia> arr = new ArrayList<Incidencia>();
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
            arr.add(inci);
            System.out.println(inci);
        }

        rs.close();
        prep.close();
        return arr;

    }

    public void insertarIncidencia(Incidencia inci) {
        Connection c = getConnection();
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
    public void listarUsuarios() throws SQLException {
        Connection c = getConnection();
        try {
            Statement stmt3 = c.createStatement();
            String sql3 = "SELECT * FROM usuarios;";
            ResultSet rs = stmt3.executeQuery(sql3);
            System.out.println("Lista de Usuarios: ");
            while (rs.next()) {
                int id = rs.getInt("usuario_id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("nombre");
                String dni = rs.getString("nombre");
                String correo = rs.getString("nombre");
                int movil = rs.getInt("movil");
                Usuario usuario = new Usuario(id, movil, nombre, apellido, dni, correo, null);
                System.out.println(usuario);
            }
            rs.close();
            stmt3.close();

        } catch (SQLException e) {
        }

    }

    public int selectIDUsuarioTablaUsuarios(String username, String apellido, String dni) throws SQLException {
        Connection c = getConnection();
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

    public void UpdateUsuario(Usuario user) {
        Connection c = getConnection();
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

    public Usuario seleccionar_usuarioPorID(int id) throws SQLException {
        Connection c = getConnection();
        String selectSql = "SELECT * FROM usuarios WHERE usuario_id=?;";
        PreparedStatement ps = (PreparedStatement) c.prepareStatement(selectSql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int user_id = rs.getInt(1);
            String nombre = rs.getString(2);
            String apellido = rs.getString(3);
            Date fecha_nacimiento = rs.getDate(4);
            String correo = rs.getString(6);
            String dni = rs.getString("dni");
            int movil = rs.getInt(7);

            Usuario usuario = new Usuario(user_id,movil, nombre, apellido, dni, correo, fecha_nacimiento);
            System.out.println(usuario);

            rs.close();
            ps.close();
            return usuario;
        }
        return null;
    }

    public Usuario seleccionar_usuario(String dni) throws SQLException {
        Connection c = getConnection();
        String selectSql = "SELECT * FROM usuarios WHERE dni=?;";
        PreparedStatement ps = (PreparedStatement) c.prepareStatement(selectSql);
        ps.setString(1, dni);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int user_id = rs.getInt(1);
            String nombre = rs.getString(2);
            String apellido = rs.getString(3);
            Date fecha_nacimiento = rs.getDate(4);
            String correo = rs.getString(6);
            int movil = rs.getInt(7);
            Usuario usuario = new Usuario(user_id, movil, nombre, apellido, dni, correo, fecha_nacimiento);
            System.out.println(usuario);

            rs.close();
            ps.close();
            return usuario;
        }
        return null;
    }

    public Usuario selectNombreApellidoUsuarioPorUserID(int user_id) throws SQLException {
        Connection c = getConnection();
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

    public void insertarUsuarios(Usuario usuario) {
        Connection c = getConnection();

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
        Connection c = getConnection();
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

    public void insertarTablaUserPassword(int usuario_id, String username, String password) {
        Connection c = getConnection();
        try {
            String insertSql = "INSERT INTO user_login(user_id,username,password) VALUES(?,?,sha1(?))";
            PreparedStatement ps = c.prepareStatement(insertSql);
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
        Connection c = getConnection();
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
        Connection c = getConnection();
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
    public void listarGrupos() throws SQLException {
        Connection c = getConnection();
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

    public int IdGrupoPorIdUsuarios(int usuario_id) throws SQLException {
        Connection c = getConnection();
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

    public int IdViajePorIdGrupo(int grupo_id) throws SQLException {
        Connection c = getConnection();
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

    public int selectIDGrupoPorIDusuario(int usuario_id) {
        Connection c = getConnection();

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
        Connection c = getConnection();
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
        Connection c = getConnection();
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
        Connection c = getConnection();
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
        Connection c = getConnection();
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
        Connection c = getConnection();
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

//-------------------------------------------RESPONSABLES-----------------------------------------------
    public void listarResponsables() throws SQLException {
        Connection c = getConnection();
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
        Connection c = getConnection();
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
        Connection c = getConnection();
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
        Connection c = getConnection();
        try {
            String insertSql = "INSERT INTO responsables(nombre,apellido,movil) VALUES(?,?,?);";
            PreparedStatement ps = c.prepareStatement(insertSql);

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
        Connection c = getConnection();
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
        Connection c = getConnection();
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

    public Viaje selectViajePorNombre(String nombre_hotel) throws SQLException {
        Connection c = getConnection();
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
        Connection c = getConnection();
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
        Connection c = getConnection();
        try {
            String insertSql = "INSERT INTO info_viaje(hotel,direccion_hotel,regimen,estacion_forfait,duracion) VALUES(?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(insertSql);

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
        Connection c = getConnection();
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
        Connection c = getConnection();
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

    public Pagos pagosPorUserID(int usuario_id) throws SQLException {
        Connection c = getConnection();
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
        Connection c = getConnection();
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

    //---------------------------------------------- EVENTOS -------------------------------------------------------------
    public void listarEventos() {
        Connection c = getConnection();
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
        Connection c = getConnection();
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

    public int asistenciaEventos(int evento_id) {
        Connection c = getConnection();
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
        Connection c = getConnection();
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
        Connection c = getConnection();
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
        Connection c = getConnection();
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

    public void listarValoracion() throws SQLException {
        Connection c = getConnection();
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

    public void insertarValoracion(Valoracion valoracion) {
        Connection c = getConnection();
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

    public Valoracion selectValoracioUserIdViajeId(int user_id, int viaje_id) throws SQLException {
        Connection c = getConnection();
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
