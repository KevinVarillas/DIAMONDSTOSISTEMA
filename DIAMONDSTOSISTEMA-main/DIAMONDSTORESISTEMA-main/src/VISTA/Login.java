/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import CONTROLADOR.LoginController;
import java.awt.Color;

import util.Mensaje;

public class Login extends javax.swing.JFrame {

    public Login() {

        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(this);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background2 = new DISEÑO.Background();
        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtusuario = new DISEÑO.TextField2();
        btnIngresar = new DISEÑO.Button();
        txtcontra = new DISEÑO.PasswordField();
        button1 = new DISEÑO.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panel.setOpaque(false);
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cinzel Decorative", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Inicia Sesión");
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 200, 30));

        txtusuario.setCaretColor(new java.awt.Color(255, 255, 255));
        txtusuario.setFont(new java.awt.Font("Roseritta", 1, 18)); // NOI18N
        txtusuario.setHint("USUARIO");
        panel.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 200, 50));

        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.setFont(new java.awt.Font("Cinzel Decorative", 1, 14)); // NOI18N
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        panel.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 150, 50));

        txtcontra.setCaretColor(new java.awt.Color(255, 255, 255));
        txtcontra.setFont(new java.awt.Font("Roseritta", 1, 18)); // NOI18N
        txtcontra.setHint("Contraseña");
        panel.add(txtcontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 200, 60));

        background2.add(panel);
        panel.setBounds(240, 80, 320, 310);

        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-x-15.png"))); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        background2.add(button1);
        button1.setBounds(740, 10, 50, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background2, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background2, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed


    }//GEN-LAST:event_btnIngresarActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed

        System.exit(0);


    }//GEN-LAST:event_button2ActionPerformed


    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresar1ActionPerformed

        try {
            String usuario = txtusuario.getText();
            String clave = String.valueOf(txtcontra.getPassword());
            LoginController controller = new LoginController();
            controller.ValidarUsuario(usuario, clave);
            Main.main(null);
            this.dispose();

        } catch (Exception e) {
            Mensaje.error(this, e.getMessage());

        }
    }//GEN-LAST:event_btnIngresar1ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed

        System.exit(0);


    }//GEN-LAST:event_button1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DISEÑO.Background background2;
    private DISEÑO.Button btnIngresar;
    private DISEÑO.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panel;
    private DISEÑO.PasswordField txtcontra;
    private DISEÑO.TextField2 txtusuario;
    // End of variables declaration//GEN-END:variables
}
