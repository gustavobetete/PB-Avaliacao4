package br.com.sprint.Avaliacao4.config;

import br.com.sprint.Avaliacao4.constants.Cargo;
import org.springframework.core.convert.converter.Converter;

public class ToUpperCaseEnumCargo implements Converter<String, Cargo> {

    @Override
    public Cargo convert(String value){
        return Cargo.valueOf(value.toUpperCase());
    }
}
