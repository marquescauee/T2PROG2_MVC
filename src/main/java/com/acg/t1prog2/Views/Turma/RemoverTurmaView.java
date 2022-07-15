/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acg.t1prog2.Views.Turma;

import com.acg.t1prog2.DAO.TurmaDAO;
import com.acg.t1prog2.Models.Turma;
import com.acg.t1prog2.Views.App;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class RemoverTurmaView extends javax.swing.JFrame {

    private TurmaDAO turmaDAO = new TurmaDAO();
    
    public RemoverTurmaView() {
        initComponents();
        
        this.popularCbTurma();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbTurma = new javax.swing.JComboBox<>();
        btRemoverTurma = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Remover Turma");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Turma:");

        btRemoverTurma.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRemoverTurma.setLabel("Remover Turma");
        btRemoverTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerTurma(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btRemoverTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20)
                .addComponent(btRemoverTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void removerTurma(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerTurma
        Turma tempTurma = (Turma) this.cbTurma.getSelectedItem();
        
        turmaDAO.removerTurma(tempTurma);
        JOptionPane.showMessageDialog(null, "Turma removida com sucesso!");
        
        this.cbTurma.removeAllItems();
        this.popularCbTurma();
    }//GEN-LAST:event_removerTurma

    private void popularCbTurma() {
        for (Turma turma : turmaDAO.recuperarTodasTurmas()) {
            this.cbTurma.addItem(turma);
        }
    }
    
    public Turma getTurma() {
        return (Turma) cbTurma.getSelectedItem();
    }
    
    public void adicionarAcaoRemoverTurma(ActionListener acao) {
        btRemoverTurma.addActionListener(acao);
    }
    
    public void exibir() {
        this.setVisible(true);
    }
    
    public void exibirMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btRemoverTurma;
    private javax.swing.JComboBox<Turma> cbTurma;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
