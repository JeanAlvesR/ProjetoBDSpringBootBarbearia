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

    @MapsId("cpf")
    @JoinColumn(name = "cpf")
    @OneToOne
    @JsonIgnore
    private Usuario usuario;

    @Column(name = "qtd_agendamento")
    private Integer qtdAgendamento;

    @Column(name = "qtd_promocao")
    private Integer qtdPromocao;

    @OneToMany(mappedBy = "cliente")
    private List<Agendamento> agendamentos;

}
