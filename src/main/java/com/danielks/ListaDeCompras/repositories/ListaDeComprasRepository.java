package com.danielks.ListaDeCompras.repositories;

import com.danielks.ListaDeCompras.entities.ListaDeCompras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaDeComprasRepository extends JpaRepository<ListaDeCompras, Long> {
}
