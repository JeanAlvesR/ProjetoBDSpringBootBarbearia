package Nexos.domain.repository;

import Nexos.domain.entity.Agendamento;
import Nexos.domain.entity.AgendamentoId;
import Nexos.domain.entity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, AgendamentoId> {

    List<Agendamento> findByCliente_Cpf(String cpf);


    @Query(value = "SELECT * FROM agendamento WHERE status = :status_ AND data_horario < :dataHorario_", nativeQuery = true)
    List<Agendamento> findByStatusAndDataHorarioBefore(@Param("status_") Status status_, @Param("dataHorario_") Timestamp dataHorario_);


    @Query(value = "SELECT cancelar_agendamento(:cpf_cliente_cancelamento, :data_cancelamento)", nativeQuery = true)
    void cancelarAgendamento(@Param("cpf_cliente_cancelamento") String cpfClienteCancelamento, @Param("data_cancelamento") Timestamp dataCancelamento);


}
