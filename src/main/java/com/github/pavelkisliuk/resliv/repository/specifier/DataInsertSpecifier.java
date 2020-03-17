package com.github.pavelkisliuk.resliv.repository.specifier;

import com.github.pavelkisliuk.resliv.entity.City;
import com.github.pavelkisliuk.resliv.entity.Message;
import com.github.pavelkisliuk.resliv.repository.CityRepository;
import com.github.pavelkisliuk.resliv.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class DataInsertSpecifier {
	private MessageRepository messageRepository;

	private CityRepository cityRepository;

	@Autowired
	public void setMessageRepository(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@Autowired
	public void setCityRepository(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	@Transactional
	public void insert(Message message, List<String> cityList) {
		messageRepository.save(message);
		for (String cityName : cityList) {
			City newCity = new City();
			newCity.setMessageId(message.getId());
			newCity.setName(cityName.toUpperCase());
			cityRepository.save(newCity);
		}
	}
}