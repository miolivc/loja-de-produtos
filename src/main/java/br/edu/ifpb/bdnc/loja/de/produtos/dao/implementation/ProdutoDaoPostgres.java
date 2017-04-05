/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.loja.de.produtos.dao.implementation;

import br.edu.ifpb.bdnc.loja.de.produtos.dao.model.ProdutoDao;
import br.edu.ifpb.bdnc.loja.de.produtos.connection.PostgresConnection;
import br.edu.ifpb.bdnc.loja.de.produtos.entity.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miolivc
 */
public class ProdutoDaoPostgres implements ProdutoDao {
    Connection conn;

    public ProdutoDaoPostgres() throws SQLException, ClassNotFoundException {
        conn = PostgresConnection.getConnection();
    }
    
    @Override
    public void add(Produto produto) {
        String sql = "INSERT INTO PRODUTO(CODIGO, NOME, DESCRICAO, VALOR) VALUES (?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, produto.getCodigo());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getDescricao());
            stmt.setFloat(4, produto.getValor());
            stmt.execute();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }

    @Override
    public List<Produto> list() {
        List<Produto> produtos = null;
        String sql = "SELECT * FROM PRODUTO";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Produto produto = new Produto();
                
                produto.setCodigo(rs.getInt("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setValor(rs.getFloat("valor"));
                
                produtos.add(produto);
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return produtos;
    }

    @Override
    public Produto find(String nome) {
        Produto produto = null;
        String sql = "SELECT * FROM PRODUTO WHERE NOME ILIKE ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                produto.setCodigo(rs.getInt("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setValor(rs.getFloat("valor"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produto;
    }

    @Override
    public Produto find(int codigo) {
        Produto produto = null;
        String sql = "SELECT * FROM PRODUTO WHERE CODIGO = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                produto.setCodigo(rs.getInt("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setValor(rs.getFloat("valor"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return produto;        
    }

    @Override
    public void delete(String nome) {
        String sql = "DELETE FROM PRODUTO WHERE NOME ILIKE ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.execute();
            
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int codigo) {
        String sql = "DELETE FROM CLIENTE WHERE NOME ILIKE ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, codigo);
            stmt.execute();
            
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void edit(Produto produto) {
        delete(produto.getCodigo());
        add(produto);
    }
    
}
