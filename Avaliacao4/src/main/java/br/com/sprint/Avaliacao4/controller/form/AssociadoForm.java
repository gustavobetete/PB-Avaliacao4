package br.com.sprint.Avaliacao4.controller.form;

import br.com.sprint.Avaliacao4.constants.Cargo;
import br.com.sprint.Avaliacao4.constants.Sexo;
import br.com.sprint.Avaliacao4.modelo.Associado;
import br.com.sprint.Avaliacao4.repository.AssociadoRepository;
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
public class AssociadoForm {

    @NotNull(message = "O campo Nome não pode ser nulo")
    @NotEmpty(message = "O campo Nome não pode ser vazio")
    @NotBlank(message = "O campo Nome não pode estar em branco")
    private String nome;

    @NotNull(message = "O campo Cargo Politico não pode ser nulo")
    private Cargo cargo;

    @NotNull(message = "O campo Data não pode ser nulo")
    private LocalDate data_Nascimento;

    @NotNull(message = "O campo Sexo não pode ser nulo")
    private Sexo sexo;

    public Associado atualizar(Long id, AssociadoRepository associadoRepository) {
        Associado associado = associadoRepository.getOne(id);
        associado.setNome(this.nome);
        associado.setCargo(this.cargo);
        associado.setData_Nascimento(this.data_Nascimento);
        associado.setSexo(this.sexo);
        return associado;
    }
    public Associado converter(AssociadoRepository associadoRepository) {
        return new Associado(nome, cargo, data_Nascimento, sexo);
    }
}
