/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acg.t1prog2.Views.Pessoa;

import com.acg.t1prog2.DAO.PessoaDAO;
import com.acg.t1prog2.Exceptions.CampoVazioException;
import com.acg.t1prog2.Exceptions.IdadeException;
import com.acg.t1prog2.Models.Pessoa;
import com.acg.t1prog2.Views.App;
import javax.swing.JOptionPane;

public class EditarPessoaView extends javax.swing.JFrame {

    private PessoaDAO pessoaDAO = new PessoaDAO();

    public EditarPessoaView() {
        initComponents();

        this.popularComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfIdadePessoa = new javax.swing.JTextField();
        btEditarAluno = new java.awt.Button();
        jLabel3 = new javax.swing.JLabel();
        tfNomePessoa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbPessoas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Pessoa");

        btEditarAluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btEditarAluno.setLabel("Editar Pessoa");
        btEditarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarPessoa(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Idade:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Selecione a pessoa:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tfNomePessoa, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                        .addComponent(tfIdadePessoa))
                    .addComponent(cbPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btEditarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(263, 263, 263))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(cbPessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(tfNomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(tfIdadePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btEditarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void editarPessoa(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarPessoa
        Pessoa tempPessoa = (Pessoa) this.cbPessoas.getSelectedItem();

        String nome = tempPessoa.getNome();
        int idade = tempPessoa.getIdade();

        if (!this.tfNomePessoa.getText().isBlank()) {
            nome = tfNomePessoa.getText();
        }

        if (!this.tfIdadePessoa.getText().isBlank()) {
            idade = Integer.parseInt(tfIdadePessoa.getText());
        }

        try {
            tempPessoa.setNome(nome);
            tempPessoa.setIdade(idade);
            JOptionPane.showMessageDialog(null, "Edição realizada com sucesso!");

            this.cbPessoas.removeAllItems();
            this.popularComboBox();
            this.limparTela();
        } catch(CampoVazioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch(IdadeException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_editarPessoa

    private void popularComboBox() {
        for (Pessoa p : pessoaDAO.recuperarTodasPessoas()) {
            this.cbPessoas.addItem(p);
        }
    }

    private void limparTela() {
        tfNomePessoa.setText("");
        tfIdadePessoa.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btEditarAluno;
    private javax.swing.JComboBox<Pessoa> cbPessoas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tfIdadePessoa;
    private javax.swing.JTextField tfNomePessoa;
    // End of variables declaration//GEN-END:variables
}
