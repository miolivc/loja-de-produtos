/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.bdnc.loja.de.produtos.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author miolivc
 */
public class Venda {
    private static int codigo = 0;
    private List<Produto> produtos;
    private Cliente cliente;
    private LocalDate data;
    private LocalTime hora;
    private float valorTotal;
    
    public Venda(){
        Venda.codigo++;
        this.produtos = new ArrayList<>();
        this.cliente = cliente;
        this.data = LocalDate.now();
        this.hora = LocalTime.now();
        this.valorTotal = 0;
    }

    public static int getCodigo() {
        return codigo;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public static void setCodigo(int codigo) {
        Venda.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Venda{" + "produtos=" + produtos + ", cliente=" + cliente + ", data=" + data + ", hora=" + hora + ", valorTotal=" + valorTotal + '}';
    }
    
}
