package com.danielks.ListaDeCompras.models;


import com.danielks.ListaDeCompras.entities.Produto;
import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ListaDeComprasDTO(
        @NotNull Long id,
        @NotBlank (message = "O nome não pode estar em branco!") String nome,
        @NotNull List<Produto> produtos,
        @Negative (message = "O valor da lista não pode estar negativo") double valorTotal
        ) {
}
