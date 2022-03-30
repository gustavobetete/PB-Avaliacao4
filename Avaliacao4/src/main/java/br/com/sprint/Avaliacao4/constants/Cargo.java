package br.com.sprint.Avaliacao4.constants;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Cargo {
    VEREADOR("vereador"),
    PREFEITO("prefeito"),
    DEPUTADO_ESTADUAL("deputado_estadual"),
    DEPUTADO_FEDERAL("deputado_federal"),
    SENADOR("senador"),
    GOVERNADOR("governador"),
    PRESIDENTE("presidente"),
    NENHUM("nenhum");

    Cargo(String value) {
        this.value = value;
    }

    private String value;

    @JsonCreator
    public static Cargo fromValue(String value) {
        for (Cargo cargo : Cargo.values()) {
            if (cargo.value.equalsIgnoreCase(value)) {
                return cargo;
            }
        }
        return null;
    }
}

