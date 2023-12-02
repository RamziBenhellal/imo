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

import com.ramzi.imo.model.Property;
import com.ramzi.imo.service.PropertyService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/property")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PropertyController {

	private final PropertyService propertyService;
	
	@GetMapping("/index")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<List<Property>>  index(){
		List<Property> properties = propertyService.getAll();
		return new ResponseEntity<>(properties,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<Property> add(@RequestBody Property property) {
		Property newProperty = propertyService.add(property);
		return new ResponseEntity<>(newProperty, HttpStatus.CREATED ); 
	}
	
	@GetMapping(path = "/details/{id}")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<Property> details(@PathVariable("id") Integer id) {
		Property property = propertyService.get(id).get();
		return new ResponseEntity<>(property, HttpStatus.OK ); 
	}
	
	@PutMapping(path = "/edit/{id}")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<Property> edit(@RequestBody Property updatedProperty, @PathVariable("id") Integer id) {
		Property renewProperty = propertyService.update(updatedProperty,id);
		return new ResponseEntity<>(renewProperty, HttpStatus.CREATED );
	}
	
	@DeleteMapping(path = "/delete/{id}")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		propertyService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK );
	}

	
	
	
	
	
	
	
}
