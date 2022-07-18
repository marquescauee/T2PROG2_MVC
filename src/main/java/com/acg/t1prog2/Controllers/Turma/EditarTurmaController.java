/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Turma;

import com.acg.t1prog2.DAO.ProfessorDAO;
import com.acg.t1prog2.DAO.TurmaDAO;
import com.acg.t1prog2.Models.Pessoa;
import com.acg.t1prog2.Models.Professor;
import com.acg.t1prog2.Models.Turma;
import com.acg.t1prog2.Views.Turma.EditarTurmaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EditarTurmaController {

    private EditarTurmaView etv;

    public EditarTurmaController(EditarTurmaView etv) {
        this.etv = etv;
        popularComboBox();
        inicializarAcaoBotao();
        exibirTela();
    }

    private void inicializarAcaoBotao() {
        etv.adicionarAcaoBotaoEditar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Turma tempTurma = etv.getTurma();
                Professor tempProfessor = etv.getProfessor();

                tempTurma.setProfessor(tempProfessor);
                TurmaDAO.atualizarTurma(tempTurma);
                etv.exibirMensagem("Alteração realizada com sucesso!");

                etv.limparComboBox();
                popularComboBox();
            }
        });
    }

    private void popularComboBox() {
        TurmaDAO turmaDAO = new TurmaDAO();

        List<Turma> turmas = new ArrayList<>();
        List<Professor> professores = new ArrayList<>();

        for (Turma turma : turmaDAO.recuperarTodasTurmas()) {
            turmas.add(turma);
        }

        for (Professor prof : ProfessorDAO.recuperarTodosProfessores()) {
            professores.add(prof);
        }

        etv.popularCbTurma(turmas);
        etv.popularCbProfessor(professores);
    }

    public void exibirTela() {
        etv.exibir();
    }
}
