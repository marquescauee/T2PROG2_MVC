/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acg.t1prog2.Views.Equipamento;

import com.acg.t1prog2.DAO.EquipamentoDAO;
import com.acg.t1prog2.Exceptions.IdentificadorUnicoException;
import com.acg.t1prog2.Exceptions.CampoVazioException;
import com.acg.t1prog2.Models.Equipamento;
import javax.swing.JOptionPane;

public class CadastrarEquipamentoView extends javax.swing.JFrame {

    private EquipamentoDAO equipDAO = new EquipamentoDAO();

    public CadastrarEquipamentoView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbNomeEquip = new javax.swing.JLabel();
        tfNomeEquip = new javax.swing.JTextField();
        lbCodigoEquip = new javax.swing.JLabel();
        tfCodigoEquip = new javax.swing.JTextField();
        lbMarcaEquip = new javax.swing.JLabel();
        tfMarcaEquip = new javax.swing.JTextField();
        btCadastrarEquip = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Equipamento");

        lbNomeEquip.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbNomeEquip.setText("Nome:");

        lbCodigoEquip.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbCodigoEquip.setText("Código:");

        lbMarcaEquip.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbMarcaEquip.setText("Marca:");

        btCadastrarEquip.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btCadastrarEquip.setLabel("Cadastrar Equipamento");
        btCadastrarEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarEquipamento(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lbNomeEquip, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbCodigoEquip, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lbMarcaEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfMarcaEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNomeEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCodigoEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btCadastrarEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNomeEquip)
                    .addComponent(tfNomeEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodigoEquip)
                    .addComponent(tfCodigoEquip, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMarcaEquip)
                    .addComponent(tfMarcaEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btCadastrarEquip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarEquipamento(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarEquipamento
        String nome = tfNomeEquip.getText();
        String codigo = tfCodigoEquip.getText();
        String marca = tfMarcaEquip.getText();

        Equipamento equip = new Equipamento();      
        
        try {
            equip.setNome(nome);
            equip.setMarca(marca);
            equip.setCodigo(codigo);
            addEquipamento(equip);
            JOptionPane.showMessageDialog(null, "Equipamento cadastrado com sucesso!");
            this.limparTela();
        } catch (CampoVazioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_cadastrarEquipamento

    private void addEquipamento(Equipamento e) {
        equipDAO.salvarEquipamento(e);
    }

    private void limparTela() {
        tfNomeEquip.setText("");
        tfCodigoEquip.setText("");
        tfMarcaEquip.setText("");
    }
    
    public void exibir() {
        this.setVisible(true);
    }
    
    public void exibirMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btCadastrarEquip;
    private javax.swing.JLabel lbCodigoEquip;
    private javax.swing.JLabel lbMarcaEquip;
    private javax.swing.JLabel lbNomeEquip;
    private javax.swing.JTextField tfCodigoEquip;
    private javax.swing.JTextField tfMarcaEquip;
    private javax.swing.JTextField tfNomeEquip;
    // End of variables declaration//GEN-END:variables
}
