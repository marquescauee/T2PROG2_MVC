/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Models.Esportes;

import com.acg.t1prog2.DAO.LanceDAO;
import com.acg.t1prog2.Models.Esporte;
import com.acg.t1prog2.Models.Lance;

public class Volei extends Esporte {

    public Volei(int qtdParticipantes) {
        super(qtdParticipantes);
    }
    
    @Override
    public void gerarSimulacao() {
        Lance l1 = new Lance();
        Lance l2 = new Lance();
        Lance l3 = new Lance();
        
        LanceDAO lanceDAO = new LanceDAO();
        
        l1.setEsporte(this);
        l2.setEsporte(this);
        l3.setEsporte(this);
        
        l1.setLance(
            "É o ponto decisivo!! a Equipe 1 vence o jogo por 24x23 e está ganhando a partida por 2 sets a 1"
                + "\nO jogador da equipe 2 faz o saque e a equipe 1 recepciona bem!"
                + "\nO levantamento é feito e o jogador desce o braço na barreira adversária!! BLOQUEADO!!"
                + "\nA equipe tenta novamente, o levantamento é feito para o mesmo jogador!"
                + "\nO jogador desce o braço novamente e crava a bola no chão!!! É CAMPEÃO!!!\n"
        );
        
        l2.setLance(
             "O Brasil vai no saque. É ele..."
                     + "\nLUCARELLI!! É ACE DO BRASIL!" 
        );
        
        l3.setLance(
             "O Brasil segue vencendo o jogo por 2 a 0."
                     + "\nO time adversário vem pra jogada!"
                     + "\nBRUNINHO NO BLOQUEIO!!!"
        );
        
        lanceDAO.salvarLance(l1);
        lanceDAO.salvarLance(l2);
        lanceDAO.salvarLance(l3);
        
        LanceDAO.associarEsporte(l1, this);
        LanceDAO.associarEsporte(l2, this);
        LanceDAO.associarEsporte(l3, this);
        
    }

    @Override
    public String regras() {
        return "Para uma partida de vôlei, deve-se cumprir os seguintes requisitos:"
                + "\nUma partida é constituída de 5 sets"
                + "\nOs sets não possuem tempo"
                + "\nCada set tem um máximo de 25 pontos, com diferença de 2 pontos caso haja empate em 24x24"
                + "\nApós o saque, a equipe só pode tocar três vezes na bola"
                + "\nGanha a equipe que vencer três sets\n";
    }
    
    public static String mostrarRegras() {
        Esporte e = new Volei(12);
        
        return e.regras();
    }
    
    @Override
    public String toString() {
        return super.toString() + " Vôlei";
    }
}
