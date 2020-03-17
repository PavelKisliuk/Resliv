package com.github.pavelkisliuk.resliv.repository.specifier;

import com.github.pavelkisliuk.resliv.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityAmountSpecifier {
	private CityRepository cityRepository;

	@Autowired
	public void setCityRepository(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	public long amount() {
		return cityRepository.count();
	}

	public long amount(Long messageId) {
		return cityRepository.countCitiesByMessageId(messageId);
	}
}