/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.loja.de.produtos.factory;

import br.edu.ifpb.bdnc.loja.de.produtos.dao.model.*;
import br.edu.ifpb.bdnc.loja.de.produtos.dao.implementation.ClienteDaoPostgres;
import java.sql.SQLException;

/**
 *
 * @author miolivc
 */
public class PostgresFactoryDao implements FactoryDaoInterface {

    @Override
    public ClienteDao createClienteDao() {
        try {
            return new ClienteDaoPostgres();
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Falha na classe de retorno DAO para postgres");
        }
        return null;
    }

    @Override
    public ProdutoDao createProdutoDao() {
        return null;
    }

    @Override
    public VendaDao createVendaDao() {
        return null;
    }

    
}
