package VISTA;

import DISEÑO.PanelShadow;

public class MenuVentas extends PanelShadow {

    Main main;
    public MenuVentas(Main mainInstance) {
        main = mainInstance;

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnpedido = new DISEÑO.Button2();
        button23 = new DISEÑO.Button2();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnpedido.setForeground(new java.awt.Color(183, 154, 129));
        btnpedido.setText("Registrar Pedido");
        btnpedido.setFont(new java.awt.Font("Cinzel Decorative", 1, 12)); // NOI18N
        btnpedido.setMaximumSize(new java.awt.Dimension(163, 33));
        btnpedido.setMinimumSize(new java.awt.Dimension(163, 33));
        btnpedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpedidoActionPerformed(evt);
            }
        });
        add(btnpedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 180, 60));

        button23.setForeground(new java.awt.Color(183, 154, 129));
        button23.setText("Consultar Ventas");
        button23.setFont(new java.awt.Font("Cinzel Decorative", 1, 12)); // NOI18N
        button23.setMaximumSize(new java.awt.Dimension(163, 33));
        button23.setMinimumSize(new java.awt.Dimension(163, 33));
        button23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button23ActionPerformed(evt);
            }
        });
        add(button23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 180, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void btnpedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpedidoActionPerformed

         main.ShowJPanel(new RegistrarVenta(main));

    }//GEN-LAST:event_btnpedidoActionPerformed

    private void button23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button23ActionPerformed
         main.ShowJPanel(new ConsultarVentas(main));


    }//GEN-LAST:event_button23ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DISEÑO.Button2 btnpedido;
    private DISEÑO.Button2 button23;
    // End of variables declaration//GEN-END:variables
}
