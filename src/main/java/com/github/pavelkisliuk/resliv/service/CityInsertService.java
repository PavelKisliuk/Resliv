package com.github.pavelkisliuk.resliv.service;

import com.github.pavelkisliuk.resliv.entity.City;
import com.github.pavelkisliuk.resliv.repository.specifier.CityInsertSpecifier;
import com.github.pavelkisliuk.resliv.validation.DataEmptyValidator;
import com.github.pavelkisliuk.resliv.validation.DataExistValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CityInsertService {
	private static final String KEY_WARN = "warn";
	private static final String KEY_SUCCESS = "success";

	private static final String VALUE_EMPTY = "Can't write empty value!";
	private static final String VALUE_CITY_EXIST = "Such city already exist.";
	private static final String VALUE_SUCCESS = "City appended successfully.";

	private DataExistValidator dataExistValidator;
	private DataEmptyValidator dataEmptyValidator;
	private CityInsertSpecifier cityInsertSpecifier;

	@Autowired
	public void setDataExistValidator(DataExistValidator dataExistValidator) {
		this.dataExistValidator = dataExistValidator;
	}

	@Autowired
	public void setDataEmptyValidator(DataEmptyValidator dataEmptyValidator) {
		this.dataEmptyValidator = dataEmptyValidator;
	}

	@Autowired
	public void setCityInsertSpecifier(CityInsertSpecifier cityInsertSpecifier) {
		this.cityInsertSpecifier = cityInsertSpecifier;
	}

	public Map<String, String> serve(City newCity) {
		Map<String, String> response = new HashMap<>();

		if (dataEmptyValidator.isEmptyValue(newCity.getName())) {
			response.put(KEY_WARN, VALUE_EMPTY);
			return response;
		}

		if (dataExistValidator.isCityExist(newCity)) {
			response.put(KEY_WARN, VALUE_CITY_EXIST);
			return response;
		}
		cityInsertSpecifier.insert(newCity);

		response.put(KEY_SUCCESS, VALUE_SUCCESS);
		return response;
	}
}