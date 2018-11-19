/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ebenz
 */
public class LoginObjetoTest {
    
    public LoginObjetoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of login method, of class LoginObjeto.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        int usuario_id = 0;
        String pass = "";
        LoginObjeto instance = new LoginObjeto();
        instance.login(usuario_id, pass);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsuario_id method, of class LoginObjeto.
     */
    @Test
    public void testGetUsuario_id() {
        System.out.println("getUsuario_id");
        LoginObjeto instance = new LoginObjeto();
        int expResult = 0;
        int result = instance.getUsuario_id();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsuario_id method, of class LoginObjeto.
     */
    @Test
    public void testSetUsuario_id() {
        System.out.println("setUsuario_id");
        int usuario_id = 0;
        LoginObjeto instance = new LoginObjeto();
        instance.setUsuario_id(usuario_id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPass method, of class LoginObjeto.
     */
    @Test
    public void testGetPass() {
        System.out.println("getPass");
        LoginObjeto instance = new LoginObjeto();
        String expResult = "";
        String result = instance.getPass();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPass method, of class LoginObjeto.
     */
    @Test
    public void testSetPass() {
        System.out.println("setPass");
        String pass = "";
        LoginObjeto instance = new LoginObjeto();
        instance.setPass(pass);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
