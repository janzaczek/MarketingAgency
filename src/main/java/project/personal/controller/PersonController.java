package project.personal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.personal.model.Person;
import project.personal.repository.PersonRepository;

import java.util.List;

@RestController
@RequestMapping("/person/")
public class PersonController {

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // wonder which one is better response entity or list
    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPersons(){
        List<Person> personList = personRepository.findAll();
        return new ResponseEntity<>(personList, HttpStatus.OK);
    }

//    @GetMapping("all-list")
//    public List<Person> findAllPersons(){
//        return personRepository.findAll();
//    }

}
