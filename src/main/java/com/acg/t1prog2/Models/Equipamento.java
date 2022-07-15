/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Models;

import com.acg.t1prog2.DAO.EquipamentoDAO;
import com.acg.t1prog2.Exceptions.CampoVazioException;
import java.util.Objects;


public class Equipamento implements Comparable<Equipamento> {
    
    private String nome;
    private String marca;
    private String codigo;


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) throws CampoVazioException {
        if(marca.isBlank()) {
            throw new CampoVazioException();
        }
        
        this.marca = marca;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) throws CampoVazioException {
        EquipamentoDAO equipDAO = new EquipamentoDAO();    
        
        if(codigo.isBlank()) {
            throw new CampoVazioException();
        }
        
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Equipamento: " + this.nome + ", marca: " + this.marca + ", codigo: " + this.codigo;
    }

    @Override
    public int compareTo(Equipamento equip) {
        if(Long.parseLong(this.codigo) < Long.parseLong(equip.getCodigo())) {
            return -1;
        } else if(Long.parseLong(this.codigo) > Long.parseLong(equip.getCodigo())) {
            return 1;
        } else {
            return 0;
        }
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
        final Equipamento other = (Equipamento) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    

    
    
    

}
