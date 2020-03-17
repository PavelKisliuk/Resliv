package com.github.pavelkisliuk.resliv.service;

import com.github.pavelkisliuk.resliv.entity.Message;
import com.github.pavelkisliuk.resliv.entity.NewData;
import com.github.pavelkisliuk.resliv.repository.specifier.NewDataInsertSpecifier;
import com.github.pavelkisliuk.resliv.validation.DataExistValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AddDataInsertService {
	private static final String KEY_EXIST = "exist";
	private static final String KEY_SUCCESS = "success";

	private static final String VALUE_MESSAGE_EXIST = "Such message already exist!";
	private static final String VALUE_CITY_EXIST = "This city already exist: ";
	private static final String VALUE_SUCCESS = "Data inserted successfully.";

	private DataExistValidator dataExistValidator;
	private NewDataInsertSpecifier newDataInsertSpecifier;

	@Autowired
	public void setDataExistValidator(DataExistValidator dataExistValidator) {
		this.dataExistValidator = dataExistValidator;
	}

	@Autowired
	public void setNewDataInsertSpecifier(NewDataInsertSpecifier newDataInsertSpecifier) {
		this.newDataInsertSpecifier = newDataInsertSpecifier;
	}

	public Map<String, String> serve(NewData newData) {
		Map<String, String> response = new HashMap<>();
		Message message = new Message();
		message.setMessage(newData.getMessage());

		if (dataExistValidator.isMessageExist(message)) {
			response.put(KEY_EXIST, VALUE_MESSAGE_EXIST);
			return response;
		}

		Optional<String> city = dataExistValidator.isCityGroupExist(newData.getCities());
		if (city.isPresent()) {
			response.put(KEY_EXIST, VALUE_CITY_EXIST + city.get());
			return response;
		}
		newDataInsertSpecifier.insert(message, newData.getCities());

		response.put(KEY_SUCCESS, VALUE_SUCCESS);
		return response;
	}
}