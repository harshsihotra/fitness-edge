package com.fitness.edge.fitnessedge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.edge.fitnessedge.model.Person;
import com.fitness.edge.fitnessedge.repository.PersonRepository;

@RestController
@RequestMapping("/user")
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	@PostMapping("/create")
	public void createPerson(@RequestBody Person person) {
		personRepository.createPerson(person);
	}

	@GetMapping("/get/{id}")
	public Person getPerson(@PathVariable String id) {
		return personRepository.getPerson(id);
	}

}
