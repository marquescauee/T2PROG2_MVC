/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Models;


public abstract class Mensalidade {
    protected int id;
    protected double valor;

    public Mensalidade(double valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "valor: " + this.valor;
    }
    
}
