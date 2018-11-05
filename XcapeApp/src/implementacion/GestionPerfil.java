package implementacion;

import dBManager.DBManager;
import java.io.*;
import java.sql.SQLException;
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
        System.out.println("Mi perfil: ");
        try {
            BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Introduzca DNI: ");
            String dni = consola.readLine();
            db.seleccionar_usuario(dni);
        } catch (IOException e) {
            System.out.println("Se ha producido un error:" + e);
        }

    }
}
