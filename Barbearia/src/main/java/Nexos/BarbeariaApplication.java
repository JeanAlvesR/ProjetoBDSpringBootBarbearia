package Nexos;

import Nexos.domain.entity.Agendamento;
import Nexos.domain.entity.Barbeiro;
import Nexos.domain.entity.Cliente;
import Nexos.domain.entity.Usuario;
import Nexos.domain.entity.enums.Role;
import Nexos.domain.entity.enums.Status;
import Nexos.domain.repository.AgendamentoRepository;
import Nexos.domain.repository.BarbeiroRepository;
import Nexos.domain.repository.ClienteRepository;
import Nexos.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.time.Instant;

@SpringBootApplication
public class BarbeariaApplication {

        @Bean
    public CommandLineRunner commandLineRunner(@Autowired AgendamentoRepository agendamentoRepository, @Autowired UsuarioRepository usuarioRepository, @Autowired BarbeiroRepository barbeiroRepository, @Autowired ClienteRepository clienteRepository){
        return args -> {
            Usuario u1 = new Usuario();
            u1.setCpf("777");
            u1.setRole(Role.barbeiro);

            usuarioRepository.save(u1);

            Barbeiro barbeiro = new Barbeiro();
            barbeiro.setCpf("777");
            barbeiro = barbeiroRepository
                    .save(barbeiro);
            u1.setBarbeiro(barbeiro);

            Usuario u2 = new Usuario();
            u2.setRole(Role.cliente);
            u2.setCpf("666");
            usuarioRepository.save(u2);


            Cliente cliente = new Cliente();
            cliente.setCpf("666");
            cliente = clienteRepository.save(cliente);

            u2.setCliente(cliente);


            Agendamento agendamento = new Agendamento();
            agendamento.setCpf_barbeiro("777");
            agendamento.setData_horario(Timestamp.from(Instant.now()));
            agendamento.setCliente(cliente);
            agendamento.setStatus(Status.andamento);
            agendamento.setValorTotal(100.00);

           agendamento = agendamentoRepository.save(agendamento);
        };
    }
    public static void main(String[] args) {

        SpringApplication.run(BarbeariaApplication.class, args);
    }
}