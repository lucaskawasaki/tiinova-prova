package com.tiinova.prova.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tiinova.prova.domain.Brand;
import com.tiinova.prova.domain.Vehicle;
import com.tiinova.prova.repository.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;	

	@Autowired
	private BrandService brandService;

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
		vehicle.setUpdated(Calendar.getInstance().getTime());
		
		Vehicle changedVehicle = findById(id);		
		BeanUtils.copyProperties(vehicle, changedVehicle, "id");
		
		return vehicleRepository.save(changedVehicle);
	}
	
	public List<Vehicle> findVehiclesNotSold() {
		return vehicleRepository.findVehiclesNotSold();
	}
	
	public List<Vehicle> findByBrand(long id){
		Brand brand = brandService.findById(id);
		return vehicleRepository.findByBrand(brand);
	}
}
