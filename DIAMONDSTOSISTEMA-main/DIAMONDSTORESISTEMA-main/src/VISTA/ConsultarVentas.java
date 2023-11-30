
package VISTA;

import CONTROLADOR.CobrarPedidoController;
import DISEÑO.PanelShadow;
import MODELO.Pedido;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultarVentas extends PanelShadow {

    Main main;
    private List<Pedido> lista = new ArrayList<>();
    CobrarPedidoController control = new CobrarPedidoController();
    private double totalPedidoSeleccionado;

    public ConsultarVentas(Main mainInstance) {
        main = mainInstance;

        initComponents();
        tbldatos.addMouseListener(new MouseAdapter() {

            @Override

            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // Asegúrate de que sea un solo clic
                    int filaSeleccionada = tbldatos.getSelectedRow();
                    if (filaSeleccionada >= 0) {
                        double totalPedido = (double) tbldatos.getValueAt(filaSeleccionada, 4);

                        // Guarda los datos en un lugar temporal (por ejemplo, variables de clase)
                        totalPedidoSeleccionado = totalPedido;
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldatos = new javax.swing.JTable();
        txtpedido = new DISEÑO.TextField();
        btneliminar = new DISEÑO.Button();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 246, 249));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cinzel Decorative", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(239, 135, 176));
        jLabel1.setText("Ventas Registradas");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 323, 46));

        tbldatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NOMBRE CLIENTE", "PRODUCTO", "CANTIDAD", "PRECIO", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(tbldatos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 700, 240));

        txtpedido.setForeground(new java.awt.Color(191, 110, 82));
        txtpedido.setFont(new java.awt.Font("Roseritta", 1, 14)); // NOI18N
        txtpedido.setHint("BUSCA LA VENTA POR EL NOMBRE DEL CLIENTE");
        txtpedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpedidoKeyReleased(evt);
            }
        });
        add(txtpedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 410, 50));

        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-eliminar-24.png"))); // NOI18N
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });
        add(btneliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, 70, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-cliente-40.png"))); // NOI18N
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 40, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void txtpedidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpedidoKeyReleased

        this.consultarPedido();


    }//GEN-LAST:event_txtpedidoKeyReleased

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed

        try {
            eliminarPedido();
        } catch (Exception ex) {
            mostrarError("Error al eliminar el producto: " + ex.getMessage());
        }


    }//GEN-LAST:event_btneliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DISEÑO.Button btneliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbldatos;
    private DISEÑO.TextField txtpedido;
    // End of variables declaration//GEN-END:variables

    private void consultarPedido() {
        lista = control.getPedido(txtpedido.getText());
        DefaultTableModel tabla = (DefaultTableModel) tbldatos.getModel();
        tabla.setRowCount(0); // Elimina todas las filas
        for (Pedido r : lista) {
            Object[] rowData = {r.getClienteName(), r.getProducto(), r.getCantidad(), r.getPrecio(), r.getTotal()};
            tabla.addRow(rowData);
        }

    }

    private void eliminarPedido() {
        int filaSeleccionada = tbldatos.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) tbldatos.getModel();

        if (filaSeleccionada != -1) {
            String ClienteName = (String) modelo.getValueAt(filaSeleccionada, 0); // Obtén el nombre del producto
            System.out.println("Intentando eliminar pedido del cliente: " + ClienteName);

            boolean eliminado = control.eliminarPedido(ClienteName);
            if (eliminado) {
                System.out.println("Pedido eliminado: " + ClienteName);
                modelo.removeRow(filaSeleccionada);
            } else {
                System.out.println("No se pudo eliminar el pedido.");
                mostrarError("No se pudo eliminar el pedido.");
            }
        } else {
            System.out.println("Por favor, seleccione un pedido de la tabla.");
            mostrarError("Por favor, seleccione un pedido de la tabla.");
        }
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

}
