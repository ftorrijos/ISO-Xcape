/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.Date;
import modelo.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author javiersancerninozaleda
 */
public class IntGraficaGestionPerfil extends javax.swing.JFrame {

    public static Usuario user;

    /*  static void main(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     */
    /**
     * Creates new form IntGraficaGestionPerfil
     */
    public IntGraficaGestionPerfil() {
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

        jTextFieldNombre3 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellidos = new javax.swing.JLabel();
        jLabelMovil = new javax.swing.JLabel();
        jLabelDNI = new javax.swing.JLabel();
        jLabelMail = new javax.swing.JLabel();
        jLabelFNacimiento = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellidos = new javax.swing.JTextField();
        jTextFieldMovil = new javax.swing.JTextField();
        jTextFieldDNI = new javax.swing.JTextField();
        jTextFieldFNacimientoDia = new javax.swing.JTextField();
        jTextFieldFNacimientoMes = new javax.swing.JTextField();
        jTextFieldFNacimientoAno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonActualizar = new javax.swing.JButton();
        jTextFieldCorreo = new javax.swing.JTextField();
        jButtonVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));
        setUndecorated(true);

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/xcape pequeno.jpg"))); // NOI18N

        jLabelNombre.setText("Nombre");

        jLabelApellidos.setText("Apellidos");

        jLabelMovil.setText("Movil");

        jLabelDNI.setText("DNI");

        jLabelMail.setText("E-Mail");

        jLabelFNacimiento.setText("Fecha Nacimiento");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("Actualiza tus datos");

        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonActualizarMouseClicked(evt);
            }
        });
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jButtonVolver.setText("Volver sin guardar");
        jButtonVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonVolverMouseClicked(evt);
            }
        });
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelLogo)
                        .addGap(133, 133, 133)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonVolver)
                                .addGap(105, 105, 105)
                                .addComponent(jButtonActualizar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNombre)
                                    .addComponent(jLabelApellidos)
                                    .addComponent(jLabelMovil)
                                    .addComponent(jLabelDNI)
                                    .addComponent(jLabelMail)
                                    .addComponent(jLabelFNacimiento))
                                .addGap(69, 69, 69)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldDNI, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                    .addComponent(jTextFieldMovil, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextFieldFNacimientoDia, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldFNacimientoMes, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldFNacimientoAno))
                                    .addComponent(jTextFieldCorreo))))))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1)))
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelApellidos)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelMovil)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabelDNI)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelMail)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFNacimiento)
                    .addComponent(jTextFieldFNacimientoDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFNacimientoMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFNacimientoAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonActualizar)
                    .addComponent(jButtonVolver))
                .addGap(62, 62, 62))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonActualizarMouseClicked
        Usuario fake = user;

        fake = actualizarDatos(fake);

        int respuesta = JOptionPane.showConfirmDialog(null, "Esta seguro de que desea actualizarel usuario?\nEsta sera su nueva informacion: \n" + fake);

        if (respuesta == JOptionPane.YES_OPTION) {
            dBManager.DBManager.UpdateUsuario(fake);
            this.setVisible(false);

            IntGraficaMenu.main(fake);
        }


    }//GEN-LAST:event_jButtonActualizarMouseClicked

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonVolverMouseClicked
        // TODO add your handling code here:

        this.setVisible(false);
        IntGraficaMenu.main(user);

    }//GEN-LAST:event_jButtonVolverMouseClicked

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonVolverActionPerformed

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
            java.util.logging.Logger.getLogger(IntGraficaGestionPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IntGraficaGestionPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IntGraficaGestionPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IntGraficaGestionPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        user = usuario;

        java.awt.EventQueue.invokeLater(() -> {
            new IntGraficaGestionPerfil().setVisible(true);
            cargarDatos();
        });

    }

    public static void cargarDatos() {
        //    System.out.println(user);

        jTextFieldNombre.setText(user.getNombre());
        jTextFieldApellidos.setText(user.getApellido());
        jTextFieldMovil.setText(Integer.toString(user.getMovil()));
        jTextFieldDNI.setText(user.getDni());
        jTextFieldCorreo.setText(user.getCorreo());

        String string = String.valueOf(user.getFecha_nacimiento());
        String[] parts = string.split("-");
        String anno = parts[0]; // 004
        String mes = parts[1]; // 034556
        String dia = parts[2];
        jTextFieldFNacimientoDia.setText(dia);
        jTextFieldFNacimientoMes.setText(mes);
        jTextFieldFNacimientoAno.setText(anno);

    }

    public static Usuario actualizarDatos(Usuario fake) {

        fake.setNombre(jTextFieldNombre.getText());
        fake.setApellido(jTextFieldApellidos.getText());
        fake.setMovil(Integer.parseInt(jTextFieldMovil.getText()));
        fake.setDni(jTextFieldDNI.getText());
        fake.setCorreo(jTextFieldCorreo.getText());

        String f_ano = jTextFieldFNacimientoAno.getText();
        String f_mes = jTextFieldFNacimientoMes.getText();
        String f_dia = jTextFieldFNacimientoDia.getText();
        String f_nac = f_ano + "/" + f_mes + "/" + f_dia;
        System.out.println(f_nac);
        Date fecha = new Date(f_nac);
        fake.setFecha_nacimiento(fecha);
        /*int dia = Integer.parseInt(jTextFieldFNacimientoDia.getText());
        int mes = Integer.parseInt(jTextFieldFNacimientoMes.getText());
        int ano = Integer.parseInt(jTextFieldFNacimientoAno.getText());
        Date fecha = new Date(ano, mes, dia);
        fake.setFecha_nacimiento(fecha);*/
        return fake;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelDNI;
    private static javax.swing.JLabel jLabelFNacimiento;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelMovil;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JTextField jTextFieldApellidos;
    private static javax.swing.JTextField jTextFieldCorreo;
    public static javax.swing.JTextField jTextFieldDNI;
    private static javax.swing.JTextField jTextFieldFNacimientoAno;
    private static javax.swing.JTextField jTextFieldFNacimientoDia;
    private static javax.swing.JTextField jTextFieldFNacimientoMes;
    private static javax.swing.JTextField jTextFieldMovil;
    private static javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNombre3;
    // End of variables declaration//GEN-END:variables
}
