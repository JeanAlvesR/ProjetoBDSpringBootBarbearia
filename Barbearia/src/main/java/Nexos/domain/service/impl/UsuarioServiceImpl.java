package Nexos.domain.service.impl;

import Nexos.domain.entity.Usuario;
import Nexos.exceptions.BadRequestException;
import Nexos.domain.repository.UsuarioRepository;
import Nexos.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioPorCpf(String cpf) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByCpf(cpf);
        return usuarioOptional.orElse(null);
    }

    @Override
    public void alterarUsuario(String cpf, Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByCpf(cpf);
        if (usuarioOptional.isPresent()) {
            Usuario usuarioExistente = usuarioOptional.get();

            // Atribuir os campos do usuário fornecido ao usuário existente
            usuarioExistente.setCpf(usuario.getCpf());
            usuarioExistente.setEmail(usuario.getEmail());
            usuarioExistente.setSenha(usuario.getSenha());
            usuarioExistente.setData_registro(usuario.getData_registro());
            usuarioExistente.setRole(usuario.getRole());

            // Salvar o usuário atualizado no banco de dados
            usuarioRepository.save(usuarioExistente);
        }
    }

    @Override
    public void deletarUsuario(String cpf) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByCpf(cpf);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            // Remover o usuário do banco de dados
            usuarioRepository.delete(usuario);
        }
        else{
            throw new BadRequestException("Usuario não existe!");
        }
    }

    @Override
    public void criarUsuario(Usuario usuario) {
        // Salvar o novo usuário no banco de dados
        usuarioRepository.save(usuario);

    }

}
