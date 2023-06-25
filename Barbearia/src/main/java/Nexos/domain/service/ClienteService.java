package Nexos.domain.service;

import Nexos.domain.entity.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> getClientes();

    Cliente getClientePorCPF(String cpf);

    void criarCliente(Cliente cliente);

    void alterarCliente(Cliente cliente);

    void deletarCliente(String cpf);

}
