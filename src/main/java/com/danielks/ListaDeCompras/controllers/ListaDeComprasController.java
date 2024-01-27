package com.danielks.ListaDeCompras.controllers;

import com.danielks.ListaDeCompras.models.ListaDeComprasDTO;
import com.danielks.ListaDeCompras.services.ListaDeComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
