package com.ramzi.imo.mongoService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramzi.imo.model.Sale;
import com.ramzi.imo.repository.SaleRepository;
import com.ramzi.imo.service.SaleService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SaleImplementation implements SaleService {
	
	private final SaleRepository SaleRepository;

	@Override
	public Sale add(Sale sale) {
		return SaleRepository.save(sale);
	}

	@Override
	public Optional<Sale> get(Integer id) {
		return SaleRepository.findById(id);
	}

	@Override
	public List<Sale> getAll() {
		return SaleRepository.findAll();
	}

	@Override
	public boolean update(Sale updatedSale, Integer id) {
		return SaleRepository.findById(id)
				.map( Sale ->{
					
					Sale.setSalePrice(updatedSale.getSalePrice());
					//SaleRepository.flush();
					return true;
				}).orElse(false);
	}

	@Override
	public void remove(Integer id) {
		SaleRepository.deleteById(id);
		
	}

}
