package com.convoy.logisticsmanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.convoy.logisticsmanagement.dto.DriverDto;
import com.convoy.logisticsmanagement.dto.ResponseStructure;
import com.convoy.logisticsmanagement.exceptions.CarrierNotFoundException;
import com.convoy.logisticsmanagement.exceptions.DriverAlreadyExistsException;
import com.convoy.logisticsmanagement.exceptions.DriverNotFoundException;
import com.convoy.logisticsmanagement.exceptions.TruckNotFoundException;
import com.convoy.logisticsmanagement.model.Carrier;
import com.convoy.logisticsmanagement.model.Driver;
import com.convoy.logisticsmanagement.model.Truck;
import com.convoy.logisticsmanagement.repository.CarrierRepo;
import com.convoy.logisticsmanagement.repository.DriverRepo;
import com.convoy.logisticsmanagement.repository.TruckRepo;

@Service
public class DriverService {

	@Autowired
	private DriverRepo driverRepo;
	
	@Autowired
	private TruckRepo truckRepo;
	
	@Autowired
	private CarrierRepo carrierRepo;
	
	public ResponseEntity<ResponseStructure<Driver>> saveDriver(DriverDto driverDto) {
		Optional<Driver> driverOpt=driverRepo.findById(driverDto.getId());
		if(driverOpt.isPresent()) {
			throw new DriverAlreadyExistsException();
		}
		Driver driver=new Driver();
		driver.setId(driverDto.getId());
		driver.setName(driverDto.getName());
		driver.setContact(driverDto.getContact());
		driverRepo.save(driver);
		ResponseStructure<Driver> responseStructure=new ResponseStructure<Driver>();
		responseStructure.setStatuscode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Driver Saved");
		responseStructure.setData(driver);
		return new ResponseEntity<ResponseStructure<Driver>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Driver>> findDriver(int id) {
		Optional<Driver> driverOpt=driverRepo.findById(id);
		if(!driverOpt.isPresent()) {
			throw new DriverNotFoundException();
		}
		Driver driver=driverOpt.get();
		ResponseStructure<Driver> responseStructure=new ResponseStructure<Driver>();
		responseStructure.setStatuscode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Driver Found");
		responseStructure.setData(driver);
		return new ResponseEntity<ResponseStructure<Driver>>(responseStructure, HttpStatus.FOUND);
	}

	public ResponseEntity<ResponseStructure<Driver>> deleteDriver(int id) {
		Optional<Driver> driverOpt=driverRepo.findById(id);
		if(!driverOpt.isPresent()) {
			throw new DriverNotFoundException();
		}
		Driver driver=driverOpt.get();
		driverRepo.delete(driver);
		ResponseStructure<Driver> responseStructure=new ResponseStructure<Driver>();
		responseStructure.setStatuscode(HttpStatus.OK.value());
		responseStructure.setMessage("Driver Deleted");
		responseStructure.setData(driver);
		return new ResponseEntity<ResponseStructure<Driver>>(responseStructure, HttpStatus.OK);
		
	}

	public ResponseEntity<ResponseStructure<Driver>> updateDriver(int driverid, int truckid, int carrierid) {
		Driver driver = driverRepo.findById(driverid).orElseThrow(()->new DriverNotFoundException("Driver with "+driverid+" Not Found"));
		Truck truck = truckRepo.findById(truckid).orElseThrow(()->new TruckNotFoundException("Truck with "+truckid+" Not Found"));
		Carrier carrier = carrierRepo.findById(carrierid).orElseThrow(()->new CarrierNotFoundException("Carrier with "+carrierid+" Not Found"));
		
		truck.setCarrier(carrier);
		driver.setTruck(truck);
		driver.setCarrier(carrier);
		
		truckRepo.save(truck);
		driverRepo.save(driver);
		
		ResponseStructure<Driver> responseStructure=new ResponseStructure<Driver>();
		responseStructure.setStatuscode(HttpStatus.ACCEPTED.value());
		responseStructure.setMessage("Driver Updated");
		responseStructure.setData(driver);
		return new ResponseEntity<ResponseStructure<Driver>>(responseStructure, HttpStatus.ACCEPTED);
		
	}

}
