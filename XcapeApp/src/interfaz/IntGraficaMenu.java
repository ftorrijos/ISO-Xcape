/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Cursor;
import modelo.Usuario;

/**
 *
 * @author javiersancerninozaleda
 */
public class IntGraficaMenu extends javax.swing.JFrame {
    public static Usuario user;
 
    /**
     * Creates new form IntGraficaMenu
     */
    public  IntGraficaMenu() {
        
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

        jPanel1 = new javax.swing.JPanel();
        jLabelMiViaje = new javax.swing.JLabel();
        jLabelGestionPerfil = new javax.swing.JLabel();
        jLabelMedia = new javax.swing.JLabel();
        jLabelSalir = new javax.swing.JLabel();
        jLabelEventos2 = new javax.swing.JLabel();
        jLabelChat1 = new javax.swing.JLabel();
        jLabelMapa1 = new javax.swing.JLabel();
        jLabelTiempo1 = new javax.swing.JLabel();
        jLabelSplitwise1 = new javax.swing.JLabel();
        jLabelValora1 = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        ImagenCerrar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jLabelMiViaje.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/MiViaje.png"))); // NOI18N
        jLabelMiViaje.setLabelFor(jLabelMiViaje);
        jLabelMiViaje.setText("Mi Viaje");
        jLabelMiViaje.setToolTipText("");
        jLabelMiViaje.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelMiViaje.setIconTextGap(5);
        jLabelMiViaje.setSize(new java.awt.Dimension(45, 25));
        jLabelMiViaje.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabelGestionPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/GestionPerfil.png"))); // NOI18N
        jLabelGestionPerfil.setLabelFor(jLabelMiViaje);
        jLabelGestionPerfil.setText("Gestion de Perfil");
        jLabelGestionPerfil.setToolTipText("");
        jLabelGestionPerfil.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelGestionPerfil.setIconTextGap(5);
        jLabelGestionPerfil.setMaximumSize(new java.awt.Dimension(80, 101));
        jLabelGestionPerfil.setMinimumSize(new java.awt.Dimension(80, 101));
        jLabelGestionPerfil.setPreferredSize(new java.awt.Dimension(80, 101));
        jLabelGestionPerfil.setSize(new java.awt.Dimension(45, 25));
        jLabelGestionPerfil.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabelGestionPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelGestionPerfilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelGestionPerfilMouseEntered(evt);
            }
        });

        jLabelMedia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Media.png"))); // NOI18N
        jLabelMedia.setLabelFor(jLabelMiViaje);
        jLabelMedia.setText("Media");
        jLabelMedia.setToolTipText("");
        jLabelMedia.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabelMedia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelMedia.setIconTextGap(5);
        jLabelMedia.setSize(new java.awt.Dimension(45, 25));
        jLabelMedia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabelSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Salir.png"))); // NOI18N
        jLabelSalir.setLabelFor(jLabelSalir);
        jLabelSalir.setText("LOG OUT");
        jLabelSalir.setToolTipText("");
        jLabelSalir.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabelSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelSalir.setIconTextGap(5);
        jLabelSalir.setSize(new java.awt.Dimension(45, 25));
        jLabelSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabelSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSalirMouseClicked(evt);
            }
        });

        jLabelEventos2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eventos.png"))); // NOI18N
        jLabelEventos2.setLabelFor(jLabelMiViaje);
        jLabelEventos2.setText("Eventos");
        jLabelEventos2.setToolTipText("");
        jLabelEventos2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelEventos2.setIconTextGap(5);
        jLabelEventos2.setSize(new java.awt.Dimension(45, 25));
        jLabelEventos2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabelChat1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Chat.png"))); // NOI18N
        jLabelChat1.setLabelFor(jLabelMiViaje);
        jLabelChat1.setText("Chat");
        jLabelChat1.setToolTipText("");
        jLabelChat1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelChat1.setIconTextGap(5);
        jLabelChat1.setSize(new java.awt.Dimension(45, 25));
        jLabelChat1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabelMapa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Mapas.png"))); // NOI18N
        jLabelMapa1.setLabelFor(jLabelMiViaje);
        jLabelMapa1.setText("Mapa");
        jLabelMapa1.setToolTipText("");
        jLabelMapa1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabelMapa1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelMapa1.setIconTextGap(5);
        jLabelMapa1.setSize(new java.awt.Dimension(45, 25));
        jLabelMapa1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabelTiempo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Weather.png"))); // NOI18N
        jLabelTiempo1.setLabelFor(jLabelMiViaje);
        jLabelTiempo1.setText("Tiempo");
        jLabelTiempo1.setToolTipText("");
        jLabelTiempo1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabelTiempo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelTiempo1.setIconTextGap(5);
        jLabelTiempo1.setSize(new java.awt.Dimension(45, 25));
        jLabelTiempo1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jLabelSplitwise1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Alert.png"))); // NOI18N
        jLabelSplitwise1.setLabelFor(jLabelSalir);
        jLabelSplitwise1.setText("Incidencias");
        jLabelSplitwise1.setToolTipText("");
        jLabelSplitwise1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabelSplitwise1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelSplitwise1.setIconTextGap(5);
        jLabelSplitwise1.setSize(new java.awt.Dimension(45, 25));
        jLabelSplitwise1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabelSplitwise1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSplitwise1MouseClicked(evt);
            }
        });

        jLabelValora1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/experiencia.png"))); // NOI18N
        jLabelValora1.setLabelFor(jLabelSalir);
        jLabelValora1.setText("Valora tu Exp.");
        jLabelValora1.setToolTipText("");
        jLabelValora1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabelValora1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabelValora1.setIconTextGap(5);
        jLabelValora1.setSize(new java.awt.Dimension(45, 25));
        jLabelValora1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabelValora1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelValora1MouseClicked(evt);
            }
        });

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/xcape pequeno.jpg"))); // NOI18N

        ImagenCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        ImagenCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImagenCerrarMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Bienvenido, " +user.getCorreo()+ "!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 13, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSplitwise1)
                            .addComponent(jLabelValora1))
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMedia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSalir, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelLogo)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMiViaje, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelMapa1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelEventos2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelGestionPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelChat1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTiempo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(41, 41, 41)
                .addComponent(ImagenCerrar)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ImagenCerrar)
                                .addGap(28, 28, 28)
                                .addComponent(jLabelGestionPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelMiViaje, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabelLogo)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabelEventos2)
                        .addComponent(jLabelChat1))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTiempo1)
                    .addComponent(jLabelMapa1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelMedia)
                    .addComponent(jLabelSplitwise1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelValora1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ImagenCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_ImagenCerrarMouseClicked

    private void jLabelGestionPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelGestionPerfilMouseClicked
        
        this.setVisible(false);
         IntGraficaGestionPerfil.main(user);
        
    }//GEN-LAST:event_jLabelGestionPerfilMouseClicked

    private void jLabelSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSalirMouseClicked
        
        IntGraficaPrincipal.main();
        
