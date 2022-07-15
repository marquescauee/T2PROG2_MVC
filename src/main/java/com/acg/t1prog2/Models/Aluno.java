/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Models;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {

    private String matricula;
    
    static private int geradorMatricula = 0;
    
    private List<Mensalidade> listaMensalidades;

    public Aluno() {
        super();
        this.matricula = gerarMatricula();
        this.listaMensalidades = new ArrayList<>();
    }

    public static String gerarMatricula() {
        String text = ++geradorMatricula + "2022";

        return text;
    }

    public void addMensalidade(Mensalidade mensalidade) {
        this.listaMensalidades.add(mensalidade);
    }

    public List<Mensalidade> getListaMensalidades() {
        return listaMensalidades;
    }
    
    

    public double calcularMensalidade() {
        int mensalidade = 0;

        for (Mensalidade mens : this.listaMensalidades) {
            mensalidade += mens.getValor();
        }

        return mensalidade;
    }

    @Override
    public String toString() {
        return super.toString() + ", matrícula: " + this.matricula;
    }
}
