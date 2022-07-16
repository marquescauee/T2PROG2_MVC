/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Ginasio;

import com.acg.t1prog2.DAO.GinasioDAO;
import com.acg.t1prog2.Exceptions.CampoVazioException;
import com.acg.t1prog2.Models.Ginasio;
import com.acg.t1prog2.Views.Ginasio.EditarGinasioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class EditarGinasioController {

    private Ginasio ginasio;
    private EditarGinasioView egv;

    public EditarGinasioController(EditarGinasioView egv) {
        this.egv = egv;
        inicializarAcaoBotoes();
        popularComboBox();
        exibirTela();
    }

    private void inicializarAcaoBotoes() {
        egv.adicionarAcaoEditarGinasio(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ginasio tempGinasio = (Ginasio) egv.getGinasio();

                String nome = tempGinasio.getNome();
                int anoCriacao = tempGinasio.getAnoCriacao();
                double tamanho = tempGinasio.getTamanho();
                String endereco = tempGinasio.getEndereco();

                if (!egv.getNome().isBlank()) {
                    nome = egv.getNome();
                }

                if (!String.valueOf(egv.getAnoCriacao()).isBlank()) {
                    anoCriacao = egv.getAnoCriacao();
                }

                if (!String.valueOf(egv.getArea()).isBlank()) {
                    tamanho = egv.getArea();
                }

                if (!egv.getEndereco().isBlank()) {
                    endereco = egv.getEndereco();
                }

                try {
                    tempGinasio.setNome(nome);
                    tempGinasio.setAnoCriacao(anoCriacao);
                    tempGinasio.setEndereco(endereco);
                    tempGinasio.setTamanho(tamanho);

                    egv.exibirMensagem("Edição realizada com sucesso!");

                    egv.limparComboBox();
                    popularComboBox();
                    
                    egv.limparTela();

                } catch (CampoVazioException ez) {
                    egv.exibirMensagem(ez.getMessage());
                }
            }
        });
    }

    private void popularComboBox() {
        GinasioDAO ginasioDAO = new GinasioDAO();

        List<Ginasio> ginasios = new ArrayList<>();

        for (Ginasio g : ginasioDAO.recuperarTodosGinasios()) {
            ginasios.add(g);
        }

        egv.popularComboBox(ginasios);
    }

    public void exibirTela() {
        this.egv.exibir();
    }

}
