/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acg.t1prog2.Views.Pessoa;

import com.acg.t1prog2.DAO.PessoaDAO;
import com.acg.t1prog2.Exceptions.CampoVazioException;
import com.acg.t1prog2.Exceptions.IdadeException;
import com.acg.t1prog2.Exceptions.IdentificadorUnicoException;
import com.acg.t1prog2.Models.Aluno;
import com.acg.t1prog2.Models.Pessoa;
import com.acg.t1prog2.Models.Professor;
import com.acg.t1prog2.Views.App;
import javax.swing.JOptionPane;

public class CadastrarPessoaView extends javax.swing.JFrame {

    private PessoaDAO pessoaDAO = new PessoaDAO();

    public CadastrarPessoaView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfNomePessoa = new javax.swing.JTextField();
        tfIdadePessoa = new javax.swing.JTextField();
        tfCpfPessoa = new javax.swing.JTextField();
        btCadastrarAluno = new java.awt.Button();
        rbAluno = new javax.swing.JRadioButton();
        rbProfessor = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Pessoa");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("CPF:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Idade:");

        btCadastrarAluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btCadastrarAluno.setLabel("Cadastrar Pessoa");
        btCadastrarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarPessoa(evt);
            }
        });

        buttonGroup1.add(rbAluno);
        rbAluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbAluno.setText("Aluno");

        buttonGroup1.add(rbProfessor);
        rbProfessor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbProfessor.setText("Professor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(tfIdadePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfCpfPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(tfNomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(rbAluno)
                        .addGap(92, 92, 92)
                        .addComponent(rbProfessor)
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btCadastrarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(tfNomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfCpfPessoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfIdadePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAluno)
                    .addComponent(rbProfessor))
                .addGap(20, 20, 20)
                .addComponent(btCadastrarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarPessoa(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarPessoa

        String nome = tfNomePessoa.getText();
        String cpf = tfCpfPessoa.getText();

        Pessoa p;

        if (!rbAluno.isSelected() && !rbProfessor.isSelected()) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione professor ou aluno.");
            return;
        }

        if (rbAluno.isSelected()) {
            p = new Aluno();
        } else if (rbProfessor.isSelected()) {
            p = new Professor();
        } else {
            p = null;
        }

        try {
            int idade = Integer.parseInt(tfIdadePessoa.getText());
            p.setNome(nome);
            p.setCpf(cpf);
            p.setIdade(idade);

            this.adicionarPessoa(p);
            JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!");
            this.limparTela();

        } catch (CampoVazioException e) {
            JOptionPane.showMessageDialog(null, "Campo em branco.");
        } catch (IdentificadorUnicoException e) {
            JOptionPane.showMessageDialog(null, "Já existe uma pessoa com esse cpf");
        } catch (IdadeException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "CPF Inválido");
        }
    }//GEN-LAST:event_cadastrarPessoa

    private void adicionarPessoa(Pessoa p) {
        pessoaDAO.salvarPessoa(p);
    }

    private void limparTela() {
        tfNomePessoa.setText("");
        tfCpfPessoa.setText("");
        tfIdadePessoa.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btCadastrarAluno;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton rbAluno;
    private javax.swing.JRadioButton rbProfessor;
    private javax.swing.JTextField tfCpfPessoa;
    private javax.swing.JTextField tfIdadePessoa;
    private javax.swing.JTextField tfNomePessoa;
    // End of variables declaration//GEN-END:variables
}
