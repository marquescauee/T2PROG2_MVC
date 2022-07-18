/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Models;

import com.acg.t1prog2.DAO.AlunoDAO;
import com.acg.t1prog2.DAO.ProfessorDAO;
import com.acg.t1prog2.Exceptions.CampoVazioException;
import com.acg.t1prog2.Exceptions.IdadeException;
import com.acg.t1prog2.Exceptions.IdentificadorUnicoException;
import java.util.List;

public abstract class Pessoa {
    
    protected String nome;
    protected String cpf;
    protected int idade;
    protected int id;
    
    public Pessoa() {
        
    }

    public Pessoa(String nome, String cpf, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
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
      
        List<Professor> professores = ProfessorDAO.recuperarTodosProfessores();
        
        List<Aluno> alunos = AlunoDAO.recuperarTodosAlunos();
        
        for(Professor prof : professores) {
            if(prof.getCpf().equals(cpf)) {
                throw new IdentificadorUnicoException();
            }
        }       
        
        for(Aluno aluno : alunos) {
            if(aluno.getCpf().equals(cpf)) {
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

    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + this.nome + ", CPF: " + this.cpf + ", idade: " + this.idade;
    } 
}
