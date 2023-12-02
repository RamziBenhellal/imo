 package com.ramzi.imo.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



import lombok.Data;

@Data
@Document
public class Address {
	public Address(String street, String hausNumber, String postalCode, String city, String land, LocalDateTime createdAt) {
		this.street = street;
		this.hausNumber = hausNumber;
		this.postalCode = postalCode;
		this.city = city;
		this.land = land;
		this.createdAt = createdAt;
	}

	@Id
	private String id;
	private String street;
	private String hausNumber;
	private String postalCode;
	private String city;
	private String land;
	private Property property;	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;


	
	
	

}
