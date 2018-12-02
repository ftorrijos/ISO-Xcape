/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import dBManager.DBManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;
import modelo.*;

/**
 *
 * @author usuario
 */
public class MenuAdmin {

    DBManager db = new DBManager();

    public void Menuadmin(int usuario_id) throws IOException, SQLException {
        System.out.println("\b");
        System.out.println("\b");
        //dejar un espacio
        System.out.println("Hola: " + db.selectUserNameUsuario(usuario_id) + ", bienvenido al menu administración:");
        int opcion = 0;
        MenuAdmin.mostrartMenuAdmin();
        BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nInserte opción -> ");
        opcion = Integer.parseInt(consola.readLine());
        System.out.println("");
        switch (opcion) {
            case 1:
                db.listarGrupos();
                Menuadmin(usuario_id);
                break;
            case 2:
                Grupo grupo = insertarGrupoLectura();
                db.insertarGrupo(grupo);
                Menuadmin(usuario_id);
                break;
            case 3:
                db.listarIncidencias();
                Menuadmin(usuario_id);
                break;
            case 4:
                Incidencia inci = insertarIncidenciaLectura(usuario_id);
                db.insertarIncidencia(inci);
                Menuadmin(usuario_id);
                break;
            case 5:
                db.listarPagos();
                Menuadmin(usuario_id);
                break;
            case 6:
                Pagos pago = insertarPagosLectura(usuario_id);
                db.insertarPagos(pago);
                Menuadmin(usuario_id);
                break;
            case 7:
                db.listarResponsables();
                Menuadmin(usuario_id);
                break;
            case 8:
                Responsable respon = insertarResponsableLectura();
                db.insertarResponsable(respon);
                Menuadmin(usuario_id);
                break;
            case 9:
                db.listarUsuarios();
                Menuadmin(usuario_id);
                break;
            case 10:
                insertar_usuario();
                Menuadmin(usuario_id);
                break;
            case 11:
                db.listarViajes();
                Menuadmin(usuario_id);
                break;
            case 12:
                Viaje viaje = insertarViajeLectura();
                db.insertarViajes(viaje);
                Menuadmin(usuario_id);
                break;
            case 13:
                db.listarEventos();
                Menuadmin(usuario_id);
                break;
            case 14:
                Evento evento = insertarEvento();
                db.insertarEventos(evento);
                Menuadmin(usuario_id);
                break;
            default:
                System.out.println("\nVolviendo al menu principal...");
                break;
        }

    }

    private static void mostrartMenuAdmin() {
        System.out.println("\t" + "MENU");
        System.out.println("1.Mostrar grupos");
        System.out.println("2.Insertar grupos");
        System.out.println("3.Mostar incidencias");
        System.out.println("4.Insertar incidencias");
        System.out.println("5.Mostrar pagos");
        System.out.println("6.InsertarPago");
        System.out.println("7.Mostrar responsables");
        System.out.println("8.Insertar responsables");
        System.out.println("9.Mostar Usuarios");
        System.out.println("10.Insertar usuarios(CURRENTLY UNAVAILABLE)");
        System.out.println("11.Mostrar viajes");
        System.out.println("12.Insertar viajes");
        System.out.println("13.Listar Eventos");
        System.out.println("14.Insertar Eventos");
        System.out.println("15.SALIR");

    }
     private static void mostrartMenuGrupos() {
        System.out.println("\t" + "MENU GRUPOS");
        System.out.println("1.Mostrar");
        System.out.println("2.Insertar");
        System.out.println("3.Borrar");
        System.out.println("15.SALIR");

    }

    private Grupo insertarGrupoLectura() throws SQLException {

        Scanner scGrupo = new Scanner(System.in);
        System.out.println("Por favor introducir el nombre del viaje:");
        String nombre = scGrupo.nextLine();
        db.listarResponsables();
        System.out.println("Por favor introducir el id del responsable:");
        int responsable_id = scGrupo.nextInt();
        db.listarViajes();
        System.out.println("Por favor introducir el id del viaje:");
        int viaje_id = scGrupo.nextInt();
        Grupo group = new Grupo(responsable_id, viaje_id, nombre);
        return group;
    }

    private Incidencia insertarIncidenciaLectura(int usuario_id) throws SQLException {

        Scanner scInci = new Scanner(System.in);
        System.out.println("Por favor introducir la incidencia:");
        String mensaje = scInci.nextLine();
        System.out.println("Por favor introducir el id del grupo:");
        int grupo_id = scInci.nextInt();

        System.out.println("Gracias lo tendremos en cuenta!");
        Incidencia incidencia = new Incidencia(usuario_id, grupo_id, mensaje);
        return incidencia;
    }

