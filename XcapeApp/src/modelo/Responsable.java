/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dBManager.DBManager;
import implementacion.Contacto;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Responsable {

    private int responsable_id, movil;
    private String nombre, apellido;
    DBManager db = new DBManager();

    public Responsable(int responsable_id, String nombre, String apellido, int movil) {
        this.nombre = nombre;
        this.apellido=apellido;
        this.responsable_id = responsable_id;
        this.movil=movil;              
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
     * @return the movil
     */
    public int getMovil() {
        return movil;
    }

    /**
     * @param movil the movil to set
     */
    public void setMovil(int movil) {
        this.movil = movil;
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

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

     @Override
    public String toString() {
     return "Responsable {"+"responsable id="+getResponsable_id()+", nombre="+getNombre()+" "+getApellido()+ " , contacto=" + getMovil() + '}';
        
    }
    
}
