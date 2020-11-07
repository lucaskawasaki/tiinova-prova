package com.tiinova.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiinova.prova.domain.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
