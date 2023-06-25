package Nexos.domain.service.impl;

import Nexos.domain.entity.Agendamento;
import Nexos.domain.entity.Barbeiro;
import Nexos.domain.entity.Cliente;
import Nexos.domain.entity.enums.Status;
import Nexos.exceptions.BadRequestException;
import Nexos.domain.repository.AgendamentoRepository;
import Nexos.domain.repository.BarbeiroRepository;
import Nexos.domain.repository.ClienteRepository;
import Nexos.domain.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AgendamentoServiceImpl implements AgendamentoService {

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;


    @Override
    public void cancelarAgendamento(String cpfClienteCancelamento, Timestamp dataCancelamento) {
        agendamentoRepository.cancelarAgendamento(cpfClienteCancelamento, dataCancelamento);
    }


    public void criarAgendamento(Agendamento agendamento) {
        String cpfBarbeiro = agendamento.getCpf_barbeiro();
// Capturar a hora e a data atuais
        LocalDateTime dataHorario = LocalDateTime.now();

        // Converter LocalDateTime para Timestamp
        Timestamp timestamp = Timestamp.valueOf(dataHorario);

        agendamento.setData_horario(timestamp);
        // Verificar se o CPF do barbeiro existe no repositório de Barbeiro
        Barbeiro barbeiroExistente = barbeiroRepository.findByCpf(cpfBarbeiro).orElse(null);

        if (barbeiroExistente == null) {
            throw new BadRequestException("Não Há barbeiro com esse CPF!");
        }

        Cliente cliente = agendamento.getCliente();
        if (cliente != null) {
            String cpfCliente = cliente.getCpf();

            // Verificar se o CPF do cliente existe no repositório de Cliente
            Cliente clienteExistente = clienteRepository.findByCpf(cpfCliente).orElse(null);

            if (clienteExistente == null) {
                throw new BadRequestException("Não Há cliente com esse CPF!");

            }
        }

        // Definir o status como "Andamento"
        agendamento.setStatus(Status.andamento);

        // Salvar o agendamento no banco de dados
        Agendamento novoAgendamento = agendamentoRepository.save(agendamento);

        // Retornar o ID do novo agendamento criado
    }

    public List<Agendamento> todosAgendamentos() {
        return agendamentoRepository.findAll();
    }

    public List<Agendamento> agendamentoPorCliente(String cpf_cliente) {
        return agendamentoRepository.findByCliente_Cpf(cpf_cliente);
    }

}
