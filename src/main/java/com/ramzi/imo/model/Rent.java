package com.ramzi.imo.model;

import java.time.LocalDateTime;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Rent extends Operation {
	public Rent(
			Double rentPrice, Double deposit, LocalDateTime createdAt) {
		this.rentPrice = rentPrice;
		this.deposit = deposit;
		this.createdAt = createdAt;
	}

	private Double rentPrice;
	private Double deposit;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	

}
