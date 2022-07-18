/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.DAO;

import com.acg.t1prog2.Models.Esporte;
import com.acg.t1prog2.Models.Mensalidade;
import com.acg.t1prog2.Models.Professor;
import com.acg.t1prog2.Models.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO {
    
    public static void createTable() {
        Connection connection = Conexao.getConnection();
        String criarTabela = "CREATE TABLE IF NOT EXISTS TURMA"
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "professor_id INTEGER,"
                + "esporte_id INTEGER,"
                + "FOREIGN KEY (professor_id) REFERENCES PROFESSOR (id),"
                + "FOREIGN KEY (esporte_id) REFERENCES ESPORTE (id))";
        
        Statement stmt = null;
        
        try {
            stmt = connection.createStatement();
            stmt.execute(criarTabela);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvarTurma(Turma t) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO TURMA (professor_id, esporte_id) VALUES (?, ?)";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, t.getProfessor().getId());
            pstmt.setInt(2, t.getEsporte().getId());
            pstmt.execute();
            
            System.out.println("Turma gravada com sucesso!");
            
            final ResultSet resultado = pstmt.getGeneratedKeys();
            
            if(resultado.next()) {
                int id = resultado.getInt(1);
                t.setId(id);
            }
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean atualizarTurma(Turma t) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "UPDATE TURMA SET professor_id=? WHERE ID=?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, t.getProfessor().getId());
            pstmt.setInt(2, t.getId());
            pstmt.execute();
            
            System.out.println("Turma atualizada com sucesso!");
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static List<Turma> recuperarTodasTurmas() {
        createTable();
        List<Turma> turmas = new ArrayList<>();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM TURMA";
        Statement stmt;
        
        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                int professor_id = resultado.getInt("professor_id");
                int esporte_id = resultado.getInt("esporte_id");
                
                Professor p = null;
                Esporte esporte = null;
                List<Mensalidade> mensalidades = new ArrayList<>();
                
                for(Professor prof : ProfessorDAO.recuperarTodosProfessores()) {
                    if(prof.getId() == professor_id) {
                        p = prof;
                    }
                }
                
                for(Esporte esp : EsporteDAO.recuperarTodosEsportes()) {
                    if(esp.getId() == esporte_id) {
                        esporte = esp;
                        
                        for(Mensalidade m : esp.getListaMensalidades()) {
                            mensalidades.add(m);
                        }
                    }
                }
                
                Turma t = new Turma();
                t.setId(id);
                t.setEsporte(esporte);
                t.setProfessor(p);
                
                for(Mensalidade m : mensalidades) {
                    t.getEsporte().addMensalidade(m);
                }
                
                turmas.add(t);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } 
        return turmas;
    }
    
    public static boolean removerTurma(Turma t) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "DELETE FROM TURMA WHERE ID = ?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, t.getId());
            pstmt.execute();
            System.out.println("Turma removida com sucesso!");
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
