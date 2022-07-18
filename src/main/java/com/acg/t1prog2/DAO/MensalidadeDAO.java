/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.DAO;

import com.acg.t1prog2.Models.Aluno;
import com.acg.t1prog2.Models.Mensalidade;
import com.acg.t1prog2.Models.Mensalidades.Anual;
import com.acg.t1prog2.Models.Mensalidades.Mensal;
import com.acg.t1prog2.Models.Mensalidades.Semestral;
import com.acg.t1prog2.Models.Mensalidades.Trimestral;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MensalidadeDAO {
    
    public static void createTable() {
        Connection connection = Conexao.getConnection();
        String criarTabela = "CREATE TABLE IF NOT EXISTS MENSALIDADE"
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "valor DOUBLE NOT NULL,"
                + "aluno_id INTEGER,"
                + "FOREIGN KEY (aluno_id) REFERENCES ALUNO (id))";
        
        Statement stmt = null;
        
        try {
            stmt = connection.createStatement();
            stmt.execute(criarTabela);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvarMensalidade(Mensalidade mens) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO MENSALIDADE (valor) VALUES (?)";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setDouble(1, mens.getValor());
            
            pstmt.execute();
            
            System.out.println("Mensalidade gravada com sucesso!");
            
            final ResultSet resultado = pstmt.getGeneratedKeys();
            
            if(resultado.next()) {
                int id = resultado.getInt(1);
                mens.setId(id);
            }
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static List<Mensalidade> recuperarTodasMensalidades() {
        createTable();
        List<Mensalidade> mensalidades = new ArrayList<>();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM MENSALIDADE";
        Statement stmt;
        
        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                double valor = resultado.getDouble("valor");
                
                Mensalidade m = null;
                
                if(resultado instanceof Mensal) {
                    m = new Mensal(valor);
                } else if(resultado instanceof Trimestral) {
                    m = new Trimestral(valor);
                } else if(resultado instanceof Semestral) {
                    m = new Semestral(valor);
                } else if(resultado instanceof Anual) {
                    m = new Anual(valor);
                }
                
                m.setId(id);
                mensalidades.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return mensalidades;
    }
}
