/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Ginasio;

import com.acg.t1prog2.DAO.EquipamentoDAO;
import com.acg.t1prog2.DAO.GinasioDAO;
import com.acg.t1prog2.Models.Equipamento;
import com.acg.t1prog2.Models.Ginasio;
import com.acg.t1prog2.Views.Ginasio.AssociarEquipamentoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AssociarEquipamentoController {
    private AssociarEquipamentoView aev;

    public AssociarEquipamentoController(AssociarEquipamentoView aev) {
        this.aev = aev;
        popularComboBox();
        inicializarAcaoBotoes();
        exibirTela();
    }

    private void inicializarAcaoBotoes() {
        aev.adicionarAcaoBotaoAssociar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipamento tempEquip = aev.getEquipamento();
                Ginasio tempGinasio = aev.getGinasio();

                EquipamentoDAO.associarGinasio(tempEquip, tempGinasio);
                tempGinasio.getListaEquipamentos().add(tempEquip);
                
                aev.exibirMensagem("Associação realizada com sucesso!");
            }
        });
    }

    private void popularComboBox() {

        List<Ginasio> ginasios = new ArrayList<>();
        List<Equipamento> equipamentos = new ArrayList<>();

        for (Ginasio g : GinasioDAO.recuperarTodosGinasios()) {
            ginasios.add(g);
        }

        for (Equipamento equip : EquipamentoDAO.recuperarTodosEquipamentos()) {
            equipamentos.add(equip);
        }

        aev.popularComboBoxGinasio(ginasios);
        aev.popularComboBoxEquipamentos(equipamentos);
    }

    public void exibirTela() {
        this.aev.exibir();
    }
}
