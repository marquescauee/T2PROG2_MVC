/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acg.t1prog2.Views.Turma;

import com.acg.t1prog2.DAO.EsporteDAO;
import com.acg.t1prog2.DAO.PessoaDAO;
import com.acg.t1prog2.DAO.TurmaDAO;
import com.acg.t1prog2.Models.Esporte;
import com.acg.t1prog2.Models.Pessoa;
import com.acg.t1prog2.Models.Professor;
import com.acg.t1prog2.Models.Turma;
import javax.swing.JOptionPane;

public class CadastrarTurmaView extends javax.swing.JFrame {

    private EsporteDAO esporteDAO = new EsporteDAO();
    private PessoaDAO pessoaDAO = new PessoaDAO();
    private TurmaDAO turmaDAO = new TurmaDAO();
    
    public CadastrarTurmaView() {
        initComponents();
        
        this.popularCbEsporte();
        this.popularCbProfessor();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbProfessor = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbEsporte = new javax.swing.JComboBox<>();
        btCadastrarTurma = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Turma");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Professor:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Esporte:");

        btCadastrarTurma.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btCadastrarTurma.setLabel("Cadastrar Turma");
        btCadastrarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarTurma(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbEsporte, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cbProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(btCadastrarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(cbProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(cbEsporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btCadastrarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarTurma(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarTurma
        Professor prof = (Professor) this.cbProfessor.getSelectedItem();
        Esporte esporte = (Esporte) this.cbEsporte.getSelectedItem();
        
        Turma turma = new Turma();
        
        turma.setProfessor(prof);
        turma.setEsporte(esporte);
        
        this.adicionarTurma(turma);
        
        JOptionPane.showMessageDialog(null, "Turma cadastrada com sucesso!");
    }//GEN-LAST:event_cadastrarTurma

    private void popularCbEsporte() {
        for(Esporte esp : esporteDAO.recuperarTodosEsportes()) {
            this.cbEsporte.addItem(esp);
        }
    }
    
    private void popularCbProfessor() {
        for(Pessoa p : pessoaDAO.recuperarTodasPessoas()) {
            if(p instanceof Professor professor) {
                this.cbProfessor.addItem(professor);
            }
        }
    }
    
    private void adicionarTurma(Turma turma) {
        turmaDAO.salvarTurma(turma);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btCadastrarTurma;
    private javax.swing.JComboBox<Esporte> cbEsporte;
    private javax.swing.JComboBox<Professor> cbProfessor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
