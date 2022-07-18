/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Models.Tabela;

import com.acg.t1prog2.Exceptions.CampoVazioException;
import com.acg.t1prog2.Models.Ginasio;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class GinasioTableModel extends AbstractTableModel {

    private List<Ginasio> ginasios;
    
    private final String[] nomeColunas = {"Nome", "Ano", "Área", "Endereço"};
    private final int COLUNA_NOME = 0;
    private final int COLUNA_ANO = 1;
    private final int COLUNA_AREA = 2;
    private final int COLUNA_ENDERECO = 3;
    
    public GinasioTableModel(List<Ginasio> ginasios) {
        this.ginasios = ginasios;
    }
    
    @Override
    public int getRowCount() {
        return ginasios.size();
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
        Ginasio ginasio = this.ginasios.get(rowIndex);
        String valor = null;
        switch(columnIndex){
            case COLUNA_NOME:
                valor = ginasio.getNome();
                break;
            case COLUNA_ANO:
                valor = String.valueOf(ginasio.getAnoCriacao());
                break;
            case COLUNA_AREA:
                valor = String.valueOf(ginasio.getTamanho());
                break;
            case COLUNA_ENDERECO:
                valor = ginasio.getEndereco();
        }
        return valor;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    	Ginasio ginasio = this.ginasios.get(rowIndex);
        
        try {
            switch (columnIndex) {
            case COLUNA_NOME:
                ginasio.setNome((String) aValue);
                break;
            case COLUNA_ANO:
                ginasio.setAnoCriacao(Integer.parseInt((String) aValue));
                break;
            case COLUNA_AREA:
                ginasio.setTamanho(Double.parseDouble((String) aValue));
                break;
            case COLUNA_ENDERECO:
                ginasio.setEndereco((String) aValue);
            }  
        } catch(CampoVazioException e) {
            System.out.println(e.getMessage()); 
        }
        fireTableDataChanged();
    }
    
}
