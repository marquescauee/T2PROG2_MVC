/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Pessoa;

import com.acg.t1prog2.DAO.PessoaDAO;
import com.acg.t1prog2.Exceptions.CampoVazioException;
import com.acg.t1prog2.Exceptions.IdadeException;
import com.acg.t1prog2.Exceptions.IdentificadorUnicoException;
import com.acg.t1prog2.Models.Aluno;
import com.acg.t1prog2.Models.Pessoa;
import com.acg.t1prog2.Models.Professor;
import com.acg.t1prog2.Views.Pessoa.CadastrarPessoaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarPessoaController {

    private Pessoa pessoa;
    private CadastrarPessoaView cpv;

    public CadastrarPessoaController(CadastrarPessoaView cpv) {
        this.cpv = cpv;
        inicializarAcaoBotao();
        exibirTela();
    }

    private void inicializarAcaoBotao() {
        cpv.adicionarAcaoBotaoCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = cpv.getNome();
                String cpf = cpv.getCPF();

                if (!cpv.getRbAluno() && !cpv.getRbProfessor()) {
                    cpv.exibirMensagem("Por favor, selecione professor ou aluno.");
                    return;
                }

                try {
                    if (cpv.getRbAluno()) {
                        pessoa = new Aluno();
                    } else if (cpv.getRbProfessor()) {
                        pessoa = new Professor();
                    } else {
                        pessoa = null;
                    }
                    
                    int idade = cpv.getIdade();
                    pessoa.setNome(nome);
                    pessoa.setCpf(cpf);
                    pessoa.setIdade(idade);

                    adicionarPessoa(pessoa);
                    cpv.exibirMensagem("Pessoa cadastrada com sucesso!");
                    cpv.limparTela();

                } catch (CampoVazioException ex) {
                    cpv.exibirMensagem("Campo em branco.");
                } catch (IdentificadorUnicoException ex) {
                    cpv.exibirMensagem("Já existe uma pessoa com esse cpf");
                } catch (IdadeException ex) {
                    cpv.exibirMensagem(ex.getMessage());
                } catch (NumberFormatException ex) {
                    cpv.exibirMensagem("CPF Inválido");
                }
            }
        });
    }

    private void adicionarPessoa(Pessoa p) {
        PessoaDAO pessoaDAO = new PessoaDAO();

        pessoaDAO.salvarPessoa(p);
    }

    public void exibirTela() {
        cpv.exibir();
    }
}
