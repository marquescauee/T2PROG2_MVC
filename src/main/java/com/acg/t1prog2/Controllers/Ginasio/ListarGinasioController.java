/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Ginasio;

import com.acg.t1prog2.DAO.GinasioDAO;
import com.acg.t1prog2.Models.Tabela.GinasioTableModel;
import com.acg.t1prog2.Views.Ginasio.ListarGinasioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListarGinasioController {
    private ListarGinasioView lgv;
    private GinasioTableModel gtm;
    
    public ListarGinasioController(ListarGinasioView lgv, GinasioTableModel gtm) {
        this.lgv = lgv;
        this.gtm = gtm;
        setTableModel();
        inicializarTelaListarDados();
    }
    
    private void setTableModel(){
        lgv.setTableModel(this.gtm);
    }
    
    public void exibir(){
        lgv.exibirTela();
    }
    
    public void atualizarDados(){
        gtm.fireTableDataChanged();
    }
    
    private void inicializarTelaListarDados() {
        gtm = new GinasioTableModel(GinasioDAO.recuperarTodosGinasios());
    }
}
