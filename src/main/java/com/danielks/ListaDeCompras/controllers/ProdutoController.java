package com.danielks.ListaDeCompras.controllers;

import com.danielks.ListaDeCompras.models.ProdutoDTO;
import com.danielks.ListaDeCompras.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    public ProdutoController(ProdutoService service)  {this.service = service;}

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> recuperarTodosProdutos() {
        List<ProdutoDTO> produtos = service.recuperarTodosProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> recuperarProdutoPorId(@PathVariable Long id) {
        Optional<ProdutoDTO> produto = service.recuperarProdutosPorId(id);
        return produto.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        ProdutoDTO produtoCriado = service.criarProduto(produtoDTO);
        return new ResponseEntity<>(produtoCriado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        service.deletarProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
