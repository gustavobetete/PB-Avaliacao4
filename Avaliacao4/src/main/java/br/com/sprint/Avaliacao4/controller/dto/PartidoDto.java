package br.com.sprint.Avaliacao4.controller.dto;

import br.com.sprint.Avaliacao4.constants.Ideologia;
import br.com.sprint.Avaliacao4.modelo.Partido;
import br.com.sprint.Avaliacao4.serializer.LocalDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidoDto {

    private Long id;
    private String nome_Partido;
    private String sigla;
    private Ideologia ideologia;
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate data_Fundacao;

    public PartidoDto(Partido partido) {
        this.id = partido.getId();
        this.nome_Partido = partido.getNome_Partido();
        this.sigla = partido.getSigla();
        this.ideologia = partido.getIdeologia();
        this.data_Fundacao = partido.getData_Fundacao();

    }

    public static Page<PartidoDto> converter(Page<Partido> partido) {
        return partido.map(PartidoDto::new);
    }
}
