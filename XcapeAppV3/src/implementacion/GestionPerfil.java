/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacion;

import DBManager.DBManager;
import java.util.Scanner;

/**
 *
 * @author Alejandro Gutiérrez <agutierrezvivancos@gmail.com>
 */
public class GestionPerfil {
    
    DBManager db = new DBManager();
    public void insertar_usuario(){
        System.out.println("Porfavor introducir el nombre del usuario:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        db.insertarUsuarios(name);
        System.out.println("Ususario:" + name + " ,insertado correctamente." );
        
           
    }
}
