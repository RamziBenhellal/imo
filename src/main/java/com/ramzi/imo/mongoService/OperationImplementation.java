package com.ramzi.imo.mongoService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramzi.imo.model.Operation;
import com.ramzi.imo.model.Rent;
import com.ramzi.imo.model.Sale;
import com.ramzi.imo.repository.OperationRepository;
import com.ramzi.imo.service.OperationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OperationImplementation implements OperationService {
	
	private final OperationRepository operationRepository;

	@Override
	public Operation add(Operation operation) {
		return operationRepository.save(operation);
	}

	@Override
	public Optional<Operation> get(Integer id) {
		return operationRepository.findById(id);
	}

	@Override
	public List<Operation> getAll() {
		return operationRepository.findAll();
	}

	@Override
	public Operation update(Operation updatedOperation, Integer id) {
		return operationRepository.findById(id)
				.map( operation ->{
					if(operation instanceof Rent) {
						((Rent)operation).setRentPrice(((Rent)updatedOperation).getRentPrice());
						((Rent)operation).setDeposit(((Rent)updatedOperation).getDeposit());
					}
					else if(operation instanceof Sale) {
						((Sale)operation).setSalePrice(((Sale)updatedOperation).getSalePrice());
					}
					//operationRepository.flush();
					return operation;
				}).orElse(null);
	}

	@Override
	public void remove(Integer id) {
		operationRepository.deleteById(id);
	}

}
