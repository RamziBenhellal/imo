package com.ramzi.imo.mongoService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramzi.imo.model.Address;
import com.ramzi.imo.repository.AddressRepository;
import com.ramzi.imo.service.AddressService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AddressImplementation implements AddressService{

	
	private final AddressRepository addressRepository;
	
	
	@Override
	public Address add(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Optional<Address> get(Integer id) {
		return addressRepository.findById(id);
	}

	@Override
	public List<Address> getAll() {
		return addressRepository.findAll();
	}

	@Override
	public Address update(Address updatedAddress, Integer id) {
		return addressRepository.findById(id)
				.map( address ->{
					address.setStreet(updatedAddress.getStreet());
					address.setHausNumber(updatedAddress.getHausNumber());
					address.setPostalCode(updatedAddress.getPostalCode());
					address.setCity(updatedAddress.getCity());
					address.setLand(updatedAddress.getLand());
					//addressRepository.flush();
					return address;
				}).orElse(null);
	}

	@Override
	public void remove(Integer id) {
		addressRepository.deleteById(id);

		
	}

}
