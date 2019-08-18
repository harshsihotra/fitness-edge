package com.fitness.edge.fitnessedge.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonIgnoreProperties
@JsonInclude(value = Include.NON_NULL)
@Document(collection = "Address")
public class Address {
	@Id
	@Field("_id")
	private ObjectId id;
	private String addressLine1;
	private String addressLine2;
	private String state;
    private String city;
    private String zip;
}