// TODO add your handling code here:
    }//GEN-LAST:event_jLabelSalirMouseClicked

    private void jLabelGestionPerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelGestionPerfilMouseEntered
        // TODO add your handling code here:
        jLabelGestionPerfil.setCursor(new Cursor(HAND_CURSOR));

        jLabelGestionPerfil.getRootPane().setOpaque(false);

    }//GEN-LAST:event_jLabelGestionPerfilMouseEntered

    private void jLabelSplitwise1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSplitwise1MouseClicked
        // TODO add your handling code here:
        
        IntGraficaInci.main(user);
        
    }//GEN-LAST:event_jLabelSplitwise1MouseClicked

    private void jLabelValora1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelValora1MouseClicked

        this.setVisible(false);
        IntGraficaValora.main(user);
    }//GEN-LAST:event_jLabelValora1MouseClicked

    
    /**
     * @param usuario
     */
    public static void main(Usuario usuario) {
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
            java.util.logging.Logger.getLogger(IntGraficaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IntGraficaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IntGraficaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IntGraficaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        user=usuario;
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IntGraficaMenu().setVisible(true);

            }
        });
        
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImagenCerrar;
    private static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelChat1;
    private javax.swing.JLabel jLabelEventos2;
    private javax.swing.JLabel jLabelGestionPerfil;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelMapa1;
    private javax.swing.JLabel jLabelMedia;
    private javax.swing.JLabel jLabelMiViaje;
    private javax.swing.JLabel jLabelSalir;
    private javax.swing.JLabel jLabelSplitwise1;
    private javax.swing.JLabel jLabelTiempo1;
    private javax.swing.JLabel jLabelValora1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
