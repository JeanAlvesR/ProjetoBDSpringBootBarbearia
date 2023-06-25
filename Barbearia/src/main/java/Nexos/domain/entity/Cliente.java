package Nexos.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {
    @Id
    private String cpf;

    private String nome;

    private String telefone;

    @Column(name = "qtd_agendamento")
    private Integer qtdAgendamento;

    @Column(name = "qtd_promocao")
    private Integer qtdPromocao;

    @MapsId("cpf")
    @JoinColumn(name = "cpf")
    @OneToOne
    @JsonIgnore
    private Usuario usuario;
    @OneToMany(mappedBy = "cliente")
    private List<Agendamento> agendamentos;

}
