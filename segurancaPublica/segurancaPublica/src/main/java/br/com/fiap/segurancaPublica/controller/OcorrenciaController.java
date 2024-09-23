package br.com.fiap.segurancaPublica.controller;

import br.com.fiap.segurancaPublica.dto.OcorrenciaCadastroDto;
import br.com.fiap.segurancaPublica.dto.OcorrenciaExibicaoDto;
import br.com.fiap.segurancaPublica.model.Ocorrencia;
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
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService service;

    @PostMapping("/ocorrencia")
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaExibicaoDto gravar(@RequestBody @Valid OcorrenciaCadastroDto ocorrenciaCadastroDto){
        return service.gravar(ocorrenciaCadastroDto);
    }
    @GetMapping("/ocorrencia")
    @ResponseStatus(HttpStatus.OK)
    public Page<OcorrenciaExibicaoDto> listarOcorrencia(Pageable paginacao){
        return service.listarOcorrencia(paginacao);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/ocorrencia/{id}")
    public void remover(@PathVariable Long id){
        service.remover(id);
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/ocorrencia")
    public Ocorrencia atualizarStatus(@RequestBody Ocorrencia ocorrenciaStatus){
        return service.atualizar(ocorrenciaStatus);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/ocorrencia", params = {"dataInicio","dataFim"})
    public List<OcorrenciaExibicaoDto> listarOcorrenciasPorPeriodo(
            @RequestParam LocalDate dataInicio,
            @RequestParam LocalDate dataFim
    ){
        return service.listarOcorrenciasPorPeriodo(dataInicio, dataFim);
    }
}
