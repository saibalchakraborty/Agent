package com.demo.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.agent.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{
}
