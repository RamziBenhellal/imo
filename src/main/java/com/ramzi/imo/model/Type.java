package com.ramzi.imo.model;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;



@Data
@Document
public class Type {
	public Type(String name, LocalDateTime createdAt) {
		this.name = name;
		this.createdAt = createdAt;
	}

	@Id
	private String id;
	private String name;
	private Set<Property> properties;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	
}
