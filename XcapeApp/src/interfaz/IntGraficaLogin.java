/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Image;
import static java.lang.System.exit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.*;

import dBManager.*;
import java.sql.SQLException;
import static java.util.Objects.hash;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.LoginObjeto;
import implementacion.Login;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import modelo.Usuario;

/**
 *
 * @author javiersancerninozaleda
 */
public class IntGraficaLogin extends javax.swing.JFrame {


    /**
     * Creates new form IntGrafica
     */
    public IntGraficaLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        AlertImage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        BotonAcceder = new javax.swing.JButton();
        jLabelPassword = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelFont = new javax.swing.JLabel();
        ImagenCerrar = new javax.swing.JLabel();
        jUsuario = new javax.swing.JTextField();
        jContrasena = new javax.swing.JTextField();
        jLabelUser1 = new javax.swing.JLabel();
        jUsuario1 = new javax.swing.JTextField();

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

        AlertImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Alert.png"))); // NOI18N

        jLabel1.setText("INTRODUCE ALGO");

        jButton1.setText("ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(AlertImage)
                        .addGap(106, 106, 106)
                        .addComponent(jLabel1)))
                .addContainerGap(298, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(AlertImage))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(99, 99, 99))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BotonAcceder.setText("ACCEDER");
        BotonAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAccederActionPerformed(evt);
            }
        });
        getContentPane().add(BotonAcceder, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, -1, -1));

        jLabelPassword.setText("Contraseñ");
        getContentPane().add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 360, 90, -1));

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setForeground(new java.awt.Color(255, 153, 0));

        jLabelFont.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/xcape.jpg"))); // NOI18N

        ImagenCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        ImagenCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImagenCerrarMouseClicked(evt);
            }
        });

        jUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUsuarioActionPerformed(evt);
            }
        });

        jContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jContrasenaActionPerformed(evt);
            }
        });

        jLabelUser1.setText("Usuario:");
        jLabelUser1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jLabelUser1ComponentAdded(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFont, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ImagenCerrar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelUser1)
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(107, 107, 107))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(ImagenCerrar)
                .addGap(18, 18, 18)
                .addComponent(jLabelFont, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(204, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 520, 590));

        jUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUsuario1ActionPerformed(evt);
            }
        });
        getContentPane().add(jUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 150, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAccederActionPerformed
        // TODO add your handling code here:
       //ESTO ES UNA PRUEBA DE QUE FUNCIONA
       
       String TextoVacio = "";

       Usuario user = null;

      
      if(jUsuario.getText().equals(TextoVacio) || jContrasena.getText().equals(TextoVacio)){
           
      JOptionPane.showMessageDialog(null, "Introduzca usuario y contrasena");
      
    
       } 
      else{
           try {
               user = haceLogin();
           } catch (SQLException ex) {
               Logger.getLogger(IntGraficaLogin.class.getName()).log(Level.SEVERE, null, ex);
           } catch (NoSuchAlgorithmException ex) {
               Logger.getLogger(IntGraficaLogin.class.getName()).log(Level.SEVERE, null, ex);
           } catch (UnsupportedEncodingException ex) {
               Logger.getLogger(IntGraficaLogin.class.getName()).log(Level.SEVERE, null, ex);
           }
           
            new IntGraficaMenu(user).setVisible(true);
           
      } 
         
       
    }//GEN-LAST:event_BotonAccederActionPerformed

    private void jUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUsuarioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ImagenCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ImagenCerrarMouseClicked

    private void jUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUsuario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUsuario1ActionPerformed

    private void jContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jContrasenaActionPerformed

    private void jLabelUser1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jLabelUser1ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabelUser1ComponentAdded

    /**
     * @param args the command line arguments
     */
    public static void main() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IntGraficaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IntGraficaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IntGraficaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IntGraficaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
         
            public void run() {
                new IntGraficaLogin().setVisible(true);
            }
        });
        
        
       
        
    }
    
   
    
    public Usuario haceLogin() throws SQLException, NoSuchAlgorithmException, UnsupportedEncodingException{
        
        DBManager db = new DBManager();
        LoginObjeto log = new LoginObjeto();

     
           
          String username = jUsuario.getText();
          String password = jContrasena.getText();
          String passHash = Login.hash(password);
         

          String dbPass = db.selectPasswordUsuario(username);

         
          if (username.equals("admin") && dbPass.equalsIgnoreCase(passHash)) {
            log.setUsuario_id(db.selectIDUsuario(username));
            log.setPass("okadmin");
    //        return log;
        } else if (dbPass.equalsIgnoreCase(passHash)) {
            log.setUsuario_id(db.selectIDUsuario(username));
            log.setPass("ok");
   //         return log;
        } else {
            JOptionPane.showMessageDialog(null, "Introduzca usuario y contrasena validos");

            log.setUsuario_id(0);
            log.setPass("nook");
    //        return log;
        }
          
       Usuario user  = DBManager.selectNombreApellidoUsuarioPorUserID(log.getUsuario_id());
          
          return user;
       
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlertImage;
    private javax.swing.JButton BotonAcceder;
    private javax.swing.JLabel ImagenCerrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jContrasena;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFont;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jUsuario;
    private javax.swing.JTextField jUsuario1;
    // End of variables declaration//GEN-END:variables
}
