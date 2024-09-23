package br.com.fiap.segurancaPublica.repository;

import br.com.fiap.segurancaPublica.model.Local;
import br.com.fiap.segurancaPublica.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocalRepository extends JpaRepository<Local, Long> {

   Optional<Local> findByCep(String cep);
}
