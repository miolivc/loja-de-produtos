/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.loja.de.produtos.factory;

/**
 *
 * @author miolivc
 */
public class DaoFactory {
    public static final int POSTGRES = 0;
    public static final int MONGO = 1;
    public static final int NEO4J = 2;
    
    public static FactoryDaoInterface createFactory(int factoryType){
        if (factoryType == POSTGRES){
            return new PostgresFactoryDao();
        }
        if (factoryType == MONGO){
            return new MongoFactoryDao();
        } 
        if (factoryType == NEO4J){
            return new Neo4JFactoryDao();
        } 
        return null;
    }
    
}
