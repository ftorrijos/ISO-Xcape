/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class Evento {

    private int evento_id, listas;
    private String nombre, direccion, ciudad, fecha;

    public Evento(int evento_id, String nombre, String direccion, String ciudad, String fecha, int listas) {
        this.evento_id = evento_id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.fecha = fecha;
        this.listas = listas;
    }
    public Evento( String nombre, String direccion, String ciudad, String fecha, int listas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.fecha = fecha;
        this.listas = listas;
    }

    /**
     * @return the evento_id
     */
    public int getEvento_id() {
        return evento_id;
    }

    /**
     * @param evento_id the evento_id to set
     */
    public void setEvento_id(int evento_id) {
        this.evento_id = evento_id;
    }

    /**
     * @return the listas
     */
    public int getListas() {
        return listas;
    }

    /**
     * @param listas the listas to set
     */
    public void setListas(int listas) {
        this.listas = listas;
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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {

        return "Evento{" + "Id=" + getEvento_id() + ", nombre=" + getNombre() + " ,dirección=" + getDireccion() + " ,ciudad=" + getCiudad() + " , fecha=" + getFecha() + " ,asistentes= " + getListas() + '}';

    }

}
