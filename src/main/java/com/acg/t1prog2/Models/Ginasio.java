/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Models;

import com.acg.t1prog2.Exceptions.CampoVazioException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ginasio {
    
    private String nome;
    private int anoCriacao;
    private double tamanho;
    private String endereco;
    
    private Set<Esporte> listaEsportes;
    private Map<String, Equipamento> mapEquipCodigo;
    
    public Ginasio() {
        this.listaEsportes = new HashSet<>();
        this.mapEquipCodigo = new HashMap<>();
    }

    public Set<Equipamento> getListaEquipamentos() {
        Set<Equipamento> listaEquips = new HashSet<>();
        
        for(Map.Entry<String, Equipamento> equip : this.mapEquipCodigo.entrySet()) {
            listaEquips.add(equip.getValue());
        }
        
        return listaEquips;
    }
    
    public void addEquipamentoMap(Equipamento equipamento) {
        this.mapEquipCodigo.put(equipamento.getCodigo(), equipamento);
    }
    
    public Equipamento buscarEquipamentoPorCodigo(String codigo) {
        return this.mapEquipCodigo.get(codigo);
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
    
    public String getNome() {
        return nome;
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
