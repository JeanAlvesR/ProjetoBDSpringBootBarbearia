package Nexos.util;

import Nexos.domain.entity.Agendamento;
import Nexos.domain.entity.enums.Status;
import Nexos.domain.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class SchedulerStatusAgendamento {

    private final AgendamentoRepository agendamentoRepository;

    @Autowired
    public SchedulerStatusAgendamento(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    @Scheduled(fixedRate = 3600000) // Executa a cada 1 hora (3600000 milissegundos)
    public void verificarAgendamentos() {
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        LocalDateTime limite = dataHoraAtual.minusMinutes(40);

        List<Agendamento> agendamentos = agendamentoRepository.findByStatusAndDataHorarioBefore(
                Status.andamento, Timestamp.valueOf(limite));

        for (Agendamento agendamento : agendamentos) {
            agendamento.setStatus(Status.concluido);
            agendamentoRepository.save(agendamento);
        }
    }
}

