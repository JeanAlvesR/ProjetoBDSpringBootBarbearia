package Nexos.domain.service.impl;

import Nexos.domain.entity.Comentario;
import Nexos.domain.repository.ComentarioRepository;
import Nexos.domain.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Override
    public void criarComentario(Comentario comentario) {
        comentarioRepository.save(comentario);
    }

    @Override
    public void deletarComentario(int comentarioId) {
        comentarioRepository.deleteById(comentarioId);
    }

    @Override
    public List<Comentario> todosComentarios() {
        return comentarioRepository.findAll();
    }

}
