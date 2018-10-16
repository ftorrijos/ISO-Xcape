package implementacion;

import DBManager.DBManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.*;

/**
 *
 * @author Alejandro Gutiérrez <agutierrezvivancos@gmail.com>
 */
public class Contacto {

    public Contacto() {

    }

    /**
     *
     * @throws SQLException
     */
    public static void listarUsuarios() throws SQLException {

        try {
            Connection c = DBManager.getConnection();

            Statement stmt3 = c.createStatement();
            String sql3 = "SELECT * FROM usuarios;";
            ResultSet rs = stmt3.executeQuery(sql3);
            System.out.println("Lista de Usuarios: ");

            while (rs.next()) {
                int usuario_id = rs.getInt("usuario_id");
                String nombre = rs.getString("nombre");
                Usuario usuario = new Usuario(usuario_id, nombre);
                System.out.println(usuario);
            }
            rs.close();
            stmt3.close();

        } catch (SQLException e) {
        }

    }

    public static void listarGrupos() throws SQLException {

        try {
            Connection c = DBManager.getConnection();
            Statement stmt4 = c.createStatement();
            String sql4 = "SELECT * FROM grupo;";
            ResultSet rs = stmt4.executeQuery(sql4);
            System.out.println("Lista de Usuarios: ");

            while (rs.next()) {
                int grupo_id = rs.getInt("grupo_id");
                String nombre = rs.getString("nombre");
                Grupo grupo = new Grupo(grupo_id, nombre);
                System.out.println(grupo);
            }
            rs.close();
            stmt4.close();

        } catch (SQLException e) {
        }

    }

}
