/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acg.t1prog2.Views.Equipamento;

import com.acg.t1prog2.Models.Equipamento;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class RemoverEquipamentoView extends javax.swing.JFrame {
    
    public RemoverEquipamentoView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbEditarEquip = new javax.swing.JComboBox<>();
        lbEquip = new javax.swing.JLabel();
        btRemoverEquip = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Remover Equipamento");

        lbEquip.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbEquip.setText("Equipamento:");

        btRemoverEquip.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRemoverEquip.setLabel("Remover Equipamento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbEquip)
                .addGap(18, 18, 18)
                .addComponent(cbEditarEquip, 0, 558, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btRemoverEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(268, 268, 268))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbEquip)
                    .addComponent(cbEditarEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btRemoverEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void popularComboBox(List<Equipamento> equips) {
        for(Equipamento equip : equips) {
            cbEditarEquip.addItem(equip);
        }
    }
    
    public void limparComboBox() {
        cbEditarEquip.removeAllItems();
    }
    
    public void adicionarAcaoRemover(ActionListener acao) {
        btRemoverEquip.addActionListener(acao);
    }
    
    public Equipamento getEquipamento() {
        return (Equipamento) cbEditarEquip.getSelectedItem();
    }
    
    public void exibir() {
        this.setVisible(true);
    }
    
    public void exibirMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btRemoverEquip;
    private javax.swing.JComboBox<Equipamento> cbEditarEquip;
    private javax.swing.JLabel lbEquip;
    // End of variables declaration//GEN-END:variables
}
