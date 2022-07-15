/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.DAO;

import com.acg.t1prog2.Models.Pessoa;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    
    private static List<Pessoa> pessoas = new ArrayList<>();
    
    public void salvarPessoa(Pessoa p) {
        pessoas.add(p);
    }

    public List<Pessoa> recuperarTodasPessoas() {
        return pessoas;
    }

    public void removerPessoa(Pessoa p) {
        pessoas.remove(p);
    }
}
