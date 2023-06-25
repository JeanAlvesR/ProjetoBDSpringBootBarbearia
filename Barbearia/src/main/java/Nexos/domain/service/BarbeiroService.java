package Nexos.domain.service;

import Nexos.domain.entity.Barbeiro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BarbeiroService {
    List<Barbeiro> getBarbeiros();

    Barbeiro getBarbeiroPorCPF(String cpf);

    void alterarBarbeiro(Barbeiro barbeiro);

    void deletarBarbeiro(String cpf);

    void criarBarbeiro(Barbeiro barbeiro);
}
