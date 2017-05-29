/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.loja.de.produtos.manager;

import br.edu.ifpb.bdnc.loja.de.produtos.dao.implementation.VendaDaoMongo;
import br.edu.ifpb.bdnc.loja.de.produtos.dao.implementation.VendaDaoNeo4J;
import br.edu.ifpb.bdnc.loja.de.produtos.dao.model.VendaDao;
import br.edu.ifpb.bdnc.loja.de.produtos.entity.Cliente;
import br.edu.ifpb.bdnc.loja.de.produtos.entity.Venda;
import br.edu.ifpb.bdnc.loja.de.produtos.entity.Produto;
import br.edu.ifpb.bdnc.loja.de.produtos.factory.DaoFactory;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author miolivc
 */
public class VendaManager {
    VendaDao vendaDaoMongo;
    VendaDao vendaDaoNeo4J;
    
    public VendaManager(){
        vendaDaoMongo = DaoFactory.createFactory(DaoFactory.MONGO).createVendaDao();
        vendaDaoNeo4J = DaoFactory.createFactory(DaoFactory.NEO4J).createVendaDao();
    }
    
    public void add(int codigo, List<Produto> produtos, Cliente cliente, LocalDate data, LocalTime hora){
        Venda venda = new Venda();
        venda.setCodigo(codigo);
        venda.setCliente(cliente);
        venda.setProdutos(produtos);
        venda.setData(data);
        venda.setHora(hora);
        vendaDaoMongo.add(venda);
        vendaDaoNeo4J.add(venda);
    }
    
    public void update(int codigo, List<Produto> produtos, Cliente cliente, LocalDate data, LocalTime hora){
        this.delete(codigo);
        this.add(codigo, produtos, cliente, data, hora);
    }
    
    public void delete(int codigo){
        vendaDaoMongo.delete(codigo);
        vendaDaoNeo4J.delete(codigo);
    }
    
    public List<Venda> list(){
        List<Venda> vendas = vendaDaoMongo.list();
        return vendas;
    }
    
    public Venda find(int codigo){
        Venda venda = vendaDaoMongo.find(codigo);
        return venda;
    }
}
