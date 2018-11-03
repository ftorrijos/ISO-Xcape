/*
Objeto Usuario
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Alejandro Gutiérrez <agutierrezvivancos@gmail.com>
 */
public class Usuario {

    private int id, codigo_postal, movil;
    private String nombre, apellido1, apellido2, fecha_nacimiento, correo, sexo, direccion, provincia, modo_pago;
    private Date fecha_nacimiento;

    public Usuario(int id, String nombre, String apellido1,String correo, int movil) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.id = id;
        this.correo = correo;
        this.movil = movil;
        this 
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
