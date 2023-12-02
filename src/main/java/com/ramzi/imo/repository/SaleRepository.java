package com.ramzi.imo.repository;


import com.ramzi.imo.model.Sale;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SaleRepository extends MongoRepository<Sale, Integer> {

}
