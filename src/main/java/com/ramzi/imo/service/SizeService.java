package com.ramzi.imo.service;

import java.util.List;
import java.util.Optional;

import com.ramzi.imo.model.Size;
import org.springframework.stereotype.Component;

@Component
public interface SizeService {

	Size add(Size size);
	Optional<Size> get(Integer id);
	List<Size> getAll();
	Size edit(Size updatedSize,Integer id);
	void update(Integer id);
	void remove(Integer id);

	Size addPropertyToSize(Integer id, Integer idProperty);
}
