package implementacion;

import dBManager.DBManager;
import java.util.Scanner;

/**
 *
 * @author Alejandro Gutiérrez <agutierrezvivancos@gmail.com>
 */
public class GestionPerfil {

    DBManager db = new DBManager();

    public void insertar_usuario() {
        System.out.println("Porfavor introducir el nombre del usuario:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        db.insertarUsuarios(name);
        System.out.println("Ususario:" + name + " ,insertado correctamente.");

    }
}
