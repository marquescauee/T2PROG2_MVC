/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acg.t1prog2.Views.Ginasio;

import com.acg.t1prog2.DAO.GinasioDAO;
import com.acg.t1prog2.Exceptions.CampoVazioException;
import com.acg.t1prog2.Models.Ginasio;
import com.acg.t1prog2.Views.App;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class EditarGinasioView extends javax.swing.JFrame {

    private GinasioDAO ginasioDAO = new GinasioDAO();

    public EditarGinasioView() {
        initComponents();

        this.popularComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfEnderecoGinasio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfTamanhoGinasio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfAnoCriacaoGinasio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfNomeGinasio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btEditarGinasio = new java.awt.Button();
        jLabel5 = new javax.swing.JLabel();
        cbGinasio = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar Ginásio");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Endereço:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tamanho:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Ano de criação:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Nome:");

        btEditarGinasio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btEditarGinasio.setLabel("Editar Ginásio");
        btEditarGinasio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarGinasio(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Ginásio:");

        cbGinasio.setMinimumSize(new java.awt.Dimension(72, 25));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNomeGinasio, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfAnoCriacaoGinasio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(tfTamanhoGinasio, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfEnderecoGinasio, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbGinasio, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btEditarGinasio, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(cbGinasio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(tfNomeGinasio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(tfAnoCriacaoGinasio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(tfTamanhoGinasio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(tfEnderecoGinasio, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btEditarGinasio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void editarGinasio(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarGinasio
        Ginasio tempGinasio = (Ginasio) this.cbGinasio.getSelectedItem();

        String nome = tempGinasio.getNome();
        int anoCriacao = tempGinasio.getAnoCriacao();
        double tamanho = tempGinasio.getTamanho();
        String endereco = tempGinasio.getEndereco();

        if (!this.tfNomeGinasio.getText().isBlank()) {
            nome = tfNomeGinasio.getText();
        }

        if (!this.tfAnoCriacaoGinasio.getText().isBlank()) {
            anoCriacao = Integer.parseInt(tfAnoCriacaoGinasio.getText());
        }

        if (!this.tfTamanhoGinasio.getText().isBlank()) {
            tamanho = Double.parseDouble(tfTamanhoGinasio.getText());
        }

        if (!this.tfEnderecoGinasio.getText().isBlank()) {
            endereco = tfEnderecoGinasio.getText();
        }

        try {
            tempGinasio.setNome(nome);
            tempGinasio.setAnoCriacao(anoCriacao);
            tempGinasio.setEndereco(endereco);
            tempGinasio.setTamanho(tamanho);

            JOptionPane.showMessageDialog(null, "Edição realizada com sucesso!");

            this.cbGinasio.removeAllItems();
            this.popularComboBox();
            this.limparTela();

        } catch (CampoVazioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_editarGinasio

    private void popularComboBox() {
        for (Ginasio ginasio : ginasioDAO.recuperarTodosGinasios()) {
            cbGinasio.addItem(ginasio);
        }
    }
    
    public void adicionarAcaoEditarGinasio(ActionListener acao) {
        this.btEditarGinasio.addActionListener(acao);
    }
    
    public Ginasio getGinasio() {
        return (Ginasio) cbGinasio.getSelectedItem();
    }
    
    public String getNome() {
        return tfNomeGinasio.getText();
    }
    
    public int getAnoCriacao() {
        return Integer.parseInt(tfAnoCriacaoGinasio.getText());
    }
    
    public double getArea() {
        return Double.parseDouble(tfTamanhoGinasio.getText());
    }
    
    public String getEndereco() {
        return tfEnderecoGinasio.getText();
    }

    private void limparTela() {
        tfNomeGinasio.setText("");
        tfAnoCriacaoGinasio.setText("");
        tfTamanhoGinasio.setText("");
        tfEnderecoGinasio.setText("");
    }
    
     public void exibir() {
        this.setVisible(true);
    }
    
    public void exibirMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btEditarGinasio;
    private javax.swing.JComboBox<Ginasio> cbGinasio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tfAnoCriacaoGinasio;
    private javax.swing.JTextField tfEnderecoGinasio;
    private javax.swing.JTextField tfNomeGinasio;
    private javax.swing.JTextField tfTamanhoGinasio;
    // End of variables declaration//GEN-END:variables
}
