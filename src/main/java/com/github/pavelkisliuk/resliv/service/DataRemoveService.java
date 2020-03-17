package com.github.pavelkisliuk.resliv.service;

import com.github.pavelkisliuk.resliv.entity.Message;
import com.github.pavelkisliuk.resliv.repository.specifier.DataRemoveSpecifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DataRemoveService {
	private static final String KEY_SUCCESS = "success";

	private static final String VALUE_SUCCESS = "Data was removed.";

	private DataRemoveSpecifier dataRemoveSpecifier;

	@Autowired
	public void setDataRemoveSpecifier(DataRemoveSpecifier dataRemoveSpecifier) {
		this.dataRemoveSpecifier = dataRemoveSpecifier;
	}

	public Map<String, String> serve(Message message) {
		Map<String, String> response = new HashMap<>();

		dataRemoveSpecifier.delete(message);

		response.put(KEY_SUCCESS, VALUE_SUCCESS);
		return response;
	}
}