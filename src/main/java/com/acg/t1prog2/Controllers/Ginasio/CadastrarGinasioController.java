/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Ginasio;

import com.acg.t1prog2.DAO.EsporteDAO;
import com.acg.t1prog2.DAO.GinasioDAO;
import com.acg.t1prog2.DAO.MensalidadeDAO;
import com.acg.t1prog2.Exceptions.CampoVazioException;
import com.acg.t1prog2.Models.Esporte;
import com.acg.t1prog2.Models.Esportes.Basquete;
import com.acg.t1prog2.Models.Esportes.Futebol;
import com.acg.t1prog2.Models.Esportes.Natacao;
import com.acg.t1prog2.Models.Esportes.Volei;
import com.acg.t1prog2.Models.Ginasio;
import com.acg.t1prog2.Models.Mensalidade;
import com.acg.t1prog2.Models.Mensalidades.Anual;
import com.acg.t1prog2.Models.Mensalidades.Mensal;
import com.acg.t1prog2.Models.Mensalidades.Semestral;
import com.acg.t1prog2.Models.Mensalidades.Trimestral;
import com.acg.t1prog2.Views.Ginasio.CadastrarGinasioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CadastrarGinasioController {

    private Ginasio ginasio;
    private CadastrarGinasioView cgv;

    public CadastrarGinasioController(CadastrarGinasioView cgv) {
        this.cgv = cgv;
        inicializarAcaoBotoes();
        exibirTela();
    }

    private void inicializarAcaoBotoes() {
        cgv.adicionarAcaoBotaoCadastrar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = cgv.getNome();
                String endereco = cgv.getEndereco();

                try {
                    ginasio = new Ginasio();
                    
                    double tamanho = cgv.getArea();
                    int anoCriacao = cgv.getAnoCriacao();
                    ginasio.setNome(nome);
                    ginasio.setAnoCriacao(anoCriacao);
                    ginasio.setEndereco(endereco);
                    ginasio.setTamanho(tamanho);

                    verificarSeAlgumMarcado();

                    addGinasio(ginasio);
                    registrarEsporte(ginasio);

                    cgv.exibirMensagem("Ginásio cadastrado com sucesso!");
                    cgv.limparTela();
                } catch (CampoVazioException | NumberFormatException ex) {
                    cgv.exibirMensagem("Campo vazio.");
                }  
            }
        });  
    }

    private boolean verificarSeAlgumMarcado() throws CampoVazioException {
        boolean nenhumMarcado = false;

        if (!cgv.getCheckFutebol() && !cgv.getCheckBasquete() && !cgv.getCheckNatacao() && !cgv.getCheckVolei()) {
            nenhumMarcado = true;
        }

        if (!cgv.getCheckMensal() && !cgv.getCheckTrimestral() && !cgv.getCheckSemestral() && !cgv.getCheckAnual()) {
            nenhumMarcado = true;
        }

        if (nenhumMarcado) {
            throw new CampoVazioException();
        }

        return nenhumMarcado;
    }
    
    private void addGinasio(Ginasio ginasio) {
        GinasioDAO.salvarGinasio(ginasio);
    }
    
    private void registrarEsporte(Ginasio ginasio) {
        
        if (cgv.getCheckFutebol()) {
            Esporte fut = new Futebol(22);
            EsporteDAO.salvarEsporte(fut);
            registrarMensalidade(fut);
            ginasio.getListaEsportes().add(fut);  
        }

        if (cgv.getCheckBasquete()) {
            Esporte basq = new Basquete(10);
            EsporteDAO.salvarEsporte(basq);
            registrarMensalidade(basq);
            ginasio.getListaEsportes().add(basq);
            
        }

        if (cgv.getCheckVolei()) {
            Esporte volei = new Volei(12);
            EsporteDAO.salvarEsporte(volei);
            registrarMensalidade(volei);
            ginasio.getListaEsportes().add(volei);
            
        }

        if (cgv.getCheckNatacao()) {
            Esporte natacao = new Natacao(8);
            EsporteDAO.salvarEsporte(natacao);
            registrarMensalidade(natacao);
            ginasio.getListaEsportes().add(natacao);
            
        }
    }
    
    private void registrarMensalidade(Esporte esporte) {
        if (cgv.getCheckMensal()) {
            Mensalidade mensal = new Mensal(100);
            mensal.setEsporte(esporte);
            MensalidadeDAO.salvarMensalidade(mensal);
            esporte.getListaMensalidades().add(mensal);
        }

        if (cgv.getCheckTrimestral()) {
            Mensalidade trimestral = new Trimestral(270);
            trimestral.setEsporte(esporte);
            MensalidadeDAO.salvarMensalidade(trimestral);
            esporte.getListaMensalidades().add(trimestral);
        }

        if (cgv.getCheckSemestral()) {
            Mensalidade semestral = new Semestral(550);
            semestral.setEsporte(esporte);
            MensalidadeDAO.salvarMensalidade(semestral);
            esporte.getListaMensalidades().add(semestral);
        }

        if (cgv.getCheckAnual()) {
            Mensalidade anual = new Anual(900);
            anual.setEsporte(esporte);
            MensalidadeDAO.salvarMensalidade(anual);
            esporte.getListaMensalidades().add(anual);
        }

    }

    public void exibirTela() {
        this.cgv.exibir();
    }
}
