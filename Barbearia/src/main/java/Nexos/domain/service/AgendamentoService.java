package Nexos.domain.service;

import Nexos.domain.entity.Agendamento;

import java.sql.Timestamp;
import java.util.List;

public interface AgendamentoService {
    public void cancelarAgendamento(String cpfClienteCancelamento, Timestamp dataCancelamento);

    public void criarAgendamento(Agendamento agendamento);

    public List<Agendamento> todosAgendamentos();

    public List<Agendamento> agendamentoPorCliente(String cpf_cliente);


}
