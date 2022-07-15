/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Models;


public class Mensalidade {
    protected double valor;

    public Mensalidade(double valor) {
        this.valor = valor;
    }
    
    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "valor: " + this.valor;
    }
    
}
