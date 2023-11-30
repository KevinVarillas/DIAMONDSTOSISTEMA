package VISTA;

import CONTROLADOR.RegistroPedidoController;
import CONTROLADOR.VentaPDF;
import DISEÑO.PanelShadow;

import MODELO.Pedido;
import SERVICES.ActualizarStockService;
import SERVICES.RegistroPedidoService;
import java.awt.Color;
import java.awt.event.KeyEvent;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import javax.swing.table.DefaultTableModel;

import util.Mensaje;

public class RegistrarVenta extends PanelShadow {

    Main main;
    RegistroPedidoService pedi = new RegistroPedidoService();
    DefaultTableModel modelo = new DefaultTableModel();
    double total = 0.00;

    public RegistrarVenta(Main mainInstance) {
        main = mainInstance;
        modelo.addColumn("CLIENTE");
        modelo.addColumn("PRODUCTO");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("PRECIO UNIDAD");
        modelo.addColumn("TOTAL");
        initComponents();

    }

    public void setProductoYPrecio(String nombreProducto, double precio) {
        txtproducto.setText(nombreProducto);
        txtprecio.setText(String.valueOf(precio));

    }

    public void setTotal(double total) {
        txttotal.setText(String.valueOf(total)); // Convierte precio a String

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtnombre = new DISEÑO.TextField();
        txtproducto = new DISEÑO.TextField();
        txtprecio = new DISEÑO.TextField();
        txtcantidad = new DISEÑO.TextField();
        btnseleccionar = new DISEÑO.Button();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldatospagar = new javax.swing.JTable();
        txttotal = new DISEÑO.TextField();
        button2 = new DISEÑO.Button();
        button3 = new DISEÑO.Button();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtpagocon = new DISEÑO.TextField();
        txtcambio = new DISEÑO.TextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbxpago = new javax.swing.JComboBox<>();
        txtmetododepago = new DISEÑO.TextField();
        jLabel11 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 246, 249));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtnombre.setForeground(new java.awt.Color(191, 110, 82));
        txtnombre.setFont(new java.awt.Font("Roseritta", 1, 14)); // NOI18N
        txtnombre.setHint("Nombre del cliente");
        add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 160, 50));

        txtproducto.setForeground(new java.awt.Color(191, 110, 82));
        txtproducto.setFont(new java.awt.Font("Roseritta", 1, 14)); // NOI18N
        txtproducto.setHint("Escoja el Producto ->");
        txtproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproductoActionPerformed(evt);
            }
        });
        add(txtproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 230, 50));

        txtprecio.setForeground(new java.awt.Color(191, 110, 82));
        txtprecio.setFont(new java.awt.Font("Roseritta", 1, 14)); // NOI18N
        txtprecio.setHint("Precio");
        add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 100, 50));

        txtcantidad.setForeground(new java.awt.Color(191, 110, 82));
        txtcantidad.setFont(new java.awt.Font("Roseritta", 1, 14)); // NOI18N
        txtcantidad.setHint("Cantidad");
        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcantidadKeyPressed(evt);
            }
        });
        add(txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 110, 50));

        btnseleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/estrella.png"))); // NOI18N
        btnseleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnseleccionarActionPerformed(evt);
            }
        });
        add(btnseleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 60, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-maquillaje-40.png"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 40, 40));

        tbldatospagar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CLIENTE", "PRODUCTO", "CANTIDAD", "PRECIO UNIDAD", "PRECIO TOTAL"
            }
        ));
        jScrollPane1.setViewportView(tbldatospagar);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 490, 190));

        txttotal.setForeground(new java.awt.Color(133, 83, 65));
        txttotal.setFont(new java.awt.Font("Roseritta", 1, 14)); // NOI18N
        txttotal.setHint("Total a pagar");
        add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 150, 60));

        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Registrar Venta");
        button2.setFont(new java.awt.Font("Cinzel Decorative", 1, 14)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });
        add(button2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, 210, 60));

        button3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-eliminar-24.png"))); // NOI18N
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, 50, 50));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tipo-de-cambio.png"))); // NOI18N
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 370, 40, 40));

        jLabel1.setFont(new java.awt.Font("Cinzel Decorative", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(239, 135, 176));
        jLabel1.setText("Registrar Venta");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 240, 70));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/monedas.png"))); // NOI18N
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 40, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-maquillaje-40.png"))); // NOI18N
        jLabel4.setText("jLabel2");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 40, 50));

        txtpagocon.setForeground(new java.awt.Color(191, 110, 82));
        txtpagocon.setFont(new java.awt.Font("Roseritta", 1, 14)); // NOI18N
        txtpagocon.setHint("PAGO CON");
        txtpagocon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpagoconKeyReleased(evt);
            }
        });
        add(txtpagocon, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 150, 50));

        txtcambio.setEditable(false);
        txtcambio.setForeground(new java.awt.Color(191, 110, 82));
        txtcambio.setFont(new java.awt.Font("Roseritta", 1, 14)); // NOI18N
        txtcambio.setHint("VUELTO");
        add(txtcambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 350, 150, 60));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mano.png"))); // NOI18N
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 40, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-etiqueta-de-precio-usd-30.png"))); // NOI18N
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 40, 40));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/metodo-de-pago (1).png"))); // NOI18N
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, 40, 40));

        jLabel2.setFont(new java.awt.Font("Cinzel Decorative", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(239, 135, 176));
        jLabel2.setText("Método de Pago");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 150, 210, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/metodo-de-pago (2).png"))); // NOI18N
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 300, 40, 40));

        cbxpago.setBackground(new java.awt.Color(255, 246, 251));
        cbxpago.setFont(new java.awt.Font("Roseritta", 1, 14)); // NOI18N
        cbxpago.setForeground(new java.awt.Color(148, 73, 0));
        cbxpago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO", "YAPE", "PLIN" }));
        cbxpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxpagoActionPerformed(evt);
            }
        });
        add(cbxpago, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 230, 30));

        txtmetododepago.setEditable(false);
        txtmetododepago.setForeground(new java.awt.Color(191, 110, 82));
        txtmetododepago.setFont(new java.awt.Font("Roseritta", 1, 14)); // NOI18N
        txtmetododepago.setHint("MÉTODO DE PAGO");
        add(txtmetododepago, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 230, 150, 50));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Hola pagame (1).png"))); // NOI18N
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 280, 400));
    }// </editor-fold>//GEN-END:initComponents

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed

        try {
            int numFilas = tbldatospagar.getRowCount();
            for (int i = 0; i < numFilas; i++) {
                String clienteNombre = (String) tbldatospagar.getValueAt(i, 0);
                String producto = (String) tbldatospagar.getValueAt(i, 1);
                int cantidad = (int) tbldatospagar.getValueAt(i, 2);
                double precio = (double) tbldatospagar.getValueAt(i, 3);
                double total = (double) tbldatospagar.getValueAt(i, 4);  // Asegúrate de que el índice sea correcto
                String metodoPago = txtmetododepago.getText();

                // Realizar el registro para cada fila
                RegistroPedidoController control = new RegistroPedidoController(pedi);
                control.registrarPedido(clienteNombre, producto, cantidad, precio, total, metodoPago);

                // Actualizar stock
                ActualizarStockService service = new ActualizarStockService();
                boolean actualizacionExitosa = service.actualizarStockDesdePedidos(producto);
            }

            JOptionPane.showMessageDialog(null, "Pedidos guardados correctamente.");
            VentaPDF pdf = new VentaPDF();
            pdf.DatosCliente();
            pdf.generarFacturaPDF();
        } catch (Exception e) {
            // Captura excepciones generales
            Mensaje.error(this, "Ocurrió un error inesperado: " + e.getMessage());
        }
        limpiar2();
        LimpiarTableVenta();


    }//GEN-LAST:event_button2ActionPerformed

    private void btnseleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnseleccionarActionPerformed

        main.ShowJPanel(new ConsultarProducto(main, this));


    }//GEN-LAST:event_btnseleccionarActionPerformed

    private void txtcantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!"".equals(txtcantidad.getText())) {

                String nombre = txtnombre.getText();
                String producto = txtproducto.getText();
                double precio = Double.parseDouble(txtprecio.getText());
                int cant = Integer.parseInt(txtcantidad.getText());
                double total = cant * precio;

                ArrayList lista = new ArrayList();
                lista.add(nombre);
                lista.add(producto);
                lista.add(cant);
                lista.add(precio);
                lista.add(total);

                Object[] O = new Object[5];
                O[0] = lista.get(0);  // Cambiado a índice 0
                O[1] = lista.get(1);  // Cambiado a índice 1
                O[2] = lista.get(2);  // Cambiado a índice 2
                O[3] = lista.get(3);  // Cambiado a índice 3
                O[4] = lista.get(4);  // Cambiado a índice 4

                modelo.addRow(O);
                tbldatospagar.setModel(modelo);
                TotalPagar();

                limpiar();

            } else {
                JOptionPane.showMessageDialog(null, "Ingrese Cantidad");
            }
        }


    }//GEN-LAST:event_txtcantidadKeyPressed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed

        modelo = (DefaultTableModel) tbldatospagar.getModel();
        modelo.removeRow(tbldatospagar.getSelectedRow());
        TotalPagar();


    }//GEN-LAST:event_button3ActionPerformed

    private void txtpagoconKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpagoconKeyReleased

        calcularCambio();


    }//GEN-LAST:event_txtpagoconKeyReleased

    private void cbxpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxpagoActionPerformed

        // Actualizar el JTextField con el método de pago seleccionado
        txtmetododepago.setText(cbxpago.getSelectedItem().toString());


    }//GEN-LAST:event_cbxpagoActionPerformed

    private void txtproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DISEÑO.Button btnseleccionar;
    private DISEÑO.Button button2;
    private DISEÑO.Button button3;
    private javax.swing.JComboBox<String> cbxpago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tbldatospagar;
    private DISEÑO.TextField txtcambio;
    private DISEÑO.TextField txtcantidad;
    private DISEÑO.TextField txtmetododepago;
    private DISEÑO.TextField txtnombre;
    private DISEÑO.TextField txtpagocon;
    private DISEÑO.TextField txtprecio;
    private DISEÑO.TextField txtproducto;
    public static DISEÑO.TextField txttotal;
    // End of variables declaration//GEN-END:variables
