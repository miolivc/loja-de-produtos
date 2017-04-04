/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.loja.de.produtos.entity;

/**
 *
 * @author miolivc
 */
public class Produto {
    private static int codigo = 0;
    private int nome;
    private int descricao;
    private float valor;

    public Produto(int nome, int descricao, float valor) {
        Produto.codigo++;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
    }

    public static int getCodigo() {
        return codigo;
    }

    public int getDescricao() {
        return descricao;
    }

    public void setDescricao(int descricao) {
        this.descricao = descricao;
    }

    public int getNome() {
        return nome;
    }

    public void setNome(int nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", descricao=" + descricao + ", valor=" + valor + '}';
    }

}
