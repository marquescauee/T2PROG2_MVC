/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Turma;

import com.acg.t1prog2.DAO.TurmaDAO;
import com.acg.t1prog2.Models.Turma;
import com.acg.t1prog2.Views.Turma.RemoverTurmaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class RemoverTurmaController {

    private RemoverTurmaView rtv;

    public RemoverTurmaController(RemoverTurmaView rtv) {
        this.rtv = rtv;
        popularComboBox();
        inicializarAcaoBotao();
        exibirTela();
    }

    private void inicializarAcaoBotao() {
        rtv.adicionarAcaoRemoverTurma(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Turma tempTurma = rtv.getTurma();

                removerTurma(tempTurma);
                rtv.exibirMensagem("Turma removida com sucesso!");

                rtv.limparComboBox();
                popularComboBox();
            }
        });
    }

    private void removerTurma(Turma turma) {
        TurmaDAO turmaDAO = new TurmaDAO();
        
        turmaDAO.removerTurma(turma);
    }
    
    private void popularComboBox() {
        TurmaDAO turmaDAO = new TurmaDAO();

        List<Turma> turmas = new ArrayList<>();

        for (Turma turma : turmaDAO.recuperarTodasTurmas()) {
            turmas.add(turma);
        }

        rtv.popularComboBox(turmas);
    }

    public void exibirTela() {
        rtv.exibir();
    }
}
