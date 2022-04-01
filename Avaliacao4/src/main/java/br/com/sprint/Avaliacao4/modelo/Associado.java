package br.com.sprint.Avaliacao4.modelo;

import br.com.sprint.Avaliacao4.constants.Cargo;
import br.com.sprint.Avaliacao4.constants.Sexo;
import br.com.sprint.Avaliacao4.serializer.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Associado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Cargo cargo;
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate data_Nascimento;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @ManyToOne
    @JoinColumn(name="partido_id")
    private Partido partido;


    public Associado(String nome, Cargo cargo_politico, LocalDate data_nascimento, Sexo sexo) {
        this.nome = nome;
        this.cargo = cargo_politico;
        this.data_Nascimento = data_nascimento;
        this.sexo = sexo;
    }


}
