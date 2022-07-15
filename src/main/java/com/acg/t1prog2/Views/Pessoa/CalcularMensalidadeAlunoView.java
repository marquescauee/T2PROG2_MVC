/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acg.t1prog2.Views.Pessoa;

import com.acg.t1prog2.DAO.PessoaDAO;
import com.acg.t1prog2.Models.Aluno;
import com.acg.t1prog2.Models.Mensalidade;
import com.acg.t1prog2.Models.Pessoa;
import com.acg.t1prog2.Views.App;

public class CalcularMensalidadeAlunoView extends javax.swing.JFrame {

    private PessoaDAO pessoaDAO = new PessoaDAO();
    
    public CalcularMensalidadeAlunoView() {
        initComponents();
        
        popularComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbAluno = new javax.swing.JComboBox<>();
        btCalcular = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        taMensalidades = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Calcular Mensalidade Aluno");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Aluno:");

        btCalcular.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btCalcular.setLabel("Calcular Mensalidade total");
        btCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularMensalidade(evt);
            }
        });

        taMensalidades.setColumns(20);
        taMensalidades.setRows(5);
        jScrollPane1.setViewportView(taMensalidades);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(158, 158, 158))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                    .addComponent(cbAluno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(btCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void calcularMensalidade(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularMensalidade
        Aluno tempAluno = (Aluno) cbAluno.getSelectedItem();
        
        double mensalidadeTotal = tempAluno.calcularMensalidade();
        
        taMensalidades.append("Valor total: " + String.valueOf(mensalidadeTotal) + "\n");
    }//GEN-LAST:event_calcularMensalidade
 
    private void popularComboBox() {
        for(Pessoa p : pessoaDAO.recuperarTodasPessoas()) {
            if(p instanceof Aluno a) {
                cbAluno.addItem(a);
            }
        }
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btCalcular;
    private javax.swing.JComboBox<Aluno> cbAluno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taMensalidades;
    // End of variables declaration//GEN-END:variables
}
