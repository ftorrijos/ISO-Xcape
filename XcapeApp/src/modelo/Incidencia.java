/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dBManager.DBManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro Gutiérrez <agutierrezvivancos@gmail.com>
 */
public class Incidencia {

    DBManager db = new DBManager();
    private int incidencia_id, usuario_id, grupo_id;
    private String mensaje;

    public Incidencia(int incidencia_id, int usuario_id, int grupo_id, String mensaje) {
        this.incidencia_id = incidencia_id;
        this.usuario_id = usuario_id;
        this.grupo_id = grupo_id;
        this.mensaje = mensaje;
    }

    public Incidencia(int usuario_id, int grupo_id, String mensaje) {
        this.usuario_id = usuario_id;
        this.grupo_id = grupo_id;
        this.mensaje = mensaje;
    }

    /**
     * @return the incidencia_id
     */
    public int getIncidencia_id() {
        return incidencia_id;
    }

    /**
     * @param incidencia_id the incidencia_id to set
     */
    public void setIncidencia_id(int incidencia_id) {
        this.incidencia_id = incidencia_id;
    }

    /**
     * @return the usuario_id
     */
    public int getUsuario_id() {
        return usuario_id;
    }

    /**
     * @param usuario_id the usuario_id to set
     */
    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    /**
     * @return the grupo_id
     */
    public int getGrupo_id() {
        return grupo_id;
    }

    /**
     * @param grupo_id the grupo_id to set
     */
    public void setGrupo_id(int grupo_id) {
        this.grupo_id = grupo_id;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     *
     * @throws SQLException
     */

    @Override
    public String toString() {
        try {
            return "Incidencia{" + "incidencia_id=" + getIncidencia_id() + ", usuario=" + db.listarUsuariosSoloNombre(usuario_id) + " ,grupo=" + db.listarGruposSoloNombre(grupo_id) + " ,mensaje=" + mensaje + "}\n";
        } catch (SQLException ex) {
            Logger.getLogger(Incidencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
