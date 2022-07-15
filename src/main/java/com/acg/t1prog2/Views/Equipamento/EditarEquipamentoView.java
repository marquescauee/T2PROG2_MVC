/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acg.t1prog2.Views.Equipamento;

import com.acg.t1prog2.DAO.EquipamentoDAO;
import com.acg.t1prog2.Exceptions.CampoVazioException;
import com.acg.t1prog2.Models.Equipamento;
import com.acg.t1prog2.Views.App;
import javax.swing.JOptionPane;

public class EditarEquipamentoView extends javax.swing.JFrame {

    private EquipamentoDAO equipDAO = new EquipamentoDAO();

    public EditarEquipamentoView() {
        initComponents();
        this.popularComboBox();
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
        btEditarEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarEquipamento(evt);
            }
        });

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEquip)
                            .addComponent(lbNomeEquip))
                        .addGap(0, 0, 0)))
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

    private void editarEquipamento(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarEquipamento
        Equipamento tempEquip = (Equipamento) this.cbEditarEquip.getSelectedItem();

        String nome = tempEquip.getNome();
        String marca = tempEquip.getMarca();

        if (!this.tfNomeEquip.getText().isBlank()) {
            nome = tfNomeEquip.getText();
        }

        if (!this.tfMarcaEquip.getText().isBlank()) {
            marca = tfMarcaEquip.getText();
        }

        try {
            tempEquip.setNome(nome);
            tempEquip.setMarca(marca);

            JOptionPane.showMessageDialog(null, "Edição realizada com sucesso!");
            this.cbEditarEquip.removeAllItems();
            this.popularComboBox();
            this.limparTela();
        } catch (CampoVazioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_editarEquipamento

    private void popularComboBox() {        
        for (Equipamento equip : equipDAO.recuperarTodosEquipamentos()) {
            cbEditarEquip.addItem(equip);
        }
    }

    private void limparTela() {
        tfNomeEquip.setText("");
        tfMarcaEquip.setText("");
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
