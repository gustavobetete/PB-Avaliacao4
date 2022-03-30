package br.com.sprint.Avaliacao4.controller.dto;
import br.com.sprint.Avaliacao4.constants.Ideologia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidoDto {

    private Long id;
    private String nome_Partido;
    private String sigla;
    private Ideologia Ideologia;
    private Date data_Fundacao;

}
