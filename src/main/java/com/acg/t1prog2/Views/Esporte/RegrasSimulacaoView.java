/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acg.t1prog2.Views.Esporte;

import com.acg.t1prog2.DAO.LanceDAO;
import com.acg.t1prog2.Models.Esporte;
import com.acg.t1prog2.Models.Esportes.Basquete;
import com.acg.t1prog2.Models.Esportes.Futebol;
import com.acg.t1prog2.Models.Esportes.Natacao;
import com.acg.t1prog2.Models.Esportes.Volei;
import com.acg.t1prog2.Models.Lance;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class RegrasSimulacaoView extends javax.swing.JFrame {

    private LanceDAO lanceDAO = new LanceDAO();

    public RegrasSimulacaoView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taExibir = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnLimpar = new java.awt.Button();
        jpRegras = new javax.swing.JPanel();
        btRegraBasquete = new java.awt.Button();
        btRegraFut = new java.awt.Button();
        btRegraNatacao = new java.awt.Button();
        btRegraVolei = new java.awt.Button();
        jpSimulacao = new javax.swing.JPanel();
        btSimulaNatacao = new java.awt.Button();
        btSimulaVolei = new java.awt.Button();
        btSimulaBasquete = new java.awt.Button();
        btSimulaFut = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Regras e Simulação");

        taExibir.setColumns(20);
        taExibir.setRows(5);
        jScrollPane1.setViewportView(taExibir);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setText("Regras:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setText("Simulação:");

        btnLimpar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnLimpar.setLabel("Limpar Tela");

        jpRegras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btRegraBasquete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRegraBasquete.setLabel("Basquete");

        btRegraFut.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRegraFut.setLabel("Futebol");

        btRegraNatacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRegraNatacao.setLabel("Natação");

        btRegraVolei.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRegraVolei.setLabel("Vôlei");

        javax.swing.GroupLayout jpRegrasLayout = new javax.swing.GroupLayout(jpRegras);
        jpRegras.setLayout(jpRegrasLayout);
        jpRegrasLayout.setHorizontalGroup(
            jpRegrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegrasLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpRegrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btRegraFut, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRegraBasquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpRegrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btRegraNatacao, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRegraVolei, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jpRegrasLayout.setVerticalGroup(
            jpRegrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegrasLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jpRegrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btRegraFut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRegraVolei, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpRegrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btRegraNatacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRegraBasquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jpSimulacao.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btSimulaNatacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btSimulaNatacao.setLabel("Natação");

        btSimulaVolei.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btSimulaVolei.setLabel("Vôlei");

        btSimulaBasquete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btSimulaBasquete.setLabel("Basquete");

        btSimulaFut.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btSimulaFut.setLabel("Futebol");

        javax.swing.GroupLayout jpSimulacaoLayout = new javax.swing.GroupLayout(jpSimulacao);
        jpSimulacao.setLayout(jpSimulacaoLayout);
        jpSimulacaoLayout.setHorizontalGroup(
            jpSimulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSimulacaoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpSimulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSimulaFut, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSimulaBasquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jpSimulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSimulaNatacao, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSimulaVolei, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jpSimulacaoLayout.setVerticalGroup(
            jpSimulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSimulacaoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpSimulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btSimulaVolei, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSimulaFut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpSimulacaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btSimulaBasquete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSimulaNatacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jpRegras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(215, 215, 215)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(215, 215, 215)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpSimulacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(jScrollPane1))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(20, 20, 20)
                        .addComponent(jpRegras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jpSimulacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)))))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void exibirRegrasBasquete(String msg) {
        taExibir.append(msg);
    }
    
    public void exibirRegrasFut(String msg) {
        taExibir.append(msg);
    }
    
    public void exibirRegrasVolei(String msg) {
        taExibir.append(msg);
    }
    
    public void exibirRegrasNatacao(String msg) {
        taExibir.append(msg);
    }
    
    public void exibirSimulacaoFut(String msg) {
        taExibir.append(msg);
    }
    
    public void exibirSimulacaoBasquete(String msg) {
        taExibir.append(msg);
    }
    
    public void exibirSimulacaoVolei(String msg) {
        taExibir.append(msg);
    }
    
    public void exibirSimulacaoNatacao(String msg) {
        taExibir.append(msg);
    }
    
    public void adicionarAcaoBotaoLimpar(ActionListener acao) {
        btnLimpar.addActionListener(acao);
    } 
    
    public void adicionarAcaoBotaoRegrasFutebol(ActionListener acao) {
        btRegraFut.addActionListener(acao);
    }
    
    public void adicionarAcaoBotaoRegrasBasquete(ActionListener acao) {
        btRegraBasquete.addActionListener(acao);
    }
    
    public void adicionarAcaoBotaoRegrasVolei(ActionListener acao) {
        btRegraVolei.addActionListener(acao);
    }
    
    public void adicionarAcaoBotaoRegrasNatacao(ActionListener acao) {
        btRegraNatacao.addActionListener(acao);
    }
    
    public void adicionarAcaoBotaoSimularFutebol(ActionListener acao) {
        btSimulaFut.addActionListener(acao);
    }
    
    public void adicionarAcaoBotaoSimularBasquete(ActionListener acao) {
        btSimulaBasquete.addActionListener(acao);
    }
    
    public void adicionarAcaoBotaoSimularVolei(ActionListener acao) {
        btSimulaVolei.addActionListener(acao);
    }
    
    public void adicionarAcaoBotaoSimularNatacao(ActionListener acao) {
        btSimulaNatacao.addActionListener(acao);
    }
    
    public void limparTela() {
        taExibir.setText("");
    }
    
    public void exibir() {
        this.setVisible(true);
    }
    
    public void exibirMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btRegraBasquete;
    private java.awt.Button btRegraFut;
    private java.awt.Button btRegraNatacao;
    private java.awt.Button btRegraVolei;
    private java.awt.Button btSimulaBasquete;
    private java.awt.Button btSimulaFut;
    private java.awt.Button btSimulaNatacao;
    private java.awt.Button btSimulaVolei;
    private java.awt.Button btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpRegras;
    private javax.swing.JPanel jpSimulacao;
    private javax.swing.JTextArea taExibir;
    // End of variables declaration//GEN-END:variables
}
