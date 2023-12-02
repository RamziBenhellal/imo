package com.ramzi.imo.repository;



import com.ramzi.imo.model.Type;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TypeRepository extends MongoRepository<Type, Integer> {

	Type findByName(String name);
}
