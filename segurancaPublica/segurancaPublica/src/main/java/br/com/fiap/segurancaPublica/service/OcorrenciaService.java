package br.com.fiap.segurancaPublica.service;

import br.com.fiap.segurancaPublica.dto.OcorrenciaCadastroDto;
import br.com.fiap.segurancaPublica.dto.OcorrenciaExibicaoDto;
import br.com.fiap.segurancaPublica.model.Ocorrencia;
import br.com.fiap.segurancaPublica.repository.OcorrenciaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    public OcorrenciaExibicaoDto gravar(OcorrenciaCadastroDto ocorrenciaCadastroDto) {
        Ocorrencia ocorrencia = new Ocorrencia();
        BeanUtils.copyProperties(ocorrenciaCadastroDto, ocorrencia);

        return new OcorrenciaExibicaoDto(ocorrenciaRepository.save(ocorrencia));
    }

    public Page<OcorrenciaExibicaoDto> listarOcorrencia(Pageable paginacao) {
        return ocorrenciaRepository
                .findAll(paginacao)
                .map(OcorrenciaExibicaoDto::new);
    }

    public void remover(Long id) {
        Optional<Ocorrencia> ocorrenciaOptional = ocorrenciaRepository.findById(id);

        if(ocorrenciaOptional.isPresent()){
            ocorrenciaRepository.delete(ocorrenciaOptional.get());
        } else {
            throw new RuntimeException("Ocorrencia não encontrada");
        }
    }

    public List<OcorrenciaExibicaoDto> listarOcorrenciasPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {
        return ocorrenciaRepository
                .listarOcorrenciasPorPeriodo(dataInicio, dataFim)
                .stream()
                .map(OcorrenciaExibicaoDto::new)
                .toList();
    }

    public Ocorrencia atualizar(Ocorrencia ocorrencia) {

        Optional<Ocorrencia> ocorrenciaOptional = ocorrenciaRepository.findById(ocorrencia.getId());

        if(ocorrenciaOptional.isPresent()){
            return ocorrenciaRepository.save(ocorrencia);
        } else {
            throw new RuntimeException("Ocorrencia não encontrada");

        }
    }
}
