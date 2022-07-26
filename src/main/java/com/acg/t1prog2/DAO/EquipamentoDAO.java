/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.acg.t1prog2.DAO;

import com.acg.t1prog2.Exceptions.CampoVazioException;
import com.acg.t1prog2.Models.Equipamento;
import com.acg.t1prog2.Models.Ginasio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAO {
    
    public static void createTable() {
        Connection connection = Conexao.getConnection();
        String criarTabela = "CREATE TABLE IF NOT EXISTS EQUIPAMENTO"
                + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nome VARCHAR(255) NOT NULL,"
                + "marca VARCHAR(45) NOT NULL,"
                + "codigo VARCHAR(45) NOT NULL,"
                + "ginasio_id INTEGER,"
                + "FOREIGN KEY (ginasio_id) REFERENCES GINASIO (id))";
        
        Statement stmt = null;
        
        try {
            stmt = connection.createStatement();
            stmt.execute(criarTabela);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean salvarEquipamento(Equipamento equip) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "INSERT INTO EQUIPAMENTO (nome, marca, codigo) VALUES (?, ?, ?)";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, equip.getNome());
            pstmt.setString(2, equip.getMarca());
            pstmt.setString(3, equip.getCodigo());
            
            pstmt.execute();
            
            System.out.println("Equipamento gravado com sucesso!");
            
            final ResultSet resultado = pstmt.getGeneratedKeys();
            
            if(resultado.next()) {
                int id = resultado.getInt(1);
                equip.setId(id);
            }
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean atualizarEquipamento(Equipamento equip) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "UPDATE EQUIPAMENTO SET nome=?, marca=?, codigo=? WHERE ID=?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, equip.getNome());
            pstmt.setString(2, equip.getMarca());
            pstmt.setString(3, equip.getCodigo());
            pstmt.setInt(4, equip.getId());
            pstmt.execute();
            
            System.out.println("Equipamento atualizado com sucesso!");
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean associarGinasio(Equipamento equipamento, Ginasio ginasio) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "UPDATE EQUIPAMENTO SET ginasio_id=? WHERE ID=?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, ginasio.getId());
            pstmt.setInt(2, equipamento.getId());
            pstmt.execute();
            
            System.out.println("Equipamento atualizado com sucesso!");
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static Equipamento recuperarEquipamento(String codigo) {
        createTable();
        Equipamento equipamento;
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM EQUIPAMENTO WHERE codigo =?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, codigo);
            pstmt.execute();
            ResultSet resultado = pstmt.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String marca = resultado.getString("marca");
                String codigoEquip = resultado.getString("codigo");
                
                Ginasio ginasio = null;
                int ginasio_id = resultado.getInt("ginasio_id");
                
                for(Ginasio g : GinasioDAO.recuperarTodosGinasios()) {
                    if(g.getId() == ginasio_id) {
                        ginasio = g;
                    }
                }
                
                equipamento = new Equipamento(nome, marca, codigoEquip, ginasio);
                equipamento.setId(id);
                return equipamento;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        
        return null;
    }
    
    public static List<Equipamento> recuperarTodosEquipamentos() {
        createTable();
        List<Equipamento> equipamentos = new ArrayList<>();
        Connection connection = Conexao.getConnection();
        String sql = "SELECT * FROM EQUIPAMENTO";
        Statement stmt;
        
        try {
            stmt = connection.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String marca = resultado.getString("marca");
                String codigo = resultado.getString("codigo");
                
                Equipamento equip = new Equipamento(nome, marca, codigo);
                equip.setId(id);
                equipamentos.add(equip);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return equipamentos;
    }
    
    public static boolean removerEquipamento(Equipamento equip) {
        createTable();
        Connection connection = Conexao.getConnection();
        String sql = "DELETE FROM EQUIPAMENTO WHERE ID = ?";
        PreparedStatement pstmt;
        
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, equip.getId());
            pstmt.execute();
            System.out.println("Equipamento removido com sucesso!");
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
