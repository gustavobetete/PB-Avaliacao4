package br.com.sprint.Avaliacao4.config;
import br.com.sprint.Avaliacao4.constants.Sexo;
import org.springframework.core.convert.converter.Converter;

public class ToUpperCaseEnumSexo implements Converter<String, Sexo> {

    @Override
    public Sexo convert(String value){
        return Sexo.valueOf(value.toUpperCase());
    }
}
