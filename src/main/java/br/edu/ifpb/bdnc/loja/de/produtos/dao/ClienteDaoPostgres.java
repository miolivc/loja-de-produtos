/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.loja.de.produtos.dao;

import br.edu.ifpb.bdnc.loja.de.produtos.entity.Cliente;
import br.edu.ifpb.bdnc.loja.de.produtos.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author miolivc
 */
public class ClienteDaoPostgres implements ClienteDao {
    private static Connection conn;

    public ClienteDaoPostgres() throws SQLException, ClassNotFoundException {
        conn = ConnectionFactory.getConnection();
    }
    
    @Override
    public void add(Cliente cliente) {
        
    }

    @Override
    public List<Cliente> list() {
        List<Cliente> clientes = null;
        return clientes;
    }

    @Override
    public Cliente find(String cpf) {
        Cliente cliente = null;
        return cliente;
    }

    @Override
    public void delete(String cpf) {
        
    }

    @Override
    public void edit(Cliente cliente) {
        
    }
    
}
