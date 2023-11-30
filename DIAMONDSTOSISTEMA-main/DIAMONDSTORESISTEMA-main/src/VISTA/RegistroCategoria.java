package VISTA;

import CONTROLADOR.RegistrarCategoriaController;
import DISEÑO.PanelShadow;
import MODELO.Categoria;
import SERVICES.RegistrarCategoriaService;
import javax.swing.JOptionPane;
import util.Mensaje;

public class RegistroCategoria extends PanelShadow {

    public RegistroCategoria() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        button1 = new DISEÑO.Button();
        txtcate = new DISEÑO.TextField();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 246, 249));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cinzel Decorative", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(239, 135, 176));
        jLabel1.setText("Registrar Categorias");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 366, 70));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-categorizar-40.png"))); // NOI18N
        jLabel5.setText("jLabel2");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 40, 40));

        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Registrar Categoria");
        button1.setFont(new java.awt.Font("Cinzel Decorative", 1, 14)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 230, 80));

        txtcate.setFont(new java.awt.Font("Roseritta", 1, 18)); // NOI18N
        txtcate.setHint("INGRESA EL NOMBRE DE LA CATEGORIA");
        add(txtcate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 340, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imag4.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 240, 260));
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed

        try {
            Categoria cate = new Categoria();

            String categoria = txtcate.getText();

// Proceso
            RegistrarCategoriaController control = new RegistrarCategoriaController();
            control.registrarCategoria(categoria);
            JOptionPane.showMessageDialog(null, "Registro guardado correctamente.");
        } catch (Exception e) {
// Captura excepciones generales
            Mensaje.error(this, "Ocurrio un error inesperado: " + e.getMessage());
        }
        limpiar();


    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DISEÑO.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private DISEÑO.TextField txtcate;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        txtcate.setText("");
    }
}
