/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import modelo.Usuario;
import dBManager.DBManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Incidencia;
import modelo.Viaje;

/**
 *
 * @author javiersancerninozaleda
 */
public class IntGraficaMiViaje extends javax.swing.JFrame {
    public static Usuario user;
    public static Viaje miViaje;

    /**
     * Creates new form IntGrafica
     */
    public IntGraficaMiViaje() {
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
        jPanel1 = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelHotel = new javax.swing.JLabel();
        jLabelRegimen = new javax.swing.JLabel();
        jLabelDuracion = new javax.swing.JLabel();
        jLabelForfait = new javax.swing.JLabel();

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

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        jPanel1.setForeground(new java.awt.Color(255, 153, 0));

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/xcape pequeno.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel2.setText("MI VIAJE");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 5)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/9895.png"))); // NOI18N
        jLabel6.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel6.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabelHotel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHotel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hotel.png"))); // NOI18N
        jLabelHotel.setText("Su alojamiento es: "+miViaje.getHotel()+". Se encuentra en la direccion: "+miViaje.getDireccion_hotel());
        jLabelHotel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabelRegimen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/comida.png"))); // NOI18N
        jLabelRegimen.setText("El regimen de su alojamiento es: "+miViaje.getRegimen());

        jLabelDuracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eventos.png"))); // NOI18N
        jLabelDuracion.setText("La duracion de su viaje es: "+miViaje.getDuracion()+" dias");

        jLabelForfait.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/esqui.png"))); // NOI18N
        jLabelForfait.setText("Tiene contratado el forfait para la estacion: "+miViaje.getEstacion_forfait());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 404, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(152, 152, 152)
                .addComponent(jLabelLogo)
                .addGap(33, 33, 33))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelForfait)
                    .addComponent(jLabelDuracion)
                    .addComponent(jLabelRegimen)
                    .addComponent(jLabelHotel))
                .addContainerGap(620, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2)))
                .addGap(30, 30, 30)
                .addComponent(jLabelHotel)
                .addGap(18, 18, 18)
                .addComponent(jLabelRegimen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelDuracion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelForfait)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:

        this.setVisible(false);
        IntGraficaMenu.main(user);
    }//GEN-LAST:event_jLabel6MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(Usuario usuario) throws SQLException {
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
        
       user = usuario; 
        
       
       miViaje =  DBManager.selectViajePorUserId(user.getUsuario_id());
  /*     if (miViaje == null){
           JOptionPane.showMessageDialog(null, "No tienes ningun viaje asignado. Contacta con tu vendedor mas cercano");
           IntGraficaMenu.main(user);
       }
    */   
       
    //   cargarDatosViaje();
       
        java.awt.EventQueue.invokeLater(() -> {
            new IntGraficaMiViaje().setVisible(true);
        });
        
        
        
    }
    
   /*
  public static void cargarDatosViaje(){
      
      jLabelHotel.setText("Su alojamiento es: "+miViaje.getHotel()+". Se encuentra en la direccion: "+miViaje.getDireccion_hotel());
      jLabelRegimen.setText("El regimen de su alojamiento es: "+miViaje.getRegimen());
      jLabelDuracion.setText("La duracion de su viaje es: "+miViaje.getDuracion()+" dias");
      jLabelForfait.setText("Tiene contratado el forfait para la estacion: "+miViaje.getEstacion_forfait());
      
      
      
  }*/
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlertImage;
    private javax.swing.JButton jButton1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabelDuracion;
    public static javax.swing.JLabel jLabelForfait;
    public static javax.swing.JLabel jLabelHotel;
    private javax.swing.JLabel jLabelLogo;
    public static javax.swing.JLabel jLabelRegimen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
