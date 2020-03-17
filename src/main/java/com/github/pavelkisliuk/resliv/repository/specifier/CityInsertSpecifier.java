package com.github.pavelkisliuk.resliv.repository.specifier;

import com.github.pavelkisliuk.resliv.entity.City;
import com.github.pavelkisliuk.resliv.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CityInsertSpecifier {
	private CityRepository cityRepository;

	@Autowired
	public void setRepository(CityRepository repository) {
		this.cityRepository = repository;
	}

	@Transactional
	public void insert(City city) {
		city.setName(city.getName().toUpperCase());
		cityRepository.save(city);
	}
}