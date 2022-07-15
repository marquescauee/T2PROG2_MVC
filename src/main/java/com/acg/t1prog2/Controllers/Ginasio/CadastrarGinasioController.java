/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Ginasio;

import com.acg.t1prog2.Models.Ginasio;
import com.acg.t1prog2.Views.Ginasio.CadastrarGinasioView;

public class CadastrarGinasioController {
    
    private Ginasio ginasio;
    private CadastrarGinasioView cgv;
    
    public CadastrarGinasioController(CadastrarGinasioView cgv) {
        this.cgv = cgv;
        inicializarAcaoBotoes();
    }
    
    public void inicializarAcaoBotoes() {
        
    }
    
    public void exibirTela() {
        this.cgv.exibir();
    }
}
