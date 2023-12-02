package com.ramzi.imo.mongoService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramzi.imo.model.Type;
import com.ramzi.imo.repository.TypeRepository;
import com.ramzi.imo.service.TypeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TypeImplementation implements TypeService {

	private final TypeRepository typeRepository;
	@Override
	public Type add(Type type) {
		return typeRepository.save(type);
	}

	@Override
	public Optional<Type> get(String name) {
		return Optional.of(typeRepository.findByName(name));
	}

	@Override
	public List<Type> getAll() {
		return typeRepository.findAll();
	}

	@Override
	public Type update(Type updatedType, Integer id) {
		return typeRepository.findById(id)
				.map( type ->{
					type.setName(updatedType.getName());
					//typeRepository.flush();
					return type;
				}).orElse(null);
	}

	@Override
	public void remove(Integer id) {
		typeRepository.deleteById(id);		
	}

}
