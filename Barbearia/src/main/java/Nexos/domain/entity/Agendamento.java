package Nexos.domain.entity;

import Nexos.domain.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(AgendamentoId.class)
public class Agendamento {
    @Id
    @Column(name = "cpf_barbeiro")
    private String cpf_barbeiro;

    @Id
    private Timestamp data_horario;
    @MapsId("cpf_barbeiro")
    @JoinColumn(name = "cpf_barbeiro")
    @OneToOne
    @JsonIgnore
    private Barbeiro barbeiro;

    @JoinColumn(name = "cpf_cliente")
    @ManyToOne
    @JsonIgnore
    private Cliente cliente;
    private String descricao;
    private Double valorTotal;
    @Enumerated(EnumType.STRING)
    private Status status;


}
