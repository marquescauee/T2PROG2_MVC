/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Turma;

import com.acg.t1prog2.DAO.EsporteDAO;
import com.acg.t1prog2.DAO.PessoaDAO;
import com.acg.t1prog2.DAO.TurmaDAO;
import com.acg.t1prog2.Models.Esporte;
import com.acg.t1prog2.Models.Pessoa;
import com.acg.t1prog2.Models.Professor;
import com.acg.t1prog2.Models.Turma;
import com.acg.t1prog2.Views.Turma.CadastrarTurmaView;
import java.util.ArrayList;
import java.util.List;

public class CadastrarTurmaController {

    private Turma turma;
    private CadastrarTurmaView ctv;

    public CadastrarTurmaController(CadastrarTurmaView ctv) {
        this.ctv = ctv;
        popularComboBox();
        inicializarAcaoBotao();
        exibirTela();
    }

    private void inicializarAcaoBotao() {
        Professor prof = ctv.getProfessor();
        Esporte esporte = ctv.getEsporte();

        turma = new Turma();

        turma.setProfessor(prof);
        turma.setEsporte(esporte);

        adicionarTurma(turma);

        ctv.exibirMensagem("Turma cadastrada com sucesso!");
    }

    private void adicionarTurma(Turma turma) {
        TurmaDAO turmaDAO = new TurmaDAO();
        
        turmaDAO.salvarTurma(turma);
    }
    
    private void popularComboBox() {

        EsporteDAO esporteDAO = new EsporteDAO();
        PessoaDAO pessoaDAO = new PessoaDAO();

        List<Esporte> esportes = new ArrayList<>();
        List<Professor> professores = new ArrayList<>();

        for (Esporte esp : esporteDAO.recuperarTodosEsportes()) {
            esportes.add(esp);
        }

        for (Pessoa p : pessoaDAO.recuperarTodasPessoas()) {
            if (p instanceof Professor professor) {
                professores.add(professor);
            }
        }

        ctv.popularCbEsporte(esportes);
        ctv.popularCbProfessor(professores);
    }

    public void exibirTela() {
        ctv.exibir();
    }
}
