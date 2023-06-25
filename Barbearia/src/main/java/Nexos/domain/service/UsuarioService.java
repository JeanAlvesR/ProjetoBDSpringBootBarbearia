package Nexos.domain.service;

import Nexos.domain.entity.Usuario;

import java.util.List;

public interface UsuarioService {
    public List<Usuario> getUsuarios();

    Usuario getUsuarioPorCpf(String cpf);

    void alterarUsuario(String cpf, Usuario usuario);

    void deletarUsuario(String cpf);

    void criarUsuario(Usuario usuario);

}
