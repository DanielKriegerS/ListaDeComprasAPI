package com.danielks.ListaDeCompras.repositories;

import com.danielks.ListaDeCompras.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produto, Long> {
}