private void limpiar() {
        txtproducto.setText("");
        txtprecio.setText("");
        txtcantidad.setText("");
        txttotal.setText("");

    }

    private void limpiar2() {
        txtnombre.setText("");
        txtproducto.setText("");
        txtprecio.setText("");
        txtcantidad.setText("");
        txttotal.setText("");
        txtmetododepago.setText("");
        txtpagocon.setText("");
        txtcambio.setText("");

    }

    private void TotalPagar() {
        total = 0.00;
        int numFila = tbldatospagar.getRowCount();
        for (int i = 0; i < numFila; i++) {
            double cal = Double.parseDouble(String.valueOf(tbldatospagar.getModel().getValueAt(i, 4)));
            total = total + cal;
        }
        SwingUtilities.invokeLater(() -> {
            txttotal.setText(String.format("%.2f", total));
        });

    }

    private void LimpiarTableVenta() {
        modelo = (DefaultTableModel) tbldatospagar.getModel();
        int fila = tbldatospagar.getRowCount();
        for (int i = 0; i < fila; i++) {
            modelo.removeRow(0);
        }
    }

    private void calcularCambio() {
        try {
            // Obtén el monto total desde tu campo de texto txtPrecio
            double montoTotal = Double.parseDouble(txttotal.getText());

            // Obtén el monto ingresado desde tu campo de texto txtBilleteIngresado
            double montoIngresado = Double.parseDouble(txtpagocon.getText());

            // Calcula el cambio
            double cambio = montoIngresado - montoTotal;

            // Muestra el cambio en el campo de texto txtCambio
            txtcambio.setText(String.format("%.2f", cambio));
        } catch (NumberFormatException e) {
            // Maneja cualquier error en la conversión de valores
            txtcambio.setText(""); // Limpia el campo de texto en caso de error
        }
    }

}
