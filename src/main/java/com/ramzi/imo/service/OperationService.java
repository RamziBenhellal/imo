package com.ramzi.imo.service;

import java.util.List;
import java.util.Optional;

import com.ramzi.imo.model.Operation;
import org.springframework.stereotype.Component;

@Component
public interface OperationService {

	Operation add(Operation operation);
	Optional<Operation> get(Integer id);
	List<Operation> getAll();
	Operation update(Operation updatedOperation,Integer id);
	void remove(Integer id);
}
