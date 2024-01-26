package com.danielks.ListaDeCompras.services;

import com.danielks.ListaDeCompras.entities.ListaDeCompras;
import com.danielks.ListaDeCompras.exceptions.ListaExceptions.ListaNaoEncontradaException;
import com.danielks.ListaDeCompras.models.ListaDeComprasDTO;
import com.danielks.ListaDeCompras.repositories.ListaDeComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<ListaDeComprasDTO> recuperarTodasAsListas(Long id) {
        List<ListaDeCompras> listas = repository.findAll();
        return listas.stream()
                .map(this::converteEmDTO)
                .collect(Collectors.toList());
    }

    public Optional<ListaDeComprasDTO> recuperarListaPorId(Long id) {
        Optional<ListaDeCompras> listaOptional = repository.findById(id);
        if(listaOptional.isPresent()){
            return listaOptional.map(this::converteEmDTO);
        } else {
            throw new ListaNaoEncontradaException(id);
        }
    }
}
