/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Models.Mensalidades;

import com.acg.t1prog2.Models.Mensalidade;

public class Mensal extends Mensalidade {
    
    public Mensal(double valor) {
       super(valor);
    }

    @Override
    public String toString() {
        return "Tipo: Mensal, " + super.toString();
    }
    
    
}
