/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acg.t1prog2.Views.Ginasio;

import com.acg.t1prog2.DAO.GinasioDAO;
import com.acg.t1prog2.Models.Equipamento;
import com.acg.t1prog2.Models.Esporte;
import com.acg.t1prog2.Models.Ginasio;
import com.acg.t1prog2.Views.App;
import java.util.List;

public class ListarGinasioView extends javax.swing.JFrame {

    private GinasioDAO ginasioDAO = new GinasioDAO();
    
    public ListarGinasioView() {
        initComponents();
        
        this.listarGinasios();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        taGinasios = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Ginásio");

        taGinasios.setColumns(20);
        taGinasios.setRows(5);
        jScrollPane2.setViewportView(taGinasios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void listarGinasios() {
        for(Ginasio ginasio : ginasioDAO.recuperarTodosGinasios()) {
            
            taGinasios.append(ginasio + "\n");
            
            for(Equipamento equip : ginasio.getListaEquipamentos()) {
                taGinasios.append(equip + "\n");
            }
            
            for(Esporte esporte : ginasio.getListaEsportes()) {
                taGinasios.append(esporte + "\n");
            }
            
            taGinasios.append("---------------------------------------\n");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea taGinasios;
    // End of variables declaration//GEN-END:variables
}
