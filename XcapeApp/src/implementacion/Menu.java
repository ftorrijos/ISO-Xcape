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
import modelo.*;

/**
 *
 * @author usuario
 */
public class Menu {

    /**
     *
     * @throws SQLException
     */
    public static void run(int usuario_id) throws SQLException {
        DBManager db = new DBManager();
        int opcion = 0;
        int opcionC = 0;
        do {
            System.out.println("Hola: " + db.selectNombreUsuario(usuario_id) + " bienvenido.");
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
                            mostrarMenuMiViaje();
                            System.out.print("\nInserte opción -> ");
                            opcionC = Integer.parseInt(consola.readLine());

//  public static void mostrarMenuMiViaje() {
//        System.out.println("\t " + "MÓDULO MiViaje:");
//        System.out.println("1.Consultar información sobre mi viaje");
//        System.out.println("2.Consultar mis pagos");
//        System.out.println("3.Consultar mi grupos");
//        System.out.println("4.Consultar mi responsable");
//        System.out.println("5.Consultar mis incicendias");
//        System.out.println("6.Volver al menú principal");
//    }
//                            
                            switch (opcionC) {
                                case 1:
                                    int id_grupo2 = db.IdGrupoPorIdUsuarios(usuario_id);
                                    int viaje_id = db.IdViajePorIdGrupo(id_grupo2);
                                    db.listarViajePorID(viaje_id);
                                    System.out.println("\nVolviendo al menu ...");
                                    break;
                                case 2:

                                    db.listarGruposSoloNombre(db.IdGrupoPorIdUsuarios(usuario_id));
                                    System.out.println("\nVolviendo al menu ...");
                                    break;
                                case 3:
                                    System.out.println("Tu grupo es: " + db.listarGruposSoloNombre(db.IdGrupoPorIdUsuarios(usuario_id)));
                                    System.out.println("\nVolviendo al menu ...");
                                    break;
                                case 4:
                                    int id_grupo = db.IdGrupoPorIdUsuarios(usuario_id);
                                    int responsable_id = db.IdResponsablePorGrupoID(id_grupo);
                                    Responsable respon = db.listarResponsableYContacto(responsable_id);
                                    System.out.println("Tu responsable se llama:" + respon.getNombre() + " " + respon.getApellido() + " y su contacto es: " + respon.getMovil());
                                    System.out.println("\nVolviendo al menu ...");
                                    break;
                                case 5:
                                    db.listarIncidenciasUserID(usuario_id);

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
                        do {
                            System.out.println("MENU USUARIO");
                            mostrarMenuGestionPerfil();
                            System.out.print("\nInserte opción -> ");
                            opcion = Integer.parseInt(consola.readLine());

                            switch (opcion) {
                                case 1:
                                    gp.ver_Datos();
                                    System.out.println("\nVolviendo al menu ...");
                                    break;
                                case 2:
                                    //ModificarMiPerfil();
                                    break;
                                case 3:
                                    gp.insertar_usuario();
                                    System.out.println("\nVolviendo al menu ...");
                                    break;
                                default:
                                    System.out.println("\nVolviendo al menu principal...");
                                    break;
                            }
                        } while (opcion < 2);
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

    public static void mostrarMenuMiViaje() {
        System.out.println("\t " + "MÓDULO MiViaje:");
        System.out.println("1.Consultar información sobre mi viaje");
        System.out.println("2.Consultar mis pagos");
        System.out.println("3.Consultar mi grupos");
        System.out.println("4.Consultar mi responsable");
        System.out.println("5.Consultar mis incidencias");
        System.out.println("6.Volver al menú principal");
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
        System.out.println("1.Ver mi perfil");
        System.out.println("2.Modificar mi perfil");
        System.out.println("3.Añadir usuario");
        System.out.println("4.Volver a menu principal");

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
