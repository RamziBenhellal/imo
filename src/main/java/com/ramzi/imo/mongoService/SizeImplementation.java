package com.ramzi.imo.mongoService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramzi.imo.model.Property;
import com.ramzi.imo.model.Size;
import com.ramzi.imo.repository.SizeRepository;
import com.ramzi.imo.service.PropertyService;
import com.ramzi.imo.service.SizeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SizeImplementation implements SizeService{

	private final SizeRepository sizeRepository;
	private final PropertyService propertyService;
	
	@Override
	public Size add(Size size) {
		return sizeRepository.save(size);
	}

	@Override
	public Optional<Size> get(Integer id) {
		return sizeRepository.findById(id);
	}

	@Override
	public List<Size> getAll() {
		return sizeRepository.findAll();
	}

	@Override
	public Size edit(Size updatedSize, Integer id) {
		return null;
	}

	@Override
	public void update(Integer id) {

	}



	@Override
	public void remove(Integer id) {
		sizeRepository.deleteById(id);
	}

	@Override
	public Size addPropertyToSize(Integer id, Integer idProperty) {
		return sizeRepository.findById(id)
				.map( size ->{
					Property property = propertyService.get(idProperty).get();
					size.setProperty(property);
					//sizeRepository.flush();
					return size;
				}).orElse(null);
	}

}
