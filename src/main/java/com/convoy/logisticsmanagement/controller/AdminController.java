package com.convoy.logisticsmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.convoy.logisticsmanagement.dto.ResponseStructure;
import com.convoy.logisticsmanagement.model.Address;
import com.convoy.logisticsmanagement.service.AddressService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/saveaddress")
	public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody Address address) {
		return addressService.saveAddress(address);
	}
	
	@GetMapping("/findaddress/{id}")
	public ResponseEntity<ResponseStructure<Address>> findAddress(@PathVariable int id) {
		return addressService.findAddress(id);
	}
	
	@DeleteMapping("/deleteaddress/{id}")
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(@PathVariable int id) {
		return addressService.deleteAddress(id);
	}
}
