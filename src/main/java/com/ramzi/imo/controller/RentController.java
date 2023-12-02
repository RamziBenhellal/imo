package com.ramzi.imo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramzi.imo.model.Rent;
import com.ramzi.imo.service.RentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/operation/rent")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RentController {
	
	private final RentService rentService;
	
	@GetMapping("/index")
	public List<Rent> index(){
		return rentService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody Rent rent) {
		rentService.add(rent);
	}
	
	@GetMapping(path = "/details/{id}")
	public Optional<Rent> details(@PathVariable("id") Integer id) {
		return rentService.get(id);
	}
	
	@PutMapping(path = "/edit/{id}")
	public boolean edit(@RequestBody Rent updatedRent, @PathVariable("id") Integer id) {
		return rentService.update(updatedRent, id);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		rentService.remove(id);
	}

}
