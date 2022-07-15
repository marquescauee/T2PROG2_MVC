/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.DAO;

import com.acg.t1prog2.Models.Turma;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO {
    
    private static List<Turma> turmas = new ArrayList<>();
    
    public void salvarTurma(Turma t) {
        turmas.add(t);
    }

    public List<Turma> recuperarTodasTurmas() {
        return turmas;
    }
    
    public void removerTurma(Turma t) {
        turmas.remove(t);
    }
}
