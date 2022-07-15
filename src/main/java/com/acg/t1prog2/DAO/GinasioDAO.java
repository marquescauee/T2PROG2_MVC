/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.DAO;

import com.acg.t1prog2.Models.Esporte;
import com.acg.t1prog2.Models.Ginasio;
import java.util.ArrayList;
import java.util.List;

public class GinasioDAO {
    
    private static List<Ginasio> ginasios = new ArrayList<>();
    
    public void salvarGinasio(Ginasio g) {
        ginasios.add(g);
    }

    public List<Ginasio> recuperarTodosGinasios() {
        return ginasios;
    }
    
    public void removerGinasio(Ginasio g) {
        ginasios.remove(g);
        EsporteDAO esporteDAO = new EsporteDAO(); 
        for(Esporte e : g.getListaEsportes()) {
            esporteDAO.removerEsporte(e);
        }
    }
}
