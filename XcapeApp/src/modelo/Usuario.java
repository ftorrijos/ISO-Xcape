/*
Objeto Usuario
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Alejandro Gutiérrez <agutierrezvivancos@gmail.com>
 */
public class Usuario {

    private int usuario_id, movil;
    private String nombre, apellido, dni, correo;
    private Date fecha_nacimiento;

    public Usuario(int usuario_id, int movil, String nombre, String apellido, String dni, String correo, Date fecha_nacimiento) {
        this.usuario_id = usuario_id;
        this.movil = movil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Usuario(int movil, String nombre, String apellido, String dni, String correo, Date fecha_nacimiento) {
        this.movil = movil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getMovil() {
        return movil;
    }

    public void setMovil(int movil) {
        this.movil = movil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return "--------------------------------" + "\n\t USUARIO ID -> " + usuario_id
                + "\nNombre: " + nombre + "\nApellido: " + apellido + "\nDNI: "
                + dni + "\nCorreo: " + correo + "\nFecha de nacimiento: " + fecha_nacimiento
                + "\nMovil: " + movil + "\n--------------------------------";
    }
}
