package com.ramzi.imo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramzi.imo.model.Address;
import com.ramzi.imo.service.AddressService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/address")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddressController {
	
	private final AddressService addressService;
	
	@GetMapping("/index")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<List<Address>> index(){
		List<Address> addresses = addressService.getAll();
		return new ResponseEntity<>(addresses,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<Address> add(@RequestBody Address address) {
		Address newAddress = addressService.add(address);
		return new ResponseEntity<>(newAddress, HttpStatus.CREATED );
	}
	
	@GetMapping(path = "/details/{id}")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<Address> details(@PathVariable("id") Integer id) {
		Address address = addressService.get(id).get();
		return new ResponseEntity<>(address, HttpStatus.OK );
	}
	
	@PutMapping(path = "/edit/{id}")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<Address> edit(@RequestBody Address updatedAddress, @PathVariable("id") Integer id) {
		Address renewAddress = addressService.update(updatedAddress, id);
		return new ResponseEntity<>(renewAddress, HttpStatus.OK );	}
	
	@DeleteMapping(path = "/delete/{id}")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		addressService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK );
	}

}
