package br.com.fiap.segurancaPublica.repository;

import br.com.fiap.segurancaPublica.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

   Optional<Usuario> findByEmail(String email);

}