    private Pagos insertarPagosLectura(int usuario_id) throws SQLException {

        Scanner scPago = new Scanner(System.in);
        System.out.println("Por favor introducir el metodo de pago:");
        String metodo_pago = scPago.nextLine();
        System.out.println("Por favor introducir el DNI:");
        String dni = scPago.nextLine();
        System.out.println("Ha realizado el primer pago?");
        System.out.println("1.Pago realizado");
        System.out.println("2.Pago NO realizado");
        int c = 0;
        c = scPago.nextInt();

        String primer_pago = null;
        switch (c) {
            case 1:
                primer_pago = "ok";
                break;
            case 2:
                primer_pago = null;
                break;
            default:
                break;
        }
        System.out.println("Ha realizado el segundo pago?");
        System.out.println("1.Pago realizado");
        System.out.println("2.Pago NO realizado");
        int x = 0;
        x = scPago.nextInt();
        String segundo_pago = null;
        switch (x) {
            case 1:
                segundo_pago = "ok";
                break;
            case 2:
                segundo_pago = null;
                break;
            default:
                break;
        }
        System.out.println("Por favor introducir el id del usuario:");
        int user_id = scPago.nextInt();

        // el admin no tiene que realizar pagos, lo hace en caso de erroor por eso debe asignarle un ID al usuario
        Pagos pago = new Pagos(metodo_pago, primer_pago, segundo_pago, user_id, dni);
        return pago;
    }

    private Responsable insertarResponsableLectura() throws SQLException {

        Scanner scInci = new Scanner(System.in);
        System.out.println("Por favor introducir el nombre:");
        String nombre = scInci.nextLine();
        System.out.println("Por favor introducir el apellido:");
        String apellido = scInci.nextLine();
        System.out.println("Por favor introducir el movil del responsable:");
        int movil = scInci.nextInt();
        Responsable respon = new Responsable(nombre, apellido, movil);
        return respon;
    }

    private Viaje insertarViajeLectura() throws SQLException {

        Scanner scViaje = new Scanner(System.in);
        System.out.println("Por favor introducir el hotel:");
        String hotel = scViaje.nextLine();
        System.out.println("Por favor introducir la direccion del hotel:");
        String direccion_hotel = scViaje.nextLine();
        System.out.println("Por favor introducir el regimen:");
        String regimen = scViaje.nextLine();
        System.out.println("Por favor introducir la estacion:");
        String estacion_forfait = scViaje.nextLine();
        System.out.println("Por favor introducir la duración:");
        int duracion = scViaje.nextInt();
        Viaje viaje = new Viaje(hotel, direccion_hotel, regimen, estacion_forfait, duracion);
        return viaje;
    }
    
    private Evento insertarEvento() throws SQLException {

        Scanner scViaje = new Scanner(System.in);
        System.out.println("Por favor introducir el nombre de la fiesta:");
        String nombre = scViaje.nextLine();
        System.out.println("Por favor introducir la direccion:");
        String direccion = scViaje.nextLine();
        System.out.println("Por favor introducir la ciudad:");
        String ciudad = scViaje.nextLine();
        System.out.println("Por favor introducir la fecha(xx/xx/xxxx):");
        String fecha = scViaje.nextLine().toLowerCase();
        
        
        Evento evento = new Evento(nombre,direccion,ciudad,fecha,0);
        
        return evento;
    }public void insertar_usuario() {
        System.out.println("\tREGISTRO:");
        System.out.println("Por favor, introduzca los siguientes datos:");
        try {
            BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Nombre: ");
            String nombre = consola.readLine();
            System.out.println("Apellido:");
            String apellido = consola.readLine();
            System.out.println("Fecha de nacimiento en formato AAAA/MM/DD");
            Date fecha_nacimiento = new Date(consola.readLine());
            System.out.println("DNI:");
            String dni = consola.readLine();
            System.out.println("Correo electrónico:");
            String correo = consola.readLine();
            System.out.println("Movil: ");
            int movil = Integer.parseInt(consola.readLine());
            Usuario usuario = new Usuario(movil, nombre, apellido, dni, correo, fecha_nacimiento);
            DBManager.insertarUsuarios(usuario);
           //System.out.println(usuario.getNombre() + " bienvenido a la eXperiencia Xcape");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
