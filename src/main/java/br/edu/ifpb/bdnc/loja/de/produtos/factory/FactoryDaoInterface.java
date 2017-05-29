/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.loja.de.produtos.factory;

import br.edu.ifpb.bdnc.loja.de.produtos.dao.model.*;

/**
 *
 * @author miolivc
 */
public interface FactoryDaoInterface {
    
    ClienteDao createClienteDao();
    ProdutoDao createProdutoDao();
    VendaDao createVendaDao();

}
