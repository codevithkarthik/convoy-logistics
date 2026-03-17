package com.convoy.logisticsmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.convoy.logisticsmanagement.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

}
