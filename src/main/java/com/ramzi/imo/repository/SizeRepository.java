package com.ramzi.imo.repository;


import com.ramzi.imo.model.Size;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SizeRepository extends MongoRepository<Size, Integer> {

}
