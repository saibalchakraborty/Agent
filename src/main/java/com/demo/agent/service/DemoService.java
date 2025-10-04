package com.demo.agent.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.agent.model.Person;
import com.demo.agent.repository.PersonRepository;

@Service
public class DemoService {

    @Autowired
    private PersonRepository personRepository;


    public int addPerson(Person person) {
        com.demo.agent.entity.Person p = new com.demo.agent.entity.Person();
        p.setFirstName(person.getFirstName());
        p.setLastName(person.getLastName());
        p.setAge(person.getAge());
        p.setGender(person.getGender());
        p.setEmailId(person.getEmailId());
        p.setPhoneNumber(person.getPhoneNumber());
        com.demo.agent.entity.Person savedPerson = personRepository.save(p);
        return savedPerson.getId();
    }

    public List<Person> getPerson(String firstName) {
        List<com.demo.agent.entity.Person> personEntityList = personRepository.findAll();
        return personEntityList.stream().filter(person -> firstName.equals(person.getFirstName())).map(person -> {
            Person p = new Person();
            p.setFirstName(person.getFirstName());
            p.setLastName(person.getLastName());
            p.setAge(person.getAge());
            p.setGender(person.getGender());
            p.setEmailId(person.getEmailId());
            p.setPhoneNumber(person.getPhoneNumber());
            return p;
        }).collect(Collectors.toList());
    }

}
