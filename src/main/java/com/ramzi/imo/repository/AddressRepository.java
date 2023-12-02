package com.ramzi.imo.repository;



import com.ramzi.imo.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address, Integer> {

}
