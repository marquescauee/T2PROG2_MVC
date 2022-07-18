/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Pessoa;

import com.acg.t1prog2.DAO.AlunoDAO;
import com.acg.t1prog2.DAO.ProfessorDAO;
import com.acg.t1prog2.Exceptions.CampoVazioException;
import com.acg.t1prog2.Exceptions.IdadeException;
import com.acg.t1prog2.Models.Aluno;
import com.acg.t1prog2.Models.Pessoa;
import com.acg.t1prog2.Models.Professor;
import com.acg.t1prog2.Views.Pessoa.EditarPessoaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EditarPessoaController {

    private EditarPessoaView epv;

    public EditarPessoaController(EditarPessoaView epv) {
        this.epv = epv;
        popularComboBox();
        inicializarAcaoBotao();
        exibirTela();
    }

    private void inicializarAcaoBotao() {
        epv.adicionarAcaoBotaoEditar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pessoa tempPessoa = epv.getPessoa();

                String nome = tempPessoa.getNome();
                int idade = tempPessoa.getIdade();

                if (!epv.getNome().isBlank()) {
                    nome = epv.getNome();
                }

                if (!String.valueOf(epv.getIdade()).isBlank()) {
                    idade = epv.getIdade();
                }

                try {
                    tempPessoa.setNome(nome);
                    tempPessoa.setIdade(idade);
                    
                    if(tempPessoa instanceof Aluno) {
                        AlunoDAO.atualizarAluno((Aluno) tempPessoa);
                    } else {
                        ProfessorDAO.atualizarProfessor((Professor) tempPessoa);
                    }
                    
                    epv.exibirMensagem("Edição realizada com sucesso!");

                    epv.limparComboBox();
                    popularComboBox();
                    epv.limparTela();
                } catch (CampoVazioException ex) {
                    epv.exibirMensagem(ex.getMessage());
                } catch (IdadeException ex) {
                    epv.exibirMensagem(ex.getMessage());
                }
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

        epv.popularComboBox(pessoas);
    }

    public void exibirTela() {
        epv.exibir();
    }
}
