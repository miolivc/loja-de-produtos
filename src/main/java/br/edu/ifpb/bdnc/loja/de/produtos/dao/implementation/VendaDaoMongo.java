/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.loja.de.produtos.dao.implementation;

import br.edu.ifpb.bdnc.loja.de.produtos.dao.model.VendaDao;
import br.edu.ifpb.bdnc.loja.de.produtos.connection.MongoConnection;
import br.edu.ifpb.bdnc.loja.de.produtos.entity.Produto;
import br.edu.ifpb.bdnc.loja.de.produtos.entity.Venda;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.eq;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author miolivc
 */
public class VendaDaoMongo implements VendaDao {
    ClienteDaoPostgres clienteDao;
    MongoCollection database;

    public VendaDaoMongo() {
        database = MongoConnection.getConnection().getCollection("venda");
        clienteDao = null;
    }
    
    @Override
    public void add(Venda venda) {
        Document document = new Document("_id", venda.getCodigo())
                .append("cliente", venda.getCliente().getCpf())
                .append("produtos", venda.getProdutos())
                .append("data", venda.getData())
                .append("hora", venda.getHora())
                .append("valor", venda.getValorTotal());
        database.insertOne(document);
    }

    @Override
    public Venda find(int codigo) {
        Venda venda = new Venda();
        MongoCursor cursor = database.find(eq("_id", codigo)).iterator();
        while(cursor.hasNext()){
            Document document = (Document) cursor.next();
            venda.setCliente(clienteDao.find(document.getString("cpf")));
            venda.setData((LocalDate) document.get("data"));
            venda.setHora((LocalTime) document.get("hora"));
            venda.setProdutos((List<Produto>) document.get("produtos"));
            venda.setValorTotal(document.getInteger("valor"));
        }
        return venda;
    }
    
    public List<Venda> list(){
        List<Venda> vendas = null;
        MongoCursor cursor = database.find().iterator();
        while(cursor.hasNext()){
            Venda venda = new Venda();
            Document document = (Document) cursor.next();
            venda.setCliente(clienteDao.find(document.getString("cpf")));
            venda.setData((LocalDate) document.get("data"));
            venda.setHora((LocalTime) document.get("hora"));
            venda.setProdutos((List<Produto>) document.get("produtos"));
            venda.setValorTotal(document.getInteger("valor"));
            vendas.add(venda);
        }
        return vendas;
    }
    
    public void delete(int codigo){
        database.findOneAndDelete(eq("_id", codigo));
    }
}
