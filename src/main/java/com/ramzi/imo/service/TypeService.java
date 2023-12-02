package com.ramzi.imo.service;

import java.util.List;
import java.util.Optional;

import com.ramzi.imo.model.Type;
import org.springframework.stereotype.Component;

@Component
public interface TypeService {

	Type add(Type type);
	Optional<Type> get(String name);
	List<Type> getAll();
	Type update(Type updatedSize,Integer id);
	void remove(Integer id);
}
