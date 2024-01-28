package com.danielks.ListaDeCompras.controllers;

import com.danielks.ListaDeCompras.models.ListaDeComprasDTO;
import com.danielks.ListaDeCompras.models.ProdutoDTO;
import com.danielks.ListaDeCompras.services.ListaDeComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/listas")
public class ListaDeComprasController {
    @Autowired
    private ListaDeComprasService service;

    public ListaDeComprasController(ListaDeComprasService service) {this.service = service;}

    @GetMapping
    public ResponseEntity<List<ListaDeComprasDTO>> recuperarTodasAsListas() {
        List<ListaDeComprasDTO> listas = service.recuperarTodasAsListas();
        return new ResponseEntity<>(listas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListaDeComprasDTO> recuperarListaPorId(@PathVariable Long id) {
        Optional<ListaDeComprasDTO> lista = service.recuperarListaPorId(id);
        return lista.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ListaDeComprasDTO> criarLista(@RequestBody ListaDeComprasDTO listaDTO){
        ListaDeComprasDTO listaCriada = service.criarLista(listaDTO);
        return new ResponseEntity<>(listaCriada, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLista(@PathVariable Long id) {
        service.deletarLista(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
