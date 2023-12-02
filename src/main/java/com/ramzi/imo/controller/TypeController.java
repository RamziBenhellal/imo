package com.ramzi.imo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramzi.imo.model.Type;
import com.ramzi.imo.service.TypeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/type")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TypeController {
	
	private final TypeService typeService;
	
	@GetMapping("/index")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<List<Type>>  index(){
		List<Type> types = typeService.getAll();
		return new ResponseEntity<>(types,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<Type> add(@RequestBody Type type) {
		Type newType = typeService.add(type);
		return new ResponseEntity<>(newType, HttpStatus.CREATED );
		
	}
	
	@GetMapping(path = "/details/{id}")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<Type> details(@PathVariable("id") String id) {
		Type type = typeService.get(id).get(); 
		return new ResponseEntity<>(type,HttpStatus.OK);
	}
	
	@PutMapping(path = "/edit/{id}")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<Type> edit(@RequestBody Type updatedType, @PathVariable("id") Integer id) {
		Type renewType = typeService.update(updatedType, id);
		return new ResponseEntity<>(renewType, HttpStatus.OK );	
	}
	
	@DeleteMapping(path = "/delete/{id}")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		typeService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
}
