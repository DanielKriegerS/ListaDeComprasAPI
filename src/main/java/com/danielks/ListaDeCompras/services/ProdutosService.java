package com.danielks.ListaDeCompras.services;

import com.danielks.ListaDeCompras.repositories.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutosService {
    @Autowired
    private ProdutosRepository repositorio;
}
