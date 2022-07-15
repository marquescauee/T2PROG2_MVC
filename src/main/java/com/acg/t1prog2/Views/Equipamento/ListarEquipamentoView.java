/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.acg.t1prog2.Views.Equipamento;

import com.acg.t1prog2.DAO.EquipamentoDAO;
import com.acg.t1prog2.Models.Equipamento;
import java.util.Collections;

public class ListarEquipamentoView extends javax.swing.JFrame {

    private EquipamentoDAO equipDAO = new EquipamentoDAO();
    
    public ListarEquipamentoView() {
        initComponents();
        
        this.listarEquipamentos();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taListarEquipamento = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Equipamento");

        taListarEquipamento.setColumns(20);
        taListarEquipamento.setRows(5);
        jScrollPane1.setViewportView(taListarEquipamento);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void listarEquipamentos() {        
        Collections.sort(equipDAO.recuperarTodosEquipamentos());
        
        for(Equipamento equip : equipDAO.recuperarTodosEquipamentos()) {
            this.taListarEquipamento.append(equip + "\n");
        }
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea taListarEquipamento;
    // End of variables declaration//GEN-END:variables
}
