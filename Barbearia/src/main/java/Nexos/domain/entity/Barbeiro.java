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
public class Barbeiro {
    @Id
    private String cpf;

    private String nome;

    private String telefone;

    @MapsId("cpf")
    @JoinColumn(name = "cpf")
    @OneToOne
    @JsonIgnore
    private Usuario usuario;

    @Column(name = "media_nota")
    private Double mediaNota;

    @OneToMany
    private List<Comentario> comentarios;

}
