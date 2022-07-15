/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acg.t1prog2.Views.Ginasio;

import com.acg.t1prog2.DAO.EquipamentoDAO;
import com.acg.t1prog2.DAO.GinasioDAO;
import com.acg.t1prog2.Models.Equipamento;
import com.acg.t1prog2.Models.Ginasio;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class AssociarEquipamentoView extends javax.swing.JFrame {

    private EquipamentoDAO equipDAO = new EquipamentoDAO();
    private GinasioDAO ginasioDAO = new GinasioDAO();

    public AssociarEquipamentoView() {
        initComponents();

        this.popularComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbEquipamento = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbGinasio = new javax.swing.JComboBox<>();
        btnAssociar = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar Equipamento");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Equipamento:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Ginásio:");

        btnAssociar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAssociar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAssociar.setLabel("Associar");
        btnAssociar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                associarEquipamento(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbGinasio, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAssociar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(216, 216, 216))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEquipamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbGinasio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btnAssociar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void associarEquipamento(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_associarEquipamento
        Equipamento tempEquip = (Equipamento) this.cbEquipamento.getSelectedItem();
        Ginasio tempGinasio = (Ginasio) this.cbGinasio.getSelectedItem();
 
        tempGinasio.getListaEquipamentos().add(tempEquip);
        tempGinasio.addEquipamentoMap(tempEquip);
        
        JOptionPane.showMessageDialog(null, "Associação realizada com sucesso!");
    }//GEN-LAST:event_associarEquipamento

    private void popularComboBox() {
        for(Equipamento equip : equipDAO.recuperarTodosEquipamentos()) {
            this.cbEquipamento.addItem(equip);
        }
        
        for(Ginasio gin : ginasioDAO.recuperarTodosGinasios()) {
            this.cbGinasio.addItem(gin);
        }
    }
    
    public void adicionarAcaoBotaoAssociar(ActionListener acao) {
        this.btnAssociar.addActionListener(acao);
    }
    
    public Ginasio getGinasio() {
        return (Ginasio) cbGinasio.getSelectedItem();
    }
    
    public Equipamento getEquipamento() {
        return (Equipamento) cbEquipamento.getSelectedItem();
    }
    
    public void exibir() {
        this.setVisible(true);
    }
    
    public void exibirMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnAssociar;
    private javax.swing.JComboBox<Equipamento> cbEquipamento;
    private javax.swing.JComboBox<Ginasio> cbGinasio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
