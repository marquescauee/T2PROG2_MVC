/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Models;

import com.acg.t1prog2.Exceptions.ReservaException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Reserva {
    
    private int id;
    private LocalDateTime dataHora;
    private Ginasio ginasio;
    private Turma turma;

    public Reserva() {
        
    }
    
    private Reserva(LocalDateTime dataHora, Ginasio ginasio, Turma turma) throws ReservaException {
        this.dataHora = dataHora;
        this.ginasio = ginasio;
        this.turma = turma;
    }

    public static Reserva reservarGinasio(LocalDateTime dataHora, Ginasio ginasio, Turma turma) throws ReservaException {
        validarDataReserva(dataHora);
        validarHorarioReserva(dataHora);
        return new Reserva(dataHora, ginasio, turma);
    }

    private static void validarDataReserva(LocalDateTime dataHora) throws ReservaException {
        LocalDateTime dataHoraAgora = LocalDateTime.now();
        if (!dataHora.isAfter(dataHoraAgora)) {
            throw new ReservaException("Você selecionou uma data no passado. Tente novamente");
        }
    }

    private static void validarHorarioReserva(LocalDateTime dataHora) throws ReservaException {
        LocalTime horarioValidoInicial = LocalTime.of(6, 0, 0);

        if (dataHora.toLocalTime().isBefore(horarioValidoInicial)) {
            throw new ReservaException("Não é possível reservar o ginásio para antes de 06:00");
        }

        
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Ginasio getGinasio() {
        return ginasio;
    }

    public void setGinasio(Ginasio ginasio) {
        this.ginasio = ginasio;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getDataFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataHora.format(formatter);
        return dataFormatada;
    }

    public String getHoraFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String horaFormatada = dataHora.format(formatter);
        return horaFormatada;
    }

    @Override
    public String toString() {
        return "Data: " + getDataFormatada() + ", Hora: " + getHoraFormatada() + "\n" + ginasio + "\nTurma:" + turma;
    }
}
