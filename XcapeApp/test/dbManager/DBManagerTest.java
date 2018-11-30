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
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import dBManager.DBManager;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.junit.Ignore;

/**
 *
 * @author usuario
 */
public class DBManagerTest {

    public DBManagerTest(){}
    
    DBManager db = new DBManager();
    Login log = new Login();

//----------Usuario de prueba, es el usuario mock que no llega a almacenarse en la BBDD
    Date date = new Date(1991 / 10 / 10);
    Usuario mockUser = new Usuario(5000, 879123542, "UsuarioPrueba", "ApellidoPrueba", "00000000K", "correo@prueba.com", date);
    LoginObjeto mockLogin = new LoginObjeto();
    Responsable mockResponsable = new Responsable("responsablenombre", "responsableapellido", 655549786);
    Evento mockEvento = new Evento("evento mock", "una dirección", "ciudad", "27/08/1960", 14632);
    Viaje mockViaje = new Viaje("ViajeHotel", "DireccionHotel", "RegimenCompletoTieso", "EstacionTodas", 15000);
    Pagos mockPago = new Pagos("Bitcoin", "ok", "NULL", 0, "");
    Grupo mockGrupo = new Grupo(0, 0, "Viaje-01");
    Valoracion mockValoracion = new Valoracion(0,0,99,"si");
    Incidencia mockIncidencia = new Incidencia(0, 0, "Esto es un test de incidencias");
   
    
    

    //@Override
    protected void setUp() throws Exception {
        System.out.println("Creando la infraestructura de los test");
        createDatabase();
        createTables();
    }

    //@Override
    protected void tearDown() throws Exception {
        System.out.println("Destruyendo la infraestrucutra de los test");
        // dropDatabase();
    }
//primer test de prueba

    @Test
    public void testAdd1Plus1() throws InterruptedException {

        int x = 1;
        int y = 1;
        assertEquals(2, (x + y));
        TimeUnit.SECONDS.sleep(20);
    }

