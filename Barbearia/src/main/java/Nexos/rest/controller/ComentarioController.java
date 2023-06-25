package Nexos.rest.controller;

import Nexos.domain.entity.Comentario;
import Nexos.domain.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarComentario(@RequestBody Comentario comentario) {
        comentarioService.criarComentario(comentario);
    }

    @DeleteMapping("/{comentarioId}")
    public void deletarComentario(@PathVariable int comentarioId) {
        comentarioService.deletarComentario(comentarioId);
    }

    @GetMapping
    public List<Comentario> todosComentarios() {
        return comentarioService.todosComentarios();
    }
}

