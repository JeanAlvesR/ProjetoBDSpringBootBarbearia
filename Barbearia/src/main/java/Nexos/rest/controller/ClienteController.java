package Nexos.rest.controller;


import Nexos.domain.entity.Cliente;
import Nexos.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    @GetMapping("/{cpf}")
    public Cliente getClientePorCPF(@PathVariable String cpf) {
        return clienteService.getClientePorCPF(cpf);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarCliente(@RequestBody Cliente cliente) {
        clienteService.criarCliente(cliente);
    }

    @PutMapping
    public void alterarCliente(@RequestBody Cliente cliente) {
        clienteService.alterarCliente(cliente);
    }

    @DeleteMapping("/{cpf}")
    public void deletarCliente(@PathVariable String cpf) {
        clienteService.deletarCliente(cpf);
    }
}

