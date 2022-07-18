/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Ginasio;

import com.acg.t1prog2.DAO.EsporteDAO;
import com.acg.t1prog2.DAO.GinasioDAO;
import com.acg.t1prog2.DAO.MensalidadeDAO;
import com.acg.t1prog2.Models.Esporte;
import com.acg.t1prog2.Models.Ginasio;
import com.acg.t1prog2.Models.Mensalidade;
import com.acg.t1prog2.Views.Ginasio.RemoverGinasioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RemoverGinasioController {

    private Ginasio ginasio;
    private RemoverGinasioView rgv;

    public RemoverGinasioController(RemoverGinasioView rgv) {
        this.rgv = rgv;
        popularComboBox();
        inicializarAcaoBotoes();
        exibirTela();
    }

    private void inicializarAcaoBotoes() {
        rgv.adicionarAcaoBotaoRemover(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ginasio tempGinasio = rgv.getGinasio();
                removerEsporte(tempGinasio);
                removerMensalidade(tempGinasio);
                removerGinasio(tempGinasio);

                rgv.exibirMensagem("Ginásio removido com sucesso!");

                rgv.limparComboBox();
                popularComboBox();
            }

        });
    }

    private void removerGinasio(Ginasio ginasio) {
        GinasioDAO.removerGinasio(ginasio);
    }

    private void removerEsporte(Ginasio ginasio) {
        for (Esporte e : ginasio.getListaEsportes()) {
            EsporteDAO.removerEsporte(e);
        }
    }

    private void removerMensalidade(Ginasio ginasio) {
        Set<Esporte> esportes = ginasio.getListaEsportes();

        for (Esporte esp : esportes) {
            for (Mensalidade m : esp.getListaMensalidades()) {
                MensalidadeDAO.removerMensalidade(m);
            }
        }
    }

    private void popularComboBox() {
        List<Ginasio> ginasios = new ArrayList<>();

        for (Ginasio g : GinasioDAO.recuperarTodosGinasios()) {
            ginasios.add(g);
        }

        rgv.popularComboBox(ginasios);
    }

    public void exibirTela() {
        rgv.exibir();
    }
}
