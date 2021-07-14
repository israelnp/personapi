package br.com.israel.personapi.api.assembler;

import br.com.israel.personapi.api.model.PersonModel;
import br.com.israel.personapi.domain.model.Person;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonAssembler {

    @Autowired
    private ModelMapper modelMapper;

    public PersonModel toModel(Person person) {
        return modelMapper.map(person, PersonModel.class);
    }

    public List<PersonModel> toListDeModel(List<Person> jornadasTrabalho) {
        return jornadasTrabalho.stream().map(this::toModel).collect(Collectors.toList());
    }
}
