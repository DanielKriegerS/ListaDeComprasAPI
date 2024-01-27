package com.danielks.ListaDeCompras.services;

import com.danielks.ListaDeCompras.entities.Produto;
import com.danielks.ListaDeCompras.exceptions.ProdutoExceptions.ProdutoNaoEncontradoException;
import com.danielks.ListaDeCompras.models.ProdutoDTO;
import com.danielks.ListaDeCompras.repositories.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutosRepository repositorio;

    private ProdutoDTO converteEmDTO(Produto entidade){
        return new ProdutoDTO(
                entidade.getId(),
                entidade.getListaId(),
                entidade.getNome(),
                entidade.getValor(),
                entidade.getDataCriacao()
        );
    }

    private Produto converteEmEntidade(ProdutoDTO modelo){
        return new Produto(
                modelo.id(),
                modelo.nome(),
                modelo.valor(),
                modelo.listaId(),
                modelo.dataCriacao()
        );
    }

    public Optional<ProdutoDTO> recuperarTodosProdutos(Long id){
        Optional<Produto> produtoOptional = repositorio.findById(id);
        if(produtoOptional.isPresent()){
            return produtoOptional.map(this::converteEmDTO);
        } else {
            throw new ProdutoNaoEncontradoException(id);
        }
    }

}
