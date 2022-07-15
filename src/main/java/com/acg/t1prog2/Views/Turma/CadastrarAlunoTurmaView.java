/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acg.t1prog2.Views.Turma;

import com.acg.t1prog2.DAO.PessoaDAO;
import com.acg.t1prog2.DAO.TurmaDAO;
import com.acg.t1prog2.Exceptions.CadastroTurmaException;
import com.acg.t1prog2.Models.Aluno;
import com.acg.t1prog2.Models.Esporte;
import com.acg.t1prog2.Models.Mensalidade;
import com.acg.t1prog2.Models.Pessoa;
import com.acg.t1prog2.Models.Turma;
import com.acg.t1prog2.Views.App;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CadastrarAlunoTurmaView extends javax.swing.JFrame {

    private TurmaDAO turmaDAO = new TurmaDAO();
    private PessoaDAO pessoaDAO = new PessoaDAO();

    public CadastrarAlunoTurmaView() {
        initComponents();
        this.popularComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbAluno = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbTurma = new javax.swing.JComboBox<>();
        btCadastrarAluno = new java.awt.Button();
        cbMensalidade = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Aluno");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Aluno:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Turma:");

        btCadastrarAluno.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btCadastrarAluno.setLabel("Cadastrar Aluno");
        btCadastrarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarAluno(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tipo de Mensalidade:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(105, 105, 105)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbAluno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbTurma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbMensalidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(378, Short.MAX_VALUE)
                .addComponent(btCadastrarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(217, 217, 217))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(cbAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbMensalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(20, 20, 20)
                .addComponent(btCadastrarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarAluno(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarAluno
        try {
            Turma tempTurma = (Turma) cbTurma.getSelectedItem();
            Aluno tempAluno = (Aluno) cbAluno.getSelectedItem();
            Mensalidade tempMens = (Mensalidade) cbMensalidade.getSelectedItem();
            Esporte tempEsporteTurma = tempTurma.getEsporte();

            int qtdAlunosTurma = tempTurma.getListaAlunos().size();

            verificarMensalidade(tempMens);
            verificaQtdJogadoresTurma(qtdAlunosTurma, tempEsporteTurma);
            naoExisteAlunoNaTurma(tempTurma, tempAluno);

            salvarAlunoNaTurma(tempTurma, tempAluno);
            tempAluno.getListaMensalidades().add(tempMens);
            JOptionPane.showMessageDialog(null, "Aluno cadastrado na turma com sucesso!");

        } catch (CadastroTurmaException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Algo não foi selecionado. Tente novamente.");
        }
    }//GEN-LAST:event_cadastrarAluno

    private boolean verificarMensalidade(Mensalidade mensalidade) throws CadastroTurmaException {
        Turma tempTurma = (Turma) cbTurma.getSelectedItem();

        if (tempTurma.getEsporte().getListaMensalidades().contains(mensalidade)) {
            return tempTurma.getEsporte().getListaMensalidades().contains(mensalidade);
        } else {
            throw new CadastroTurmaException("A mensalidade selecionada não está presente para a turma selecionada.");
        }
    }

    private boolean verificaQtdJogadoresTurma(int qtdAlunosTurma, Esporte esporte) throws CadastroTurmaException {
        if (qtdAlunosTurma < esporte.getQtdJogadores()) {
            return true;
        } else {
            throw new CadastroTurmaException("A turma já está cheia. Entre em contato para mais informações.");
        }
    }

    private boolean naoExisteAlunoNaTurma(Turma turma, Aluno aluno) throws CadastroTurmaException {
        for(Turma t : turmaDAO.recuperarTodasTurmas()) {
            if(t.getEsporte().equals(turma.getEsporte()) && t.getProfessor().equals(turma.getProfessor())) {
                if(!t.getListaAlunos().contains(aluno)) {
                    return true;
                }
            }
        }
        throw new CadastroTurmaException("O aluno já está cadastrado nessa turma.");
    }
    
    private void salvarAlunoNaTurma(Turma t, Aluno a) {
        t.addAluno(a);
    }

    private void popularComboBox() {
        for (Pessoa p : pessoaDAO.recuperarTodasPessoas()) {
            if (p instanceof Aluno a) {
                cbAluno.addItem(a);
            }
        }

        for (Turma t : turmaDAO.recuperarTodasTurmas()) {
            cbTurma.addItem(t);
        }

        for (Turma t : turmaDAO.recuperarTodasTurmas()) {
            Esporte esporte = t.getEsporte();

            for (Mensalidade m : esporte.getListaMensalidades()) {
                cbMensalidade.addItem(m);
            }

            cbMensalidade.addItem(null);
        }

    }

    public Aluno getAluno() {
        return (Aluno) cbAluno.getSelectedItem();
    }
    
    public Turma getTurma() {
        return (Turma) cbTurma.getSelectedItem();
    }
    
    public Mensalidade getMensalidade() {
        return (Mensalidade) cbMensalidade.getSelectedItem();
    }
    
    public void adicionarAcaoBotaoCadastrar(ActionListener acao) {
        btCadastrarAluno.addActionListener(acao);
    }
    
    public void exibir() {
        this.setVisible(true);
    }
    
    public void exibirMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btCadastrarAluno;
    private javax.swing.JComboBox<Aluno> cbAluno;
    private javax.swing.JComboBox<Mensalidade> cbMensalidade;
    private javax.swing.JComboBox<Turma> cbTurma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
