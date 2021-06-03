package br.com.viniciust.controller;

import br.com.viniciust.model.Person;
import br.com.viniciust.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService services;

    @GetMapping(value="/{id}")
    public Person findById(@PathVariable("id") Long id){
        return services.findById(id);
    }

    @GetMapping(value = "/all")
    public List<Person> findAll(){
        return services.findAll();
    }

    @PostMapping
    public Person create(@RequestBody Person person){
        return services.create(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
         services.delete(id);
         return  ResponseEntity.ok().build();
    }

   @PutMapping
    public Person update(@RequestBody Person person){
        return services.update(person);
    }
}
