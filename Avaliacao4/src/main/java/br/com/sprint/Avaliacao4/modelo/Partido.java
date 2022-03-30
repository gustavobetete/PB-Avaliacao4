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
    private Ideologia Ideologia;
    private Date data_Fundacao;

}
