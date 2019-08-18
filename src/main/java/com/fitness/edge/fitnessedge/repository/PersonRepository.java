package com.fitness.edge.fitnessedge.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fitness.edge.fitnessedge.model.Person;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository
public class PersonRepository {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Person createPerson(Person person) {
		log.info("inserting:"+person.toString());
		person = mongoTemplate.insert(person);
		log.info("inserted:"+person.toString());
		return person;
	}
	
	public List<Person> getPerson(Person person) throws Exception{
		log.info("getting Person :"+ person);
		BasicQuery basicQuery = new BasicQuery(new ObjectMapper().writeValueAsString(person));
		log.info("query string :"+basicQuery.toString());
		return mongoTemplate.find(basicQuery, Person.class);
	}

}
