/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.loja.de.produtos.connection;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author miolivc
 */
public class MongoConnection {
    
    public static MongoDatabase getConnection(){
        return new MongoClient("localhost", 27017).getDatabase("lista-de-produtos");
    }
}
