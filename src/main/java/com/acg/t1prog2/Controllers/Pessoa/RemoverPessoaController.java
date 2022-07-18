/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Pessoa;

import com.acg.t1prog2.DAO.AlunoDAO;
import com.acg.t1prog2.DAO.ProfessorDAO;
import com.acg.t1prog2.Models.Aluno;
import com.acg.t1prog2.Models.Pessoa;
import com.acg.t1prog2.Models.Professor;
import com.acg.t1prog2.Views.Pessoa.RemoverPessoaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RemoverPessoaController {

    private RemoverPessoaView rpv;

    public RemoverPessoaController(RemoverPessoaView rpv) {
        this.rpv = rpv;
        popularComboBox();
        inicializarAcaoBotao();
        exibirTela();
    }

    private void inicializarAcaoBotao() {
        rpv.adicionarAcaoBotaoRemover(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Pessoa tempPessoa = rpv.getPessoa();

                if(tempPessoa instanceof Aluno) {
                    AlunoDAO.removerAluno((Aluno) tempPessoa);
                } else if(tempPessoa instanceof Professor) {
                    ProfessorDAO.removerProfessor((Professor) tempPessoa);
                }

                rpv.exibirMensagem("Pessoa removida com sucesso!");

                rpv.limparComboBox();
                popularComboBox();
            }
        });
    }

    private void popularComboBox() {
        List<Pessoa> pessoas = new ArrayList<>();

        for (Aluno a : AlunoDAO.recuperarTodosAlunos()) {
            pessoas.add(a);
        }
        
        for(Professor prof : ProfessorDAO.recuperarTodosProfessores()) {
            pessoas.add(prof);
        }

        rpv.popularComboBox(pessoas);
    }

    public void exibirTela() {
        rpv.exibir();
    }
}
