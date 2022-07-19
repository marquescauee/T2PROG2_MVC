/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Ginasio;

import com.acg.t1prog2.DAO.EquipamentoDAO;
import com.acg.t1prog2.DAO.GinasioDAO;
import com.acg.t1prog2.Models.Equipamento;
import com.acg.t1prog2.Models.Ginasio;
import com.acg.t1prog2.Views.Ginasio.BuscarEquipamentoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class BuscarEquipamentoController {
     private BuscarEquipamentoView bev;

    public BuscarEquipamentoController(BuscarEquipamentoView bev) {
        this.bev = bev;
        popularComboBox();
        inicializarAcaoBotoes();
        exibirTela();
    }

    private void inicializarAcaoBotoes() {
        bev.adicionarAcaoBotaoBuscar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ginasio tempGin = bev.getGinasio();
                String codigo = bev.getCodigo();
                Equipamento equipBuscado = EquipamentoDAO.recuperarEquipamento(codigo);
                
                if (equipBuscado != null) {
                    bev.mostrarResultadoBusca(equipBuscado.toString() + "\n");
                } else {
                    bev.mostrarResultadoBusca("O ginásio não possui o equipamento com o código informado \n");
                }
            }
        });
    }

    private void popularComboBox() {

        List<Ginasio> ginasios = new ArrayList<>();

        for (Ginasio g : GinasioDAO.recuperarTodosGinasios()) {
            ginasios.add(g);
        }

        bev.popularComboBoxGinasio(ginasios);
    }

    public void exibirTela() {
        this.bev.exibir();
    }
}
