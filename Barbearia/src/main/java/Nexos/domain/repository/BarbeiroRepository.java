package Nexos.domain.repository;

import Nexos.domain.entity.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BarbeiroRepository extends JpaRepository<Barbeiro, String> {
    void deleteByCpf(String cpf);

    Optional<Barbeiro> findByCpf(String cpf);

}
