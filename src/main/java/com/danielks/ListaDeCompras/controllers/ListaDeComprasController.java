package com.danielks.ListaDeCompras.controllers;

import com.danielks.ListaDeCompras.services.ListaDeComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/listas")
public class ListaDeComprasController {
    @Autowired
    private ListaDeComprasService service;

    public ListaDeComprasController(ListaDeComprasService service) {this.service = service;}
}
