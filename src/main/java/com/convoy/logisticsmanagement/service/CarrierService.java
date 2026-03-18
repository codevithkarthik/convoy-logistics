package com.convoy.logisticsmanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.convoy.logisticsmanagement.dto.ResponseStructure;
import com.convoy.logisticsmanagement.exceptions.CarrierAlreadyExistsException;
import com.convoy.logisticsmanagement.exceptions.CarrierNotFoundException;
import com.convoy.logisticsmanagement.model.Carrier;
import com.convoy.logisticsmanagement.repository.CarrierRepo;

@Service
public class CarrierService {
	
	@Autowired
	private CarrierRepo carrierRepo;

	public ResponseEntity<ResponseStructure<Carrier>> saveCarrier(Carrier carrier) {
		Optional<Carrier> carrierOpt=carrierRepo.findById(carrier.getId());
		if(carrierOpt.isPresent()) {
			throw new CarrierAlreadyExistsException();
		}
		carrierRepo.save(carrier);
		ResponseStructure<Carrier> responseStructure=new ResponseStructure<Carrier>();
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Carrier Saved");
		responseStructure.setData(carrier);
		return new ResponseEntity<ResponseStructure<Carrier>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Carrier>> findCarrier(int id) {
		Optional<Carrier> carrierOpt=carrierRepo.findById(id);
		if(carrierOpt.isEmpty()) {
			throw new CarrierNotFoundException();
		}
		Carrier carrier=carrierOpt.get();
		ResponseStructure<Carrier> responseStructure= new ResponseStructure<Carrier>();
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Carrier Found");
		responseStructure.setData(carrier);
		return new ResponseEntity<ResponseStructure<Carrier>>(responseStructure, HttpStatus.FOUND);
		
	}

	public ResponseEntity<ResponseStructure<Carrier>> deleteCarrier(int id) {
		Optional<Carrier> carrierOpt=carrierRepo.findById(id);
		if(carrierOpt.isEmpty()) {
			throw new CarrierNotFoundException();
		}
		Carrier carrier=carrierOpt.get();
		carrierRepo.delete(carrier);
		ResponseStructure<Carrier> responseStructure= new ResponseStructure<Carrier>();
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setMessage("Carrier Deleted");
		responseStructure.setData(carrier);
		return new ResponseEntity<ResponseStructure<Carrier>>(responseStructure, HttpStatus.OK);
		
	}
	
	
}
