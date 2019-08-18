package com.fitness.edge.fitnessedge.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="Person")
public class Person {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String email;
	private Integer phone;

}
