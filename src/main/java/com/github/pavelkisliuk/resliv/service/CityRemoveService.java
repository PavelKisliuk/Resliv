package com.github.pavelkisliuk.resliv.service;

import com.github.pavelkisliuk.resliv.entity.City;
import com.github.pavelkisliuk.resliv.repository.specifier.CityRemoveSpecifier;
import com.github.pavelkisliuk.resliv.validation.DataExistValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CityRemoveService {
	private static final String KEY_WARN = "warn";
	private static final String KEY_SUCCESS = "success";

	private static final String VALUE_NOT_ENOUGH = "Impossible to delete all cities.";
	private static final String VALUE_CITIES_REMOVED = "Cities was removed.";

	private DataExistValidator dataExistValidator;
	private CityRemoveSpecifier cityRemoveSpecifier;

	@Autowired
	public void setDataExistValidator(DataExistValidator dataExistValidator) {
		this.dataExistValidator = dataExistValidator;
	}

	@Autowired
	public void setCityRemoveSpecifier(CityRemoveSpecifier cityRemoveSpecifier) {
		this.cityRemoveSpecifier = cityRemoveSpecifier;
	}

	public Map<String, String> serve(List<City> cityList) {
		Map<String, String> response = new HashMap<>();

		if (!dataExistValidator.isEnoughCities(cityList)) {
			response.put(KEY_WARN, VALUE_NOT_ENOUGH);
			return response;
		}

		cityRemoveSpecifier.delete(cityList);

		response.put(KEY_SUCCESS, VALUE_CITIES_REMOVED);
		return response;
	}
}