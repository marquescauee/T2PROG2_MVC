/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acg.t1prog2.Views.Ginasio;

import com.acg.t1prog2.DAO.GinasioDAO;
import com.acg.t1prog2.DAO.ReservaDAO;
import com.acg.t1prog2.DAO.TurmaDAO;
import com.acg.t1prog2.Exceptions.ReservaException;
import com.acg.t1prog2.Models.Ginasio;
import com.acg.t1prog2.Models.Reserva;
import com.acg.t1prog2.Models.Turma;
import com.acg.t1prog2.Views.App;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

public class ReservarGinasioView extends javax.swing.JFrame {

    private GinasioDAO ginasioDAO = new GinasioDAO();
    private TurmaDAO turmaDAO = new TurmaDAO();
    private ReservaDAO reservaDAO = new ReservaDAO();
    
    public ReservarGinasioView() {
        initComponents();
        popularComboBox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfData = new javax.swing.JTextField();
        tfHora = new javax.swing.JTextField();
        cbGinasio = new javax.swing.JComboBox<>();
        cbTurma = new javax.swing.JComboBox<>();
        btReservar = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reservar Ginásio");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Hora:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Ginásio:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Data:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Turma:");

        btReservar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btReservar.setLabel("Reservar ginásio");
        btReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservarGinasio(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel1))
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfData)
                    .addComponent(tfHora)
                    .addComponent(cbGinasio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbTurma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(368, Short.MAX_VALUE)
                .addComponent(btReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(350, 350, 350))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tfData, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbGinasio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btReservar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void reservarGinasio(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservarGinasio
         try {
            Reserva reserva = recuperarReserva();
            reservaDAO.salvarReserva(reserva);
            JOptionPane.showMessageDialog(null, "Ginásio reservado com sucesso: " + reserva.toString());
            limparTela();
            popularComboBox();
        } catch (ReservaException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_reservarGinasio

    public Reserva recuperarReserva() throws ReservaException {
        LocalDateTime dataHoraRserva = getDataHora();
        Ginasio ginasio = (Ginasio) cbGinasio.getSelectedItem();
        Turma turma = (Turma) cbTurma.getSelectedItem();
        Reserva reserva = Reserva.reservarGinasio(dataHoraRserva, ginasio, turma);

        if (ginasio == null) {
            throw new ReservaException("Nenhum ginásio selecionado");
        }
        
        if (turma == null) {
            throw new ReservaException("Nenhuma turma selecionada");
        }

        return reserva;
    }
    
    public LocalDateTime getDataHora() throws ReservaException {
        String data = tfData.getText();
        String hora = tfHora.getText();
        String dataHora = data + ' ' + hora;

        try {
            DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime dataHoraRserva = LocalDateTime.parse(dataHora, formatoData);
            return dataHoraRserva;
        } catch (DateTimeParseException e) {
            throw new ReservaException("Data ou hora inválida");
        }
    }
    
    private void popularComboBox() {
        for (Ginasio ginasio : ginasioDAO.recuperarTodosGinasios()) {
            cbGinasio.addItem(ginasio);
        }
        
        for(Turma t : turmaDAO.recuperarTodasTurmas()) {
            cbTurma.addItem(t);
        }
    }
    
    public void adicionarAcaoBotaoReservar(ActionListener acao) {
        this.btReservar.addActionListener(acao);
    }
    
    public void exibir() {
        this.setVisible(true);
    }
    
    public void exibirMensagem(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    
    public void limparTela() {
        tfData.setText("");
        tfHora.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btReservar;
    private javax.swing.JComboBox<Ginasio> cbGinasio;
    private javax.swing.JComboBox<Turma> cbTurma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tfData;
    private javax.swing.JTextField tfHora;
    // End of variables declaration//GEN-END:variables
}
