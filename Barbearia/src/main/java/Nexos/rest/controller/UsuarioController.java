package Nexos.rest.controller;

import Nexos.domain.entity.Usuario;
import Nexos.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @GetMapping("/{cpf}")
    public Usuario getUsuarioPorCpf(@PathVariable String cpf) {
        return usuarioService.getUsuarioPorCpf(cpf);
    }

    @PutMapping("/{cpf}")
    public void alterarUsuario(@PathVariable String cpf, @RequestBody Usuario usuario) {
        usuarioService.alterarUsuario(cpf, usuario);
    }

    @DeleteMapping("/{cpf}")
    public void deletarUsuario(@PathVariable String cpf) {
        usuarioService.deletarUsuario(cpf);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarUsuario(@RequestBody Usuario usuario) {
        usuarioService.criarUsuario(usuario);
    }
}
