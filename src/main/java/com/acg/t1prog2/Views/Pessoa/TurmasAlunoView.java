/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acg.t1prog2.Views.Pessoa;

import com.acg.t1prog2.DAO.PessoaDAO;
import com.acg.t1prog2.DAO.TurmaDAO;
import com.acg.t1prog2.Models.Aluno;
import com.acg.t1prog2.Models.Pessoa;
import com.acg.t1prog2.Models.Turma;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class TurmasAlunoView extends javax.swing.JFrame {

    private TurmaDAO turmaDAO = new TurmaDAO();
    private PessoaDAO pessoaDAO = new PessoaDAO();
    
    public TurmasAlunoView() {
        initComponents();
        
        popularComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbAluno = new javax.swing.JComboBox<>();
        btMostrarTurmas = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        taMostrarAlunos = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Turmas do Aluno");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Aluno:");

        btMostrarTurmas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btMostrarTurmas.setLabel("Mostrar Turmas");
        btMostrarTurmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarTurmas(evt);
            }
        });

        taMostrarAlunos.setColumns(20);
        taMostrarAlunos.setRows(5);
        jScrollPane1.setViewportView(taMostrarAlunos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btMostrarTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                    .addComponent(cbAluno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbAluno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(btMostrarTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mostrarTurmas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarTurmas
        Aluno tempAluno = (Aluno) cbAluno.getSelectedItem();
        
        for(Turma t : turmaDAO.recuperarTodasTurmas()) {
            for(Aluno a : t.getListaAlunos()) {
                if(a.getCpf().equals(tempAluno.getCpf())) {
                    taMostrarAlunos.append(t + "\n");
                }
            }
        }
    }//GEN-LAST:event_mostrarTurmas

    private void popularComboBox() {
        for(Pessoa p : pessoaDAO.recuperarTodasPessoas()) {
            if(p instanceof Aluno a) {
                cbAluno.addItem(a);
            }
        }
    }
    
    public Aluno getAluno() {
        return (Aluno) cbAluno.getSelectedItem();
    }
    
    public void adicionarAcaoBotaoMostrar(ActionListener acao) {
        btMostrarTurmas.addActionListener(acao);
    }
    
    public void exibir() {
        this.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btMostrarTurmas;
    private javax.swing.JComboBox<Aluno> cbAluno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taMostrarAlunos;
    // End of variables declaration//GEN-END:variables
}
