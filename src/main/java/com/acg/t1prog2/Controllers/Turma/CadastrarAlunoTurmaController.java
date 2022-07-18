/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Turma;

import com.acg.t1prog2.DAO.AlunoDAO;
import com.acg.t1prog2.DAO.TurmaDAO;
import com.acg.t1prog2.Exceptions.CadastroTurmaException;
import com.acg.t1prog2.Models.Aluno;
import com.acg.t1prog2.Models.Esporte;
import com.acg.t1prog2.Models.Mensalidade;
import com.acg.t1prog2.Models.Pessoa;
import com.acg.t1prog2.Models.Turma;
import com.acg.t1prog2.Views.Turma.CadastrarAlunoTurmaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CadastrarAlunoTurmaController {

    private CadastrarAlunoTurmaView catv;

    public CadastrarAlunoTurmaController(CadastrarAlunoTurmaView catv) {
        this.catv = catv;
        popularComboBox();
        inicializarAcaoBotao();
        exibirTela();
    }

    private void inicializarAcaoBotao() {
        catv.adicionarAcaoBotaoCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Turma tempTurma = catv.getTurma();
                    Aluno tempAluno = catv.getAluno();
                    Mensalidade tempMens = catv.getMensalidade();
                    Esporte tempEsporteTurma = tempTurma.getEsporte();

                    int qtdAlunosTurma = tempTurma.getListaAlunos().size();

                    verificarMensalidade(tempMens);
                    verificaQtdJogadoresTurma(qtdAlunosTurma, tempEsporteTurma);
                    naoExisteAlunoNaTurma(tempTurma, tempAluno);

                    salvarAlunoNaTurma(tempTurma, tempAluno);
                    tempAluno.getListaMensalidades().add(tempMens);
                    catv.exibirMensagem("Aluno cadastrado na turma com sucesso!");

                } catch (CadastroTurmaException ex) {
                    catv.exibirMensagem(ex.getMessage());
                } catch (NullPointerException ex) {
                    catv.exibirMensagem("Algo não foi selecionado. Tente novamente.");
                }
            }
        });
    }

    private boolean verificarMensalidade(Mensalidade mensalidade) throws CadastroTurmaException {
        Turma tempTurma = catv.getTurma();

        if (tempTurma.getEsporte().getListaMensalidades().contains(mensalidade)) {
            return tempTurma.getEsporte().getListaMensalidades().contains(mensalidade);
        } else {
            throw new CadastroTurmaException("A mensalidade selecionada não está presente para a turma selecionada.");
        }
    }

    private boolean verificaQtdJogadoresTurma(int qtdAlunosTurma, Esporte esporte) throws CadastroTurmaException {
        if (qtdAlunosTurma < esporte.getQtdJogadores()) {
            return true;
        } else {
            throw new CadastroTurmaException("A turma já está cheia. Entre em contato para mais informações.");
        }
    }

    private boolean naoExisteAlunoNaTurma(Turma turma, Aluno aluno) throws CadastroTurmaException {
        TurmaDAO turmaDAO = new TurmaDAO();

        for (Turma t : turmaDAO.recuperarTodasTurmas()) {
            if (t.getEsporte().equals(turma.getEsporte()) && t.getProfessor().equals(turma.getProfessor())) {
                if (!t.getListaAlunos().contains(aluno)) {
                    return true;
                }
            }
        }
        throw new CadastroTurmaException("O aluno já está cadastrado nessa turma.");
    }

    private void salvarAlunoNaTurma(Turma t, Aluno a) {
        t.addAluno(a);
    }

    private void popularComboBox() {

        List<Aluno> alunos = new ArrayList<>();
        List<Turma> turmas = new ArrayList<>();
        List<Mensalidade> mensalidades = new ArrayList<>();

        for (Aluno a : AlunoDAO.recuperarTodosAlunos()) {
            alunos.add(a);
        }

        for (Turma t : TurmaDAO.recuperarTodasTurmas()) {
            turmas.add(t);
        }

        for (Turma t : TurmaDAO.recuperarTodasTurmas()) {
            Esporte esporte = t.getEsporte();

            for (Mensalidade m : esporte.getListaMensalidades()) {
                mensalidades.add(m);
            }

            mensalidades.add(null);
        }

        catv.popularComboBoxAluno(alunos);
        catv.popularComboBoxTurma(turmas);
        catv.popularComboBoxMensalidade(mensalidades);
    }

    public void exibirTela() {
        catv.exibir();
    }
}
