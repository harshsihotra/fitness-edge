package com.fitness.edge.fitnessedge.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.fitness.edge.fitnessedge.model.Person;

@Repository
public class PersonRepository {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public void createPerson(Person person) {
		mongoTemplate.insert(person);
	}
	
	public Person getPerson(String id) {
		Query query =new Query();
		query.addCriteria(Criteria.where("id").is(id));
		return mongoTemplate.findOne(query, Person.class);
	}

}
