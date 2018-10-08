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

    private int grupo_id;
    private String nombre;

    public Grupo(int grupo_id, String nombre) {
        this.grupo_id = grupo_id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Grupo{" + "grupo_id=" + grupo_id + ", nombre=" + nombre + '}';
    }
    
}
