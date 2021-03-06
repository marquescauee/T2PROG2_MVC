/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Turma;

import com.acg.t1prog2.DAO.AlunoDAO;
import com.acg.t1prog2.DAO.MensalidadeDAO;
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

                    salvarAlunoNaTurma(tempTurma, tempAluno, tempMens);
                    catv.exibirMensagem("Aluno cadastrado na turma com sucesso!");

                } catch (CadastroTurmaException ex) {
                    catv.exibirMensagem(ex.getMessage());
                } 
            }
        });
    }

    private boolean verificarMensalidade(Mensalidade mensalidade) throws CadastroTurmaException {
        Turma tempTurma = catv.getTurma();
        Esporte esporteTurma = tempTurma.getEsporte();
        Mensalidade mensalidadesEsporte = MensalidadeDAO.recuperarMensalidadeEsporte(mensalidade.getValor(), esporteTurma);
        
        if(mensalidadesEsporte.getId() == mensalidade.getId()) {
            return true;
        }          

        
        throw new CadastroTurmaException("A mensalidade selecionada n??o est?? presente para a turma selecionada.");
    }

    private boolean verificaQtdJogadoresTurma(int qtdAlunosTurma, Esporte esporte) throws CadastroTurmaException {
        if (qtdAlunosTurma < esporte.getQtdJogadores()) {
            return true;
        } else {
            throw new CadastroTurmaException("A turma j?? est?? cheia. Entre em contato para mais informa????es.");
        }
    }

    private void salvarAlunoNaTurma(Turma t, Aluno a, Mensalidade mensalidade) {
        Esporte esporteTurma = t.getEsporte();
        Mensalidade mensalidadesEsporte = MensalidadeDAO.recuperarMensalidadeEsporte(mensalidade.getValor(), esporteTurma);
        
        if(mensalidadesEsporte.getId() == mensalidade.getId()) {
            MensalidadeDAO.associarMensalidadeAluno(mensalidade, a);
        }          

        
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
     
        for(Mensalidade m : MensalidadeDAO.recuperarTodasMensalidades()) {
            mensalidades.add(m);
        }

        catv.popularComboBoxAluno(alunos);
        catv.popularComboBoxTurma(turmas);
        catv.popularComboBoxMensalidade(mensalidades);
    }

    public void exibirTela() {
        catv.exibir();
    }
}
