package com.ramzi.imo.service;

import java.util.List;
import java.util.Optional;

import com.ramzi.imo.model.Rent;
import org.springframework.stereotype.Component;

@Component
public interface RentService {

	Rent add(Rent rent);
	Optional<Rent> get(Integer id);
	List<Rent> getAll();
	boolean update(Rent updatedRent,Integer id);
	void remove(Integer id);
}
