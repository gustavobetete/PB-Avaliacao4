package br.com.sprint.Avaliacao4.modelo;

import br.com.sprint.Avaliacao4.constants.Ideologia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome_Partido;
    private String sigla;
    @Enumerated(EnumType.STRING)
    private Ideologia ideologia;
    private Date data_Fundacao;

    public Partido(String nome_partido, String sigla, Ideologia ideologia, Date data_fundacao) {
        this.nome_Partido = nome_partido;
        this.sigla = sigla;
        this.ideologia = ideologia;
        this.data_Fundacao = data_fundacao;
    }
}
