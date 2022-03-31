package br.com.sprint.Avaliacao4.config.validacao;

import lombok.Getter;

@Getter
public class ErroDeFormularioDto {

    private String nome;
    private String erro;

    public ErroDeFormularioDto(String campo, String erro) {
        this.nome = campo;
        this.erro = erro;
    }
}
