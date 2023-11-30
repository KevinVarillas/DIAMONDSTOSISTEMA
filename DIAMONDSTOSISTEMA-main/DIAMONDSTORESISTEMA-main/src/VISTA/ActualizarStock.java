package VISTA;

import BASEDATOS.AccesoBD;
import CONTROLADOR.ActualizarStockController;
import DISEÑO.PanelShadow;
import MODELO.Producto;
import SERVICES.ActualizarStockService;
import static VISTA.RegistrarVenta.txttotal;
import java.sql.Statement;
import javax.swing.JOptionPane;
import util.Mensaje;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import util.ListadoCombo;

public class ActualizarStock extends PanelShadow {

    Connection cn = null;

    ActualizarStockService acts = new ActualizarStockService();

    public ActualizarStock() {

        initComponents();

        cargarCombo(cbxNombrePro);

        init();

    }

    private void init() {
        setRadius(20);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtactual = new DISEÑO.TextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxNombrePro = new javax.swing.JComboBox<>();
        txtnuevo = new DISEÑO.TextField();
        button1 = new DISEÑO.Button();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 246, 249));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtactual.setForeground(new java.awt.Color(191, 110, 82));
        txtactual.setFont(new java.awt.Font("Roseritta", 1, 14)); // NOI18N
        txtactual.setHint("COLOCA EL STOCK ACTUAL DEL PRODUCTO");
        add(txtactual, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 310, 60));

        jLabel1.setFont(new java.awt.Font("Cinzel Decorative", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(239, 135, 176));
        jLabel1.setText("Actualizar Stock del Producto");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 490, 50));

        jLabel2.setFont(new java.awt.Font("Roseritta", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(191, 110, 82));
        jLabel2.setText("SELECCIONA EL PRODUCTO");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 250, 40));

        cbxNombrePro.setBackground(new java.awt.Color(255, 255, 255));
        cbxNombrePro.setFont(new java.awt.Font("Roseritta", 1, 18)); // NOI18N
        cbxNombrePro.setForeground(new java.awt.Color(239, 135, 176));
        cbxNombrePro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cbxNombrePro, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 250, 60));

        txtnuevo.setForeground(new java.awt.Color(191, 110, 82));
        txtnuevo.setFont(new java.awt.Font("Roseritta", 1, 14)); // NOI18N
        txtnuevo.setHint("COLOCA EL STOCK INGRESANTE");
        add(txtnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 310, 60));

        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Guardar");
        button1.setFont(new java.awt.Font("Cinzel Decorative", 1, 14)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 280, 140, 70));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-maquillaje-40.png"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 40, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imag5 (1).png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 320, 320));
    }// </editor-fold>//GEN-END:initComponents
 private void cargarCombo(JComboBox c) {

        try {
            cn = AccesoBD.getConnection();

            DefaultComboBoxModel combo = new DefaultComboBoxModel();
            c.setModel(combo);
            ListadoCombo lp = new ListadoCombo();
            try {
                Statement st = (Statement) cn.createStatement();
                ResultSet rs = st.executeQuery("SELECT nombre FROM productos");
                while (rs.next()) {
                    Producto p = new Producto();
                    p.setNombre(rs.getString(1));
                    lp.AgregarProductos(p);
                    combo.addElement(p.getNombre());
                }
            } catch (Exception e) {
                System.out.print("ERROR" + e);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ActualizarStock.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ActualizarStock.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed

        try {
            // Datos
            String nombre = cbxNombrePro.getSelectedItem().toString();
            int nuevoStock = Integer.parseInt(txtnuevo.getText());

            // Proceso
            ActualizarStockController controlac = new ActualizarStockController(acts);
            controlac.actualizarStock(nombre, nuevoStock);

            JOptionPane.showMessageDialog(null, "Registro guardado correctamente.");
            limpiar();
        } catch (Exception e) {
            // Captura excepciones generales
            Mensaje.error(this, "Ocurrió un error inesperado: " + e.getMessage());
        }

      

    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DISEÑO.Button button1;
    private javax.swing.JComboBox<String> cbxNombrePro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private DISEÑO.TextField txtactual;
    private DISEÑO.TextField txtnuevo;
    // End of variables declaration//GEN-END:variables


private void limpiar() {
        txtnuevo.setText("");
        txtactual.setText("");
      

    }





}
