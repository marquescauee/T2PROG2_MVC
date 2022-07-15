/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Models;

import com.acg.t1prog2.DAO.PessoaDAO;
import com.acg.t1prog2.Exceptions.CampoVazioException;
import com.acg.t1prog2.Exceptions.IdadeException;
import com.acg.t1prog2.Exceptions.IdentificadorUnicoException;
import java.util.InputMismatchException;

public abstract class Pessoa {
    
    private String nome;
    private String cpf;
    private int idade;
    private int id;
    protected static int geradorID = 0;


    public Pessoa() {
        this.id = gerarID();
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws IdentificadorUnicoException, CampoVazioException, NumberFormatException {
        PessoaDAO pessoaDAO = new PessoaDAO();
        for(Pessoa p : pessoaDAO.recuperarTodasPessoas()) {
            if(p.getCpf().equals(cpf)) {
                throw new IdentificadorUnicoException();
            }
        }       
               
        if(cpf.isBlank()) {
            throw new CampoVazioException();
        }
        
        if(!(Integer.valueOf(cpf) instanceof Number)) {
            throw new NumberFormatException();
        }
        
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) throws CampoVazioException, IdadeException {
        if(idade == 0) {
            throw new CampoVazioException();
        }
        
        if(idade < 0 || idade > 100) {
            throw new IdadeException("Idade inválida");
        }
        
        this.idade = idade;
    }
    
    private static int gerarID() {
        return ++geradorID;
    }
    
    public int getID() {
        return Pessoa.geradorID;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + this.nome + ", CPF: " + this.cpf + ", idade: " + this.idade;
    } 
}
