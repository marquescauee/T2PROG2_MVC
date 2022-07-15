/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.DAO;

import com.acg.t1prog2.Models.Esporte;
import java.util.ArrayList;
import java.util.List;

public class EsporteDAO {
    
    private static List<Esporte> esportes = new ArrayList<>();
    
    public void salvarEsporte(Esporte e) {
        esportes.add(e);
    }

    public List<Esporte> recuperarTodosEsportes() {
        return esportes;
    }
    
    public void removerEsporte(Esporte e) {
        esportes.remove(e);
    }
}
