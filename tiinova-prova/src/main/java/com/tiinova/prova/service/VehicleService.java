package com.tiinova.prova.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tiinova.prova.domain.Vehicle;
import com.tiinova.prova.repository.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;

	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}

	public void save(Vehicle vehicle) {
		vehicleRepository.save(vehicle);	
	}
	
	public void deleteById(long id) {
		vehicleRepository.deleteById(id);
	}
	
	public Vehicle findById(long id) {
		Optional<Vehicle> vehicle = vehicleRepository.findById(id);
		
		if(vehicle.isPresent() == false) {
			throw new EmptyResultDataAccessException("Veiculo Não Encontrado!", 1);
		}
		
		return vehicle.get();
	}

	public Vehicle update(long id, Vehicle vehicle) {
		Vehicle changedVehicle = findById(id);		
		BeanUtils.copyProperties(vehicle, changedVehicle, "id");
		
		return vehicleRepository.save(changedVehicle);
	}
}
