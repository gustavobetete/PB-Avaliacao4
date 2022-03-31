package br.com.sprint.Avaliacao4.modelo;

import br.com.sprint.Avaliacao4.constants.Cargo;
import br.com.sprint.Avaliacao4.constants.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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
    private Date data_Nascimento;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    public Associado(String nome, Cargo cargo_politico, Date data_nascimento, Sexo sexo) {
        this.nome = nome;
        this.cargo = cargo_politico;
        this.data_Nascimento = data_nascimento;
        this.sexo = sexo;
    }


}
