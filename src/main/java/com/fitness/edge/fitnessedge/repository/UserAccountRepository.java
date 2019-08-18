package com.fitness.edge.fitnessedge.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.fitness.edge.fitnessedge.model.UserAccount;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UserAccountRepository {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public UserAccount createUserAccount(UserAccount userAccount) throws Exception{
		log.info("inserting:"+userAccount.toString());
		userAccount = mongoTemplate.insert(userAccount);
		log.info("inserted:"+userAccount.toString());
		return userAccount;
	}

}
