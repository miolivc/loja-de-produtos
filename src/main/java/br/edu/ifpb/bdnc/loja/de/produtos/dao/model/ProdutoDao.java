/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.loja.de.produtos.dao.model;

import br.edu.ifpb.bdnc.loja.de.produtos.entity.Produto;
import java.util.List;

/**
 *
 * @author miolivc
 */
public interface ProdutoDao {
    public void add(Produto produto);
    public List<Produto> list();
    public Produto find(String nome);
    public Produto find(int codigo);
    public void delete(String nome);
    public void delete(int codigo);
    public void edit(Produto produto);
}
