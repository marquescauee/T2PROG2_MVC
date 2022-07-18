/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.DAO;

import com.acg.t1prog2.Models.Ginasio;
import com.acg.t1prog2.Models.Reserva;
import com.acg.t1prog2.Models.Turma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {
 
    public static void createTable() {
        Connection connection = Conexao.getConnection();
        String criarTabela = "CREATE TABLE IF NOT EXISTS RESERVA"
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "dataHora VARCHAR(255) NOT NULL,"
                + "ginasio_id INTEGER,"
                + "turma_id INTEGER,"
                + "FOREIGN KEY (ginasio_id) REFERENCES GINASIO (id),"
                + "FOREIGN KEY (turma_id) REFERENCES TURMA (id))";
        
        Statement stmt = null;
        
        try {
            stmt = connection.createStatement();
            stmt.execute(criarTabela);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvarReserva(Reserva reserva) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO RESERVA (dataHora, ginasio_id, turma_id) VALUES (?, ?, ?)";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(reserva.getDataHora()));
            pstmt.setInt(2, reserva.getGinasio().getId());
            pstmt.setInt(3, reserva.getTurma().getId());
            
            pstmt.execute();
            
            System.out.println("Reserva gravada com sucesso!");
            
            final ResultSet resultado = pstmt.getGeneratedKeys();
            
            if(resultado.next()) {
                int id = resultado.getInt(1);
                reserva.setId(id);
            }
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static List<Reserva> recuperarTodasReservas() {
        createTable();
        List<Reserva> reservas = new ArrayList<>();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM RESERVA";
        Statement stmt;
        
        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                LocalDateTime data = LocalDateTime.parse(resultado.getString("dataHora"));
                
                Turma t = null;
                Ginasio g = null;
                
                for(Turma turma : TurmaDAO.recuperarTodasTurmas()) {
                    if(turma.getId() == resultado.getInt("turma_id")) {
                        t = turma;
                    }
                }
                
                for(Ginasio ginasio : GinasioDAO.recuperarTodosGinasios()) {
                    if(ginasio.getId() == resultado.getInt("ginasio_id")) {
                        g = ginasio;
                    }
                }
                
                Reserva reserva = new Reserva();
                reserva.setDataHora(data);
                reserva.setGinasio(g);
                reserva.setTurma(t);
                reserva.setId(id);
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return reservas;
    }
}
