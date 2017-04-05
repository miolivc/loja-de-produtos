/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.loja.de.produtos.dao.implementation;

import br.edu.ifpb.bdnc.loja.de.produtos.dao.model.ClienteDao;
import br.edu.ifpb.bdnc.loja.de.produtos.entity.Cliente;
import br.edu.ifpb.bdnc.loja.de.produtos.connection.PostgresConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author miolivc
 */
public class ClienteDaoPostgres implements ClienteDao {
    private static Connection conn;

    public ClienteDaoPostgres() throws SQLException, ClassNotFoundException {
        conn = PostgresConnection.getConnection();
    }
    
    @Override
    public void add(Cliente cliente) {
        String sql = "INSERT INTO CLIENTE(CPF, NOME, DATANASC, EMAIL, SENHA) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setDate(3, Date.valueOf(cliente.getDataNasc()));
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getPassword());
            stmt.execute();
            
            sql = "INSERT INTO ENDERECO (CPF, RUA, BAIRRO, CIDADE, UF, NUMERO) VALUES (?,?,?,?,?,?)";
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getEndereco().getRua());
            stmt.setString(3, cliente.getEndereco().getBairro());
            stmt.setString(4, cliente.getEndereco().getCidade());
            stmt.setString(5, cliente.getEndereco().getUf());
            stmt.setInt(6, cliente.getEndereco().getNumero());
            stmt.execute();
            
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Cliente> list() {
        List<Cliente> clientes = null;
        String sql = "SELECT * FROM CLIENTE NATURAL JOIN ENDERECO";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                Cliente cliente = new Cliente();
                
                cliente.setCpf(rs.getString("cpf"));
                cliente.setDataNasc(rs.getDate("datanasc").toLocalDate());
                cliente.setEmail(rs.getString("email"));
                cliente.setPassword(rs.getString("senha"));
                cliente.getEndereco().setRua(rs.getString("rua"));
                cliente.getEndereco().setBairro(rs.getString("bairro"));
                cliente.getEndereco().setCidade(rs.getString("cidade"));
                cliente.getEndereco().setUf(rs.getString("uf"));
                
                clientes.add(cliente);
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clientes;
    }

    @Override
    public Cliente find(String cpf) {
        Cliente cliente = null;
        String sql = "SELECT * FROM CLIENTE NATURAL JOIN ENDERECO WHERE CPF = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                cliente.setCpf(rs.getString("cpf"));
                cliente.setDataNasc(rs.getDate("datanasc").toLocalDate());
                cliente.setEmail(rs.getString("email"));
                cliente.setPassword(rs.getString("senha"));
                cliente.getEndereco().setRua(rs.getString("rua"));
                cliente.getEndereco().setBairro(rs.getString("bairro"));
                cliente.getEndereco().setCidade(rs.getString("cidade"));
                cliente.getEndereco().setUf(rs.getString("uf"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cliente;
    }

    @Override
    public void delete(String cpf) {
        String sql = "DELETE FROM ENDERECO WHERE CPF = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.execute();
            
            sql = "DELETE FROM CLIENTE WHERE CPF = ?";
            stmt.setString(1, cpf);
            stmt.execute();
            
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void edit(Cliente cliente) {
        delete(cliente.getCpf());
        add(cliente);
    }
    
}
