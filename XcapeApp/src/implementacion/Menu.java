/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import dBManager.DBManager;
import implementacion.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

/**
 *
 * @author usuario
 */
public class Menu {
      /**
     *
     * @throws SQLException
     */
    
    public static void run() throws SQLException {
        int opcion = 0;
        int opcionC = 0;
        DBManager db = new DBManager();
        do {
            //Aquí estaria login();
          
           
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
                                    //Contacto.listarUsuarios();
                                    System.out.println("\nVolviendo al menu ...");
                                    break;
                                case 2:
                                    //Contacto.listarResponsables();
                                    break;
                                case 3:
                                    db.listarGrupos();
                                    System.out.println("\nVolviendo al menu ...");
                                    break;
                                case 4:
                                    db.listarIncidencias();
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
        System.out.println("1.MI VIAJE");
        System.out.println("2.GESTION DE PERFIL");
        System.out.println("3.EVENTOS");
        System.out.println("4.CHAT");
        System.out.println("5.MAPA");
        System.out.println("6.TIEMPO");
        System.out.println("7.SPLITWISE");
        System.out.println("8.MEDIA");
        System.out.println("9.VALORA TU EXP");
        System.out.println("10.SALIR");
    }

    public static void mostrarMenuContactos() {
        System.out.println("\t " + "MÓDULO CONTACTO:");
        System.out.println("1.Consultar lista de usuarios");
        System.out.println("2.Consultar lista de responsables");
        System.out.println("3.Consultar lista de grupos");
        System.out.println("4.Consultar incidencias");
        System.out.println("5.Volver al menú principal");
    }

    public static void mostrarMenuGestionPerfil() {
	System.out.println("\t " + "MÓDULO GESTION PERFIL:");
	System.out.println("1.");
	System.out.println("2.");
	System.out.println("3.");
	System.out.println("4.");

	}

    public static void mostrarMenuChat() {
	System.out.println("\t " + "MÓDULO CHAT:");
	System.out.println("1.");
	System.out.println("2.");
	System.out.println("3.");
	System.out.println("4.");

	}

    public static void mostrarMenuMapa() {
	System.out.println("\t " + "MÓDULO MAPA:");
	System.out.println("1.");
	System.out.println("2.");
	System.out.println("3.");
	System.out.println("4.");

	}

public static void mostrarMenuTiempo() {
	System.out.println("\t " + "MÓDULO TIEMPO:");
	System.out.println("1.");
	System.out.println("2.");
	System.out.println("3.");
	System.out.println("4.");

	}

public static void mostrarMenuSplitwise() {
	System.out.println("\t " + "MÓDULO SPLITWISE:");
	System.out.println("1.");
	System.out.println("2.");
	System.out.println("3.");
	System.out.println("4.");

	}
public static void mostrarMenuMedia() {
	System.out.println("\t " + "MÓDULO MEDIA:");
	System.out.println("1.");
	System.out.println("2.");
	System.out.println("3.");
	System.out.println("4.");

	}

    public static void mostrarMenuValorar() {
	System.out.println("\t " + "MÓDULO VALORACION:");
	System.out.println("1.");
	System.out.println("2.");
	System.out.println("3.");
	System.out.println("4.");

	}
}
