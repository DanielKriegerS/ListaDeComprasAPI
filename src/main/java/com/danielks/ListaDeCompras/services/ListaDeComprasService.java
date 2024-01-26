package com.danielks.ListaDeCompras.services;

import com.danielks.ListaDeCompras.entities.ListaDeCompras;
import com.danielks.ListaDeCompras.models.ListaDeComprasDTO;
import com.danielks.ListaDeCompras.repositories.ListaDeComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListaDeComprasService {

    @Autowired
    private ListaDeComprasRepository repository;

    private ListaDeComprasDTO converteEmDTO(ListaDeCompras entidade) {
        return new ListaDeComprasDTO(
                entidade.getId(),
                entidade.getNome(),
                entidade.getProdutos(),
                entidade.getValorTotal(),
                entidade.getDataCriacao()
        );
    }

    private ListaDeCompras converterEmEntidade(ListaDeComprasDTO modelo) {
        return new ListaDeCompras(
                modelo.id(),
                modelo.nome(),
                modelo.produtos(),
                modelo.valorTotal(),
                modelo.dataCriacao()
        );
    }
}
