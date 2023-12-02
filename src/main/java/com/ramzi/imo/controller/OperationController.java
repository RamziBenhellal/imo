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

import com.ramzi.imo.model.Operation;
import com.ramzi.imo.model.Rent;
import com.ramzi.imo.model.Sale;
import com.ramzi.imo.service.OperationService;
import com.ramzi.imo.service.RentService;
import com.ramzi.imo.service.SaleService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/operation")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class OperationController {
	
	private final OperationService operationService;
	private final RentService rentService;
	private final SaleService saleService;
	
	@GetMapping("/index")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<List<Operation>>  index(){
		List<Operation> operations = operationService.getAll();
		return new ResponseEntity<>(operations,HttpStatus.OK);
	}
	
	@PostMapping("/addrent")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<Rent> addRent(@RequestBody Rent rent) {
		
			Rent newrent = rentService.add(rent);
			return new ResponseEntity<>(newrent, HttpStatus.CREATED ); 
		
	}
	
	@PostMapping("/addsale")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<Sale> addSale(@RequestBody Sale sale) {
		
			Sale newsale = saleService.add(sale);
			return new ResponseEntity<>(newsale, HttpStatus.CREATED ); 
		
	}
	
	@GetMapping(path = "/details/{id}")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<Operation> details(@PathVariable("id") Integer id) {
		Operation operation = operationService.get(id).get();
		return new ResponseEntity<>(operation, HttpStatus.OK ); 
	}
	
	@PutMapping(path = "/edit/{id}")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<Operation> edit(@RequestBody Operation updatedOperation, @PathVariable("id") Integer id) {
		Operation renewOperation = operationService.update(updatedOperation, id);
		return new ResponseEntity<>(renewOperation, HttpStatus.OK );
	}
	
	@DeleteMapping(path = "/delete/{id}")
	@CrossOrigin(origins = "http://localhost:3000/")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		operationService.remove(id);
		return new ResponseEntity<>(HttpStatus.OK );
	}

}
