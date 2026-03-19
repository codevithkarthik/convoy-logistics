package com.convoy.logisticsmanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.convoy.logisticsmanagement.dto.ResponseStructure;
import com.convoy.logisticsmanagement.dto.TruckDto;
import com.convoy.logisticsmanagement.exceptions.CarrierNotFoundException;
import com.convoy.logisticsmanagement.exceptions.TruckAlreadyExistsException;
import com.convoy.logisticsmanagement.exceptions.TruckNotFoundException;
import com.convoy.logisticsmanagement.model.Carrier;
import com.convoy.logisticsmanagement.model.Truck;
import com.convoy.logisticsmanagement.repository.CarrierRepo;
import com.convoy.logisticsmanagement.repository.TruckRepo;

@Service
public class TruckService {
	@Autowired
	private TruckRepo truckRepo;
	
	@Autowired
	private CarrierRepo carrierRepo;

	public ResponseEntity<ResponseStructure<Truck>> saveTruck(TruckDto truckDto) {
		Optional<Truck> truckOpt=truckRepo.findById(truckDto.getId());
		if(truckOpt.isPresent()) {
			throw new TruckAlreadyExistsException();
		}
		Truck truck = new Truck();
		truck.setId(truckDto.getId());
		truck.setName(truckDto.getName());
		truck.setNumber(truckDto.getNumber());
		truck.setCapacity(truckDto.getCapacity());
		truck.setStatus(truckDto.getStatus());
		truckRepo.save(truck);
		ResponseStructure<Truck> responseStructure = new ResponseStructure<Truck>();
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Truck Saved");
		responseStructure.setData(truck);
		return new ResponseEntity<ResponseStructure<Truck>>(responseStructure, HttpStatus.CREATED);
		
	}

	public ResponseEntity<ResponseStructure<Truck>> findTruck(int id) {
		Optional<Truck> truckOpt=truckRepo.findById(id);
		if(truckOpt.isEmpty()) {
			throw new TruckNotFoundException();
		}
		Truck truck=truckOpt.get();
		ResponseStructure<Truck> responseStructure = new ResponseStructure<Truck>();
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Truck Found");
		responseStructure.setData(truck);
		return new ResponseEntity<ResponseStructure<Truck>>(responseStructure, HttpStatus.FOUND);
		
		
	}

	public ResponseEntity<ResponseStructure<Truck>> deleteTruck(int id) {
		Optional<Truck> truckOpt=truckRepo.findById(id);
		if(truckOpt.isEmpty()) {
			throw new TruckNotFoundException();
		}
		Truck truck=truckOpt.get();
		truckRepo.delete(truck);
		ResponseStructure<Truck> responseStructure = new ResponseStructure<Truck>();
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setMessage("Truck Deleted");
		responseStructure.setData(truck);
		return new ResponseEntity<ResponseStructure<Truck>>(responseStructure, HttpStatus.OK);
		
	}

	public ResponseEntity<ResponseStructure<Truck>> updateTruck(int truckid, int carrierid) {
		Truck truck = truckRepo.findById(truckid).orElseThrow(()->new TruckNotFoundException("Truck with id "+truckid+" Not Found"));
		Carrier carrier = carrierRepo.findById(carrierid).orElseThrow(()->new CarrierNotFoundException("Carrier with id "+carrierid+" Not Found"));
		truck.setCarrier(carrier);
		truckRepo.save(truck);
		ResponseStructure<Truck> responseStructure = new ResponseStructure<Truck>();
		responseStructure.setStatuscode(HttpStatus.ACCEPTED.value());
		responseStructure.setMessage("Truck Updated");
		responseStructure.setData(truck);
		return new ResponseEntity<ResponseStructure<Truck>>(responseStructure, HttpStatus.ACCEPTED);
	}
	
	
}
