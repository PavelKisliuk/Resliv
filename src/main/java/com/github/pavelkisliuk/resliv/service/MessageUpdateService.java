package com.github.pavelkisliuk.resliv.service;

import com.github.pavelkisliuk.resliv.entity.Message;
import com.github.pavelkisliuk.resliv.repository.specifier.MessageUpdateSpecifier;
import com.github.pavelkisliuk.resliv.validation.DataEmptyValidator;
import com.github.pavelkisliuk.resliv.validation.DataExistValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MessageUpdateService {
	private static final String KEY_WARN = "warn";
	private static final String KEY_SUCCESS = "success";

	private static final String VALUE_EMPTY = "Can't write empty value!";
	private static final String VALUE_MESSAGE_EXIST = "Such message already exist.";
	private static final String VALUE_SUCCESS = "Message brought up to date successfully.";

	private DataExistValidator dataExistValidator;
	private DataEmptyValidator dataEmptyValidator;
	private MessageUpdateSpecifier messageUpdateSpecifier;

	@Autowired
	public void setDataExistValidator(DataExistValidator dataExistValidator) {
		this.dataExistValidator = dataExistValidator;
	}

	@Autowired
	public void setDataEmptyValidator(DataEmptyValidator dataEmptyValidator) {
		this.dataEmptyValidator = dataEmptyValidator;
	}

	@Autowired
	public void setMessageUpdateSpecifier(MessageUpdateSpecifier messageUpdateSpecifier) {
		this.messageUpdateSpecifier = messageUpdateSpecifier;
	}

	public Map<String, String> serve(Message newMessage) {
		Map<String, String> response = new HashMap<>();

		if(dataEmptyValidator.isEmptyValue(newMessage.getMessage())) {
			response.put(KEY_WARN, VALUE_EMPTY);
			return response;
		}

		if (dataExistValidator.isMessageExist(newMessage)) {
			response.put(KEY_WARN, VALUE_MESSAGE_EXIST);
			return response;
		}
		messageUpdateSpecifier.update(newMessage);

		response.put(KEY_SUCCESS, VALUE_SUCCESS);
		return response;
	}
}