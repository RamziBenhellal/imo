package com.ramzi.imo.model;


import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@NoArgsConstructor
@Data
@Document
public abstract class Operation {
	public Operation(Property property) {
		this.property = property;}

	@Id
	private String id;
	private Property property;

}
