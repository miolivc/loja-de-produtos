/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.loja.de.produtos.dao.model;

import br.edu.ifpb.bdnc.loja.de.produtos.entity.Venda;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author miolivc
 */
public interface VendaDao {
    
    public void add(Venda venda);
    public Venda find(int codigo);
    public List<Venda> list();
    public void delete(int codigo);
    
}