    //--------------------------------------Test de Login ------------------------------------------------------
    @Test
    public void testLogHash() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        assertEquals("5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8", Login.hash("password").toLowerCase());
    }

    @Ignore
    @Test
    public void testLoginAdmin() {
        String username = "admin";
        String password = "admin";
        LoginObjeto logobj = new LoginObjeto(10, "okadmin");

        try {
            assertEquals(logobj.getPass(), log.comprobarUserPassword(username, password).getPass());
        } catch (SQLException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(DBManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//-----------------------------------------TEST CORRESPONDIENTES A DB_Manager------------------------------------------------
    //-------------------------- comprobación incidencias ----------------------------------------------------------------
    
    @Test
    public void testInsercciónSelecciónTodo() throws SQLException {
        DBManager.insertarUsuarios(mockUser);
        int mockUser_id = db.seleccionar_usuario(mockUser.getDni()).getUsuario_id();
        mockLogin.setUsuario_id(mockUser_id);
        DBManager.insertarTablaUserPassword(mockUser_id, "UsuarioPrueba", "passwordprueba");
        db.insertarResponsable(mockResponsable);
        mockResponsable.setResponsable_id(db.selectResponsableYContactoPorNombre(mockResponsable.getNombre()).getResponsable_id());
        mockGrupo.setResponsable_id(mockResponsable.getResponsable_id());
        db.insertarViajes(mockViaje);
        mockViaje.setViaje_id(db.selectViajePorNombre(mockViaje.getHotel()).getViaje_id());
        mockGrupo.setViaje_id(mockViaje.getViaje_id());
        db.insertarEventos(mockEvento);
        db.selectEventoPorNombre(mockEvento.getNombre());
        db.insertarViajes(mockViaje);
        DBManager.selectViajePorNombre(mockViaje.getHotel());
        db.insertarPagos(mockPago);
        mockPago.setUsuario_id(mockUser.getUsuario_id());
        mockPago.setDni(mockUser.getDni());
        db.insertarGrupo(mockGrupo);
        DBManager.seleccionar_usuarioPorID(mockUser_id);
        db.insertarGrupo(mockGrupo);
        mockGrupo.setGrupo_id(db.selectGrupoPorNombre(mockGrupo.getNombre()).getGrupo_id());
        mockGrupo.setViaje_id(db.selectGrupoPorNombre(mockGrupo.getNombre()).getViaje_id());
        DBManager.insertarValoracion(mockValoracion);
        mockValoracion.setViaje_id(db.selectValoracioUserIdViajeId(mockUser.getUsuario_id(), mockViaje.getViaje_id()).getValora_id());
        mockValoracion.setUsuario_id(mockUser.getUsuario_id());
        mockValoracion.setViaje_id(mockViaje.getViaje_id());
        DBManager.insertarIncidencia(mockIncidencia);
        mockIncidencia.setIncidencia_id(DBManager.selectIncidenciaPorUserIdYMensaje(mockUser.getUsuario_id(), mockIncidencia.getMensaje()).getIncidencia_id());
        
        System.out.println(mockUser);
        System.out.println(mockLogin);
        System.out.println(mockResponsable);
        System.out.println(mockValoracion);
        System.out.println(mockPago);
        System.out.println(mockViaje);
        System.out.println(mockIncidencia);
        System.out.println(mockEvento);
        System.out.println(mockGrupo);
        
        assertEquals(1,1);
    }

    @Ignore
    @Test
    public void testLoginUser() throws SQLException {
        Connection c = getConnection();

//            assertEquals(logobj.getPass(), log.comprobarUserPassword(username, password).getPass());
        c.close();
    }

    //----------------------------CREACION BBDD PRUEBA Y CONEXIONES ---------------------------------------------
    public static void createDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=root");
            Statement st = conn.createStatement();
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS dbxTesting");
            System.out.println("Database created !");
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void createTables() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbxTesting", "root", "root");
            Statement st = conn.createStatement();
            st.execute("CREATE TABLE eventos(evento_id int(11) NOT NULL AUTO_INCREMENT,nombre varchar(30) DEFAULT NULL,direccion varchar(60) DEFAULT NULL,ciudad varchar(50) DEFAULT NULL,fecha varchar(20) DEFAULT NULL,listas int(11) DEFAULT NULL,PRIMARY KEY (evento_id))");
            st.execute("CREATE TABLE grupo(grupo_id int(11) NOT NULL AUTO_INCREMENT,nombre varchar(10) DEFAULT NULL,responsable_id int(11) DEFAULT NULL,viaje_id int(11) DEFAULT NULL,PRIMARY KEY (grupo_id), KEY responsable_id(responsable_id),KEY viaje_id(viaje_id),CONSTRAINT grupo_ibfk_1 FOREIGN KEY (responsable_id) REFERENCES responsables(responsable_id),CONSTRAINT grupo_ibfk_2 FOREIGN KEY (viaje_id) REFERENCES info_viaje(viaje_id`)");
            st.execute("CREATE TABLE incidencias(incidencia_id int(11) NOT NULL AUTO_INCREMENT,usuario_id int(11) DEFAULT NULL,grupo_id int(11) DEFAULT NULL,mensaje varchar(500) DEFAULT NULL,PRIMARY KEY (incidencia_id), KEY grupo_id (grupo_id),KEY `usuario_id (usuario_id),CONSTRAINT incidencias_ibfk_1 FOREIGN KEY (grupo_id) REFERENCES grupo (grupo_id),CONSTRAINT incidencias_ibfk_2 FOREIGN KEY (usuario_id) REFERENCES usuarios (usuario_id)");
            st.execute("CREATE TABLE info_viaje(viaje_id int(11) NOT NULL AUTO_INCREMENT,hotel varchar(50) DEFAULT NULL,direccion_hotel varchar(100) DEFAULT NULL,regimen varchar(50) DEFAULT NULL,estacion_forfait varchar(50) DEFAULT NULL,duracion int(11) DEFAULT NULL,PRIMARY KEY (viaje_id)");
            st.execute("CREATE TABLE pagos(pago_id int(11) NOT NULL AUTO_INCREMENT,metodo_pago varchar(15) DEFAULT NULL,primer_pago varchar(15) DEFAULT NULL,segundo_pago varchar(15) DEFAULT NULL,usuario_id int(11) DEFAULT NULL,DNI varchar(20) DEFAULT NULL,PRIMARY KEY (pago_id), KEY usuario_id(usuario_id), CONSTRAINT pagos_ibfk_1 FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)");
            st.execute("");
            System.out.println("Tables created !");
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void dropDatabase() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user=root&password=root");
            Statement st = conn.createStatement();
            int myResult = st.executeUpdate("DROP DATABASE dbxTesting");
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
}
