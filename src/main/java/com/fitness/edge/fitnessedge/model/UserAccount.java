package com.fitness.edge.fitnessedge.model;

import java.util.Date;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;

@Data
@Document(collection = "UserAccount")
public class UserAccount {

	@Indexed(unique = true)
	private String username;
	private String password;
	@JsonFormat(shape = Shape.STRING, pattern = "MM/dd/YYYY")
	private Date createdDate;
	@JsonFormat(shape = Shape.STRING, pattern = "MM/dd/YYYY HH:mm:ss")
	private Date updatedDateTime;
	@DBRef
	private Person person;
}
