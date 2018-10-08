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
public class Usuario {

    private int id, codigo_postal, movil;
    private String nombre, apellido1, apellido2, fecha_nacimiento, correo, sexo, direccion, provincia, modo_pago;

    public Usuario(int id, String nombre) {
        this.nombre = nombre;
        this.id = id;
    }

    /*
    public Usuario(String nombre, String apellido1, String apellido2, String fecha_nacimiento, String correo,
            String sexo, String direccion, String provincia, String modo_pago, int id, int codigo_postal, int movil) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.sexo = sexo;
        this.direccion = direccion;
        this.provincia = provincia;
        this.modo_pago = modo_pago;
        this.id = id;
        this.codigo_postal = codigo_postal;
        this.movil = movil;

    }
     */
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}
