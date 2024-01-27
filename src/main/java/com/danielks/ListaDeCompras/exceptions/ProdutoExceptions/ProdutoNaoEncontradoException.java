package com.danielks.ListaDeCompras.exceptions.ProdutoExceptions;

import com.danielks.ListaDeCompras.exceptions.EntidadeNaoEncontradaException;

public class ProdutoNaoEncontradoException extends EntidadeNaoEncontradaException {

    public ProdutoNaoEncontradoException(Long id) { super("Produto com o ID " + id + " não encontrado!");}
}
