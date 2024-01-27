package com.danielks.ListaDeCompras.controllers;

import com.danielks.ListaDeCompras.models.ListaDeComprasDTO;
import com.danielks.ListaDeCompras.services.ListaDeComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PostMapping
    public ResponseEntity<ListaDeComprasDTO> criarLista(@RequestBody ListaDeComprasDTO listaDTO){
        ListaDeComprasDTO listaCriada = service.criarLista(listaDTO);
        return new ResponseEntity<>(listaCriada, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        service.deletarLista(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
