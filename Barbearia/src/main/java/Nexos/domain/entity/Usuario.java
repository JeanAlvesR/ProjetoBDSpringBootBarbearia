package Nexos.domain.entity;

import Nexos.domain.entity.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
public class Usuario {
    @Id
    private String cpf;
    private String email;
    @JsonIgnore
    private String senha;
    private Timestamp data_registro;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cliente cliente;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Barbeiro barbeiro;

    @Enumerated(EnumType.STRING)
    private Role role;
}
