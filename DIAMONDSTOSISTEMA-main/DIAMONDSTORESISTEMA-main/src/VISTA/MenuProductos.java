package VISTA;

import DISEÑO.PanelShadow;
import VISTA.Main;
import java.awt.BorderLayout;
import javax.swing.JPanel;
public class MenuProductos extends PanelShadow {

     Main main; 
RegistrarVenta venta;
    public MenuProductos(Main mainInstance) {
        main = mainInstance;
        initComponents();

       
   
    }

    

   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnregistro = new DISEÑO.Button2();
        btnConsultarp = new DISEÑO.Button2();
        btnActualizar = new DISEÑO.Button2();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnregistro.setForeground(new java.awt.Color(183, 154, 129));
        btnregistro.setText("Registrar Producto");
        btnregistro.setFont(new java.awt.Font("Cinzel Decorative", 1, 12)); // NOI18N
        btnregistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistroActionPerformed(evt);
            }
        });
        add(btnregistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 180, 60));

        btnConsultarp.setForeground(new java.awt.Color(183, 154, 129));
        btnConsultarp.setText("Consultar Producto");
        btnConsultarp.setFont(new java.awt.Font("Cinzel Decorative", 1, 12)); // NOI18N
        btnConsultarp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarpActionPerformed(evt);
            }
        });
        add(btnConsultarp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 180, 60));

        btnActualizar.setForeground(new java.awt.Color(183, 154, 129));
        btnActualizar.setText("Actualizar Producto");
        btnActualizar.setFont(new java.awt.Font("Cinzel Decorative", 1, 12)); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 180, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void btnregistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistroActionPerformed

        main.ShowJPanel(new RegistroProducto());
        


    }//GEN-LAST:event_btnregistroActionPerformed

    private void btnConsultarpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarpActionPerformed

        main.ShowJPanel(new ConsultarProducto(main, venta));

    }//GEN-LAST:event_btnConsultarpActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

       main.ShowJPanel(new ActualizarStock());

    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DISEÑO.Button2 btnActualizar;
    private DISEÑO.Button2 btnConsultarp;
    private DISEÑO.Button2 btnregistro;
    // End of variables declaration//GEN-END:variables
}
