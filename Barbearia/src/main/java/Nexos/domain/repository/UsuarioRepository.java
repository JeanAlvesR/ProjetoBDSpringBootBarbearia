package Nexos.domain.repository;

import Nexos.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    void deleteByCpf(String cpf);
    Optional<Usuario> findByCpf(String cpf);
}
