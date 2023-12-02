package com.ramzi.imo.service;

import java.util.List;
import java.util.Optional;
import com.ramzi.imo.model.Property;
import org.springframework.stereotype.Component;

@Component
public interface PropertyService {
	
	Property add(Property property);
	Optional<Property> get(Integer id);
	List<Property> getAll();
	Property update(Property updatedProperty,Integer id);
	void remove(Integer id);
	
	

}
