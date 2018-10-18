/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import implementacion.Contacto;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Responsable {

    private int responsable_id, grupo_id;
    private String nombre;
    Contacto contacto = new Contacto();

    public Responsable(int responsable_id, String nombre, int grupo_id) {
        this.nombre = nombre;
        this.responsable_id = responsable_id;
        this.grupo_id = grupo_id;

    }

    /**
     * @return the responsable_id
     */
    public int getResponsable_id() {
        return responsable_id;
    }

    /**
     * @param responsable_id the responsable_id to set
     */
    public void setResponsable_id(int responsable_id) {
        this.responsable_id = responsable_id;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        try {
            return "Responsable {" + "id=" + responsable_id + ", nombre=" + nombre + ", responsable del grupo=" + contacto.listarGruposSoloNombre(grupo_id) + '}';
        } catch (SQLException ex) {
            Logger.getLogger(Responsable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
