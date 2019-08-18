package com.fitness.edge.fitnessedge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.edge.fitnessedge.model.Person;
import com.fitness.edge.fitnessedge.model.Response;
import com.fitness.edge.fitnessedge.repository.PersonRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	@PostMapping("/create")
	public Response createPerson(@RequestBody Person person) {
		Response response = new Response();
		try {
			person = personRepository.createPerson(person);
			if(!StringUtils.isEmpty(person.getId())){
				response.setStatus("200");
				response.setMessage("Success");
				response.setPersonId(person.getId());
			}else {
				response.setStatus("500");
				response.setMessage("Error Inserting person");
			}
		}catch (Exception e) {
			log.error("Error Occurred :", e);
			response.setStatus("500");
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@GetMapping("/get")
	public Response getPerson(Person person) {
		Response response = new Response();
		try {
			response.setStatus("200");
			response.setMessage("Success");
			response.setPersons(personRepository.getPerson(person));
		}catch(Exception e) {
			log.error("Error Occurred :", e);
			response.setStatus("500");
			response.setMessage(e.getMessage());
		}
		return response;
	}

}
