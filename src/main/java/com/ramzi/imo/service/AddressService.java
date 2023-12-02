package com.ramzi.imo.service;

import java.util.List;
import java.util.Optional;

import com.ramzi.imo.model.Address;
import org.springframework.stereotype.Component;

public interface AddressService {

	Address add(Address address);
	Optional<Address> get(Integer id);
	List<Address> getAll();
	Address update(Address updatedAddress,Integer id);
	void remove(Integer id);
}
