/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.DAO;

import com.acg.t1prog2.Models.Equipamento;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAO {
    
    private static List<Equipamento> equipamentos = new ArrayList<>();
    
    public void salvarEquipamento(Equipamento e) {
        equipamentos.add(e);
    }

    public List<Equipamento> recuperarTodosEquipamentos() {
        return equipamentos;
    }
    
    public void removerEquipamento(Equipamento e) {
        equipamentos.remove(e);
    }
}
