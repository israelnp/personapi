package br.com.israel.personapi.api.assembler;

import br.com.israel.personapi.api.model.input.PersonInput;
import br.com.israel.personapi.domain.model.Person;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;

    public Person toDomainObject(PersonInput personInput) {
        return modelMapper.map(personInput, Person.class);
    }
}