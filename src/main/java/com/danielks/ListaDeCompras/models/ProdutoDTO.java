package com.danielks.ListaDeCompras.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ProdutoDTO(
        @NotNull Long id,
        @NotNull Long listaId,
        @NotBlank(message = "O nome não pode estar em branco") String nome,
        @NotBlank(message = "O valor não pode ser 0") double valor,
        LocalDate dataCriacao
) {
}
