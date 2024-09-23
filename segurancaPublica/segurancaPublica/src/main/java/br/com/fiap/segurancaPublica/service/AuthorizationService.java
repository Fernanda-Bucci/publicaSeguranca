package br.com.fiap.segurancaPublica.service;

import br.com.fiap.segurancaPublica.model.Usuario;
import br.com.fiap.segurancaPublica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorizationService implements UserDetailsService {

    private final UsuarioRepository repository;

    @Autowired
    public AuthorizationService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = repository.findByEmail(username);
        if (usuarioOptional.isPresent()) {
            return usuarioOptional.get();
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado com o email: " + username);
        }
    }
}
