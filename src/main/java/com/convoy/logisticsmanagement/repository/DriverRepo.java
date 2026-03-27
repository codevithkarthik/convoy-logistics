package com.convoy.logisticsmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.convoy.logisticsmanagement.model.Driver;

@Repository
public interface DriverRepo extends JpaRepository<Driver, Integer> {

}
