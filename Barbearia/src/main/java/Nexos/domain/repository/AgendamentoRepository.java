package Nexos.domain.repository;

import Nexos.domain.entity.Agendamento;
import Nexos.domain.entity.AgendamentoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, AgendamentoId> {
}
