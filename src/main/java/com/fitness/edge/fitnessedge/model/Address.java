package com.fitness.edge.fitnessedge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonIgnoreProperties
@JsonInclude(value = Include.NON_NULL)
public class Address {
	private String addressLine1;
	private String addressLine2;
	private String state;
    private String city;
    private String zip;
    private String country;
}
