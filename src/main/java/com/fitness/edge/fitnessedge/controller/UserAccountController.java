package com.fitness.edge.fitnessedge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.edge.fitnessedge.model.Person;
import com.fitness.edge.fitnessedge.model.Response;
import com.fitness.edge.fitnessedge.model.UserAccount;
import com.fitness.edge.fitnessedge.repository.PersonRepository;
import com.fitness.edge.fitnessedge.repository.UserAccountRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/userAccount")
public class UserAccountController {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	UserAccountRepository accountRepository;

	@PostMapping("/register")
	private Response registerUserAccount(UserAccount account) {
		Response response = new Response();
		try {
			if(null!= account.getPerson()) {
				account.getPerson().setUsername(account.getUsername());
				Person person = personRepository.createPerson(account.getPerson());
				account.setPerson(person);
			}
			accountRepository.createUserAccount(account);
			response.setStatus("200");
			response.setMessage("Registered");
		} catch (Exception e) {
			log.error("Error Occurred"+e);
			response.setStatus("500");
			response.setMessage(e.getMessage());
		}

		return response;
	}
}
