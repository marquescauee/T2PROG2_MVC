/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acg.t1prog2.Views.Pessoa;

import com.acg.t1prog2.DAO.PessoaDAO;
import com.acg.t1prog2.DAO.TurmaDAO;
import com.acg.t1prog2.Models.Pessoa;
import com.acg.t1prog2.Models.Professor;
import com.acg.t1prog2.Models.Turma;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CalcularSalarioProfessorView extends javax.swing.JFrame {

    private TurmaDAO turmaDAO = new TurmaDAO();
    private PessoaDAO pessoaDAO = new PessoaDAO();
    
    public CalcularSalarioProfessorView() {
        initComponents();
        
        popularComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbProfessor = new javax.swing.JComboBox<>();
        btCalcular = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        taSalario = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Calcular Mensalidade Professor");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Professor:");

        btCalcular.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btCalcular.setLabel("Calcular Salário");
        btCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularSalario(evt);
            }
        });

        taSalario.setColumns(20);
        taSalario.setRows(5);
        jScrollPane1.setViewportView(taSalario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                    .addComponent(cbProfessor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(21, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void calcularSalario(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularSalario
        Professor tempProf = (Professor) cbProfessor.getSelectedItem();
        
        double aulasMes = 8;
        int cont = 0;
        
        for(Turma t : turmaDAO.recuperarTodasTurmas()) {
            if(t.getProfessor().getCpf().equals(tempProf.getCpf())) {
                cont++;
            }
        }
        
        double salario = (tempProf.getHoraAula() * aulasMes) * cont;
        
        taSalario.append("Salário: " + String.valueOf(salario));
    }//GEN-LAST:event_calcularSalario

    private void popularComboBox() {
        for(Pessoa p : pessoaDAO.recuperarTodasPessoas()) {
            if(p instanceof Professor prof) {
                cbProfessor.addItem(prof);
            }
        }
    }

    public Professor getProfessor() {
        return (Professor) cbProfessor.getSelectedItem();
    }
    
    public void adicionarAcaoBotaoCalcular(ActionListener acao) {
        btCalcular.addActionListener(acao);
    }
    
    public void exibir() {
        this.setVisible(true);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btCalcular;
    private javax.swing.JComboBox<Professor> cbProfessor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taSalario;
    // End of variables declaration//GEN-END:variables
}
