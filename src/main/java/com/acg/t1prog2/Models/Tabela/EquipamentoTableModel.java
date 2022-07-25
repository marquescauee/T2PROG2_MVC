/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.Models.Tabela;

import com.acg.t1prog2.Exceptions.CampoVazioException;
import com.acg.t1prog2.Exceptions.IdentificadorUnicoException;
import com.acg.t1prog2.Models.Equipamento;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class EquipamentoTableModel extends AbstractTableModel {
    
    private List<Equipamento> equipamentos;
    
    private final String[] nomeColunas = {"Nome", "Marca", "Codigo"};
    private final int COLUNA_NOME = 0;
    private final int COLUNA_MARCA = 1;
    private final int COLUNA_CODIGO = 2;
    
    public EquipamentoTableModel(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }
    
    @Override
    public int getRowCount() {
        return equipamentos.size();
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
        Equipamento equip = this.equipamentos.get(rowIndex);
        String valor = null;
        switch(columnIndex){
            case COLUNA_NOME:
                valor = equip.getNome();
                break;
            case COLUNA_MARCA:
                valor = equip.getMarca();
                break;
            case COLUNA_CODIGO:
                valor = equip.getCodigo();
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
    	Equipamento equip = this.equipamentos.get(rowIndex);
        
        try {
            switch (columnIndex) {
            case COLUNA_NOME:
                equip.setNome((String) aValue);
                break;
            case COLUNA_MARCA:
                equip.setMarca((String) aValue);
                break;
            case COLUNA_CODIGO:
                equip.setCodigo((String) aValue);
                break;        
            }  
        } catch(CampoVazioException | IdentificadorUnicoException e) {
            System.out.println(e.getMessage()); 
        }
        fireTableDataChanged();
    }
}
