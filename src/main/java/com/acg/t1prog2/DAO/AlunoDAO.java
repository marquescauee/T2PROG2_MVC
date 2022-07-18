/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.DAO;

import com.acg.t1prog2.Exceptions.CampoVazioException;
import com.acg.t1prog2.Exceptions.IdadeException;
import com.acg.t1prog2.Exceptions.IdentificadorUnicoException;
import com.acg.t1prog2.Models.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    public static void createTable() {
        Connection connection = Conexao.getConnection();
        String criarTabela = "CREATE TABLE IF NOT EXISTS ALUNO"
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nome VARCHAR(255) NOT NULL,"
                + "cpf INTEGER(11) NOT NULL,"
                + "idade INTEGER NOT NULL)";
        
        Statement stmt = null;
        
        try {
            stmt = connection.createStatement();
            stmt.execute(criarTabela);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvarAluno(Aluno a) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO ALUNO (nome, cpf, idade) VALUES (?, ?, ?)";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, a.getNome());
            pstmt.setString(2, a.getCpf());
            pstmt.setInt(3, a.getIdade());
            
            pstmt.execute();
            
            System.out.println("Aluno gravado com sucesso!");
            
            final ResultSet resultado = pstmt.getGeneratedKeys();
            
            if(resultado.next()) {
                int id = resultado.getInt(1);
                a.setId(id);
            }
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean atualizarAluno(Aluno a) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "UPDATE ALUNO SET nome=?, cpf=?, idade=? WHERE ID=?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, a.getNome());
            pstmt.setString(2, a.getCpf());
            pstmt.setInt(3, a.getIdade());
            pstmt.setInt(4, a.getId());
            pstmt.execute();
            
            System.out.println("Aluno atualizado com sucesso!");
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static List<Aluno> recuperarTodosAlunos() {
        createTable();
        List<Aluno> alunos = new ArrayList<>();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM ALUNO";
        Statement stmt;
        
        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String cpf = resultado.getString("cpf");
                int idade = resultado.getInt("idade");
                
                Aluno a = new Aluno(nome, cpf, idade);
                a.setId(id);
                alunos.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } 
        return alunos;
    }
    
    public static boolean removerAluno(Aluno a) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "DELETE FROM ALUNO WHERE ID = ?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, a.getId());
            pstmt.execute();
            System.out.println("Aluno removido com sucesso!");
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
