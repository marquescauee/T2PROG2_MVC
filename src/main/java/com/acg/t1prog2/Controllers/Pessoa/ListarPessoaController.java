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
import com.acg.t1prog2.Models.Tabela.PessoaTableModel;
import com.acg.t1prog2.Views.Pessoa.ListarPessoaView;
import java.util.ArrayList;
import java.util.List;

public class ListarPessoaController {
    
    private ListarPessoaView lpv;
    private PessoaTableModel ptm;
    
    public ListarPessoaController(ListarPessoaView lpv, PessoaTableModel ptm) {
        this.lpv = lpv;
        this.ptm = ptm;
        setTableModel();
        inicializarTelaListarDados();
    }
    
    private void setTableModel(){
        lpv.setTableModel(this.ptm);
    }
    
    private void inicializarTelaListarDados() {
        List<Pessoa> pessoas = new ArrayList<>();
        
        for(Aluno a : AlunoDAO.recuperarTodosAlunos()) {
            pessoas.add(a);
        }
        
        for(Professor p : ProfessorDAO.recuperarTodosProfessores()) {
            pessoas.add(p);
        }
        
        ptm = new PessoaTableModel(pessoas);
    }
    
    public void atualizarDados(){
        ptm.fireTableDataChanged();
    }
    
    public void exibirTela() {
        lpv.exibir();
    }
}
