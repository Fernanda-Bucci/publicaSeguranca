package br.com.fiap.segurancaPublica.dto;
import br.com.fiap.segurancaPublica.model.Usuario;

public record UsuarioExibicaoDto(
        Long idUsuario,
        String nome,
        String email,
        String telefone
        )
{
    public UsuarioExibicaoDto(Usuario usuario){
        this(usuario.getIdUsuario(), usuario.getNome(), usuario.getEmail(), usuario.getTelefone());
    }
}
