package Nexos.rest.controller;

import Nexos.domain.entity.Agendamento;
import Nexos.domain.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAgendamento(@RequestBody Agendamento agendamento) {
        agendamentoService.criarAgendamento(agendamento);
    }

    @GetMapping
    public List<Agendamento> todosAgendamentos() {
        return agendamentoService.todosAgendamentos();
    }

    @GetMapping("/cliente/{cpf_cliente}")
    public List<Agendamento> agendamentoPorCliente(@PathVariable String cpf_cliente) {
        return agendamentoService.agendamentoPorCliente(cpf_cliente);
    }

    @DeleteMapping("/{cpfClienteCancelamento}/{dataCancelamento}")
    public void cancelarAgendamento(
            @PathVariable String cpfClienteCancelamento,
            @PathVariable Timestamp dataCancelamento) {
        agendamentoService.cancelarAgendamento(cpfClienteCancelamento, dataCancelamento);
    }

}


