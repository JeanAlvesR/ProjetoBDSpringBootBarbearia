package Nexos.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoId implements Serializable {
    private String cpf_barbeiro;

    private Timestamp data_horario;
}
