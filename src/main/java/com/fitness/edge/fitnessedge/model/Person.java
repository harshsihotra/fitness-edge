package com.fitness.edge.fitnessedge.model;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
@JsonIgnoreProperties
@Document(collection="Person")
public class Person {

	@Id
	@Field("_id")
	private ObjectId id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String email;
	private String phone;
	@DBRef
	private Address address;

}
