package br.com.sprint.Avaliacao4.controller.form;

import br.com.sprint.Avaliacao4.constants.Ideologia;
import br.com.sprint.Avaliacao4.modelo.Partido;
import br.com.sprint.Avaliacao4.repository.PartidoRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidoForm {

    @NotNull(message = "O campo Nome não pode ser nulo")
    @NotEmpty(message = "O campo Nome não pode ser vazio")
    @NotBlank(message = "O campo Nome não pode estar em branco")
    private String nome_Partido;

    @NotNull(message = "O campo Sigla não pode ser nulo")
    @NotEmpty(message = "O campo Sigla não pode ser vazio")
    @NotBlank(message = "O campo Sigla não pode estar em branco")
    private String sigla;

    @NotNull(message = "O campo Ideologia não pode ser nulo")
    private Ideologia ideologia;

    @NotNull(message = "O campo Data fundação não pode ser nulo")
    private LocalDate data_Fundacao;

    public Partido atualizar(Long id, PartidoRepository partidoRepository) {
        Partido partido = partidoRepository.getOne(id);
        partido.setNome_Partido(this.getNome_Partido());
        partido.setSigla(this.getSigla());
        partido.setIdeologia(this.getIdeologia());
        partido.setData_Fundacao(this.getData_Fundacao());
        return partido;
    }
    public Partido converter(PartidoRepository partidoRepository) {
        return new Partido(nome_Partido, sigla, ideologia, data_Fundacao);
    }
}
