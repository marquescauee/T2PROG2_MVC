/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Pessoa;

import com.acg.t1prog2.DAO.PessoaDAO;
import com.acg.t1prog2.DAO.TurmaDAO;
import com.acg.t1prog2.Models.Aluno;
import com.acg.t1prog2.Models.Pessoa;
import com.acg.t1prog2.Models.Turma;
import com.acg.t1prog2.Views.Pessoa.TurmasAlunoView;
import java.util.ArrayList;
import java.util.List;

public class TurmasAlunoController {
    
    private TurmasAlunoView tav;
    
    public TurmasAlunoController(TurmasAlunoView tav) {
        this.tav = tav;
        popularComboBox();
        inicializarAcaoBotao();
        exibirTela();
    }
    
    private void inicializarAcaoBotao() {
        TurmaDAO turmaDAO = new TurmaDAO();
        
        Aluno tempAluno = tav.getAluno();
        
        for(Turma t : turmaDAO.recuperarTodasTurmas()) {
            for(Aluno a : t.getListaAlunos()) {
                if(a.getCpf().equals(tempAluno.getCpf())) {
                    tav.mostrarAlunos(t + "\n");
                }
            }
        }
    }
    
    private void popularComboBox() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        List<Aluno> alunos = new ArrayList<>();
        
        for(Pessoa p : pessoaDAO.recuperarTodasPessoas()) {
            if(p instanceof Aluno a) {
                alunos.add(a);
            }
        }
        
        tav.popularComboBox(alunos);
    }
 
    public void exibirTela() {
        tav.exibir();
    }
}
