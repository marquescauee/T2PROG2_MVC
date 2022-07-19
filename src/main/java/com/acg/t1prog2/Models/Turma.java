/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Turma {
    
    private int id;
    private Esporte esporte;
    private Professor professor;
    private List<Aluno> listaAlunos;
    
    public Turma() {
        this.listaAlunos = new ArrayList<>();
    }

    public Turma(int id, Esporte esporte, Professor professor) {
        this.listaAlunos = new ArrayList<>();
        this.id = id;
        this.esporte = esporte;
        this.professor = professor;
    }
    
    public Esporte getEsporte() {
        return esporte;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }
    
    public void setEsporte(Esporte esporte) {
        this.esporte = esporte;
    } 
    
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    
    public Professor getProfessor() {
        return this.professor;
    }
    
    public void addAluno(Aluno aluno) {
        this.listaAlunos.add(aluno);
    }
    
    public void removeAluno(Aluno aluno) {
        this.listaAlunos.remove(aluno);
    }

    public List<Aluno> ordenarListaAlunosOrdemAlfabetica() {
        this.listaAlunos.sort(new Comparator<Aluno>() {
            @Override
            public int compare(Aluno o1, Aluno o2) {
                return o1.getNome().compareTo(o2.getNome());
            }   
        });
        
        return listaAlunos;
    }
    
    public String representacaoListaAlunos() {
        List<Aluno> lista = this.ordenarListaAlunosOrdemAlfabetica();
        
        String texto = "";
        
        for(Aluno a : lista) {
            texto += "Aluno: " + a.getNome() + ", Idade: " + a.getIdade() + "\n";
        }
        
        return texto;
    }

    @Override
    public String toString() {
        return "Código da turma: " + this.id + ", " + this.esporte + "\nProfessor: " 
                + professor + "\nAlunos: " + representacaoListaAlunos();
    }
    
    
 
}
