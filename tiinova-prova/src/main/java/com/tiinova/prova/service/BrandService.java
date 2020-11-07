package com.tiinova.prova.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tiinova.prova.domain.Brand;
import com.tiinova.prova.repository.BrandRepository;

@Service
public class BrandService {
	
	@Autowired
	private BrandRepository brandRepository;

	public List<Brand> findAll() {
		return brandRepository.findAll();
	}

	public void save(Brand vehicle) {
		brandRepository.save(vehicle);	
	}
	
	public void deleteById(long id) {
		brandRepository.deleteById(id);
	}
	
	public Brand findById(long id) {
		Optional<Brand> brand = brandRepository.findById(id);
		
		if(brand.isPresent() == false) {
			throw new EmptyResultDataAccessException("Veiculo Não Encontrado!", 1);
		}
		
		return brand.get();
	}

	public Brand update(long id, Brand brand) {		
		Brand changedBrand = findById(id);		
		BeanUtils.copyProperties(brand, changedBrand, "id");
		
		return brandRepository.save(changedBrand);
	}
}
