package com.fitness.edge.fitnessedge.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Address")
public class Address {
	private String addressLine1;
	private String addressLine2;
	private String state;
    private String city;
    private String zip;
}
