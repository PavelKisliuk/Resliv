package com.github.pavelkisliuk.resliv.validation;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataEmptyValidator {
	public boolean isEmptyValue(String value) {
		return value.isEmpty();
	}

	public boolean isEmptyValue(List<String> value) {
		return value.stream().anyMatch(String::isEmpty);
	}
}