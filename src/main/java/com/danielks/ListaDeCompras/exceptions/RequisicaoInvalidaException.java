package com.danielks.ListaDeCompras.exceptions;

import com.sun.jdi.request.InvalidRequestStateException;

public class RequisicaoInvalidaException extends InvalidRequestStateException {
    public RequisicaoInvalidaException(String mensagem) {super(mensagem);    }
}
