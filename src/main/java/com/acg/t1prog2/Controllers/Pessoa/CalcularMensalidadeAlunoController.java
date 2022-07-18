/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Pessoa;

import com.acg.t1prog2.DAO.AlunoDAO;
import com.acg.t1prog2.Models.Aluno;
import com.acg.t1prog2.Models.Pessoa;
import com.acg.t1prog2.Views.Pessoa.CalcularMensalidadeAlunoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CalcularMensalidadeAlunoController {

    private CalcularMensalidadeAlunoView cmav;

    public CalcularMensalidadeAlunoController(CalcularMensalidadeAlunoView cmav) {
        this.cmav = cmav;
        popularComboBox();
        inicializarAcaoBotao();
        exibirTela();
    }

    private void inicializarAcaoBotao() {
        cmav.adicionarAcaoBotaoCalcular(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Aluno tempAluno = cmav.getAluno();

                double mensalidadeTotal = tempAluno.calcularMensalidade();
                
                cmav.exibirValorTotal("Valor total: " + String.valueOf(mensalidadeTotal) + "\n");             
            }
        });
    }

    private void popularComboBox() {
        List<Aluno> alunos = new ArrayList<>();

        for (Aluno a : AlunoDAO.recuperarTodosAlunos()) {
                alunos.add(a);
        }

        cmav.popularComboBox(alunos);
    }

    public void exibirTela() {
        cmav.exibir();
    }
}
