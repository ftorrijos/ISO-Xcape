/*
Interfaz
 */
package interfaz;

import implementacion.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

/**
 *
 * @author Alejandro Gutiérrez <agutierrezvivancos@gmail.com>
 */
public class InterfazConsola {

    /**
     *
     * @throws SQLException
     */
    public static void run() throws SQLException {
        int opcion = 0;
        int opcionC = 0;
        do {
            mostrarMenu();
            try {
                BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("\nInserte opción -> ");
                opcion = Integer.parseInt(consola.readLine());
                System.out.println("");
                switch (opcion) {
                    case 1:
                        do {
                            System.out.println("");
                            mostrarMenuContactos();
                            System.out.print("\nInserte opción -> ");
                            opcionC = Integer.parseInt(consola.readLine());

                            switch (opcionC) {
                                case 1:
                                    Contacto.listarUsuarios();
                                    System.out.println("\nVolviendo al menu ...");
                                    break;
                                case 2:
                                    Contacto.listarResponsables();
                                    break;
                                case 3:
                                    Contacto.listarGrupos();
                                    System.out.println("\nVolviendo al menu ...");
                                    break;
                                default:
                                    System.out.println("\nVolviendo al menu principal...");
                                    break;
                            }
                        } while (opcionC < 3);
                        break;
                    case 2:
                        GestionPerfil gp = new GestionPerfil();
                        gp.insertar_usuario();
                        break;
                    case 3:
                        //modulos.Chat();
                        break;
                    case 4:
                        //modulos.Mapa();
                        break;
                    case 5:
                        //modulos.Tiempo();
                        break;
                    case 6:
                        //modulos.SplitWise();
                        break;
                    case 7:
                        //modulos.Media();
                        break;
                    case 8:
                        //modulos.ValoraTuExp();
                        break;
                    default:
                        break;
                }
            } catch (IOException ex) {
                System.out.println("Se ha producido un error:" + ex);
            }
        } while (opcion < 9);
    }

    /**
     * MENU
     */
    public static void mostrarMenu() {
        System.out.println("\t" + "MENU");
        System.out.println("1.CONTACTOS");
        System.out.println("2.GESTION DE PERFIL");
        System.out.println("3.CHAT");
        System.out.println("4.MAPA");
        System.out.println("5.TIEMPO");
        System.out.println("6.SPLITWISE");
        System.out.println("7.MEDIA");
        System.out.println("8.VALORA TU EXP");
        System.out.println("9.SALIR");
    }

    public static void mostrarMenuContactos() {
        System.out.println("\t " + "MÓDULO CONTACTO:");
        System.out.println("1.Consultar lista de usuarios");
        System.out.println("2.Consultar lista de responsables");
        System.out.println("3.Consultar lista de grupos");
        System.out.println("4.Volver al menú principal");
    }
}
