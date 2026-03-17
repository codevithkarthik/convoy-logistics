package com.convoy.logisticsmanagement.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.convoy.logisticsmanagement.dto.ResponseStructure;
import com.convoy.logisticsmanagement.exceptions.AddressAlreadyExistsException;
import com.convoy.logisticsmanagement.exceptions.AddressNotFoundException;
import com.convoy.logisticsmanagement.model.Address;
import com.convoy.logisticsmanagement.repository.AddressRepo;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepo addressRepo;

	public ResponseEntity<ResponseStructure<Address>> saveAddress(Address address) {
		Optional<Address> addOpt=addressRepo.findById(address.getId());
		if(addOpt.isPresent()) {
			throw new AddressAlreadyExistsException();
		}
		addressRepo.save(address);
		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Address Saved");
		responseStructure.setData(address);
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<Address>> findAddress(int id) {
		Optional<Address> addOpt=addressRepo.findById(id);
		if(addOpt.isEmpty()) {
			throw new AddressNotFoundException();
		}
		Address address=addOpt.get();
		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Address Found");
		responseStructure.setData(address);
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.FOUND);
		
	}

	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id) {
		Optional<Address> addOpt=addressRepo.findById(id);
		if(addOpt.isEmpty()) {
			throw new AddressNotFoundException();
		}
		Address address=addOpt.get();
		addressRepo.delete(address);
		ResponseStructure<Address> responseStructure = new ResponseStructure<Address>();
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setMessage("Address Deleted");
		responseStructure.setData(address);
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
		
	}

}
