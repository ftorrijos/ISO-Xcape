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
        System.out.println("Hola: " + db.selectNombreUsuario(usuario_id) + ", bienvenido al menu administración:");
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
                //pagos
                Menuadmin(usuario_id);
                break;
            case 6:
                Menuadmin(usuario_id);
                break;
            case 7:
                db.listarResponsables();
                Menuadmin(usuario_id);
                break;
            case 8:
                Menuadmin(usuario_id);
                break;
            case 9:
                db.listarUsuarios();
                Menuadmin(usuario_id);
                break;
            case 10:
                Menuadmin(usuario_id);
                break;
            case 11:
                db.listarViajes();
                Menuadmin(usuario_id);
                break;
            case 12:

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
        System.out.println("10.Insertar usuarios");
        System.out.println("11.Mostrar viajes");
        System.out.println("12.Insertar viajes");
        System.out.println("13.SALIR");

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
}
