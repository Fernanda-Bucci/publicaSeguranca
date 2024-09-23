package br.com.fiap.segurancaPublica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record OcorrenciaCadastroDto(
        Long id,
        @NotBlank
        String tipoOcorrencia,
        @NotNull
        LocalDate dataOcorrencia,
        @NotBlank
        String status,
        @NotBlank
        String descricao,
        @NotBlank
        String email
) {
}
