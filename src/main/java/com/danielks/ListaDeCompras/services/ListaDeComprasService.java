package com.danielks.ListaDeCompras.services;

import com.danielks.ListaDeCompras.entities.ListaDeCompras;
import com.danielks.ListaDeCompras.exceptions.ListaExceptions.ListaNaoEncontradaException;
import com.danielks.ListaDeCompras.exceptions.RequisicaoInvalidaException;
import com.danielks.ListaDeCompras.models.ListaDeComprasDTO;
import com.danielks.ListaDeCompras.repositories.ListaDeComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListaDeComprasService {

    @Autowired
    private ListaDeComprasRepository repositorio;

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

    public List<ListaDeComprasDTO> recuperarTodasAsListas() {
        List<ListaDeCompras> listas = repositorio.findAll();
        return listas.stream()
                .map(this::converteEmDTO)
                .collect(Collectors.toList());
    }

    public Optional<ListaDeComprasDTO> recuperarListaPorId(Long id) {
        Optional<ListaDeCompras> listaOptional = repositorio.findById(id);
        if(listaOptional.isPresent()){
            return listaOptional.map(this::converteEmDTO);
        } else {
            throw new ListaNaoEncontradaException(id);
        }
    }

    public ListaDeComprasDTO criarLista(ListaDeComprasDTO listaDTO) {
        if(listaDTO.nome() == null ||listaDTO.nome().equals("")) {
            throw new RequisicaoInvalidaException("O nome da lista não pode ser vazio");
        }
        ListaDeCompras lista = converterEmEntidade(listaDTO);
        lista.setDataCriacao(LocalDate.now());

        lista = repositorio.save(lista);
        return converteEmDTO(lista);
    }

    public ListaDeComprasDTO atualizarLista(Long id, ListaDeComprasDTO listaAtualizadaDTO) {
        Optional<ListaDeCompras> optionalLista = repositorio.findById(id);

        if (optionalLista.isPresent()){
            ListaDeCompras listaExistente = optionalLista.get();

            if(listaAtualizadaDTO.nome() != null){
                listaExistente.setNome(listaAtualizadaDTO.nome());
            }
            if(listaAtualizadaDTO.valorTotal() != listaExistente.getValorTotal()){
                listaExistente.setValorTotal(listaAtualizadaDTO.valorTotal());
            }

            if(listaAtualizadaDTO.produtos().size() != listaExistente.getProdutos().size()){
                listaExistente.setProdutos(listaAtualizadaDTO.produtos());
            }

            listaExistente = repositorio.save(listaExistente);
            return converteEmDTO(listaExistente);
        } else {
            throw new ListaNaoEncontradaException(id);
        }
    }

    public void deletarLista(Long id) { repositorio.deleteById(id);}
}
