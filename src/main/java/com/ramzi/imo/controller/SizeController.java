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

import com.ramzi.imo.model.Size;
import com.ramzi.imo.service.SizeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/size")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SizeController {
	
	private final SizeService sizeService;
	
	@GetMapping("/index")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<List<Size>> index(){
		List<Size> sizes = sizeService.getAll(); 
		return new ResponseEntity<>(sizes,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<Size> add(@RequestBody Size size) {
		Size newSize = sizeService.add(size);
		return new ResponseEntity<>(newSize, HttpStatus.CREATED );
	}
	
	@GetMapping(path = "/details/{id}")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<Size> details(@PathVariable("id") Integer id) {
		Size size = sizeService.get(id).get();
		return new ResponseEntity<>(size, HttpStatus.OK );
	}
	
	@PutMapping(path = "/edit/{id}")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<Size> edit(@RequestBody Size updatedSize, @PathVariable("id") Integer id) {
		Size renewSize = sizeService.edit(updatedSize, id);
		return new ResponseEntity<>(renewSize, HttpStatus.OK );	
	}
	
	@DeleteMapping(path = "/delete/{id}")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		sizeService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK );
	}
	
	@PostMapping("/addproperty/{idSize}/{idProperty}")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<Size> addProperty(@PathVariable("idSize") Integer idSize,@PathVariable("idProperty") Integer idProperty) {
		Size size = sizeService.addPropertyToSize( idSize,idProperty);
		return new ResponseEntity<>(size,HttpStatus.OK);
	}

}
