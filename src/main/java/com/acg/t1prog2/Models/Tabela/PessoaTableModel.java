/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Models.Tabela;

import com.acg.t1prog2.Exceptions.CampoVazioException;
import com.acg.t1prog2.Exceptions.IdadeException;
import com.acg.t1prog2.Exceptions.IdentificadorUnicoException;
import com.acg.t1prog2.Models.Pessoa;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PessoaTableModel extends AbstractTableModel {
    private List<Pessoa> pessoas;
    
    private final String[] nomeColunas = {"Nome", "CPF", "Idade"};
    private final int COLUNA_NOME = 0;
    private final int COLUNA_CPF = 1;
    private final int COLUNA_IDADE = 2;
   
    public PessoaTableModel(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
    @Override
    public int getRowCount() {
        return pessoas.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return nomeColunas[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pessoa pessoa = this.pessoas.get(rowIndex);
        String valor = null;
        switch(columnIndex){
            case COLUNA_NOME:
                valor = pessoa.getNome();
                break;
            case COLUNA_CPF:
                valor = String.valueOf(pessoa.getCpf());
                break;
            case COLUNA_IDADE:
                valor = String.valueOf(pessoa.getIdade());
                break;          
        }
        return valor;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    	Pessoa pessoa = this.pessoas.get(rowIndex);
        
        try {
            switch (columnIndex) {
            case COLUNA_NOME:
                pessoa.setNome((String) aValue);
                break;
            case COLUNA_CPF:
                pessoa.setCpf((String) aValue);
                break;
            case COLUNA_IDADE:
                pessoa.setIdade(Integer.parseInt((String) aValue));
                break;
            }  
        }catch(CampoVazioException | IdentificadorUnicoException | IdadeException e) {
            System.out.println(e.getMessage());   
        }
        fireTableDataChanged();
    }
}
