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

import com.tiinova.prova.domain.Brand;
import com.tiinova.prova.service.BrandService;

@RestController
@RequestMapping("/marcas")
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Brand> toList() {
		return brandService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void salvar(@RequestBody Brand brand) {
		brandService.save(brand);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		brandService.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Brand> update(@PathVariable long id, @Valid @RequestBody Brand brand){
				
		return ResponseEntity.ok(brandService.update(id, brand));
	}
}
