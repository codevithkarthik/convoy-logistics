package com.convoy.logisticsmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.convoy.logisticsmanagement.model.Cargo;

public interface CargoRepo extends JpaRepository<Cargo, Integer> {

}
