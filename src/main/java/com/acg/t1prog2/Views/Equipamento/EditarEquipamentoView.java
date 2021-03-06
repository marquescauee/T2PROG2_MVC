/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acg.t1prog2.Views.Equipamento;

import com.acg.t1prog2.Models.Equipamento;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

public class EditarEquipamentoView extends javax.swing.JFrame {

    public EditarEquipamentoView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfMarcaEquip = new javax.swing.JTextField();
        lbMarcaEquip = new javax.swing.JLabel();
        tfNomeEquip = new javax.swing.JTextField();
        lbNomeEquip = new javax.swing.JLabel();
        cbEditarEquip = new javax.swing.JComboBox<>();
        lbEquip = new javax.swing.JLabel();
        btEditarEquip = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Equipamento");

        lbMarcaEquip.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbMarcaEquip.setText("Marca:");

        lbNomeEquip.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNomeEquip.setText("Nome:");

        lbEquip.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbEquip.setText("Equipamento:");

        btEditarEquip.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btEditarEquip.setLabel("Editar Equipamento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbMarcaEquip)
                        .addGap(55, 55, 55))
                    .addComponent(lbEquip)
                    .addComponent(lbNomeEquip))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfMarcaEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNomeEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEditarEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(btEditarEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbEquip)
                    .addComponent(cbEditarEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbNomeEquip)
                    .addComponent(tfNomeEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbMarcaEquip)
                    .addComponent(tfMarcaEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btEditarEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void limparComboBox() {
        cbEditarEquip.removeAllItems();
    }
    
    public void popularComboBox(List<Equipamento> equips) {        
        for (Equipamento equip : equips) {
            cbEditarEquip.addItem(equip);
        }
    }

    public Equipamento getEquipamento() {
        return (Equipamento) cbEditarEquip.getSelectedItem();
    }
    
    public String getNome() {
        return tfNomeEquip.getText();
    }
    
    public String getMarca() {
        return tfMarcaEquip.getText();
    }
    
    public void adicionarAcaoEditar(ActionListener acao) {
        btEditarEquip.addActionListener(acao);
    }
    
    public void limparTela() {
        tfNomeEquip.setText("");
        tfMarcaEquip.setText("");
    }
    
    public void exibir() {
        this.setVisible(true);
    }
    
    public void exibirMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btEditarEquip;
    private javax.swing.JComboBox<Equipamento> cbEditarEquip;
    private javax.swing.JLabel lbEquip;
    private javax.swing.JLabel lbMarcaEquip;
    private javax.swing.JLabel lbNomeEquip;
    private javax.swing.JTextField tfMarcaEquip;
    private javax.swing.JTextField tfNomeEquip;
    // End of variables declaration//GEN-END:variables
}
