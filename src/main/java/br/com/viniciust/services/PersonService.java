package br.com.viniciust.services;

import br.com.viniciust.exception.ResourceNotFoundException;
import br.com.viniciust.model.Person;
import br.com.viniciust.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//cuida da injeção de dependencia
@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public Person create(Person person) {
        return repository.save(person);
    }

    public void delete(Long id) {
         Person entity =  repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records"));
          repository.delete(entity);
    }

    public Person update(Person person) {
        Person entity =repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAdress(person.getAdress());
        entity.setGender(person.getGender());
        return repository.save(entity);

    }

    public Person findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records"));
    }

    public List<Person> findAll() {
        return repository.findAll();
    }


}


