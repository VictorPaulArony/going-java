package com.person.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.person.repository.PersonRepository;
import com.person.model.Person;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    // Create a new person
    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    // Get all people
    @GetMapping
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    // Get a person by id
    @GetMapping("/{id}")
    public Optional<Person> getPersonById(@PathVariable Long id) {
        return personRepository.findById(id);
    }

    // Update a person
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person personDetails) {
        return personRepository.findById(id)
                .map(person -> {
                    person.setName(personDetails.getName());
                    person.setAge(personDetails.getAge());
                    return personRepository.save(person);
                })
                .orElseGet(() -> {
                    personDetails.setId(id);
                    return personRepository.save(personDetails);
                });
    }

    // Delete a person
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
    }
}
