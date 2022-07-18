/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Ginasio;

import com.acg.t1prog2.DAO.GinasioDAO;
import com.acg.t1prog2.DAO.ReservaDAO;
import com.acg.t1prog2.DAO.TurmaDAO;
import com.acg.t1prog2.Exceptions.ReservaException;
import com.acg.t1prog2.Models.Ginasio;
import com.acg.t1prog2.Models.Reserva;
import com.acg.t1prog2.Models.Turma;
import com.acg.t1prog2.Views.Ginasio.ReservarGinasioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class ReservarGinasioController {

    private ReservarGinasioView rgv;

    public ReservarGinasioController(ReservarGinasioView rgv) {
        this.rgv = rgv;
        popularComboBox();
        inicializarAcaoBotoes();
        exibirTela();
    }

    private void inicializarAcaoBotoes() {
        rgv.adicionarAcaoBotaoReservar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ReservaDAO reservaDAO = new ReservaDAO();
                    Reserva reserva = recuperarReserva();
                    reservaDAO.salvarReserva(reserva);
                    rgv.exibirMensagem("Ginásio reservado com sucesso: " + reserva.toString());
                    rgv.limparTela();
                    popularComboBox();
                } catch (ReservaException ex) {
                    rgv.exibirMensagem(ex.getMessage());
                }
            }
        });
    }

    public Reserva recuperarReserva() throws ReservaException {
        LocalDateTime dataHoraRserva = getDataHora();
        Ginasio ginasio = rgv.getGinasio();
        Turma turma = rgv.getTurma();
        Reserva reserva = Reserva.reservarGinasio(dataHoraRserva, ginasio, turma);

        if (ginasio == null) {
            throw new ReservaException("Nenhum ginásio selecionado");
        }
        
        if (turma == null) {
            throw new ReservaException("Nenhuma turma selecionada");
        }

        return reserva;
    }
    
    public LocalDateTime getDataHora() throws ReservaException {
        String data = rgv.getData();
        String hora = rgv.getHora();
        String dataHora = data + ' ' + hora;

        try {
            DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime dataHoraRserva = LocalDateTime.parse(dataHora, formatoData);
            return dataHoraRserva;
        } catch (DateTimeParseException e) {
            throw new ReservaException("Data ou hora inválida");
        }
    }
    
    private void popularComboBox() {
        TurmaDAO turmaDAO = new TurmaDAO();

        List<Ginasio> ginasios = new ArrayList<>();
        List<Turma> turmas = new ArrayList<>();

        for (Ginasio ginasio : GinasioDAO.recuperarTodosGinasios()) {
            ginasios.add(ginasio);
        }

        for (Turma t : turmaDAO.recuperarTodasTurmas()) {
            turmas.add(t);
        }

        rgv.popularComboBoxGinasio(ginasios);
        rgv.popularComboBoxTurma(turmas);
    }

    public void exibirTela() {
        rgv.exibir();
    }
}
