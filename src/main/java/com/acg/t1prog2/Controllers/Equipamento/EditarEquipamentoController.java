/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Equipamento;

import com.acg.t1prog2.DAO.EquipamentoDAO;
import com.acg.t1prog2.Exceptions.CampoVazioException;
import com.acg.t1prog2.Models.Equipamento;
import com.acg.t1prog2.Views.Equipamento.EditarEquipamentoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EditarEquipamentoController {

    private EditarEquipamentoView eev;

    public EditarEquipamentoController(EditarEquipamentoView eev) {
        this.eev = eev;
        popularComboBox();
        inicializarAcaoBotao();
        exibirTela();
    }

    private void inicializarAcaoBotao() {
        eev.adicionarAcaoEditar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipamento tempEquip = eev.getEquipamento();

                String nome = tempEquip.getNome();
                String marca = tempEquip.getMarca();

                if (!eev.getNome().isBlank()) {
                    nome = eev.getNome();
                }

                if (!eev.getMarca().isBlank()) {
                    marca = eev.getMarca();
                }

                try {
                    tempEquip.setNome(nome);
                    tempEquip.setMarca(marca);

                    EquipamentoDAO.atualizarEquipamento(tempEquip);
                    eev.exibirMensagem("Edição realizada com sucesso!");
                    eev.limparComboBox();
                    popularComboBox();
                    eev.limparTela();
                } catch (CampoVazioException ex) {
                    eev.exibirMensagem(ex.getMessage());
                }
            }
        });
    }

    private void popularComboBox() {
        List<Equipamento> equips = new ArrayList<>();

        for (Equipamento equip : EquipamentoDAO.recuperarTodosEquipamentos()) {
            equips.add(equip);
        }

        eev.popularComboBox(equips);
    }

    public void exibirTela() {
        eev.exibir();
    }
}
