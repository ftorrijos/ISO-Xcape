package implementacion;

import dBManager.DBManager;
import java.io.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import modelo.Usuario;

/**
 *
 * @author Alejandro Gutiérrez <agutierrezvivancos@gmail.com>
 */
public class GestionPerfil {

    DBManager db = new DBManager();

    public void insertar_usuario() {
        System.out.println("\tREGISTRATE:");
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
            db.insertarUsuarios(usuario);
            System.out.println(usuario.getNombre() + " bienvenido a la eXperiencia Xcape");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public void ver_Datos() throws SQLException {
        System.out.println("\n\tMi perfil: ");
        try {
            BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introduzca DNI: ");
            String dni = consola.readLine();
            db.seleccionar_usuario(dni);
        } catch (IOException e) {
            System.out.println("Se ha producido un error:" + e);
        }
    }

    public void modificar_Datos() throws SQLException, ParseException {
        System.out.println("\n\tMODIFICACIÓN DATOS");
        try {
            BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introduzca DNI: ");
            String dni = consola.readLine();
            Usuario usuario = db.seleccionar_usuario(dni);

            int opcion;
            //String variable;
            do {
                System.out.println("Que dato desea modificar: ");
                System.out.println("1.Nombre");
                System.out.println("2.Apellido");
                System.out.println("3.DNI");
                System.out.println("4.Correo");
                System.out.println("5.Fecha de nacimiento");
                System.out.println("6.Movil");
                System.out.println("7.Volver al menu ...");
                System.out.println("\nopcion -> ");
                opcion = Integer.parseInt(consola.readLine());
                switch (opcion) {
                    case 1:
                        //variable = "nombre";
                        System.out.println("Introduzca nuevo nombre: ");
                        String nuevoNombre = consola.readLine();
                        Usuario usuarioNew = new Usuario(usuario.getUsuario_id(),
                                usuario.getMovil(), nuevoNombre,
                                usuario.getApellido(), usuario.getDni(),
                                usuario.getCorreo(),
                                usuario.getFecha_nacimiento());
                        System.out.println(usuarioNew);
                        db.modificarUsuarios(usuarioNew);
                        System.out.println("Nombre modificado con exito");
                        break;
                    case 2:
                        System.out.println("Introduzca nuevo apellido: ");
                        String nuevoApellido = consola.readLine();
                        Usuario usuarioNew2 = new Usuario(usuario.getUsuario_id(),
                                usuario.getMovil(), usuario.getNombre(),
                                nuevoApellido, usuario.getDni(),
                                usuario.getCorreo(),
                                usuario.getFecha_nacimiento());
                        System.out.println(usuarioNew2);
                        db.modificarUsuarios(usuarioNew2);
                        System.out.println("Apellido modificado con exito");
                        break;
                    case 3:
                        System.out.println("Introduzca nuevo DNI: ");
                        String nuevoDni = consola.readLine();
                        Usuario usuarioNew3 = new Usuario(usuario.getUsuario_id(),
                                usuario.getMovil(), usuario.getNombre(),
                                usuario.getApellido(),nuevoDni,
                                usuario.getCorreo(),
                                usuario.getFecha_nacimiento());
                        System.out.println(usuarioNew3);
                        db.modificarUsuarios(usuarioNew3);
                        System.out.println("DNI modificado con exito");
                        break;
                    case 4:
                        System.out.println("Introduzca nuevo correo: ");
                        String nuevoCorreo = consola.readLine();
                        Usuario usuarioNew4 = new Usuario(usuario.getUsuario_id(),
                                usuario.getMovil(), usuario.getNombre(),
                                usuario.getApellido(), usuario.getDni(),
                                nuevoCorreo,
                                usuario.getFecha_nacimiento());
                        System.out.println(usuarioNew4);
                        db.modificarUsuarios(usuarioNew4);
                        System.out.println("Correo modificado con exito");
                        break;
                    case 5:
                        System.out.println("Introduzca nueva fecha de nacimiento: ");
                        Date nuevaFechaNacimiento = new Date(consola.readLine());
                        Usuario usuarioNew5 = new Usuario(usuario.getUsuario_id(),
                                usuario.getMovil(), usuario.getNombre(),
                                usuario.getApellido(), usuario.getDni(),
                                usuario.getCorreo(),
                                nuevaFechaNacimiento);
                        System.out.println(usuarioNew5);
                        db.modificarUsuarios(usuarioNew5);
                        System.out.println("Fecha modificada con exito");
                        break;
                    case 6:
                        System.out.println("Introduzca nuevo movil: ");
                        int nuevoMovil = Integer.parseInt(consola.readLine());
                        Usuario usuarioNew6 = new Usuario(usuario.getUsuario_id(),
                                nuevoMovil, usuario.getNombre(),
                                usuario.getApellido(), usuario.getDni(),
                                usuario.getCorreo(),
                                usuario.getFecha_nacimiento());
                        System.out.println(usuarioNew6);
                        db.modificarUsuarios(usuarioNew6);
                        System.out.println("Nombre modificado con exito");
                        break;
                    default:
                        System.out.println("Dato no reconocido");
                        break;
                }
            } while (opcion < 7);
        } catch (IOException ex) {
            System.out.println("Se ha producido un error:" + ex);
        }
    }
}
