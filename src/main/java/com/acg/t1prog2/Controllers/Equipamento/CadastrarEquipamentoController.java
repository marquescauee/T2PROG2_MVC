/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Equipamento;

import com.acg.t1prog2.DAO.EquipamentoDAO;
import com.acg.t1prog2.Exceptions.CampoVazioException;
import com.acg.t1prog2.Models.Equipamento;
import com.acg.t1prog2.Views.Equipamento.CadastrarEquipamentoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarEquipamentoController {

    private Equipamento equipamento;
    private CadastrarEquipamentoView cec;

    public CadastrarEquipamentoController(CadastrarEquipamentoView cec) {
        this.cec = cec;
        inicializarAcaoBotao();
        exibirTela();
    }

    private void inicializarAcaoBotao() {
        cec.adicionarAcaoBotaoCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = cec.getNome();
                String codigo = cec.getCodigo();
                String marca = cec.getMarca();

                try {
                    equipamento = new Equipamento();
                    
                    equipamento.setNome(nome);
                    equipamento.setMarca(marca);
                    equipamento.setCodigo(codigo);
                    addEquipamento(equipamento);
                    cec.exibirMensagem("Equipamento cadastrado com sucesso!");
                    cec.limparTela();
                } catch (CampoVazioException ex) {
                    cec.exibirMensagem(ex.getMessage());
                }
            }
        });
    }

    private void addEquipamento(Equipamento e) {
        EquipamentoDAO equipDAO = new EquipamentoDAO();
        
        equipDAO.salvarEquipamento(e);
    }
    
    public void exibirTela() {
        cec.exibir();
    }
}
