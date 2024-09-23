package br.com.fiap.segurancaPublica.service;

import br.com.fiap.segurancaPublica.dto.LocalCadastroDto;
import br.com.fiap.segurancaPublica.dto.LocalExibicaoDto;
import br.com.fiap.segurancaPublica.dto.OcorrenciaCadastroDto;
import br.com.fiap.segurancaPublica.dto.OcorrenciaExibicaoDto;
import br.com.fiap.segurancaPublica.model.Local;
import br.com.fiap.segurancaPublica.model.Ocorrencia;
import br.com.fiap.segurancaPublica.repository.LocalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LocalService {

    @Autowired
    private LocalRepository localRepository;

    public LocalExibicaoDto gravar(LocalCadastroDto localCadastroDto) {
        Local local = new Local();
        BeanUtils.copyProperties(localCadastroDto, local);

        return new LocalExibicaoDto(localRepository.save(local));
    }

    public Page<LocalExibicaoDto> listarLocal(Pageable paginacao) {
        return localRepository
                .findAll(paginacao)
                .map(LocalExibicaoDto::new);
    }

    public void remover(Long id) {
        Optional<Local> LocalOptional = localRepository.findById(id);

        if(LocalOptional.isPresent()){
            localRepository.delete(LocalOptional.get());
        } else {
            throw new RuntimeException("Local não encontrado");
        }
    }

    public Local atualizar(Local local) {

        Optional<Local> localOptional = localRepository.findById(local.getIdLocal());

        if(localOptional.isPresent()){
            return localRepository.save(local);
        } else {
            throw new RuntimeException("Local não encontrado");
        }
    }
}
