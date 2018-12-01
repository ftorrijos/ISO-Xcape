/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dBManager.DBManager;

/**
 *
 * @author ebenz
 */
public class Valoracion {

    private int valora_id, usuario_id, viaje_id, nota;
    private String si_no;
    DBManager db = new DBManager();

    public Valoracion(int valora_id, int usuario_id, int viaje_id, int nota, String si_no) {
        this.valora_id = valora_id;
        this.usuario_id = usuario_id;
        this.viaje_id = viaje_id;
        this.nota = nota;
        this.si_no = si_no;
    }

    public Valoracion(int usuario_id, int viaje_id, int nota, String si_no) {
        this.usuario_id = usuario_id;
        this.viaje_id = viaje_id;
        this.nota = nota;
        this.si_no = si_no;
    }

    /**
     * @return the valora_id
     */
    public int getValora_id() {
        return valora_id;
    }

    /**
     * @param valora_id the valora_id to set
     */
    public void setValora_id(int valora_id) {
        this.valora_id = valora_id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getViaje_id() {
        return viaje_id;
    }

    public void setViaje_id(int viaje_id) {
        this.viaje_id = viaje_id;
    }

    public int getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getSi_no() {
        return si_no;
    }

    public void setSi_no(String si_no) {
        this.si_no = si_no;
    }

    @Override
    public String toString() {
        return "valoracion {" + "valoracion id=" + getValora_id() + ", nota=" + getNota() + " viaje_id= " + getViaje_id() + " , usuario_id= " + getUsuario_id() + " ,te gusto?=" + getSi_no() + '}';

    }

}
