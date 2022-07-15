/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.DAO;

import com.acg.t1prog2.Models.Lance;
import java.util.ArrayList;
import java.util.List;


public class LanceDAO {
    private static List<Lance> lances = new ArrayList<>();
    
    public void salvarLance(Lance l) {
        lances.add(l);
    }

    public Lance recuperarLance(int i) {
        return lances.get(i);
    }
    
    public List<Lance> recuperarTodosLances() {
        return lances;
    }
   
}
