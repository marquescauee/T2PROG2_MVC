/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Ginasio;

import com.acg.t1prog2.DAO.ReservaDAO;
import com.acg.t1prog2.Models.Reserva;
import com.acg.t1prog2.Views.Ginasio.ListarReservasGinasioView;

public class ListarReservasGinasioController {
    
    private ListarReservasGinasioView lrgv;
    
    public ListarReservasGinasioController(ListarReservasGinasioView lrgv) {
        this.lrgv = lrgv;
        
        exibirTela();
        listarReservaGinasios();
    }
    
    private void listarReservaGinasios() {
        ReservaDAO reservaDAO = new ReservaDAO();
        
        for(Reserva reserva : reservaDAO.recuperarTodasReservas()) {
            lrgv.listarReservaGinasios(reserva.toString() + "\n---------------------------------------\n");
        }
    }
    
    public void exibirTela() {
        lrgv.exibir();
    }
    
}
