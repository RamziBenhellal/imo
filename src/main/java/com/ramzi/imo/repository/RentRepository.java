package com.ramzi.imo.repository;



import com.ramzi.imo.model.Rent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RentRepository extends MongoRepository<Rent, Integer> {

}
