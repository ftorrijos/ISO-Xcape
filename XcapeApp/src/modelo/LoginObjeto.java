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

public class LoginObjeto {
      private int usuario_id;
    private String pass;
    
    public void login(int usuario_id, String pass){
        this.setUsuario_id(usuario_id);
        this.setPass(pass);
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
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    
    public void setPass(String pass) {
        this.pass = pass;
    }
}
