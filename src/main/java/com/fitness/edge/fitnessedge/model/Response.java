package com.fitness.edge.fitnessedge.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class Response {

	private String status;
	private String message;
	private String personId;
	private List<Person> persons;
}
