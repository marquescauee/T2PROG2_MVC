/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Models;

import com.acg.t1prog2.DAO.MensalidadeDAO;
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

    public Aluno(String nome, String cpf, int idade) {
        super(nome, cpf, idade);
        this.matricula = gerarMatricula();
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

        List<Mensalidade> mensalidadesAluno = MensalidadeDAO.recuperarMensalidadesAluno(this);
        
        for (Mensalidade mens : mensalidadesAluno) {
            mensalidade += mens.getValor();
        }

        return mensalidade;
    }

    @Override
    public String toString() {
        return super.toString() + ", matrícula: " + this.matricula;
    }
}
