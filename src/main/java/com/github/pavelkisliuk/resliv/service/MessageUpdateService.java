package com.github.pavelkisliuk.resliv.service;

import com.github.pavelkisliuk.resliv.entity.Message;
import com.github.pavelkisliuk.resliv.repository.specifier.MessageUpdateSpecifier;
import com.github.pavelkisliuk.resliv.validation.DataExistValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MessageUpdateService {
	private static final String KEY_EXIST = "exist";
	private static final String KEY_SUCCESS = "success";

	private static final String VALUE_MESSAGE_EXIST = "Such message already exist.";
	private static final String VALUE_SUCCESS = "Message brought up to date successfully.";

	private DataExistValidator dataExistValidator;
	private MessageUpdateSpecifier messageUpdateSpecifier;

	@Autowired
	public void setDataExistValidator(DataExistValidator dataExistValidator) {
		this.dataExistValidator = dataExistValidator;
	}

	@Autowired
	public void setMessageUpdateSpecifier(MessageUpdateSpecifier messageUpdateSpecifier) {
		this.messageUpdateSpecifier = messageUpdateSpecifier;
	}

	public Map<String, String> serve(Message newMessage) {
		Map<String, String> response = new HashMap<>();

		if (dataExistValidator.isMessageExist(newMessage)) {
			response.put(KEY_EXIST, VALUE_MESSAGE_EXIST);
			return response;
		}
		messageUpdateSpecifier.update(newMessage);

		response.put(KEY_SUCCESS, VALUE_SUCCESS);
		return response;
	}
}