/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Models.Esportes;

import com.acg.t1prog2.DAO.LanceDAO;
import com.acg.t1prog2.Models.Esporte;
import com.acg.t1prog2.Models.Lance;

public class Basquete extends Esporte {
    
    public Basquete(int qtdParticipantes) {
        super(qtdParticipantes);
    }

    @Override
    public String regras() {
        return "Para uma partida de basquete, deve-se cumprir os seguintes requisitos:"
                + "\nA bola pode ser arremessada em qualquer direção com uma ou com ambas as mãos"
                + "\nUm jogador não pode correr com a bola."
                + "\nNão é permitido empurrar, derrubar ou segurar o jogador"
                + "\n2 infrações: o jogador só joga quando uma cesta for convertida em ponto"
                + "\nO tempo de jogo deve ser de quatro períodos de 10 minutos cada, com 15 minutos de descanso entre o segundo e terceiro período.\n";
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
            "Faltam 3 segundos para o fim do jogo..."
            + "\nA única chance de vitória é o jogador arremessar de onde ele está"
            + "\nEle arremessa a bola e o tempo acabar e..."
            + "\nCESTA!!! O TIME É CAMPEÃO!!!\n"
        );
        
        l2.setLance(
            "O jogador avança em velocidade em direção à cesta"
                    + "\nDeixou o primeiro pra trás!!"
                    + "\nPassou pelo segundo!"
                    + "\nELE ENTERRA A CESTA!! QUE JOGADOR É ESSE?"   
        );
        
        l3.setLance(
             "HOJE ELE TÁ IMPOSSÍVEL!!!"
                     + "\nSÃO 36 PONTOS SÓ COM CESTA DE 3"
                     + "\nALGUÉM PARA ESSE HOMEM!"
        );
        
        lanceDAO.salvarLance(l1);
        lanceDAO.salvarLance(l2);
        lanceDAO.salvarLance(l3);
        
    }
    
    public static String mostrarRegras() {
        Esporte e = new Basquete(10);
        
        return e.regras();
    }

    
    @Override
    public String toString() {
        return super.toString() + " Basquete";
    }
}
