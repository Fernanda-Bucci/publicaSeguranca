package br.com.fiap.segurancaPublica.controller;

import br.com.fiap.segurancaPublica.dto.LocalCadastroDto;
import br.com.fiap.segurancaPublica.dto.LocalExibicaoDto;
import br.com.fiap.segurancaPublica.dto.OcorrenciaCadastroDto;
import br.com.fiap.segurancaPublica.dto.OcorrenciaExibicaoDto;
import br.com.fiap.segurancaPublica.model.Local;
import br.com.fiap.segurancaPublica.model.Ocorrencia;
import br.com.fiap.segurancaPublica.service.LocalService;
import br.com.fiap.segurancaPublica.service.OcorrenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LocalController {

    @Autowired
    private LocalService service;

    @PostMapping("/local")
    @ResponseStatus(HttpStatus.CREATED)
    public LocalExibicaoDto gravar(@RequestBody @Valid LocalCadastroDto localCadastroDto) {
        return service.gravar(localCadastroDto);
    }

    @GetMapping("/local")
    @ResponseStatus(HttpStatus.OK)
    public Page<LocalExibicaoDto> listarLocal(Pageable paginacao) {
        return service.listarLocal(paginacao);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/local/{idLocal}")
    public void remover(@PathVariable Long idLocal) {
        service.remover(idLocal);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/local")
    public Local atualizarPrioridade(@RequestBody Local localPrioridade) {
        return service.atualizar(localPrioridade);
    }

}