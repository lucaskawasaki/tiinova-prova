package com.tiinova.prova.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tiinova.prova.domain.Vehicle;
import com.tiinova.prova.domain.Brand;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
	
	@Query("SELECT v FROM Vehicle v WHERE v.sold = false")
	List<Vehicle> findVehiclesNotSold();
	
	List<Vehicle> findByBrand(Brand brand);

}
