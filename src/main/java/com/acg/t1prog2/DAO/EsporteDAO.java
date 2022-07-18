/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.DAO;

import com.acg.t1prog2.Models.Esporte;
import com.acg.t1prog2.Models.Esportes.Basquete;
import com.acg.t1prog2.Models.Esportes.Futebol;
import com.acg.t1prog2.Models.Esportes.Natacao;
import com.acg.t1prog2.Models.Esportes.Volei;
import com.acg.t1prog2.Models.Ginasio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EsporteDAO {
    
    public static void createTable() {
        Connection connection = Conexao.getConnection();
        String criarTabela = "CREATE TABLE IF NOT EXISTS ESPORTE"
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "qtdParticipantes INTEGER NOT NULL)";
        
        Statement stmt = null;
        
        try {
            stmt = connection.createStatement();
            stmt.execute(criarTabela);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvarEsporte(Esporte esp) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO ESPORTE (qtdParticipantes) VALUES (?)";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, esp.getQtdJogadores());
            
            pstmt.execute();
            
            System.out.println("Esporte gravado com sucesso!");
            
            final ResultSet resultado = pstmt.getGeneratedKeys();
            
            if(resultado.next()) {
                int id = resultado.getInt(1);
                esp.setId(id);
            }
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }  
    
    public static List<Esporte> recuperarTodosEsportes() {
        createTable();
        List<Esporte> esportes = new ArrayList<>();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM ESPORTE";
        Statement stmt;
        
        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                int qtdParticipates = resultado.getInt("qtdParticipantes");
                
                Esporte esp = null;
                
                switch (qtdParticipates) {
                    case 12:
                        esp = new Volei(12);
                        break;
                    case 10:
                        esp = new Basquete(10);
                        break;
                    case 22:
                        esp = new Futebol(22);
                        break;
                    case 8:
                        esp = new Natacao(8);
                        break;
                    default:
                        break;
                }
                
                esp.setId(id);
                esportes.add(esp);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } 
        return esportes;
    }
    
    public static boolean removerEsporte(Esporte esp) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "DELETE FROM ESPORTE WHERE ID = ?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, esp.getId());
            pstmt.execute();
            System.out.println("Esporte removido com sucesso!");
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
