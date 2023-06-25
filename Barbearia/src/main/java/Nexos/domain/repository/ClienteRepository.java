package Nexos.domain.repository;

import Nexos.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    void deleteByCpf(String cpf);
    Optional<Cliente> findByCpf(String cpf);
}
