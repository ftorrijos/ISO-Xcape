/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author usuario
 */
public class Pagos {
    private int pago_id, usuario_id;
    private String metodo_pago,primer_pago, segundo_pago, dni;
    
    public Pagos(){
        this.pago_id = pago_id;
        this.metodo_pago=metodo_pago;
        this.primer_pago=primer_pago;
        this.segundo_pago=segundo_pago;
        this.dni=dni;
        this.usuario_id= usuario_id;
                
    }

    /**
     * @return the pago_id
     */
    public int getPago_id() {
        return pago_id;
    }

    /**
     * @param pago_id the pago_id to set
     */
    public void setPago_id(int pago_id) {
        this.pago_id = pago_id;
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
     * @return the metodo_pago
     */
    public String getMetodo_pago() {
        return metodo_pago;
    }

    /**
     * @param metodo_pago the metodo_pago to set
     */
    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    /**
     * @return the primer_pago
     */
    public String getPrimer_pago() {
        return primer_pago;
    }

    /**
     * @param primer_pago the primer_pago to set
     */
    public void setPrimer_pago(String primer_pago) {
        this.primer_pago = primer_pago;
    }

    /**
     * @return the segundo_pago
     */
    public String getSegundo_pago() {
        return segundo_pago;
    }

    /**
     * @param segundo_pago the segundo_pago to set
     */
    public void setSegundo_pago(String segundo_pago) {
        this.segundo_pago = segundo_pago;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
    
       @Override
    public String toString() {
        return "Pago{" + "pago_id=" + getPago_id() + ", metodo de pago =" + getMetodo_pago()+ ", primer pago ="+ getPrimer_pago()
                + " ,segundo pago="+getSegundo_pago()+ " ,DNI="+getDni()+ " , usuario="+getUsuario_id()+'}';
    }
}
