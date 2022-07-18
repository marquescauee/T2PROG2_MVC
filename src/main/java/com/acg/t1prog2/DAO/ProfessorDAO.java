/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.DAO;

import com.acg.t1prog2.Exceptions.CampoVazioException;
import com.acg.t1prog2.Exceptions.IdadeException;
import com.acg.t1prog2.Exceptions.IdentificadorUnicoException;
import com.acg.t1prog2.Models.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {
    public static void createTable() {
        Connection connection = Conexao.getConnection();
        String criarTabela = "CREATE TABLE IF NOT EXISTS PROFESSOR"
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nome VARCHAR(255) NOT NULL,"
                + "cpf INTEGER(11) NOT NULL,"
                + "idade INTEGER NOT NULL,"
                + "valorAula DOUBLE NOT NULL)";
        
        Statement stmt = null;
        
        try {
            stmt = connection.createStatement();
            stmt.execute(criarTabela);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvarProfessor(Professor p) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO PROFESSOR (nome, cpf, idade, valorAula) VALUES (?, ?, ?, ?)";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, p.getNome());
            pstmt.setString(2, p.getCpf());
            pstmt.setInt(3, p.getIdade());
            pstmt.setDouble(4, p.getHoraAula());
            
            pstmt.execute();
            
            System.out.println("Professor gravado com sucesso!");
            
            final ResultSet resultado = pstmt.getGeneratedKeys();
            
            if(resultado.next()) {
                int id = resultado.getInt(1);
                p.setId(id);
            }
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean atualizarProfessor(Professor p) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "UPDATE PROFESSOR SET nome=?, cpf=?, idade=? WHERE ID=?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, p.getNome());
            pstmt.setString(2, p.getCpf());
            pstmt.setInt(3, p.getIdade());
            pstmt.setInt(4, p.getId());
            pstmt.execute();
            
            System.out.println("Professor atualizado com sucesso!");
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static List<Professor> recuperarTodosProfessores() {
        createTable();
        List<Professor> professores = new ArrayList<>();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM PROFESSOR";
        Statement stmt;
        
        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String cpf = resultado.getString("cpf");
                int idade = resultado.getInt("idade");
                
                Professor p = new Professor(nome, cpf, idade);
                p.setId(id);
                professores.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } 
        return professores;
    }
    
    public static boolean removerProfessor(Professor p) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "DELETE FROM PROFESSOR WHERE ID = ?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, p.getId());
            pstmt.execute();
            System.out.println("Professor removido com sucesso!");
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
