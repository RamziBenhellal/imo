package com.ramzi.imo.mongoService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramzi.imo.model.Rent;
import com.ramzi.imo.repository.RentRepository;
import com.ramzi.imo.service.RentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RentImplementation implements RentService {
	
	
	private final RentRepository rentRepository;

	@Override
	public Rent add(Rent rent) {
		return rentRepository.save(rent);
	}

	@Override
	public Optional<Rent> get(Integer id) {
		return rentRepository.findById(id);
	}

	@Override
	public List<Rent> getAll() {
		return rentRepository.findAll();
	}

	@Override
	public boolean update(Rent updatedRent, Integer id) {
		return rentRepository.findById(id)
				.map( rent ->{
					
					rent.setRentPrice(updatedRent.getRentPrice());
					rent.setDeposit(updatedRent.getDeposit());
					//rentRepository.flush();
					return true;
				}).orElse(false);
	}

	@Override
	public void remove(Integer id) {
		rentRepository.deleteById(id);
		
	}

}
