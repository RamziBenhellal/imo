package com.ramzi.imo.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
@Document
public class Property {
	public Property(String name, String description, Address address, List<Size> sizes, Type type, Operation operation, LocalDateTime createdAt) {
		this.name = name;
		this.description = description;
		this.address = address;
		this.sizes = sizes;
		this.type = type;
		this.operation = operation;
		this.createdAt = createdAt;
	}

	@Id
	private String id;
	private String name;
	private String description;
	private Address address;
	private List<Size> sizes ;
	private Type type;	
	private Operation operation;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
