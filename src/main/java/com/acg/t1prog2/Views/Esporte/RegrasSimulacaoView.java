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
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparTela(evt);
            }
        });

        jpRegras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btRegraBasquete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRegraBasquete.setLabel("Basquete");
        btRegraBasquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exibirRegrasBasquete(evt);
            }
        });

        btRegraFut.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRegraFut.setLabel("Futebol");
        btRegraFut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exibirRegrasFut(evt);
            }
        });

        btRegraNatacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRegraNatacao.setLabel("Natação");
        btRegraNatacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exibirRegrasNatacao(evt);
            }
        });

        btRegraVolei.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btRegraVolei.setLabel("Vôlei");
        btRegraVolei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exibirRegrasVolei(evt);
            }
        });

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
        btSimulaNatacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simularPartidaNatacao(evt);
            }
        });

        btSimulaVolei.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btSimulaVolei.setLabel("Vôlei");
        btSimulaVolei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simularPartidaVolei(evt);
            }
        });

        btSimulaBasquete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btSimulaBasquete.setLabel("Basquete");
        btSimulaBasquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simularPartidaBasq(evt);
            }
        });

        btSimulaFut.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btSimulaFut.setLabel("Futebol");
        btSimulaFut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simularPartidaFut(evt);
            }
        });

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

    private void exibirRegrasFut(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exibirRegrasFut
        //Opção 1 - metodo estatico que instancia um objeto
        taExibir.append(Futebol.mostrarRegras());

        taExibir.append("----------------------------------------------\n");

    }//GEN-LAST:event_exibirRegrasFut

    private void exibirRegrasBasquete(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exibirRegrasBasquete
        taExibir.append(Basquete.mostrarRegras());

        taExibir.append("----------------------------------------------\n");

    }//GEN-LAST:event_exibirRegrasBasquete

    private void exibirRegrasVolei(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exibirRegrasVolei
        taExibir.append(Volei.mostrarRegras());

        taExibir.append("----------------------------------------------\n");

    }//GEN-LAST:event_exibirRegrasVolei

    private void exibirRegrasNatacao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exibirRegrasNatacao
        taExibir.append(Natacao.mostrarRegras());

        taExibir.append("----------------------------------------------\n");

    }//GEN-LAST:event_exibirRegrasNatacao

    private void simularPartidaFut(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simularPartidaFut
        Esporte e = new Futebol(22);
        e.gerarSimulacao();

        for (int i = 0; i < 100; i++) {
            int numeroAleatorio = (int) (Math.random() * lanceDAO.recuperarTodosLances().size());
            Lance lanceFut = lanceDAO.recuperarLance(numeroAleatorio);

            if (lanceFut.getEsporte() instanceof Futebol) {
                taExibir.append(lanceFut.getLance());
                taExibir.append("\n----------------------------------------------\n");
                break;
            }
        }
    }//GEN-LAST:event_simularPartidaFut

    private void simularPartidaBasq(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simularPartidaBasq
        Esporte e = new Basquete(22);
        e.gerarSimulacao();

        for (int i = 0; i < 100; i++) {
            int numeroAleatorio = (int) (Math.random() * lanceDAO.recuperarTodosLances().size());
            Lance lanceFut = lanceDAO.recuperarLance(numeroAleatorio);

            if (lanceFut.getEsporte() instanceof Basquete) {
                taExibir.append(lanceFut.getLance());
                taExibir.append("\n----------------------------------------------\n");
                break;
            }
        }
    }//GEN-LAST:event_simularPartidaBasq

    private void simularPartidaVolei(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simularPartidaVolei
        Esporte e = new Volei(22);
        e.gerarSimulacao();

        for (int i = 0; i < 100; i++) {
            int numeroAleatorio = (int) (Math.random() * lanceDAO.recuperarTodosLances().size());
            Lance lanceFut = lanceDAO.recuperarLance(numeroAleatorio);

            if (lanceFut.getEsporte() instanceof Volei) {
                taExibir.append(lanceFut.getLance());
                taExibir.append("\n----------------------------------------------\n");
                break;
            }
        }
    }//GEN-LAST:event_simularPartidaVolei

    private void simularPartidaNatacao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simularPartidaNatacao
        Esporte e = new Natacao(22);
        e.gerarSimulacao();

        for (int i = 0; i < 100; i++) {
            int numeroAleatorio = (int) (Math.random() * lanceDAO.recuperarTodosLances().size());
            Lance lanceFut = lanceDAO.recuperarLance(numeroAleatorio);

            if (lanceFut.getEsporte() instanceof Natacao) {
                taExibir.append(lanceFut.getLance());
                taExibir.append("\n----------------------------------------------\n");
                break;
            }
        }    

    }//GEN-LAST:event_simularPartidaNatacao

    private void limparTela(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparTela
        taExibir.setText("");
    }//GEN-LAST:event_limparTela

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
