package com.fitness.edge.fitnessedge.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.fitness.edge.fitnessedge.model.Person;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Repository
public class PersonRepository {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void createPerson(Person person) {
		log.info("inserting:"+person.toString());
		mongoTemplate.insert(person);
		log.info("inserted");
	}
	
	public Person getPerson(String id) {
		log.info("Getting Person with ID :"+id);
		Query query =new Query();
		query.addCriteria(Criteria.where("id").is(id));
		return mongoTemplate.findOne(query, Person.class);
	}

}
