package br.com.fiap.segurancaPublica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record LocalCadastroDto(
        Long id,
        @NotBlank
        String cep,
        @NotBlank
        String prioridade
) {
}
