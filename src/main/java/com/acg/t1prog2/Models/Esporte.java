/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Models;

import java.util.ArrayList;
import java.util.List;

public abstract class Esporte implements Modalidade {

    private int id;
    private int qtdParticipantes;
    private List<Mensalidade> listaMensalidades; 
    
    private int codigoEsporte;
    
    private static int geradorCodigoEsporte = 0;

    protected Esporte(int qtdJogadores) {
        this.listaMensalidades = new ArrayList<>();
        this.codigoEsporte = gerarCodigoTurma();
        this.qtdParticipantes = qtdJogadores;
    }
    
    public static int gerarCodigoTurma() {
        return ++geradorCodigoEsporte;
    }
    
    public void addMensalidade(Mensalidade mensalidade) {
        this.listaMensalidades.add(mensalidade);
    }
    
    public void removeMensalidade(Mensalidade mensalidade) {
        this.listaMensalidades.remove(mensalidade);
    }

    public List<Mensalidade> getListaMensalidades() {
        return listaMensalidades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public int getQtdJogadores() {
        return qtdParticipantes;
    }

    public void setQtdJogadores(int qtdJogadores) {
        this.qtdParticipantes = qtdJogadores;
    } 
    
    @Override
    public String toString() {
        return "Esporte: ";
    } 

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Esporte other = (Esporte) obj;
        return this.codigoEsporte == other.codigoEsporte;
    }
    
}
