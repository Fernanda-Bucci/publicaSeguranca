package br.com.fiap.segurancaPublica.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCadastroDto(
        Long idUsuario,

        @NotBlank(message = "Nome do usuário é obrigatório!")
        String nome,

        @NotBlank(message = "E-mail é obrigatório!")
        @Email(message = "E-mail inválido")
        String email,


        @NotBlank(message = "Nome do usuário é obrigatório!")
        @Size(min = 8, max = 10, message = "O telefone deve conter nó mínimo 8 no máximo 10")
        String telefone
        )
{

}
