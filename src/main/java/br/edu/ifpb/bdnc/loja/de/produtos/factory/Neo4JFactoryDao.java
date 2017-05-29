/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.loja.de.produtos.factory;

import br.edu.ifpb.bdnc.loja.de.produtos.dao.model.ClienteDao;
import br.edu.ifpb.bdnc.loja.de.produtos.dao.model.ProdutoDao;
import br.edu.ifpb.bdnc.loja.de.produtos.dao.model.VendaDao;
import br.edu.ifpb.bdnc.loja.de.produtos.dao.implementation.VendaDaoNeo4J;

/**
 *
 * @author miolivc
 */
public class Neo4JFactoryDao implements FactoryDaoInterface {

    @Override
    public ClienteDao createClienteDao() {
        return null;
    }

    @Override
    public ProdutoDao createProdutoDao() {
        return null;
    }

    @Override
    public VendaDao createVendaDao() {
        return new VendaDaoNeo4J();
    }

    
}
