package Nexos.domain.service.impl;

import Nexos.domain.entity.Barbeiro;
import Nexos.exceptions.BadRequestException;
import Nexos.domain.repository.BarbeiroRepository;
import Nexos.domain.service.BarbeiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarbeiroServiceImpl implements BarbeiroService {

    @Autowired
    private BarbeiroRepository barbeiroRepository;

    @Override
    public List<Barbeiro> getBarbeiros() {
        return barbeiroRepository.findAll();
    }

    @Override
    public Barbeiro getBarbeiroPorCPF(String cpf) {
        return barbeiroRepository.findByCpf(cpf).orElse(null);
    }

    @Override
    public void criarBarbeiro(Barbeiro barbeiro) {
        String cpf = barbeiro.getCpf();
        Optional<Barbeiro> barbeiroExistenteOptional = barbeiroRepository.findByCpf(cpf);

        if (barbeiroExistenteOptional.isPresent()) {
            throw new BadRequestException("Há barbeiro com esse CPF!");

        } else {
            // O barbeiro não existe, pode ser criado
            barbeiroRepository.save(barbeiro);
        }
    }

    @Override
    public void alterarBarbeiro(Barbeiro barbeiro) {
        String cpf = barbeiro.getCpf();
        Optional<Barbeiro> barbeiroExistenteOptional = barbeiroRepository.findByCpf(cpf);

        if (barbeiroExistenteOptional.isPresent()) {
            // O barbeiro existe, pode ser atualizado
            barbeiroRepository.save(barbeiro);
        } else {
            throw new BadRequestException("Não há barbeiro com esse CPF!");
        }
    }

    @Override
    public void deletarBarbeiro(String cpf) {
        Optional<Barbeiro> barbeiroExistenteOptional = barbeiroRepository.findById(cpf);

        if (barbeiroExistenteOptional.isPresent()) {
            // O barbeiro existe, pode ser excluído
            barbeiroRepository.deleteById(cpf);
        } else {
            throw new BadRequestException("Não há barbeiro com esse CPF!");
        }
    }



}
