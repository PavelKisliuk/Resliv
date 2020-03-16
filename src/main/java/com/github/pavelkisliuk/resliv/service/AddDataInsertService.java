package com.github.pavelkisliuk.resliv.service;

import com.github.pavelkisliuk.resliv.entity.Message;
import com.github.pavelkisliuk.resliv.entity.NewData;
import com.github.pavelkisliuk.resliv.repository.specifier.IsCityNameExistSpecifier;
import com.github.pavelkisliuk.resliv.repository.specifier.IsMessageNameExistSpecifier;
import com.github.pavelkisliuk.resliv.repository.specifier.NewDataInsertSpecifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AddDataInsertService {
	private static final String KEY_EXIST = "exist";
	private static final String KEY_SUCCESS = "success";

	private static final String VALUE_MESSAGE_EXIST = "Such message already exist!";
	private static final String VALUE_CITY_EXIST = "This city already exist: ";
	private static final String VALUE_SUCCESS = "Data inserted successfully.";

	private IsCityNameExistSpecifier isCityNameExistSpecifier;
	private IsMessageNameExistSpecifier isMessageNameExistSpecifier;
	private NewDataInsertSpecifier newDataInsertSpecifier;

	@Autowired
	public void setNewDataInsertSpecifier(NewDataInsertSpecifier newDataInsertSpecifier) {
		this.newDataInsertSpecifier = newDataInsertSpecifier;
	}

	@Autowired
	public void setIsCityNameExistSpecifier(IsCityNameExistSpecifier isCityNameExistSpecifier) {
		this.isCityNameExistSpecifier = isCityNameExistSpecifier;
	}

	@Autowired
	public void setIsMessageNameExistSpecifier(IsMessageNameExistSpecifier isMessageNameExistSpecifier) {
		this.isMessageNameExistSpecifier = isMessageNameExistSpecifier;
	}

	public Map<String, String> serve(NewData newData) {
		Map<String, String> response = new HashMap<>();
		Message message = new Message();

		if (isMessageExist(newData.getMessage())) {
			response.put(KEY_EXIST, VALUE_MESSAGE_EXIST);
			return response;
		}

		Optional<String> city = isCitiesExist(newData.getCities());
		if (city.isPresent()) {
			response.put(KEY_EXIST, VALUE_CITY_EXIST + city.get());
			return response;
		}

		message.setMessage(newData.getMessage());
		newDataInsertSpecifier.insert(message, newData.getCities());

		response.put(KEY_SUCCESS, VALUE_SUCCESS);
		return response;
	}

	private boolean isMessageExist(String newMessage) {
		return isMessageNameExistSpecifier.isExist(newMessage);
	}

	private Optional<String> isCitiesExist(List<String> cityList) {
		for (String city : cityList) {
			if (isCityNameExistSpecifier.isExist(city)) {
				return Optional.of(city);
			}
		}
		return Optional.empty();
	}
}