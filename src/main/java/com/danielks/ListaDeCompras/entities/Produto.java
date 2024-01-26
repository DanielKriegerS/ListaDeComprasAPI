package com.danielks.ListaDeCompras.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private double valor = 0.0;
    @Column(name = "lista_id")
    private Long listaId;

    public Produto() {
    }

    public Produto(Long id, String nome, double valor, Long listaId) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.listaId = listaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Long getListaId() {
        return listaId;
    }

    public void setListaId(Long listaId) {
        this.listaId = listaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id.equals(produto.id) && listaId.equals(produto.listaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, listaId);
    }
}
