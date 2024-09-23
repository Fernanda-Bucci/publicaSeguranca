package br.com.fiap.segurancaPublica.dto;

import br.com.fiap.segurancaPublica.model.Local;
import br.com.fiap.segurancaPublica.model.Ocorrencia;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record LocalExibicaoDto(
        Long id,
        @NotBlank
        String cep,
        @NotBlank
        String prioridade
) {
    public LocalExibicaoDto(Local local){
        this(
                local.getIdLocal(),
                local.getCep(),
                local.getPrioridade()
        );
    }
}

