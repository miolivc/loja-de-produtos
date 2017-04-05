/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.loja.de.produtos.manager;

import br.edu.ifpb.bdnc.loja.de.produtos.dao.implementation.ClienteDaoPostgres;
import br.edu.ifpb.bdnc.loja.de.produtos.dao.model.ClienteDao;
import br.edu.ifpb.bdnc.loja.de.produtos.entity.Cliente;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author miolivc
 */
public class ClienteManager {
    ClienteDao clienteDao = null;

    public ClienteManager() throws SQLException, ClassNotFoundException {
        clienteDao = new ClienteDaoPostgres();
    }
    
    public void add(String email, String password, String cpf, String nome, LocalDate dataNasc,
            String rua, String bairro, String cidade, String uf, int numero){
        Cliente cliente = new Cliente();
        cliente.setEmail(email);
        cliente.setPassword(password);
        cliente.setCpf(cpf);
        cliente.setNome(nome);
        cliente.setDataNasc(dataNasc);
        cliente.getEndereco().setRua(rua);
        cliente.getEndereco().setBairro(bairro);
        cliente.getEndereco().setCidade(cidade);
        cliente.getEndereco().setUf(uf);
        clienteDao.add(cliente);
    }
    
    public void update(String email, String password, String cpf, String nome, LocalDate dataNasc,
            String rua, String bairro, String cidade, String uf, int numero){
        Cliente cliente = new Cliente();
        cliente.setEmail(email);
        cliente.setPassword(password);
        cliente.setCpf(cpf);
        cliente.setNome(nome);
        cliente.setDataNasc(dataNasc);
        cliente.getEndereco().setRua(rua);
        cliente.getEndereco().setBairro(bairro);
        cliente.getEndereco().setCidade(cidade);
        cliente.getEndereco().setUf(uf);
        clienteDao.edit(cliente);
    }
    
    public List<Cliente> list(){
        List<Cliente> clientes = clienteDao.list();
        return clientes;
    }
    
    public Cliente find(String cpf){
        Cliente cliente = clienteDao.find(cpf);
        return cliente;
    }
    
    public void delete(String cpf){
        clienteDao.delete(cpf);
    }
}
