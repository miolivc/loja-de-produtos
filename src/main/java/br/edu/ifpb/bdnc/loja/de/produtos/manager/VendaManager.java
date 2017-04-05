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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author miolivc
 */
public class VendaManager {
    VendaDao daoMongo = null;
    VendaDao daoNeo4J = null;
    
    public VendaManager(){
        daoMongo = new VendaDaoMongo();
        daoNeo4J = new VendaDaoNeo4J();
    }
    
    public void add(int codigo, List<Produto> produtos, Cliente cliente, LocalDate data, LocalTime hora){
        Venda venda = new Venda();
    }
}
