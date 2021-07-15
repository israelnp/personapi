package br.com.israel.personapi.domain.service;

import br.com.israel.personapi.domain.exception.EntityInUseException;
import br.com.israel.personapi.domain.exception.PersonNotFoundException;
import br.com.israel.personapi.domain.model.Person;
import br.com.israel.personapi.domain.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private static final String PERSON_IN_USE_MSG
            = "The person code %d can not be to delete because it is in use";

    private final PersonRepository personRepository;


    public Person savePerson(Person person){
       return personRepository.save(person);
   }

    public List<Person> findAllPeople(){
        return personRepository.findAll();
    }

    public Person findPersonById(Long personId){
       var person = personRepository.getById(personId);
        isNullPerson(personId, person);
        return person;
    }

    public void deletePersonById(Long personId){
        try{
            personRepository.delete(findPersonById(personId));
        } catch (EmptyResultDataAccessException e){
            throw new PersonNotFoundException(personId);
        } catch (DataIntegrityViolationException e){
            throw new EntityInUseException(String.format(PERSON_IN_USE_MSG, personId));
        }
    }

    private void isNullPerson(Long personId, Person person) {
        if(person==null){
            throw new PersonNotFoundException(personId);
        }
    }
}
