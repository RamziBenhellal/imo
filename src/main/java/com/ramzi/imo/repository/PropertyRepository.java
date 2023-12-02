package com.ramzi.imo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ramzi.imo.model.Property;

public interface PropertyRepository extends MongoRepository<Property,String> {
	

}
