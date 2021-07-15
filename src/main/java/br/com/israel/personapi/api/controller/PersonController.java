package br.com.israel.personapi.api.controller;

import br.com.israel.personapi.api.assembler.PersonAssembler;
import br.com.israel.personapi.api.assembler.PersonInputDisassembler;
import br.com.israel.personapi.api.model.PersonModel;
import br.com.israel.personapi.api.model.input.PersonInput;
import br.com.israel.personapi.domain.exception.BusinessException;
import br.com.israel.personapi.domain.exception.PersonNotFoundException;
import br.com.israel.personapi.domain.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/people", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonService personService;
    private final PersonInputDisassembler personInputDisassembler;
    private final PersonAssembler personAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonModel createPerson(@RequestBody @Valid PersonInput personInput){
        return personAssembler
                .toModel(personService
                            .savePerson(personInputDisassembler
                                        .toDomainObject(personInput)));
    }

    @GetMapping
    public List<PersonModel> getAllPeople(){
        return personAssembler
                .toListDeModel(personService
                        .findAllPeople());
    }

    @GetMapping("/{personId}")
    public PersonModel getPersonById(@PathVariable Long personId){
        try{
            return personAssembler
                    .toModel(personService
                            .findPersonById(personId));
        } catch (PersonNotFoundException e){
             throw new BusinessException(e.getMessage(), e);
        }
    }

    @PutMapping("/{personId}")
    public PersonModel updatePerson(@PathVariable Long personId, @RequestBody PersonInput personInput){
        getPersonById(personId);
        return personAssembler
                .toModel(personService
                        .savePerson(personInputDisassembler
                                .toDomainObject(personInput)));
    }

    @DeleteMapping("/{personId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePersonById(@PathVariable Long personId){
        personService.deletePersonById(personId);
    }
}
