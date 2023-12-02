package com.ramzi.imo.mongoService;

import java.util.List;
import java.util.Optional;

import com.ramzi.imo.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ramzi.imo.model.Property;
import com.ramzi.imo.service.PropertyService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))

public class PropertyImplementation implements PropertyService {

public final PropertyRepository propertyRepository;
	@Override
	public Property add(Property property) {
		return propertyRepository.insert(property);
	}

	@Override
	public Optional<Property> get(Integer id) {
		return Optional.empty();
	}

	@Override
	public List<Property> getAll() {
		return propertyRepository.findAll();
	}

	@Override
	public Property update(Property updatedProperty, Integer id) {
		return null;
	}

	@Override
	public void remove(Integer id) {

	}
}
