package br.com.fiap.segurancaPublica.service;

import br.com.fiap.segurancaPublica.dto.UsuarioCadastroDto;
import br.com.fiap.segurancaPublica.dto.UsuarioExibicaoDto;
import br.com.fiap.segurancaPublica.exception.UsuarioNaoEncontradoException;
import br.com.fiap.segurancaPublica.model.Usuario;
import br.com.fiap.segurancaPublica.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioExibicaoDto salvarUsuario(UsuarioCadastroDto usuarioCadastroDto){

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioCadastroDto, usuario);

        return new UsuarioExibicaoDto(usuarioRepository.save(usuario));
    }

    public List<UsuarioExibicaoDto> listarTodos(){
        return usuarioRepository
                .findAll()
                .stream()
                .map(UsuarioExibicaoDto::new)
                .toList();
    }

    public void remover(Long id){
        Optional<Usuario> alimentoOptional =
                usuarioRepository.findById(id);

        if (alimentoOptional.isPresent()){
            usuarioRepository.delete(alimentoOptional.get());
        } else {
            throw new RuntimeException("Usuario não encontrado!");
        }
    }

    public UsuarioExibicaoDto atualizar(UsuarioCadastroDto usuarioCadastroDto) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioCadastroDto.idUsuario());

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setNome(usuarioCadastroDto.nome());
            usuario.setEmail(usuarioCadastroDto.email());
            usuario.setTelefone(usuarioCadastroDto.telefone());

            Usuario atualizado = usuarioRepository.save(usuario);
            return new UsuarioExibicaoDto(
                    atualizado.getIdUsuario(),
                    atualizado.getNome(),
                    atualizado.getEmail(),
                    atualizado.getTelefone()
            );
        } else {
            throw new UsuarioNaoEncontradoException("Usuario não existe!");
        }
    }

    public UsuarioExibicaoDto buscarPorId(Long idUsuario){
        Optional<Usuario> usuarioOptional =
                usuarioRepository.findById(idUsuario);

        if (usuarioOptional.isPresent()){
            return new UsuarioExibicaoDto(usuarioOptional.get());
        } else {
            throw new UsuarioNaoEncontradoException("Usuario não existe!");
        }
    }

    public UsuarioExibicaoDto buscarPorEmail(String email){
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);

        if (usuarioOptional.isPresent()){
            return new UsuarioExibicaoDto(usuarioOptional.get());
        } else {
            throw new UsuarioNaoEncontradoException("Usuario não existe!");
        }
    }

}
