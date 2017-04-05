/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.loja.de.produtos.enumeration;

import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

/**
 *
 * @author miolivc
 */
public enum Relationships implements RelationshipType {
    COMPROU;
}
