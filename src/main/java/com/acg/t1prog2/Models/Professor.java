/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Models;

public class Professor extends Pessoa {
    
    private double valorAula;
    
    public Professor() {
        super();
        this.valorAula = 200;
    }
    
    public double getHoraAula() {
        return valorAula;
    }
   
    @Override
    public String toString() {
        return super.toString() + ", hora/aula: " + this.valorAula;
    } 
}
