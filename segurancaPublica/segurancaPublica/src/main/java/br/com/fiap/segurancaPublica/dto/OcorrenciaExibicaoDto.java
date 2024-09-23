package br.com.fiap.segurancaPublica.dto;

import br.com.fiap.segurancaPublica.model.Ocorrencia;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record OcorrenciaExibicaoDto(
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
    public OcorrenciaExibicaoDto(Ocorrencia ocorrencia){
        this(
                ocorrencia.getId(),
                ocorrencia.getTipoOcorrencia(),
                ocorrencia.getDataOcorrencia(),
                ocorrencia.getStatus(),
                ocorrencia.getDescricao(),
                ocorrencia.getEmail()
        );
    }
}