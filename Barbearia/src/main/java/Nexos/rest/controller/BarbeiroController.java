package Nexos.rest.controller;

import Nexos.domain.entity.Barbeiro;
import Nexos.domain.service.BarbeiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barbeiros")
public class BarbeiroController {

    @Autowired
    private BarbeiroService barbeiroService;

    @GetMapping
    public List<Barbeiro> getBarbeiros() {
        return barbeiroService.getBarbeiros();
    }

    @GetMapping("/{cpf}")
    public Barbeiro getBarbeiroPorCPF(@PathVariable String cpf) {
        return barbeiroService.getBarbeiroPorCPF(cpf);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarBarbeiro(@RequestBody Barbeiro barbeiro) {
        barbeiroService.criarBarbeiro(barbeiro);
    }

    @PutMapping
    public void alterarBarbeiro(@RequestBody Barbeiro barbeiro) {
        barbeiroService.alterarBarbeiro(barbeiro);
    }

    @DeleteMapping("/{cpf}")
    public void deletarBarbeiro(@PathVariable String cpf) {
        barbeiroService.deletarBarbeiro(cpf);
    }
}
