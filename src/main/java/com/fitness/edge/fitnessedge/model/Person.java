package com.fitness.edge.fitnessedge.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="Person")
public class Person {

	private ObjectId id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String email;
	private String phone;
	private Address address;

}
