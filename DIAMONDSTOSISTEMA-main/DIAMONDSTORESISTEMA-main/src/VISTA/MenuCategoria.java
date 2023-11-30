/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VISTA;

import DISEÑO.PanelShadow;

/**
 *
 * @author analu
 */
public class MenuCategoria extends PanelShadow  {

    
    
     Main main; 
    public MenuCategoria(Main mainInstance) {
                main = mainInstance;

        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button21 = new DISEÑO.Button2();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button21.setForeground(new java.awt.Color(183, 154, 129));
        button21.setText("Registrar Categoria");
        button21.setFont(new java.awt.Font("Cinzel Decorative", 1, 12)); // NOI18N
        button21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button21ActionPerformed(evt);
            }
        });
        add(button21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 175, 61));
    }// </editor-fold>//GEN-END:initComponents

    private void button21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button21ActionPerformed

        main.ShowJPanel(new RegistroCategoria());




    }//GEN-LAST:event_button21ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private DISEÑO.Button2 button21;
    // End of variables declaration//GEN-END:variables
}
