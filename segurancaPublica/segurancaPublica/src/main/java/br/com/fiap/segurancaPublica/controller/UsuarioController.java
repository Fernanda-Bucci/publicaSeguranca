package br.com.fiap.segurancaPublica.controller;
import br.com.fiap.segurancaPublica.dto.UsuarioCadastroDto;
import br.com.fiap.segurancaPublica.dto.UsuarioExibicaoDto;
import br.com.fiap.segurancaPublica.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioExibicaoDto salvar(
            @RequestBody @Valid UsuarioCadastroDto usuaarioCadastro){
        return usuarioService.salvarUsuario(usuaarioCadastro);
    }

    @GetMapping("/usuario")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioExibicaoDto> litarTodos(){
        return usuarioService.listarTodos();
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<UsuarioExibicaoDto> buscarPorId(
            @PathVariable Long idUsuario){
        try {
            return ResponseEntity
                    .ok(usuarioService.buscarPorId(idUsuario));
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/usuario/{idUsuario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long idUsuario){
        usuarioService.remover(idUsuario);
    }

    @PutMapping("/usuario")
    public ResponseEntity<UsuarioExibicaoDto> atualizar(@RequestBody UsuarioCadastroDto usuarioCadastroDto) {
        try {
            UsuarioExibicaoDto usuarioExibicaoDto = usuarioService.atualizar(usuarioCadastroDto);
            return ResponseEntity.ok(usuarioExibicaoDto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /*@GetMapping(value = "/usuario", params = "email")
    public UsuarioExibicaoDto buscarPorEmail(@RequestParam String email){
        return usuarioService.buscarPorEmail(email);
    }*/

}

