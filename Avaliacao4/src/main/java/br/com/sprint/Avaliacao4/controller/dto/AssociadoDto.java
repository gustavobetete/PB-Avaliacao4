package br.com.sprint.Avaliacao4.controller.dto;

import br.com.sprint.Avaliacao4.constants.Cargo;
import br.com.sprint.Avaliacao4.constants.Sexo;
import br.com.sprint.Avaliacao4.modelo.Associado;
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
public class AssociadoDto {

    private Long id;
    private String nome;
    private Cargo cargo;
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate data_Nascimento;
    private Sexo sexo;

    public AssociadoDto(Associado associado) {
        this.id = associado.getId();
        this.nome = associado.getNome();
        this.cargo = associado.getCargo();
        this.data_Nascimento = associado.getData_Nascimento();
        this.sexo = associado.getSexo();
    }

    public static Page<AssociadoDto> converter(Page<Associado> associado) {
        return associado.map(AssociadoDto::new);
    }
}
