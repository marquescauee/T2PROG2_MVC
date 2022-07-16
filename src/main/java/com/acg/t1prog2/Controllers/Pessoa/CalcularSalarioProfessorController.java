/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Pessoa;

import com.acg.t1prog2.DAO.PessoaDAO;
import com.acg.t1prog2.DAO.TurmaDAO;
import com.acg.t1prog2.Models.Pessoa;
import com.acg.t1prog2.Models.Professor;
import com.acg.t1prog2.Models.Turma;
import com.acg.t1prog2.Views.Pessoa.CalcularSalarioProfessorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CalcularSalarioProfessorController {

    private CalcularSalarioProfessorView cspv;

    public CalcularSalarioProfessorController(CalcularSalarioProfessorView cspv) {
        this.cspv = cspv;
        popularComboBox();
        inicializarAcaoBotao();
        exibirTela();
    }

    private void inicializarAcaoBotao() {
        cspv.adicionarAcaoBotaoCalcular(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Professor tempProf = cspv.getProfessor();

                TurmaDAO tDAO = new TurmaDAO();
                
                double aulasMes = 8;
                int cont = 0;

                for (Turma t : tDAO.recuperarTodasTurmas()) {
                    if (t.getProfessor().getCpf().equals(tempProf.getCpf())) {
                        cont++;
                    }
                }

                double salario = (tempProf.getHoraAula() * aulasMes) * cont;

                cspv.exibirSalario("Salário: " + String.valueOf(salario));
            }
        });
    }

    private void popularComboBox() {
        PessoaDAO pDAO = new PessoaDAO();

        List<Professor> professores = new ArrayList<>();

        for (Pessoa p : pDAO.recuperarTodasPessoas()) {
            if (p instanceof Professor prof) {
                professores.add(prof);
            }
        }

        cspv.popularComboBox(professores);
    }

    public void exibirTela() {
        cspv.exibir();
    }
}
