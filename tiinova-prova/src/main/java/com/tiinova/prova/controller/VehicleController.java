package com.tiinova.prova.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tiinova.prova.domain.Vehicle;
import com.tiinova.prova.service.VehicleService;

@RestController
@RequestMapping("/veiculos")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Vehicle> toList() {
		return vehicleService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void salvar(@RequestBody Vehicle vehicle) {
		vehicleService.save(vehicle);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		vehicleService.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Vehicle> alterarPessoa(@PathVariable long id, @Valid @RequestBody Vehicle vehicle){
				
		return ResponseEntity.ok(vehicleService.update(id, vehicle));
	}
}
