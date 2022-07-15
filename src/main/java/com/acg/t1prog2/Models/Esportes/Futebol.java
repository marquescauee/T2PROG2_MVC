/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Models.Esportes;

import com.acg.t1prog2.DAO.LanceDAO;
import com.acg.t1prog2.Models.Esporte;
import com.acg.t1prog2.Models.Lance;

public class Futebol extends Esporte {

    public Futebol(int qtdParticipantes) {
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
            "O jogador dribla o primeiro e avança pela ponta\n" +
"           Faz o cruzamento para o atacante que cabeceia a bola e..." +
"           \nGOOOOOOOl!!!\n"
        );
        
        l2.setLance(
             "O time recupera a bola na defesa e inicia o contra-ataque em alta velocidade\n"
                     + "os dois atacantes tabelam entre si e passam pela defesa adversária\n"
                     + "O jogador finaliza e GOOOOOLL!\n"   
        );
        
        l3.setLance(
             "O júiz apita o início do jogo\n"
                     + "O atacante avança rapidamente para tentar recuperar a bola e dá um carrinho!"
                     + "XIIII!! CARTÃO VERMELHO COM 15 SEGUNDOS DE JOGO"
        );
        
        lanceDAO.salvarLance(l1);
        lanceDAO.salvarLance(l2);
        lanceDAO.salvarLance(l3);
        
    }

    @Override
    public String regras() {
        return "Para uma partida de futebol, deve-se cumprir os seguintes requisitos:"
                + "\nA partida deve ter 90 minutos"
                + "\n11 jogadores de cada lado"
                + "\npossibilidade de 3 substituições"
                + "\nVitória: 3 pontos; Empate: 1 ponto; Derrota: 0 pontos"
                + "\n2 cartões amarelos = expulsão\n";
    }

    public static String mostrarRegras() {
        Esporte e = new Futebol(22);
        
        return e.regras();
    }

    
    @Override
    public String toString() {
        return super.toString() + " Futebol";
    }

}
