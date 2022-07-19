/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Esporte;

import com.acg.t1prog2.DAO.LanceDAO;
import com.acg.t1prog2.Models.Esporte;
import com.acg.t1prog2.Models.Esportes.Basquete;
import com.acg.t1prog2.Models.Esportes.Futebol;
import com.acg.t1prog2.Models.Esportes.Natacao;
import com.acg.t1prog2.Models.Esportes.Volei;
import com.acg.t1prog2.Models.Lance;
import com.acg.t1prog2.Views.Esporte.RegrasSimulacaoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RegrasSimulacaoController {

    private RegrasSimulacaoView rsv;
    private LanceDAO lanceDAO = new LanceDAO();

    public RegrasSimulacaoController(RegrasSimulacaoView rsv) {
        this.rsv = rsv;
        inicializarAcaoBotoes();
        exibirTela();
    }

    private void inicializarAcaoBotoes() {
        rsv.adicionarAcaoBotaoLimpar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rsv.limparTela();
            }
        });

        rsv.adicionarAcaoBotaoRegrasBasquete(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rsv.exibirRegrasBasquete(Basquete.mostrarRegras() + "\n----------------------------------------------\n");
            }
        });

        rsv.adicionarAcaoBotaoRegrasFutebol(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rsv.exibirRegrasFut(Futebol.mostrarRegras() + "\n----------------------------------------------\n");
            }
        });

        rsv.adicionarAcaoBotaoRegrasVolei(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rsv.exibirRegrasVolei(Volei.mostrarRegras() + "\n----------------------------------------------\n");
            }
        });

        rsv.adicionarAcaoBotaoRegrasNatacao(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rsv.exibirRegrasNatacao(Natacao.mostrarRegras() + "\n----------------------------------------------\n");
            }
        });

        rsv.adicionarAcaoBotaoSimularBasquete(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Esporte esp = new Basquete(12);
                esp.gerarSimulacao();

                for (int i = 0; i < 100; i++) {
                    int numeroAleatorio = (int) (Math.random() * lanceDAO.recuperarTodosLances().size());
                    List<Lance> lances = lanceDAO.recuperarTodosLances();

                    for(Lance l : lances) {
                        if (l.getEsporte() instanceof Basquete) {
                        rsv.exibirMensagem(l.getLance() + "\n----------------------------------------------\n");
                        break;
                        }
                    }
                    break;
                }
            }
        });

        rsv.adicionarAcaoBotaoSimularFutebol(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Esporte esp = new Futebol(22);
                esp.gerarSimulacao();

                for (int i = 0; i < 100; i++) {
                    int numeroAleatorio = (int) (Math.random() * lanceDAO.recuperarTodosLances().size());
                    Lance lanceFut = lanceDAO.recuperarLance(numeroAleatorio);

                    if (lanceFut.getEsporte() instanceof Futebol) {
                        rsv.exibirMensagem(lanceFut.getLance() + "\n----------------------------------------------\n");
                        break;
                    }
                }
            }
        });

        rsv.adicionarAcaoBotaoSimularNatacao(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Esporte esp = new Volei(12);
                esp.gerarSimulacao();

                for (int i = 0; i < 100; i++) {
                    int numeroAleatorio = (int) (Math.random() * lanceDAO.recuperarTodosLances().size());
                    Lance lanceNatacao = lanceDAO.recuperarLance(numeroAleatorio);

                    if (lanceNatacao.getEsporte() instanceof Natacao) {
                        rsv.exibirMensagem(lanceNatacao.getLance() + "\n----------------------------------------------\n");
                        break;
                    }
                }
            }
        });

        rsv.adicionarAcaoBotaoSimularVolei(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Esporte esp = new Natacao(8);
                esp.gerarSimulacao();

                for (int i = 0; i < 100; i++) {
                    int numeroAleatorio = (int) (Math.random() * lanceDAO.recuperarTodosLances().size());
                    Lance lanceVolei = lanceDAO.recuperarLance(numeroAleatorio);
                    
                    if (lanceVolei.getEsporte() instanceof Volei) {
                        rsv.exibirMensagem(lanceVolei.getLance() + "\n----------------------------------------------\n");
                        break;
                    }
                }
            }
        });
    }

    public void exibirTela() {
        rsv.exibir();
    }
}
