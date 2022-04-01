package br.com.sprint.Avaliacao4.controller.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VinculandoForm {

    private Long idAssociado;
    private Long idPartido;
}
