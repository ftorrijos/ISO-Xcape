/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Alejandro Gutiérrez <agutierrezvivancos@gmail.com>
 */
public class Grupo {

    private int grupo_id, responsable_id, viaje_id;
    private String nombre;

    public Grupo(int grupo_id, int responsable_id, int viaje_id, String nombre) {
        this.grupo_id = grupo_id;
        this.responsable_id = responsable_id;
        this.viaje_id = viaje_id;
        this.nombre = nombre;
    }

    public Grupo(int responsable_id, int viaje_id, String nombre) {
        this.responsable_id = responsable_id;
        this.viaje_id = viaje_id;
        this.nombre = nombre;
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
     * @return the viaje_id
     */
    public int getViaje_id() {
        return viaje_id;
    }

    /**
     * @param viaje_id the viaje_id to set
     */
    public void setViaje_id(int viaje_id) {
        this.viaje_id = viaje_id;
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
        return "Grupo{" + "grupo_id=" + getGrupo_id() + ", nombre=" + getNombre() + ", responsable=" + getResponsable_id() + " ,viaje=" + getViaje_id() + '}';
    }

}
