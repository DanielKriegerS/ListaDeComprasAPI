package com.danielks.ListaDeCompras.exceptions.ListaExceptions;

import com.danielks.ListaDeCompras.exceptions.EntidadeNaoEncontradaException;

public class ListaNaoEncontradaException extends EntidadeNaoEncontradaException {

    public ListaNaoEncontradaException(Long id) { super("Lista com o ID " + id + " não encontrado!");}
}
