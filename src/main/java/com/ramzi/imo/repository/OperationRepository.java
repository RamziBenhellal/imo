package com.ramzi.imo.repository;



import com.ramzi.imo.model.Operation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OperationRepository extends MongoRepository<Operation,Integer> {

}
