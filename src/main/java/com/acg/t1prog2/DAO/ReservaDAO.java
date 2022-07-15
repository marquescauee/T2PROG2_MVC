/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.DAO;

import com.acg.t1prog2.Models.Reserva;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
 
    private static List<Reserva> reservas = new ArrayList<>();
    
    public void salvarReserva(Reserva r) {
        reservas.add(r);
    }

    public List<Reserva> recuperarTodasReservas() {
        return reservas;
    }
}
