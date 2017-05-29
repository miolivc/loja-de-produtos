/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.loja.de.produtos.factory;

import br.edu.ifpb.bdnc.loja.de.produtos.dao.model.*;
import br.edu.ifpb.bdnc.loja.de.produtos.dao.implementation.VendaDaoMongo;

/**
 *
 * @author miolivc
 */
public class MongoFactoryDao implements FactoryDaoInterface {

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
        return new VendaDaoMongo();
    }
    
}
