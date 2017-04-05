/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.loja.de.produtos.connection;

import java.io.File;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

/**
 *
 * @author miolivc
 */
public class Neo4JConnection {
    
    public static GraphDatabaseService getConnection(){
        return new GraphDatabaseFactory().newEmbeddedDatabase(new File("/data/db/lista-de-produtos"));
    }
    
}
