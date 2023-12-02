package com.ramzi.imo.service;

import java.util.List;
import java.util.Optional;

import com.ramzi.imo.model.Sale;
import org.springframework.stereotype.Component;

@Component
public interface SaleService {
	Sale add(Sale Sale);
	Optional<Sale> get(Integer id);
	List<Sale> getAll();
	boolean update(Sale updatedSale,Integer id);
	void remove(Integer id);
}
