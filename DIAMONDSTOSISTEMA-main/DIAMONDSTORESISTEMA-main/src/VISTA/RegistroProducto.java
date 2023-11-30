package VISTA;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import BASEDATOS.AccesoBD;
import DISEÑO.PanelShadow;
import SERVICES.RegistroProductoService;
import CONTROLADOR.RegistroProductoController;
import MODELO.Producto;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.awt.image.BufferedImage;

import util.Mensaje;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class RegistroProducto extends PanelShadow {

    Connection cn;
    String Ruta = "";
    RegistroProductoService regis = new RegistroProductoService();

    public RegistroProducto() {
        initComponents();

        init();
    }

    private void init() {
        setRadius(20);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtnombre = new DISEÑO.TextField();
        txtcatenombre = new DISEÑO.TextField();
        txtprecio = new DISEÑO.TextField();
        txtstock = new DISEÑO.TextField();
        jLabel3 = new javax.swing.JLabel();
        btnguardar = new DISEÑO.Button();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtcateid1 = new DISEÑO.TextField();
        lblImagen = new javax.swing.JLabel();
        btnimagen = new DISEÑO.Button();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 246, 249));
        setPreferredSize(new java.awt.Dimension(919, 492));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Cinzel Decorative", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(239, 135, 176));
        jLabel1.setText("Registra tus Productos");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 430, 60));

        txtnombre.setForeground(new java.awt.Color(191, 110, 82));
        txtnombre.setFont(new java.awt.Font("Roseritta", 1, 14)); // NOI18N
        txtnombre.setHint("Nombre del Producto");
        add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 210, 50));

        txtcatenombre.setEditable(false);
        txtcatenombre.setForeground(new java.awt.Color(191, 110, 82));
        txtcatenombre.setFont(new java.awt.Font("Roseritta", 1, 14)); // NOI18N
        txtcatenombre.setHint("Nombre Categoría");
        add(txtcatenombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 140, 50));

        txtprecio.setForeground(new java.awt.Color(191, 110, 82));
        txtprecio.setFont(new java.awt.Font("Roseritta", 1, 14)); // NOI18N
        txtprecio.setHint("Precio del Producto");
        txtprecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioActionPerformed(evt);
            }
        });
        add(txtprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 180, 50));

        txtstock.setForeground(new java.awt.Color(191, 110, 82));
        txtstock.setFont(new java.awt.Font("Roseritta", 1, 14)); // NOI18N
        txtstock.setHint("N° de Stock");
        add(txtstock, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 180, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-stock-30.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 40, 40));

        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setText("Registrar Producto");
        btnguardar.setFont(new java.awt.Font("Cinzel Decorative", 1, 14)); // NOI18N
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 240, 70));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-maquillaje-40.png"))); // NOI18N
        jLabel4.setText("jLabel2");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 40, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-categorizar-40.png"))); // NOI18N
        jLabel5.setText("jLabel2");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 40, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8-etiqueta-de-precio-usd-30.png"))); // NOI18N
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 40, 40));

        txtcateid1.setForeground(new java.awt.Color(191, 110, 82));
        txtcateid1.setFont(new java.awt.Font("Roseritta", 1, 14)); // NOI18N
        txtcateid1.setHint("ID");
        txtcateid1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcateid1KeyReleased(evt);
            }
        });
        add(txtcateid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 60, 50));

        lblImagen.setBackground(new java.awt.Color(191, 110, 82));
        add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 150, 140));

        btnimagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/subir (1).png"))); // NOI18N
        btnimagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimagenActionPerformed(evt);
            }
        });
        add(btnimagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 60, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Hola pagame.png"))); // NOI18N
        jLabel2.setToolTipText("");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 250, 320));
    }// </editor-fold>//GEN-END:initComponents

    private void txtprecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioActionPerformed
    private byte[] getImagen(String Ruta) {
        File imagen = new File(Ruta);
        try {
            byte[] icono = new byte[(int) imagen.length()];
            InputStream input = new FileInputStream(imagen);
            input.read(icono);
            return icono;
        } catch (Exception ex) {
            return null;
        }
    }


    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

        try {
            Producto pro = new Producto();

            String producto = txtnombre.getText();
            int categoria = Integer.parseInt(txtcateid1.getText());
            double precio = Double.parseDouble(txtprecio.getText());
            int stock = Integer.parseInt(txtstock.getText());
            pro.setImagen(getImagen(Ruta));

// Proceso
            RegistroProductoController control = new RegistroProductoController(regis);
            control.registroProducto(producto, categoria, precio, stock, pro);
            JOptionPane.showMessageDialog(null, "Registro guardado correctamente.");
        } catch (Exception e) {
// Captura excepciones generales
            Mensaje.error(this, "Ocurrio un error inesperado: " + e.getMessage());
        }
        limpiar();


    }//GEN-LAST:event_btnguardarActionPerformed

    private void txtcateid1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcateid1KeyReleased

        consultarNombre();


    }//GEN-LAST:event_txtcateid1KeyReleased

    private void btnimagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimagenActionPerformed

  JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        fileChooser.setFileFilter(extensionFilter);

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            Ruta = fileChooser.getSelectedFile().getAbsolutePath();
            Image mImagen = new ImageIcon(Ruta).getImage();
            ImageIcon mIcono = new ImageIcon(mImagen.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), 0));
            lblImagen.setIcon(mIcono);
        }


    }//GEN-LAST:event_btnimagenActionPerformed
    private void limpiar() {
        txtnombre.setText("");
        txtcateid1.setText("");
        txtprecio.setText("");
        txtstock.setText("");
        txtcatenombre.setText("");
        
       
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DISEÑO.Button btnguardar;
    private DISEÑO.Button btnimagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblImagen;
    private DISEÑO.TextField txtcateid1;
    private DISEÑO.TextField txtcatenombre;
    private DISEÑO.TextField txtnombre;
    private DISEÑO.TextField txtprecio;
    private DISEÑO.TextField txtstock;
    // End of variables declaration//GEN-END:variables

    private void agregarDocumentListener() {
        txtcateid1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                consultarNombre();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                consultarNombre();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                consultarNombre();
            }
        });
    }

    private void consultarNombre() {
        try {
            // Conectar a la base de datos
            cn = AccesoBD.getConnection();

            // Obtener el ID ingresado en txtcateid1
            String id = txtcateid1.getText();

            // Consulta SQL para obtener el nombre
            CallableStatement callableStatement = cn.prepareCall("{call pa_selectCategoria}");
            ResultSet result = callableStatement.executeQuery();

            while (result.next()) {
                int idCategoria = result.getInt("id_cate");
                if (id.equals(String.valueOf(idCategoria))) {
                    String nombre = result.getString("nombre");
                    txtcatenombre.setText(nombre);
                    return; // Termina el bucle al encontrar la categoría
                }
            }

            // Si no se encontró la categoría, muestra un mensaje
            txtcatenombre.setText("NO EXISTE");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistroProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
