/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import MODELO.Empleados;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import util.Session;

/**
 *
 * @author analu
 */
public class Main extends javax.swing.JFrame {

    ActualizarStock act = new ActualizarStock();

    public Main() {
        initComponents();

        ShowJPanel(new ImagenMenu());
        SetImageLabel(fondo, "src/imagenes/fondo.png");
        SetImageLabel(fondo2, "src/imagenes/fondo2.png");
        SetImageLabel(jLabel2, "src/imagenes/usuariomujer.png");
        SetImageLabel(jLabel1, "src/imagenes/Img.png");

        establecerTitulo();
        setBackground(new Color(0, 0, 0, 0));

        initContent();

        JPanel jp = new JPanel();
        content.setOpaque(false);
        content2.setOpaque(false);

    }

    private void initContent() {

    }

    public void ShowJPanel(JPanel p) {
        p.setSize(919, 492);
        p.setLocation(0, 0);

        content.removeAll();
        content.add(p, BorderLayout.CENTER);

        content.revalidate();
        content.repaint();
    }

    public void ShowJPanel2(JPanel a) {
        a.setSize(231, 351);
        a.setLocation(0, 0);

        content2.removeAll();
        content2.add(a, BorderLayout.WEST);

        content2.revalidate();
        content2.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new DISEÑO.PanelBorder();
        content2 = new javax.swing.JPanel();
        content = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jblNombreUsuario = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnventas = new DISEÑO.Button2();
        btnproductos = new DISEÑO.Button2();
        button24 = new DISEÑO.Button2();
        btncate = new DISEÑO.Button2();
        fondo2 = new javax.swing.JLabel();
        button21 = new DISEÑO.Button2();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));
        panelBorder1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout content2Layout = new javax.swing.GroupLayout(content2);
        content2.setLayout(content2Layout);
        content2Layout.setHorizontalGroup(
            content2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        content2Layout.setVerticalGroup(
            content2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        panelBorder1.add(content2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 230, 360));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        panelBorder1.add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 920, 500));
        panelBorder1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 100, 90));

        jblNombreUsuario.setFont(new java.awt.Font("Cinzel Decorative", 1, 14)); // NOI18N
        jblNombreUsuario.setForeground(new java.awt.Color(159, 125, 96));
        panelBorder1.add(jblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 130, 50));
        panelBorder1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 230, 210));
        panelBorder1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 140, 130));

        btnventas.setForeground(new java.awt.Color(183, 154, 129));
        btnventas.setText("Ventas");
        btnventas.setFont(new java.awt.Font("Cinzel Decorative", 1, 14)); // NOI18N
        btnventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnventasActionPerformed(evt);
            }
        });
        panelBorder1.add(btnventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 200, 52));

        btnproductos.setForeground(new java.awt.Color(183, 154, 129));
        btnproductos.setText("Productos");
        btnproductos.setFont(new java.awt.Font("Cinzel Decorative", 1, 14)); // NOI18N
        btnproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproductosActionPerformed(evt);
            }
        });
        panelBorder1.add(btnproductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 200, 50));

        button24.setForeground(new java.awt.Color(183, 154, 129));
        button24.setText("Reportes");
        button24.setFont(new java.awt.Font("Cinzel Decorative", 1, 14)); // NOI18N
        button24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button24ActionPerformed(evt);
            }
        });
        panelBorder1.add(button24, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 50, 170, 50));

        btncate.setForeground(new java.awt.Color(183, 154, 129));
        btncate.setText("Categoria");
        btncate.setFont(new java.awt.Font("Cinzel Decorative", 1, 14)); // NOI18N
        btncate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncateActionPerformed(evt);
            }
        });
        panelBorder1.add(btncate, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, 180, 50));
        panelBorder1.add(fondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 930, 170));

        button21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cerrar-sesión-50.png"))); // NOI18N
        button21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button21ActionPerformed(evt);
            }
        });
        panelBorder1.add(button21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 610, 90, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 1198, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btncateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncateActionPerformed

        ShowJPanel2(new MenuCategoria(this));

    }//GEN-LAST:event_btncateActionPerformed

    private void btnproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproductosActionPerformed

        ShowJPanel2(new MenuProductos(this));

    }//GEN-LAST:event_btnproductosActionPerformed

    private void btnventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnventasActionPerformed

        ShowJPanel2(new MenuVentas(this));

    }//GEN-LAST:event_btnventasActionPerformed

    private void button21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button21ActionPerformed

        System.exit(0);


    }//GEN-LAST:event_button21ActionPerformed

    private void button24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button24ActionPerformed

        ShowJPanel2(new MenuReportes(this));


    }//GEN-LAST:event_button24ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DISEÑO.Button2 btncate;
    private DISEÑO.Button2 btnproductos;
    private DISEÑO.Button2 btnventas;
    private DISEÑO.Button2 button21;
    private DISEÑO.Button2 button24;
    private javax.swing.JPanel content;
    private javax.swing.JPanel content2;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel fondo2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jblNombreUsuario;
    private DISEÑO.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables

    private void establecerTitulo() {
        Empleados usuario = (Empleados) Session.get("userUsuario");

        if (usuario != null) {
            String nombreCompleto = usuario.getNombre() + " " + usuario.getApellido();
            String titulo = "DIAMOND STORE 21 SYSTEM [Usuario: " + nombreCompleto + "]";
            this.setTitle(titulo);

            // Asignar el nombre completo al JLabel
            jblNombreUsuario.setText(nombreCompleto);
        }
    }

    private void SetImageLabel(JLabel labelName, String root) {

        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_AREA_AVERAGING));

        labelName.setIcon(icon);
        this.repaint();

    }

}
