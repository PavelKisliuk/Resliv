package com.github.pavelkisliuk.resliv.service;

import com.github.pavelkisliuk.resliv.entity.City;
import com.github.pavelkisliuk.resliv.entity.ReslivString;
import com.github.pavelkisliuk.resliv.repository.specifier.CityByNameSelectSpecifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityQueryService implements ReslivService<ReslivString, City> {
	private CityByNameSelectSpecifier cityByNameSelectSpecifier;

	@Autowired
	public void setCityByNameSelectSpecifier(CityByNameSelectSpecifier cityByNameSelectSpecifier) {
		this.cityByNameSelectSpecifier = cityByNameSelectSpecifier;
	}

	@Override
	public Optional<City> serve(ReslivString string) {
		return cityByNameSelectSpecifier.query(string);
	}
}