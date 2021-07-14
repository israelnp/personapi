package br.com.israel.personapi.domain.service;

import br.com.israel.personapi.domain.model.Person;
import br.com.israel.personapi.domain.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

   private final PersonRepository personRepository;


   public Person savePerson(Person person){
       return personRepository.save(person);
   }

    public List<Person> findAllPeople(){
        return personRepository.findAll();
    }

    public Person findPersonById(Long personId){
        return personRepository.getById(personId);
    }

    public void deletePersonById(Long personId){
       personRepository.deleteById(personId);
    }
}
