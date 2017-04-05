/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.loja.de.produtos.dao.implementation;

import br.edu.ifpb.bdnc.loja.de.produtos.dao.model.VendaDao;
import br.edu.ifpb.bdnc.loja.de.produtos.connection.Neo4JConnection;
import br.edu.ifpb.bdnc.loja.de.produtos.entity.Produto;
import br.edu.ifpb.bdnc.loja.de.produtos.entity.Venda;
import br.edu.ifpb.bdnc.loja.de.produtos.enumeration.Nodes;
import br.edu.ifpb.bdnc.loja.de.produtos.enumeration.Relationships;
import java.util.List;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.ResourceIterator;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;

/**
 *
 * @author miolivc
 */
public class VendaDaoNeo4J implements VendaDao {
    GraphDatabaseService database;
    VendaDaoMongo vendaDaoMongo;

    public VendaDaoNeo4J() {
        database = Neo4JConnection.getConnection();
        vendaDaoMongo = null;
    }
    
    @Override
    public void add(Venda venda) {
        try (Transaction tx = database.beginTx()){
            Node client = database.createNode(Nodes.CLIENTE);
            client.setProperty("cpf", venda.getCliente().getCpf());
            
            for (Produto prod : venda.getProdutos()) {
                Node produto = database.createNode(Nodes.PRODUTO);
                produto.setProperty("codigo", prod.getCodigo());
                
                Relationship comprou = client.createRelationshipTo(produto, Relationships.COMPROU);
                comprou.setProperty("id", venda.getCodigo());
            }
            
            tx.success();
        }
    }

    @Override
    public Venda find(int codigo) {
        Venda venda = null;
        String cypher = "MATCH (c:CLIENTE),(p:PRODUTO)"
                + "match (c)-[r:COMPROU{id: "+ codigo +"}]->(p) return r";
        try (Transaction tx = database.beginTx()){
            Result result = database.execute(cypher);
            ResourceIterator<Integer> resourceIterator = result.columnAs("id");
            while(resourceIterator.hasNext()){
                venda = vendaDaoMongo.find(resourceIterator.next().intValue());
            }
            tx.success();
        }
        return venda;
    }

    @Override
    public List<Venda> list() {
        List<Venda> vendas = null;
        Venda venda = null;
        String cypher = "MATCH (c:CLIENTE),(p:PRODUTO) match (c)-[r:COMPROU]->(p) return r";
        try (Transaction tx = database.beginTx()){
            Result result = database.execute(cypher);
            ResourceIterator<Integer> resourceIterator = result.columnAs("id");
            while(resourceIterator.hasNext()){
                venda = vendaDaoMongo.find(resourceIterator.next().intValue());
                vendas.add(venda);
            }
            tx.success();
        }
        return vendas;
    }

    @Override
    public void delete(int codigo) {
        String cypher = "";
        database.execute(cypher);
    }
}
