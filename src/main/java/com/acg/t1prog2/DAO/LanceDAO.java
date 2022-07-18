/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.DAO;

import com.acg.t1prog2.Models.Esporte;
import com.acg.t1prog2.Models.Lance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class LanceDAO {
    public static void createTable() {
        Connection connection = Conexao.getConnection();
        String criarTabela = "CREATE TABLE IF NOT EXISTS LANCE"
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "lance VARCHAR(255) NOT NULL,"
                + "esporte_id INTEGER,"
                + "FOREIGN KEY (esporte_id) REFERENCES ESPORTE (id))";
        
        Statement stmt = null;
        
        try {
            stmt = connection.createStatement();
            stmt.execute(criarTabela);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvarLance(Lance lance) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO LANCE (lance, esporte_id) VALUES (?, ?)";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, lance.getLance());
            pstmt.setInt(2, lance.getEsporte().getId());
            
            pstmt.execute();
            
            System.out.println("Lance gravado com sucesso!");
            
            final ResultSet resultado = pstmt.getGeneratedKeys();
            
            if(resultado.next()) {
                int id = resultado.getInt(1);
                lance.setId(id);
            }
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Lance recuperarLance(int i) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM LANCE WHERE ID = ?";
        PreparedStatement pstmt;
        
        Lance lance = new Lance();
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, i);
            pstmt.execute();
            ResultSet resultado = pstmt.executeQuery();
            
            while(resultado.next()) {
                int id = resultado.getInt("id");
                String narracao = resultado.getString("lance");
                int esporteId = resultado.getInt("esporte_id");
                
                Esporte esporte = null;
                
                for(Esporte esp : EsporteDAO.recuperarTodosEsportes()) {
                    if(esp.getId() == esporteId) {
                        esporte = esp;
                    }
                }
                
                lance.setId(id);
                lance.setEsporte(esporte);
                lance.setLance(narracao);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return lance;
    }
    
    public static List<Lance> recuperarTodosLances() {
        createTable();
        List<Lance> lances = new ArrayList<>();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM LANCE";
        Statement stmt;
        
        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String narracao = resultado.getString("lance");
                Esporte esp = null;
                
                for(Esporte e : EsporteDAO.recuperarTodosEsportes()) {
                    if(e.getId() == resultado.getInt("esporte_id")) {
                        esp = e;
                    }
                }
                
                Lance lance = new Lance();
                lance.setLance(narracao);
                lance.setEsporte(esp);
                lance.setId(id);
                lances.add(lance);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return lances;
    }
   
}
