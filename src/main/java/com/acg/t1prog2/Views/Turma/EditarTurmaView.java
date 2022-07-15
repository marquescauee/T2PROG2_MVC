/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acg.t1prog2.Views.Turma;

import com.acg.t1prog2.DAO.PessoaDAO;
import com.acg.t1prog2.DAO.TurmaDAO;
import com.acg.t1prog2.Models.Pessoa;
import com.acg.t1prog2.Models.Professor;
import com.acg.t1prog2.Models.Turma;
import com.acg.t1prog2.Views.App;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class EditarTurmaView extends javax.swing.JFrame {

    private TurmaDAO turmaDAO = new TurmaDAO();
    private PessoaDAO pessoaDAO = new PessoaDAO();

    public EditarTurmaView() {
        initComponents();
        
        this.popularCbProfessor();
        this.popularCbTurma();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbProfessor = new javax.swing.JComboBox<>();
        btEditarTurma = new java.awt.Button();
        jLabel2 = new javax.swing.JLabel();
        cbTurma = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Turma");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Professor:");

        btEditarTurma.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btEditarTurma.setLabel("Editar Turma");
        btEditarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarTurma(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Turma:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbProfessor, 0, 582, Short.MAX_VALUE)
                    .addComponent(cbTurma, 0, 582, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btEditarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(280, 280, 280))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cbProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(btEditarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void editarTurma(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarTurma
        Turma tempTurma = (Turma) this.cbTurma.getSelectedItem();
        Professor tempProfessor = (Professor) this.cbProfessor.getSelectedItem();
        
        tempTurma.setProfessor(tempProfessor);
        
        JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
        
        this.cbProfessor.removeAllItems();
        this.cbTurma.removeAllItems();
        this.popularCbTurma();
        this.popularCbProfessor();
    }//GEN-LAST:event_editarTurma

    private void popularCbTurma() {
        for (Turma turma : turmaDAO.recuperarTodasTurmas()) {
            this.cbTurma.addItem(turma);
        }
    }

    private void popularCbProfessor() {
        for (Pessoa p : pessoaDAO.recuperarTodasPessoas()) {
            if (p instanceof Professor professor) {
                this.cbProfessor.addItem(professor);
            }
        }
    }

    public Professor getProfessor() {
        return (Professor) cbProfessor.getSelectedItem();
    }
    
    public Turma getTurma() {
        return (Turma) cbTurma.getSelectedItem();
    }
    
    public void adicionarAcaoBotaoEditar(ActionListener acao) {
        btEditarTurma.addActionListener(acao);
    }
    
    public void exibir() {
        this.setVisible(true);
    }
    
    public void exibirMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btEditarTurma;
    private javax.swing.JComboBox<Professor> cbProfessor;
    private javax.swing.JComboBox<Turma> cbTurma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
