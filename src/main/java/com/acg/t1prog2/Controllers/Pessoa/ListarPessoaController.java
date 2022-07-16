/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Controllers.Pessoa;

import com.acg.t1prog2.DAO.PessoaDAO;
import com.acg.t1prog2.Models.Pessoa;
import com.acg.t1prog2.Views.Pessoa.ListarPessoaView;

public class ListarPessoaController {
    
    private ListarPessoaView lpv;
    
    public ListarPessoaController(ListarPessoaView lpv) {
        this.lpv = lpv;
        exibirTela();
        listarPessoas();
    }
    
    private void listarPessoas() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        String texto = "";
        
        for(Pessoa p : pessoaDAO.recuperarTodasPessoas()) {
            texto += p.toString() + "\n";
        }
        
        lpv.exibirListagem(texto);
    }
    
    public void exibirTela() {
        lpv.exibir();
    }
}
