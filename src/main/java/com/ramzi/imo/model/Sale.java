package com.ramzi.imo.model;

import java.time.LocalDateTime;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Sale extends Operation {
	public Sale(
			Double salePrice, LocalDateTime createdAt) {

		this.salePrice = salePrice;
		this.createdAt = createdAt;
	}

	private Double salePrice;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
