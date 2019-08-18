package com.fitness.edge.fitnessedge.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fitness.edge.fitnessedge.model.Person;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository
public class PersonRepository {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Person createPerson(Person person) throws Exception{
		log.info("inserting:"+person.toString());
		person = mongoTemplate.insert(person);
		log.info("inserted:"+person.toString());
		return person;
	}
	
	public List<Person> getPerson(Person person) throws Exception{
		log.info("getting Person :"+ person);
		HashMap<String,Object> hashMap = new ObjectMapper().convertValue(person, HashMap.class);
		Query query = new Query();
		for(Entry<String, Object> entry : hashMap.entrySet()) {
			query.addCriteria(Criteria.where(entry.getKey()).is(entry.getValue()));
		}
		log.info("query string :"+query.toString());
		return mongoTemplate.find(query, Person.class);
	}

}
