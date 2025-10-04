package com.demo.agent.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.agent.model.Person;
import com.demo.agent.service.DemoService;

@RestController
@RequestMapping("/v1/person/")
public class DemoController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private DemoService demoService;

    @GetMapping(value = "getPerson/{firstName}")
    public ResponseEntity<List<Person>> getPerson(@PathVariable("firstName") String firstName){
        log.info("--[ Begin fetch Person : {} ]--", firstName);
        List<Person> person = demoService.getPerson(firstName);
        log.info("--[ No of Person found with firstName : {} : {}]--", firstName, person.size());
        return new ResponseEntity<List<Person>>(person, HttpStatus.OK);
    }

    @PostMapping(value = "savePerson")
    public ResponseEntity<String> addPerson(@RequestBody Person person){
        log.info("--[ Begin save Person : {} ]--", person);
        int personId = demoService.addPerson(person);
        return new ResponseEntity<String>("For reference : Saved person with ID - " + personId + "", HttpStatus.OK);
    }


}

