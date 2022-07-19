/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Models;

import com.acg.t1prog2.Exceptions.CampoVazioException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ginasio {
    
    private String nome;
    private int anoCriacao;
    private double tamanho;
    private String endereco;
    private int id;
    
    private Set<Esporte> listaEsportes;
    private List<Equipamento> equipamentos;
    

    public Ginasio() {
        listaEsportes = new HashSet<>();
        equipamentos = new ArrayList<>();
    }
    
    public Ginasio(String nome, int anoCriacao, double tamanho, String endereco) {
        listaEsportes = new HashSet<>();
        equipamentos = new ArrayList<>();
        this.nome = nome;
        this.anoCriacao = anoCriacao;
        this.tamanho = tamanho;
        this.endereco = endereco;
    } 
    
    public void addEsporte(Esporte esporte) {
        this.listaEsportes.add(esporte);
    }
    
    public void removeEsporte(Esporte esporte) {
        this.listaEsportes.remove(esporte);
    }

    public Set<Esporte> getListaEsportes() {
        return listaEsportes;
    }

    public List<Equipamento> getListaEquipamentos() {
        return equipamentos;
    }
    
    
    
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setNome(String nome) throws CampoVazioException {
        if(nome.isBlank()) {
            throw new CampoVazioException();
        }
        
        this.nome = nome;
    }

    public int getAnoCriacao() {
        return anoCriacao;
    }

    public void setAnoCriacao(int anoCriacao) throws CampoVazioException {
        if(String.valueOf(anoCriacao).isBlank()) {
            throw new CampoVazioException();
        }
        
        this.anoCriacao = anoCriacao;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) throws CampoVazioException {
        if(String.valueOf(tamanho).isBlank()) {
            throw new CampoVazioException();
        }
        
        this.tamanho = tamanho;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) throws CampoVazioException {
        if(endereco.isBlank()) {
            throw new CampoVazioException();
        }
        
        this.endereco = endereco;
    }
    
    @Override
    public String toString() {
        return "Ginásio: " + this.nome + ", ano de criação: " + this.anoCriacao 
                + ", tamanho: " + this.tamanho + ", endereço: " + this.endereco;
    }
}
