/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.loja.de.produtos.manager;

import br.edu.ifpb.bdnc.loja.de.produtos.dao.implementation.ProdutoDaoPostgres;
import br.edu.ifpb.bdnc.loja.de.produtos.dao.model.ProdutoDao;
import br.edu.ifpb.bdnc.loja.de.produtos.entity.Produto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author miolivc
 */
public class ProdutoManager {
    ProdutoDao produtoDao = null;
    
    public ProdutoManager() throws SQLException, ClassNotFoundException{
        produtoDao = new ProdutoDaoPostgres();
    }
    
    public void add(int codigo, String nome, String descricao, float valor){
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setValor(valor);
        produtoDao.add(produto);
    }
    
    public void update(int codigo, String nome, String descricao, float valor){
        Produto produto = new Produto();
        produto.setCodigo(codigo);
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setValor(valor);
        produtoDao.edit(produto);
    }
    
    public List<Produto> list(){
        List<Produto> produtos = produtoDao.list();
        return produtos;
    }
    
    public Produto find(int codigo){
        Produto produto = produtoDao.find(codigo);
        return produto;
    }
    
    public Produto find(String nome){
        Produto produto = produtoDao.find(nome);
        return produto;
    }
    
    public void delete(int codigo){
        produtoDao.delete(codigo);
    }
    
    public void delete(String nome){
        produtoDao.delete(nome);
    }
}
