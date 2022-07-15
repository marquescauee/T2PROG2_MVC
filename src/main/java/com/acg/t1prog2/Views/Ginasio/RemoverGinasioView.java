/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acg.t1prog2.Views.Ginasio;

import com.acg.t1prog2.DAO.GinasioDAO;
import com.acg.t1prog2.Models.Ginasio;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class RemoverGinasioView extends javax.swing.JFrame {

    private GinasioDAO ginasioDAO = new GinasioDAO();
    
    public RemoverGinasioView() {
        initComponents();
        
        this.popularComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbGinasio = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btRemoverGinasio = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Remover Ginásio");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Ginásio:");

        btRemoverGinasio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRemoverGinasio.setLabel("Remover Ginásio");
        btRemoverGinasio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerGinasio(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(cbGinasio, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(btRemoverGinasio, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbGinasio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btRemoverGinasio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void removerGinasio(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerGinasio
        Ginasio tempGinasio = (Ginasio) this.cbGinasio.getSelectedItem();
        
        ginasioDAO.removerGinasio(tempGinasio);
        JOptionPane.showMessageDialog(null, "Ginásio removido com sucesso!");
       
        this.cbGinasio.removeAllItems();
        this.popularComboBox();
    }//GEN-LAST:event_removerGinasio


    private void popularComboBox() {
        for (Ginasio ginasio : ginasioDAO.recuperarTodosGinasios()) {
            cbGinasio.addItem(ginasio);
        }
    }
    
    public void adicionarAcaoBotaoRemover(ActionListener acao) {
        this.btRemoverGinasio.addActionListener(acao);
    }
    
    public Ginasio getGinasio() {
        return (Ginasio) cbGinasio.getSelectedItem();
    }
    
    public void exibir() {
        this.setVisible(true);
    }
    
    public void exibirMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btRemoverGinasio;
    private javax.swing.JComboBox<Ginasio> cbGinasio;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
