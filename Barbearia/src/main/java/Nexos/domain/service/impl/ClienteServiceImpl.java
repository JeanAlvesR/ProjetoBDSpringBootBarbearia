package Nexos.domain.service.impl;

import Nexos.domain.entity.Barbeiro;
import Nexos.domain.entity.Cliente;
import Nexos.domain.entity.Usuario;
import Nexos.exceptions.BadRequestException;
import Nexos.domain.repository.BarbeiroRepository;
import Nexos.domain.repository.ClienteRepository;
import Nexos.domain.repository.UsuarioRepository;
import Nexos.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private BarbeiroRepository barbeiroRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getClientePorCPF(String cpf) {
        return clienteRepository.findByCpf(cpf).orElse(null);
    }

    @Override
    public void criarCliente(Cliente cliente) {
        String cpf = cliente.getCpf();

        // Verificar se já existe um usuário com o CPF informado na tabela Usuario
        Usuario usuarioExistente = usuarioRepository.findByCpf(cpf).orElse(null);

        // Verificar se o CPF não está presente na tabela Barbeiro
        Barbeiro barbeiroExistente = barbeiroRepository.findByCpf(cpf).orElse(null);

        if (usuarioExistente == null || barbeiroExistente != null) {
            throw new BadRequestException("Já existe barbeiro cadastrado ou não consta usuário com esse CPF!");
        } else {
            // O cliente pode ser criado
            clienteRepository.save(cliente);
        }
    }

    @Override
    public void alterarCliente(Cliente cliente) {
        String cpf = cliente.getCpf();
        Optional<Cliente> clienteExistenteOptional = clienteRepository.findByCpf(cpf);

        if (clienteExistenteOptional.isPresent()) {
            // O cliente existe, pode ser atualizado
            clienteRepository.save(cliente);
        } else {
            throw new BadRequestException("Cliente não existe!");
        }
    }

    @Override
    public void deletarCliente(String cpf) {
        Optional<Cliente> clienteExistenteOptional = clienteRepository.findByCpf(cpf);

        if (clienteExistenteOptional.isPresent()) {
            // O cliente existe, pode ser excluído
            clienteRepository.deleteByCpf(cpf);
        } else {
            throw new BadRequestException("Não há cliente com esse CPF!");
        }
    }

}
