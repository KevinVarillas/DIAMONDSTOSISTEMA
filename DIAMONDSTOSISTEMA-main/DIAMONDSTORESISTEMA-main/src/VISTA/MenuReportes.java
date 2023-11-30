package VISTA;

import CONTROLADOR.Reportes;
import DISEÑO.PanelShadow;

public class MenuReportes extends PanelShadow {

    Main main;

    public MenuReportes(Main mainInstance) {
        main = mainInstance;

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button21 = new DISEÑO.Button2();
        button22 = new DISEÑO.Button2();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button21.setForeground(new java.awt.Color(183, 154, 129));
        button21.setText("Reporte de Ventas");
        button21.setFont(new java.awt.Font("Cinzel Decorative", 1, 12)); // NOI18N
        button21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button21ActionPerformed(evt);
            }
        });
        add(button21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 180, 60));

        button22.setForeground(new java.awt.Color(183, 154, 129));
        button22.setText("Reporte de Productos");
        button22.setFont(new java.awt.Font("Cinzel Decorative", 1, 12)); // NOI18N
        button22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button22ActionPerformed(evt);
            }
        });
        add(button22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 180, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void button21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button21ActionPerformed

        Reportes reportes = new Reportes();
        reportes.ReportesVentas();

    }//GEN-LAST:event_button21ActionPerformed

    private void button22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button22ActionPerformed

        Reportes reportes = new Reportes();
        reportes.ReportesProductos();
    }//GEN-LAST:event_button22ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DISEÑO.Button2 button21;
    private DISEÑO.Button2 button22;
    // End of variables declaration//GEN-END:variables
}
