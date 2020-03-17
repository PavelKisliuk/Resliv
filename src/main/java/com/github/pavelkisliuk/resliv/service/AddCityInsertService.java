package com.github.pavelkisliuk.resliv.service;

import com.github.pavelkisliuk.resliv.entity.City;
import com.github.pavelkisliuk.resliv.repository.specifier.NewCityInsertSpecifier;
import com.github.pavelkisliuk.resliv.validation.DataExistValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AddCityInsertService {
	private static final String KEY_EXIST = "exist";
	private static final String KEY_SUCCESS = "success";

	private static final String VALUE_CITY_EXIST = "This city already exist.";
	private static final String VALUE_SUCCESS = "City appended successfully.";

	private DataExistValidator dataExistValidator;
	private NewCityInsertSpecifier newCityInsertSpecifier;

	@Autowired
	public void setDataExistValidator(DataExistValidator dataExistValidator) {
		this.dataExistValidator = dataExistValidator;
	}

	@Autowired
	public void setNewCityInsertSpecifier(NewCityInsertSpecifier newCityInsertSpecifier) {
		this.newCityInsertSpecifier = newCityInsertSpecifier;
	}

	public Map<String, String> serve(City newCity) {
		Map<String, String> response = new HashMap<>();

		if (dataExistValidator.isCityExist(newCity)) {
			response.put(KEY_EXIST, VALUE_CITY_EXIST);
			return response;
		}
		newCityInsertSpecifier.insert(newCity);

		response.put(KEY_SUCCESS, VALUE_SUCCESS);
		return response;
	}
}