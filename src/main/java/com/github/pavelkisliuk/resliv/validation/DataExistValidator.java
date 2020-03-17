package com.github.pavelkisliuk.resliv.validation;

import com.github.pavelkisliuk.resliv.entity.City;
import com.github.pavelkisliuk.resliv.repository.specifier.IsCityNameExistSpecifier;
import com.github.pavelkisliuk.resliv.repository.specifier.IsMessageNameExistSpecifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class DataExistValidator {
	private IsCityNameExistSpecifier isCityNameExistSpecifier;
	private IsMessageNameExistSpecifier isMessageNameExistSpecifier;

	@Autowired
	public void setIsCityNameExistSpecifier(IsCityNameExistSpecifier isCityNameExistSpecifier) {
		this.isCityNameExistSpecifier = isCityNameExistSpecifier;
	}

	@Autowired
	public void setIsMessageNameExistSpecifier(IsMessageNameExistSpecifier isMessageNameExistSpecifier) {
		this.isMessageNameExistSpecifier = isMessageNameExistSpecifier;
	}

	public boolean isMessageExist(String newMessage) {
		return isMessageNameExistSpecifier.isExist(newMessage);
	}

	public boolean isCityExist(City city) {
		return isCityNameExistSpecifier.isExist(city.getName());
	}

	public Optional<String> isCityGroupExist(List<String> cityList) {
		for (String city : cityList) {
			if (isCityNameExistSpecifier.isExist(city)) {
				return Optional.of(city);
			}
		}
		return Optional.empty();
	}
}