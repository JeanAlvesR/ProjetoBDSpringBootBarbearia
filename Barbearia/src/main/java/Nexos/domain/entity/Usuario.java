package Nexos.domain.entity;

import Nexos.domain.entity.enums.Role;
import Nexos.domain.entity.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
public class Usuario {
    @Id
    private String cpf;
    private String email;
    private String senha;
    private Timestamp data_registro;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cliente cliente;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Barbeiro barbeiro;

    @Enumerated(EnumType.STRING)
    private Role role;
}
