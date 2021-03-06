package com.github.pavelkisliuk.resliv.validation;

import com.github.pavelkisliuk.resliv.entity.City;
import com.github.pavelkisliuk.resliv.entity.Message;
import com.github.pavelkisliuk.resliv.repository.specifier.CityAmountSpecifier;
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
	private CityAmountSpecifier cityAmountSpecifier;

	@Autowired
	public void setIsCityNameExistSpecifier(IsCityNameExistSpecifier isCityNameExistSpecifier) {
		this.isCityNameExistSpecifier = isCityNameExistSpecifier;
	}

	@Autowired
	public void setIsMessageNameExistSpecifier(IsMessageNameExistSpecifier isMessageNameExistSpecifier) {
		this.isMessageNameExistSpecifier = isMessageNameExistSpecifier;
	}

	@Autowired
	public void setCityAmountSpecifier(CityAmountSpecifier cityAmountSpecifier) {
		this.cityAmountSpecifier = cityAmountSpecifier;
	}

	public boolean isMessageExist(Message newMessage) {
		return isMessageNameExistSpecifier.isExist(newMessage.getMessage());
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

	public boolean isEnoughCities(List<City> cityList) {
		return cityAmountSpecifier.amount(cityList.get(0).getMessageId()) > cityList.size();
	}
}