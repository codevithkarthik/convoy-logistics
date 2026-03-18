package com.convoy.logisticsmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.convoy.logisticsmanagement.model.Carrier;

@Repository
public interface CarrierRepo extends JpaRepository<Carrier, Integer> {

}
