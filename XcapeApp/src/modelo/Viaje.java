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
public class Viaje {
    private int viaje_id, duracion;
    private String hotel,direccion_hotel,regimen,estacion_forfait;

    public Viaje(int viaje_id, String hotel, String direccion_hotel, String regimen, String estacion_forfait, int duracion) {
       this.viaje_id = viaje_id;
       this.hotel=hotel;
       this.direccion_hotel=direccion_hotel;
       this.regimen=regimen;
       this.estacion_forfait= estacion_forfait;
       this.duracion=duracion;
    }
     public Viaje(String hotel, String direccion_hotel, String regimen, String estacion_forfait, int duracion) {
       this.hotel=hotel;
       this.direccion_hotel=direccion_hotel;
       this.regimen=regimen;
       this.estacion_forfait= estacion_forfait;
       this.duracion=duracion;
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
     * @return the duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the hotel
     */
    public String getHotel() {
        return hotel;
    }

    /**
     * @param hotel the hotel to set
     */
    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    /**
     * @return the direccion_hotel
     */
    public String getDireccion_hotel() {
        return direccion_hotel;
    }

    /**
     * @param direccion_hotel the direccion_hotel to set
     */
    public void setDireccion_hotel(String direccion_hotel) {
        this.direccion_hotel = direccion_hotel;
    }

    /**
     * @return the regimen
     */
    public String getRegimen() {
        return regimen;
    }

    /**
     * @param regimen the regimen to set
     */
    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }

    /**
     * @return the estacion_forfait
     */
    public String getEstacion_forfait() {
        return estacion_forfait;
    }

    /**
     * @param estacion_forfait the estacion_forfait to set
     */
    public void setEstacion_forfait(String estacion_forfait) {
        this.estacion_forfait = estacion_forfait;
    }

    
       @Override
    public String toString() {
        return "Viaje{" + "viaje_id=" + getViaje_id()+ ", hotel=" + getHotel() + ", direccion hotel="+ getDireccion_hotel()+ " ,regimen= "+getRegimen()
                +", estacion forfait="+getEstacion_forfait()+", duracion="+ getDuracion()+'}';
    }


}
