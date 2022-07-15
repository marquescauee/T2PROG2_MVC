/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acg.t1prog2.Views.Pessoa;

import com.acg.t1prog2.DAO.PessoaDAO;
import com.acg.t1prog2.Models.Pessoa;
import com.acg.t1prog2.Views.App;
import javax.swing.JOptionPane;

public class RemoverPessoaView extends javax.swing.JFrame {

    private PessoaDAO pessoaDAO = new PessoaDAO();
    
    public RemoverPessoaView() {
        initComponents();
        this.popularComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbPessoas = new javax.swing.JComboBox<>();
        btRemoverAluno = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Remover Pessoa");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Pessoa:");

        btRemoverAluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRemoverAluno.setLabel("Remover Pessoa");
        btRemoverAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerPessoa(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(39, 39, 39)
                .addComponent(cbPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btRemoverAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btRemoverAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void removerPessoa(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerPessoa
        Pessoa tempPessoa = (Pessoa) this.cbPessoas.getSelectedItem();
        
        pessoaDAO.removerPessoa(tempPessoa);
        JOptionPane.showMessageDialog(null, "Pessoa removida com sucesso!");
        
        this.cbPessoas.removeAllItems();
        this.popularComboBox();
        
    }//GEN-LAST:event_removerPessoa

    
    
    private void popularComboBox() {
        for(Pessoa p : pessoaDAO.recuperarTodasPessoas()) {
            this.cbPessoas.addItem(p);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btRemoverAluno;
    private javax.swing.JComboBox<Pessoa> cbPessoas;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
