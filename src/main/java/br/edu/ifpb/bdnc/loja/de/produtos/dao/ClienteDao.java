/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.loja.de.produtos.dao;

import br.edu.ifpb.bdnc.loja.de.produtos.entity.Cliente;
import java.util.List;

/**
 *
 * @author miolivc
 */
public interface ClienteDao {
    public void add(Cliente cliente);
    public List<Cliente> list();
    public Cliente find(String cpf);
    public void delete(String cpf);
    public void edit(Cliente cliente);
}
