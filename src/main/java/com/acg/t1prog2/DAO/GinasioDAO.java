/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.DAO;

import com.acg.t1prog2.Models.Esporte;
import com.acg.t1prog2.Models.Ginasio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GinasioDAO {
    
    public static void createTable() {
        Connection connection = Conexao.getConnection();
        String criarTabela = "CREATE TABLE IF NOT EXISTS GINASIO"
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nome VARCHAR(255) NOT NULL,"
                + "anoCriacao INTEGER(4) NOT NULL,"
                + "area DOUBLE NOT NULL,"
                + "endereco VARCHAR(255) NOT NULL)";
        
        Statement stmt = null;
        
        try {
            stmt = connection.createStatement();
            stmt.execute(criarTabela);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvarGinasio(Ginasio g) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO GINASIO (nome, anoCriacao, area, endereco) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, g.getNome());
            pstmt.setInt(2, g.getAnoCriacao());
            pstmt.setDouble(3, g.getTamanho());
            pstmt.setString(4, g.getEndereco());
            
            pstmt.execute();
            
            System.out.println("Ginasio gravado com sucesso!");
            
            final ResultSet resultado = pstmt.getGeneratedKeys();
            
            if(resultado.next()) {
                int id = resultado.getInt(1);
                g.setId(id);
            }
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean atualizarGinasio(Ginasio g) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "UPDATE GINASIO SET nome=?, anoCriacao=?, area=?, endereco=? WHERE ID=?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, g.getNome());
            pstmt.setInt(2, g.getAnoCriacao());
            pstmt.setDouble(3, g.getTamanho());
            pstmt.setString(4, g.getEndereco());
            pstmt.setInt(5, g.getId());
            pstmt.execute();
            
            System.out.println("Gin??sio atualizado com sucesso!");
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static List<Ginasio> recuperarTodosGinasios() {
        createTable();
        List<Ginasio> ginasios = new ArrayList<>();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM GINASIO";
        Statement stmt;
        
        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                int anoCriacao = resultado.getInt("anoCriacao");
                double area = resultado.getDouble("area");
                String endereco = resultado.getString("endereco");
                
                Ginasio g = new Ginasio(nome, anoCriacao, area, endereco);
                g.setId(id);
                ginasios.add(g);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } 
        return ginasios;
    }
    
    public static boolean removerGinasio(Ginasio g) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "DELETE FROM GINASIO WHERE ID = ?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, g.getId());
            pstmt.execute();
            System.out.println("Ginasio removido com sucesso!");
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
