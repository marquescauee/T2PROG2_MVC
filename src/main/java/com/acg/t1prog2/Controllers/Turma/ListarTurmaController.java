/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Turma;

import com.acg.t1prog2.DAO.TurmaDAO;
import com.acg.t1prog2.Models.Turma;
import com.acg.t1prog2.Views.Turma.ListarTurmaView;

public class ListarTurmaController {
    
    private ListarTurmaView ltv;
    
    public ListarTurmaController(ListarTurmaView ltv) {
        this.ltv = ltv;
        exibirTela();
        listarTurmas();
    }
    
    private void listarTurmas() {
        TurmaDAO turmaDAO = new TurmaDAO();
        
        String texto = "";
        
        for(Turma turma : turmaDAO.recuperarTodasTurmas()) {
            texto += turma + "\n";
        }
        
        ltv.exibirListagem(texto);
    }
    
    public void exibirTela() {
        ltv.exibir();
    }
}
