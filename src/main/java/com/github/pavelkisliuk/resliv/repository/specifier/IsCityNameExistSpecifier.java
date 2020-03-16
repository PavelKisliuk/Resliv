package com.github.pavelkisliuk.resliv.repository.specifier;

import com.github.pavelkisliuk.resliv.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IsCityNameExistSpecifier {
	private CityRepository cityRepository;

	@Autowired
	public void setRepository(CityRepository repository) {
		this.cityRepository = repository;
	}

	public boolean isExist(String cityName) {
		return cityRepository.existsCityByName(cityName.toUpperCase());
	}
}