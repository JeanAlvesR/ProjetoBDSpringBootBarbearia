package Nexos.domain.service;

import Nexos.domain.entity.Comentario;

import java.util.List;

public interface ComentarioService {
    void criarComentario(Comentario comentario);

    void deletarComentario(int comentarioId);

    List<Comentario> todosComentarios();
}
