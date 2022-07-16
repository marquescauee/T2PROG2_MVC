/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Equipamento;

import com.acg.t1prog2.DAO.EquipamentoDAO;
import com.acg.t1prog2.Models.Equipamento;
import com.acg.t1prog2.Views.Equipamento.RemoverEquipamentoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RemoverEquipamentoController {

    private RemoverEquipamentoView rev;

    public RemoverEquipamentoController(RemoverEquipamentoView rev) {
        this.rev = rev;
        popularComboBox();
        inicializarAcaoBotao();
        exibirTela();
    }

    private void inicializarAcaoBotao() {
        rev.adicionarAcaoRemover(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Equipamento tempEquip = rev.getEquipamento();

                removerEquipamento(tempEquip);
                rev.exibirMensagem("Equipamento removido com sucesso!");

                rev.limparComboBox();
                popularComboBox();
            }
        });
    }
    
    private void removerEquipamento(Equipamento equipamento) {
        EquipamentoDAO equipDAO = new EquipamentoDAO();
        
        equipDAO.removerEquipamento(equipamento);
    }

    private void popularComboBox() {
        EquipamentoDAO equipDAO = new EquipamentoDAO();

        List<Equipamento> equipamentos = new ArrayList<>();

        rev.popularComboBox(equipamentos);
    }

    public void exibirTela() {
        rev.exibir();
    }
}
