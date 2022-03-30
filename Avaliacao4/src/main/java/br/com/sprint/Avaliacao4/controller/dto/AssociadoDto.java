package br.com.sprint.Avaliacao4.controller.dto;

import br.com.sprint.Avaliacao4.constants.Cargo;
import br.com.sprint.Avaliacao4.constants.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssociadoDto {

    private Long id;
    private String nome;
    private Cargo cargo_Politico;
    private Date data_Nascimento;
    private Sexo sexo;
}
