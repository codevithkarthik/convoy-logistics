package com.convoy.logisticsmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.convoy.logisticsmanagement.model.Truck;

@Repository
public interface TruckRepo extends JpaRepository<Truck, Integer> {

}
