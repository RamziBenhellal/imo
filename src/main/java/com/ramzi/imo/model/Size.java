package com.ramzi.imo.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Size {
	public Size(
			String name, String unity, Double value,LocalDateTime createdAt) {
		this.name = name;
		this.unity = unity;
		this.value = value;
		this.createdAt = createdAt;
	}

	@Id
	private String id;
	private String name;
	private String unity;
	private Double value;
    private Property property;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	
	

}
