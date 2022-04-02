package br.com.sprint.Avaliacao4.config;
import br.com.sprint.Avaliacao4.constants.Ideologia;
import br.com.sprint.Avaliacao4.constants.Sexo;
import org.springframework.core.convert.converter.Converter;

public class ToUpperCaseEnumIdeologia implements Converter<String, Ideologia> {

    @Override
    public Ideologia convert(String value){
        return Ideologia.valueOf(value.toUpperCase());
    }
}
