package br.com.fiap.segurancaPublica.repository;

import br.com.fiap.segurancaPublica.model.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {

        public Optional<Ocorrencia> findByTipoOcorrencia(String tipoocorrencia);

        @Query("SELECT o FROM Ocorrencia o WHERE o.dataOcorrencia BETWEEN :dataInicio AND :dataFim")
        public List<Ocorrencia> listarOcorrenciasPorPeriodo(
                @Param("dataInicio") LocalDate dataInicio,
                @Param("dataFim") LocalDate dataFim
        );

}
