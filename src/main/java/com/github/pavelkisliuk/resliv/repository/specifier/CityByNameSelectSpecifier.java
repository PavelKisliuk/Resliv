package com.github.pavelkisliuk.resliv.repository.specifier;

import com.github.pavelkisliuk.resliv.entity.City;
import com.github.pavelkisliuk.resliv.entity.ReslivString;
import com.github.pavelkisliuk.resliv.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CityByNameSelectSpecifier {
	private CityRepository cityRepository;

	@Autowired
	public void setCityRepository(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	public Optional<City> query(ReslivString string) {
		return cityRepository.findByName(string.getString());
	}
}