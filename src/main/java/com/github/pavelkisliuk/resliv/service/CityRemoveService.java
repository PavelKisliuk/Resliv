package com.github.pavelkisliuk.resliv.service;

import com.github.pavelkisliuk.resliv.entity.City;
import com.github.pavelkisliuk.resliv.repository.specifier.CityRemoveSpecifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CityRemoveService {
	private static final String KEY_SUCCESS = "success";

	private static final String CITIES_REMOVED = "Cities was removed.";

	private CityRemoveSpecifier cityRemoveSpecifier;

	@Autowired
	public void setCityRemoveSpecifier(CityRemoveSpecifier cityRemoveSpecifier) {
		this.cityRemoveSpecifier = cityRemoveSpecifier;
	}

	public Map<String, String> serve(List<City> cityList) {
		Map<String, String> response = new HashMap<>();

		cityRemoveSpecifier.delete(cityList);

		response.put(KEY_SUCCESS, CITIES_REMOVED);
		return response;
	}
}