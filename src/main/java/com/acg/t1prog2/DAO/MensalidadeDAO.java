/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.DAO;

import com.acg.t1prog2.Models.Mensalidade;
import java.util.ArrayList;
import java.util.List;

public class MensalidadeDAO {
    
    private static List<Mensalidade> mensalidades = new ArrayList<>();
    
    public void salvarMensalidade(Mensalidade m) {
        mensalidades.add(m);
    }

    public List<Mensalidade> recuperarTodasMensalidades() {
        return mensalidades;
    }
}
