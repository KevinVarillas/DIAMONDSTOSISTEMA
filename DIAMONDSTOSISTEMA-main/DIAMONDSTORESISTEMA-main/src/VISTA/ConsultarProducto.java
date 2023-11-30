package VISTA;

import BASEDATOS.AccesoBD;
import CONTROLADOR.ConsultarProductoController;

import DISEÑO.PanelShadow;
import DISEÑO.RenderImagen;
import MODELO.Producto;
import java.awt.Image;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultarProducto extends PanelShadow {

    private List<Producto> lista = new ArrayList<>();
    AccesoBD bd = new AccesoBD();
    ConsultarProductoController control = new ConsultarProductoController();
    DefaultTableModel mModeloTabla = new DefaultTableModel();
    RegistrarVenta venta;
    Main main;
    private String nombreProductoSeleccionado;
    private double precioProductoSeleccionado;

    public ConsultarProducto(Main mainInstance, RegistrarVenta venta) {
        this.venta = venta;  // Asigna la instancia de RegistroPedido al campo

        initComponents();
        main = mainInstance;

        mModeloTabla.addColumn("NOMBRE");
        mModeloTabla.addColumn("CATEGORIA");
        mModeloTabla.addColumn("PRECIO");
        mModeloTabla.addColumn("STOCK");
        mModeloTabla.addColumn("IMAGEN");
        CargarImagenes();
        tbldatos.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // Asegúrate de que sea un solo clic
                    int filaSeleccionada = tbldatos.getSelectedRow();
                    if (filaSeleccionada >= 0) {
                        String nombreProducto = (String) tbldatos.getValueAt(filaSeleccionada, 0);
                        double precioProducto = (double) tbldatos.getValueAt(filaSeleccionada, 2);

                        // Guarda los datos en un lugar temporal (por ejemplo, variables de clase)
                        nombreProductoSeleccionado = nombreProducto;
                        precioProductoSeleccionado = precioProducto;
                    }
                }
            }
        });

        init();
    }

    private void init() {
        setRadius(20);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldatos = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtnombre = new DISEÑO.TextField();
        btnEliminar = new DISEÑO.Button();
        button1 = new DISEÑO.Button();

        setBackground(new java.awt.Color(255, 246, 249));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cinzel Decorative", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(239, 135, 176));
        jLabel1.setText("Consulta Los Productos");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, 430, 60));

        tbldatos.setBackground(new java.awt.Color(255, 255, 255));
        tbldatos.setForeground(new java.awt.Color(0, 0, 0));
        tbldatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NOMBRE", "CATEGORIA", "PRECIO", "STOCK", "IMAGEN"
            }
        ));
        jScrollPane1.setViewportView(tbldatos);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 640, 240));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-maquillaje-40.png"))); // NOI18N
        jLabel4.setText("jLabel2");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 40, 40));

        txtnombre.setForeground(new java.awt.Color(191, 110, 82));
        txtnombre.setFont(new java.awt.Font("Roseritta", 1, 14)); // NOI18N
        txtnombre.setHint("Ingresa el nombre del producto");
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });
        txtnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnombreKeyReleased(evt);
            }
        });
        add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 390, 60));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-eliminar-24.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 180, 60, 60));

        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-comprar-24.png"))); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, 60, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void txtnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombreKeyReleased

        try {
            consultarProducto();

        } catch (ClassNotFoundException ex) {
            mostrarError("Error al consultar productos: " + ex.getMessage());

        }
    }//GEN-LAST:event_txtnombreKeyReleased

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        try {
            eliminarProducto();
        } catch (ClassNotFoundException ex) {
            mostrarError("Error al eliminar el producto: " + ex.getMessage());
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed

        int filaSeleccionada = tbldatos.getSelectedRow();
        if (filaSeleccionada != -1) {
            String nombreProducto = tbldatos.getValueAt(filaSeleccionada, 0).toString();
            double precio = Double.parseDouble(tbldatos.getValueAt(filaSeleccionada, 2).toString());

            venta.setProductoYPrecio(nombreProducto, precio);
            main.ShowJPanel(venta);
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un producto de la tabla.");
        }


    }//GEN-LAST:event_button1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DISEÑO.Button btnEliminar;
    private DISEÑO.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbldatos;
    private DISEÑO.TextField txtnombre;
    // End of variables declaration//GEN-END:variables

  private void consultarProducto() throws ClassNotFoundException {
    try {
        lista = control.getProducto(txtnombre.getText());
        DefaultTableModel tabla = (DefaultTableModel) tbldatos.getModel();
        tabla.setRowCount(0); // Elimina todas las filas

        for (Producto p : lista) {
            // Crear un ImageIcon a partir de los bytes de la imagen
            ImageIcon imagenIcono = new ImageIcon(p.getImagen());

            // Redimensionar la imagen
            int nuevoAncho = 70;  // Ajusta el ancho según tus necesidades
            int nuevoAlto = 60;   // Ajusta el alto según tus necesidades
            ImageIcon imagenRedimensionada = resizeImageIcon(imagenIcono, nuevoAncho, nuevoAlto);

            // Crear un objeto que contenga los datos a mostrar en la fila
            Object[] rowData = {p.getNombre(), p.getCategoria(), p.getPrecio(), p.getStock(), imagenRedimensionada};

            // Agregar la fila a la tabla
            tabla.addRow(rowData);
        }
    } catch (Exception e) {
        mostrarError("Error al consultar productos: " + e.getMessage());
    }
}


    private void eliminarProducto() throws ClassNotFoundException {
        int filaSeleccionada = tbldatos.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) tbldatos.getModel();

        if (filaSeleccionada != -1) {
            String nombreProducto = (String) modelo.getValueAt(filaSeleccionada, 0); // Obtén el nombre del producto
            System.out.println("Intentando eliminar producto: " + nombreProducto);

            boolean eliminado = control.eliminarProducto(nombreProducto);
            if (eliminado) {
                System.out.println("Producto eliminado: " + nombreProducto);
                modelo.removeRow(filaSeleccionada);
            } else {
                System.out.println("No se pudo eliminar el producto.");
                mostrarError("No se pudo eliminar el producto.");
            }
        } else {
            System.out.println("Por favor, seleccione un producto de la tabla.");
            mostrarError("Por favor, seleccione un producto de la tabla.");
        }
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void CargarImagenes() {
        tbldatos.setDefaultRenderer(Object.class,
                new RenderImagen());

        List<Producto> Imagenes;
        Producto pro;

        Imagenes = control.getProducto(TOOL_TIP_TEXT_KEY);
        if (Imagenes != null) {
            mModeloTabla.setRowCount(0);  // Limpia los datos existentes en la tabla

            for (int i = 0; i < Imagenes.size(); i++) {
                pro = (Producto) Imagenes.get(i);

                // Configura Datos para almacenar ImageIcon en lugar de String
                Object[] Datos = new Object[5];

                try {
                    byte[] imagen = pro.getImagen();
                    BufferedImage bufferedImage = null;
                    InputStream inputStream = new ByteArrayInputStream(imagen);
                    bufferedImage = ImageIO.read(inputStream);
                    ImageIcon mIcono = new ImageIcon(bufferedImage.getScaledInstance(60, 60, 0));

                    // Almacena el ImageIcon directamente en Datos en la columna 0
                    Datos[4] = mIcono;
                } catch (Exception e) {
                    Datos[4] = new JLabel("No imagen");
                }

                // Configura las otras celdas de Datos con los valores correspondientes
                Datos[0] = pro.getNombre();
                Datos[1] = pro.getCategoria();
                Datos[2] = pro.getPrecio();
                Datos[3] = pro.getStock();

                // Agrega la fila a la tabla
                mModeloTabla.addRow(Datos);
            }

            // Configura la tabla con el nuevo modelo de datos
            tbldatos.setModel(mModeloTabla);
            tbldatos.setRowHeight(60);

            // Asegúrate de que la columna 0 esté configurada para renderizar imágenes
            tbldatos.getColumnModel().getColumn(4).setCellRenderer(new RenderImagen());

            // Ajusta el ancho preferido de las columnas según tus necesidades
            tbldatos.getColumnModel().getColumn(0).setPreferredWidth(60);
            tbldatos.getColumnModel().getColumn(1).setPreferredWidth(60);
            tbldatos.getColumnModel().getColumn(2).setPreferredWidth(60);
            tbldatos.getColumnModel().getColumn(3).setPreferredWidth(60);
            tbldatos.getColumnModel().getColumn(4).setPreferredWidth(60);
        }

    }
    
    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
    Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
    return new ImageIcon(image);
}

}
