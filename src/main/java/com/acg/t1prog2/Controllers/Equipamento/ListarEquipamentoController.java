/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Equipamento;

import com.acg.t1prog2.DAO.EquipamentoDAO;
import com.acg.t1prog2.Models.Equipamento;
import com.acg.t1prog2.Models.Tabela.EquipamentoTableModel;
import com.acg.t1prog2.Views.Equipamento.ListarEquipamentoView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListarEquipamentoController {
    private ListarEquipamentoView lev;
    private EquipamentoTableModel etm;
    
    public ListarEquipamentoController(ListarEquipamentoView lev, EquipamentoTableModel etm) {
        this.lev = lev;
        this.etm = etm;
        setTableModel();
        inicializarTelaListarDados();
    }
    
    private void setTableModel(){
        lev.setTableModel(this.etm);
    }
    
    public void exibir(){
        lev.exibirTela();
    }
    
    public void atualizarDados(){
        etm.fireTableDataChanged();
    }
    
    private void inicializarTelaListarDados() {
        List<Equipamento> equipamentos = EquipamentoDAO.recuperarTodosEquipamentos();
       
        
        etm = new EquipamentoTableModel(EquipamentoDAO.recuperarTodosEquipamentos());
    }
}
