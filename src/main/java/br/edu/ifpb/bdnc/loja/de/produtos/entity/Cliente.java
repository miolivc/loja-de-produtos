/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.loja.de.produtos.entity;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author miolivc
 */
public class Cliente extends Pessoa {
    private String email;
    private String password;

    public Cliente(String email, String password, String cpf, String nome, LocalDate dataNasc, Endereco endereco) {
        super(cpf, nome, dataNasc, endereco);
        this.email = email;
        this.password = password;
    }

    public Cliente() {
        super(null, null, null, null);
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "email=" + email + ", password=" + password + '}';
    }
    
    
}
